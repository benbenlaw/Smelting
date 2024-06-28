package com.benbenlaw.smelting.integration.jei;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.recipe.FuelRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuelRecipeCategory implements IRecipeCategory<FuelRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "fuel");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(OpolisUtilities.MOD_ID, "textures/gui/jei_dynamic.png");

    public static final RecipeType<FuelRecipe> RECIPE_TYPE = RecipeType.create(Smelting.MOD_ID, "fuel",
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

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecipe recipe, IFocusGroup focusGroup) {
        tabs_used++;

        List<FuelRecipe> recipes = new ArrayList<>(Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(FuelRecipe.Type.INSTANCE)).stream().map(RecipeHolder::value).toList();

        List<FuelRecipe> mutableRecipes = new ArrayList<>(recipes);

        mutableRecipes.sort(Comparator.comparingInt(FuelRecipe::temp).reversed());

        // Background Size
        int numRows = (int) Math.ceil((double) mutableRecipes.size() / 9);
        int numCols = Math.min(9, mutableRecipes.size()); // Maximum of 9 columns
        int backgroundWidth = 4 + numCols * 19;
        int backgroundHeight = 2 + numRows * 19;

        background = helper.createDrawable(TEXTURE, 0, 0, backgroundWidth, backgroundHeight);

        for (int i = 0; i < mutableRecipes.size(); i++) {
            final int slotX = 4 + (i % 9 * 19);
            final int slotY = 2 + i / 9 * 19;

            int temp = mutableRecipes.get(i).temp();
            int amountUsed = mutableRecipes.get(i).fluid().getAmount();

            builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY).addFluidStack(mutableRecipes.get(i).getFluid(), 1000).addTooltipCallback(fuelInformation(temp, amountUsed))
                    .setBackground(JEISmeltingPlugin.slotDrawable, slotX - (i % 9 * 19) - 5, slotY - (2 + i / 9 * 19) - 1);

        }
    }

    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback fuelInformation(int temp, int amountUsed) {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Temp: " + temp));
            addTooltip.add(Component.literal("Used Amount: " + amountUsed));
        };
    }
}