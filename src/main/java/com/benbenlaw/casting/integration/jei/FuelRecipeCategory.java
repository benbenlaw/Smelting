package com.benbenlaw.casting.integration.jei;

import com.benbenlaw.casting.recipe.MeltingRecipe;
import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.recipe.FuelRecipe;
import com.benbenlaw.opolisutilities.integration.jei.OpolisIRecipeSlotTooltipCallback;
import com.benbenlaw.opolisutilities.recipe.SpeedUpgradesRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FuelRecipeCategory implements IRecipeCategory<FuelRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "fuel");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(OpolisUtilities.MOD_ID, "textures/gui/jei_dynamic.png");

    public static final RecipeType<FuelRecipe> RECIPE_TYPE = RecipeType.create(Casting.MOD_ID, "fuel",
            FuelRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;
    private int tabs_used = 0;

    public FuelRecipeCategory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 114);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CONTROLLER.get()));
    }

    @Override
    public @NotNull RecipeType<FuelRecipe> getRecipeType() {
        return JEISmeltingPlugin.FUEL_RECIPE;
    }

    @Override
    public boolean isHandled(FuelRecipe recipe) {
        return tabs_used == 0;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Fuel Sources");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    public @Nullable ResourceLocation getRegistryName(FuelRecipe recipe) {
        assert Minecraft.getInstance().level != null;
        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(FuelRecipe.Type.INSTANCE).stream()
                .filter(recipeHolder -> recipeHolder.value().equals(recipe))
                .map(RecipeHolder::id)
                .findFirst()
                .orElse(null);
    }

    private final Map<Point, FuelRecipe> slotRecipes = new HashMap<>();
    private int backgroundWidth;

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecipe recipe, IFocusGroup focusGroup) {
        tabs_used++;

        List<FuelRecipe> recipes = new ArrayList<>(Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(FuelRecipe.Type.INSTANCE)).stream().map(RecipeHolder::value).toList();

        List<FuelRecipe> mutableRecipes = new ArrayList<>(recipes);

        mutableRecipes.sort(Comparator.comparingInt(FuelRecipe::temp).reversed());

        // Background Size
        int yOffset = 34;

        int numRows = (int) Math.ceil((double) mutableRecipes.size() / 9);
        int numCols = 9; //Math.min(9, mutableRecipes.size()); // Maximum of 9 columns
        int backgroundWidth = 4 + numCols * 19;
        int backgroundHeight = 2 + numRows * 19 + yOffset;

        background = helper.createDrawable(TEXTURE, 0, 0, backgroundWidth, backgroundHeight);

        slotRecipes.clear();

        for (int i = 0; i < mutableRecipes.size(); i++) {
            final int slotX = 4 + (i % 9 * 19);
            final int slotY = yOffset + 2 + i / 9 * 19; // Add yOffset to the Y position

            builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY)
                    .addFluidStack(mutableRecipes.get(i).getFluid(), 1000)
                    .setBackground(JEISmeltingPlugin.slotDrawable, slotX - (i % 9 * 19) - 5, slotY - (yOffset + 2 + i / 9 * 19) - 1);

            // Store the position of this slot with its corresponding recipe
            slotRecipes.put(new Point(slotX, slotY), mutableRecipes.get(i));
        }
    }

    @Override
    public void draw(FuelRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        String tempText = null;
        String amountText = null;
        String tickText = null;

        for (Map.Entry<Point, FuelRecipe> entry : slotRecipes.entrySet()) {
            Point position = entry.getKey();
            FuelRecipe hoveredRecipe = entry.getValue();

            int slotX = position.x;
            int slotY = position.y;
            int slotWidth = 18;
            int slotHeight = 18;

            if (mouseX >= slotX && mouseX < slotX + slotWidth && mouseY >= slotY && mouseY < slotY + slotHeight) {
                int temp = hoveredRecipe.temp();
                int amountUsed = hoveredRecipe.fluid().getAmount();
                int tickPerCraft = hoveredRecipe.smeltTime();

                tempText = "Temp: " + temp;
                amountText = "Used Amount: " + amountUsed;
                tickText = "Ticks Per Craft: " + tickPerCraft;
                break;
            }
        }

        if (tempText != null) {
            int textX = 3; // Calculate X to center the text
            int textY = 2;

            guiGraphics.drawString(Minecraft.getInstance().font, tempText, textX , textY, Color.GRAY.getRGB(), false);
            guiGraphics.drawString(Minecraft.getInstance().font, amountText, textX , textY + 10, Color.GRAY.getRGB(), false);
            guiGraphics.drawString(Minecraft.getInstance().font, tickText, textX, textY + 20, Color.GRAY.getRGB(), false);
        }
    }


}