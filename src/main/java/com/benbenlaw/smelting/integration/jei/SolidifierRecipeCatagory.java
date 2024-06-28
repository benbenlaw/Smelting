package com.benbenlaw.smelting.integration.jei;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.recipe.SolidifierRecipe;
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
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SolidifierRecipeCatagory implements IRecipeCategory<SolidifierRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "solidifier");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "textures/gui/jei_solidifier.png");

    public static final RecipeType<SolidifierRecipe> RECIPE_TYPE = RecipeType.create(Smelting.MOD_ID, "solidifier",
            SolidifierRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;

    public SolidifierRecipeCatagory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(TEXTURE, 0, 0, 120, 19);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SOLIDIFIER.get()));
    }

    @Override
    public @NotNull RecipeType<SolidifierRecipe> getRecipeType() {
        return JEISmeltingPlugin.SOLIDIFIER_RECIPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Solidifying");
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
    public void setRecipe(IRecipeLayoutBuilder builder, SolidifierRecipe recipe, IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 4, 2).addFluidStack(recipe.fluid().getFluid(), recipe.fluid().getAmount()
        ).addTooltipCallback(createFluidTooltipCallback(recipe));

        builder.addSlot(RecipeIngredientRole.CATALYST, 40, 2).addIngredients(recipe.mold());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 2).addIngredients(recipe.output().ingredient());


    }


    private IRecipeSlotTooltipCallback createFluidTooltipCallback(SolidifierRecipe recipe) {

        return (fluidAmount, addTooltip) -> {
            addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid().getAmount() + "mB"));
        };


    }
}