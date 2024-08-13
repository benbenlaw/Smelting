package com.benbenlaw.casting.integration.jei;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.recipe.SolidifierRecipe;
import com.benbenlaw.opolisutilities.integration.jei.OpolisIRecipeSlotTooltipCallback;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ChimneyRecipeCatagory implements IRecipeCategory<SolidifierRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "solidifier");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "textures/gui/jei_solidifier.png");

    public static final RecipeType<SolidifierRecipe> RECIPE_TYPE = RecipeType.create(Casting.MOD_ID, "solidifier",
            SolidifierRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;

    public ChimneyRecipeCatagory(IGuiHelper helper) {
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
        int fluidAmount = recipe.fluid().getAmount();

        List<Stream<ItemStack>> ingredients = List.of(Arrays.stream(recipe.output().getItems())).reversed();
        List<ItemStack> items = ingredients.stream().flatMap(stream -> stream).toList();

        builder.addSlot(RecipeIngredientRole.INPUT, 4, 2).addFluidStack(recipe.fluid().getFluid(), 1000)
                .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                    @Override
                    public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                        String tooltipText = "Fluid Required: " + fluidAmount + "mB";
                        boolean isIngot = items.stream().anyMatch(itemStack -> itemStack.is(Tags.Items.INGOTS));
                        boolean isGem = items.stream().anyMatch(itemStack -> itemStack.is(Tags.Items.GEMS));
                        if ((isIngot || isGem) && fluidAmount % 90 == 0) {
                            int units = fluidAmount / 90;
                            String unitType = isIngot ? "Ingot" : "Gem";
                            tooltipText = units + " " + unitType + (units > 1 ? "s" : "") + " / " + fluidAmount + "mB";
                        }
                        iTooltipBuilder.add(Component.literal(tooltipText));

                    }
                });

        builder.addSlot(RecipeIngredientRole.CATALYST, 40, 2).addIngredients(recipe.mold());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 2).addIngredients(recipe.output().ingredient());
    }


}