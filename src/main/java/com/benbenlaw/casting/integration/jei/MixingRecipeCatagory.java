package com.benbenlaw.casting.integration.jei;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.recipe.FuelRecipe;
import com.benbenlaw.casting.recipe.MeltingRecipe;
import com.benbenlaw.casting.recipe.MixingRecipe;
import com.benbenlaw.opolisutilities.integration.jei.OpolisIRecipeSlotTooltipCallback;
import com.benbenlaw.opolisutilities.recipe.SpeedUpgradesRecipe;
import com.benbenlaw.opolisutilities.util.MouseUtil;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
        this.background = helper.createDrawable(TEXTURE, 0, 0, 161, 38);
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
    public @Nullable ResourceLocation getRegistryName(MixingRecipe recipe) {
        assert Minecraft.getInstance().level != null;
        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(MixingRecipe.Type.INSTANCE).stream()
                .filter(recipeHolder -> recipeHolder.value().equals(recipe))
                .map(RecipeHolder::id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, MixingRecipe recipe, @NotNull IFocusGroup focusGroup) {

        if (!recipe.fluid1().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 4, 20).addFluidStack(recipe.fluid1().getFluid(), recipe.fluid1().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 4, 20).addItemStack(new ItemStack(Items.BARRIER));

        }
        if (!recipe.fluid2().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 23, 20).addFluidStack(recipe.fluid2().getFluid(), recipe.fluid2().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 23, 20).addItemStack(new ItemStack(Items.BARRIER));
        }

        if (!recipe.fluid3().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 42, 20).addFluidStack(recipe.fluid3().getFluid(), recipe.fluid3().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 42, 20).addItemStack(new ItemStack(Items.BARRIER));
        }

        if (!recipe.fluid4().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 61, 20).addFluidStack(recipe.fluid4().getFluid(), recipe.fluid4().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 61, 20).addItemStack(new ItemStack(Items.BARRIER));
        }

        if (!recipe.fluid5().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 80, 20).addFluidStack(recipe.fluid5().getFluid(), recipe.fluid5().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 80, 20).addItemStack(new ItemStack(Items.BARRIER));
        }

        if (!recipe.fluid6().is(FluidStack.EMPTY.getFluid())) {
            builder.addSlot(RecipeIngredientRole.INPUT, 99, 20).addFluidStack(recipe.fluid6().getFluid(), recipe.fluid6().getAmount());
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 99, 20).addItemStack(new ItemStack(Items.BARRIER));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 142, 20).addFluidStack(recipe.outputFluid().getFluid(), recipe.outputFluid().getAmount());
    }


    @Override
    public void draw(MixingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        final Minecraft minecraft = Minecraft.getInstance();

        String amountText = null;

        // Define the slot positions and sizes
        int[][] slotAreas = {
                {4, 20, 16, 16},
                {23, 20, 16, 16},
                {42, 20, 16, 16},
                {61, 20, 16, 16},
                {80, 20, 16, 16},
                {99, 20, 16, 16},
                {142, 20, 16, 16}
        };

        FluidStack[] fluids = {
                recipe.fluid1(),
                recipe.fluid2(),
                recipe.fluid3(),
                recipe.fluid4(),
                recipe.fluid5(),
                recipe.fluid6(),
                recipe.outputFluid()
        };

        // Determine which slot the mouse is over and set the amount text accordingly
        for (int i = 0; i < slotAreas.length; i++) {
            int[] area = slotAreas[i];
            int slotX = area[0];
            int slotY = area[1];
            int slotWidth = area[2];
            int slotHeight = area[3];

            if (mouseX >= slotX && mouseX < slotX + slotWidth && mouseY >= slotY && mouseY < slotY + slotHeight) {
                FluidStack fluid = fluids[i];
                if (i == 6) { // Output fluid
                    if (!fluid.isEmpty()) {
                        int amount = fluid.getAmount();
                        amountText = "Fluid Produced: " + amount + "mB";
                    } else {
                        amountText = "No Output Fluid";
                    }
                } else { // Input fluids
                    if (!fluid.isEmpty()) {
                        int amount = fluid.getAmount();
                        amountText = "Fluid Required: " + amount + "mB";
                    } else {
                        amountText = "No Fluid Needed";
                    }
                }
                break;
            }
        }

        // Draw the text if there's something to display
        if (amountText != null) {
            int textX = 3; // X coordinate for the text
            int textY = 2; // Y coordinate for the text

            guiGraphics.drawString(minecraft.font.self(), Component.literal(amountText), textX, textY, Color.GRAY.getRGB(), false);
        }
    }


}