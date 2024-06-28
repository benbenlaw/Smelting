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
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

public record FuelRecipe(FluidStack fluid, int temp) implements Recipe<RecipeInput> {


    @Override
    public boolean matches(@NotNull RecipeInput container, @NotNull Level level) {
        return true;
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

    public Fluid getFluid() {
        return this.fluid.getFluid();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return FuelRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return FuelRecipe.Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Type implements RecipeType<FuelRecipe> {
        private Type() {}
        public static final FuelRecipe.Type INSTANCE = new FuelRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<FuelRecipe> {
        public static final FuelRecipe.Serializer INSTANCE = new FuelRecipe.Serializer();

        public final MapCodec<FuelRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        FluidStack.CODEC.fieldOf("fluid").forGetter(FuelRecipe::fluid),
                        Codec.INT.fieldOf("temp").forGetter(FuelRecipe::temp)

                ).apply(instance, Serializer::createFuelRecipe)
        );

        private static final StreamCodec<RegistryFriendlyByteBuf, FuelRecipe> STREAM_CODEC = StreamCodec.of(
                FuelRecipe.Serializer::write, FuelRecipe.Serializer::read);

        @Override
        public @NotNull MapCodec<FuelRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, FuelRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static FuelRecipe read(RegistryFriendlyByteBuf buffer) {
            FluidStack fluid = FluidStack.STREAM_CODEC.decode(buffer);
            int temp = buffer.readInt();
            return new FuelRecipe(fluid, temp);
        }

        private static void write(RegistryFriendlyByteBuf buffer, FuelRecipe recipe) {
            FluidStack.STREAM_CODEC.encode(buffer, recipe.fluid);
            buffer.writeInt(recipe.temp);
        }

        static FuelRecipe createFuelRecipe(FluidStack fluid, int temp) {
            return new FuelRecipe(fluid, temp);
        }
    }
}
