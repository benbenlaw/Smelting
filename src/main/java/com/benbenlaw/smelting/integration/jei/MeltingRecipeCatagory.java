package com.benbenlaw.smelting.integration.jei;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.recipe.MeltingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeltingRecipeCatagory implements IRecipeCategory<MeltingRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "melting");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "textures/gui/jei_melting.png");

    public static final RecipeType<MeltingRecipe> RECIPE_TYPE = RecipeType.create(Smelting.MOD_ID, "melting",
            MeltingRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;

    public MeltingRecipeCatagory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(TEXTURE, 0, 0, 120, 19);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CONTROLLER.get()));
    }

    @Override
    public @NotNull RecipeType<MeltingRecipe> getRecipeType() {
        return JEISmeltingPlugin.MELTING_RECIPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Melting");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MeltingRecipe recipe, IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 4, 2).addIngredients(recipe.getIngredients().getFirst());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 50, 2).addFluidStack(recipe.output().getFluid(), 1000)
                .addTooltipCallback((fluidAmount, addTooltip) -> {
                    addTooltip.add(Component.literal("Fluid Amount: " + recipe.output().getAmount() + "mB"));
                    addTooltip.add(Component.literal("Required Fuel Temp: " + recipe.meltingTemp() + "K"));
        });
    }

    @Override
    public void draw(MeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        final Minecraft minecraft = Minecraft.getInstance();
        int temp = recipe.meltingTemp();
        guiGraphics.drawString(minecraft.font.self(), Component.literal(String.valueOf(temp)), 95, 6, Color.WHITE.getRGB());
    }
}