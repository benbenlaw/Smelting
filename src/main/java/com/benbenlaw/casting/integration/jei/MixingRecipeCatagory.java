package com.benbenlaw.casting.integration.jei;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.recipe.MixingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

public class MixingRecipeCatagory implements IRecipeCategory<MixingRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "mixing");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "textures/gui/jei_mixer.png");

    public static final RecipeType<MixingRecipe> RECIPE_TYPE = RecipeType.create(Casting.MOD_ID, "mixing",
            MixingRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;

    public MixingRecipeCatagory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(TEXTURE, 0, 0, 161, 19);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MIXER.get()));
    }

    @Override
    public @NotNull RecipeType<MixingRecipe> getRecipeType() {
        return JEISmeltingPlugin.MIXER_RECIPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Mixer");
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
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, MixingRecipe recipe, @NotNull IFocusGroup focusGroup) {

        if (!recipe.fluid1().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 4, 2).addFluidStack(recipe.fluid1().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid1().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 4, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        if (!recipe.fluid2().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 23, 2).addFluidStack(recipe.fluid2().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid2().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 23, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        if (!recipe.fluid3().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 42, 2).addFluidStack(recipe.fluid3().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid3().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 42, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        if (!recipe.fluid4().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 61, 2).addFluidStack(recipe.fluid4().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid4().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 61, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        if (!recipe.fluid5().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 80, 2).addFluidStack(recipe.fluid5().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid5().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 80, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        if (!recipe.fluid6().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 99, 2).addFluidStack(recipe.fluid6().getFluid(), 1000)
                    .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Required: " + recipe.fluid6().getAmount() + "mB")));
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 99, 2).addItemStack(new ItemStack(Items.BARRIER))
                    .addTooltipCallback((itemStack, addTooltip) -> addTooltip.add(Component.literal("No Fluid Needed")));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 142, 2).addFluidStack(recipe.outputFluid().getFluid(), recipe.outputFluid().getAmount())
                .addTooltipCallback((fluidStack, addTooltip) -> addTooltip.add(Component.literal("Fluid Produced: " + recipe.outputFluid().getAmount() + "mB")));

    }
}