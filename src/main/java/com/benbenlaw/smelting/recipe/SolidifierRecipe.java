package com.benbenlaw.smelting.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

public record SolidifierRecipe(Ingredient mold, SizedIngredient output, FluidStack fluid) implements Recipe<RecipeInput> {

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.createWithCapacity(1);
        ingredients.add(mold);
        return ingredients;
    }

    @Override
    public boolean matches(@NotNull RecipeInput container, @NotNull Level level) {
        return mold.test(container.getItem(0));
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }


    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeInput container, HolderLookup.@NotNull Provider provider) {
        return ItemStack.EMPTY;
    }

    public FluidStack getFluidStack() {
        return this.fluid.copy();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return SolidifierRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return SolidifierRecipe.Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Type implements RecipeType<SolidifierRecipe> {
        private Type() {}
        public static final SolidifierRecipe.Type INSTANCE = new SolidifierRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<SolidifierRecipe> {
        public static final SolidifierRecipe.Serializer INSTANCE = new SolidifierRecipe.Serializer();

        public final MapCodec<SolidifierRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Ingredient.CODEC_NONEMPTY.fieldOf("mold").forGetter(SolidifierRecipe::mold),
                        SizedIngredient.FLAT_CODEC.fieldOf("output").forGetter(SolidifierRecipe::output),
                        FluidStack.CODEC.fieldOf("fluid").forGetter(SolidifierRecipe::fluid)
                ).apply(instance, Serializer::createSolidifierRecipe)
        );

        private static final StreamCodec<RegistryFriendlyByteBuf, SolidifierRecipe> STREAM_CODEC = StreamCodec.of(
                SolidifierRecipe.Serializer::write, SolidifierRecipe.Serializer::read);

        @Override
        public @NotNull MapCodec<SolidifierRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, SolidifierRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static SolidifierRecipe read(RegistryFriendlyByteBuf buffer) {
            Ingredient mold = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            SizedIngredient output = SizedIngredient.STREAM_CODEC.decode(buffer);
            FluidStack fluid = FluidStack.STREAM_CODEC.decode(buffer);
            return new SolidifierRecipe(mold, output, fluid );
        }

        private static void write(RegistryFriendlyByteBuf buffer, SolidifierRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.mold);
            SizedIngredient.STREAM_CODEC.encode(buffer, recipe.output);
            FluidStack.STREAM_CODEC.encode(buffer, recipe.fluid);
        }

        static SolidifierRecipe createSolidifierRecipe(Ingredient mold, SizedIngredient output, FluidStack fluid) {
            return new SolidifierRecipe(mold, output, fluid);
        }
    }
}
