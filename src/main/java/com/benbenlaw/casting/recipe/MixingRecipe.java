package com.benbenlaw.casting.recipe;

import com.benbenlaw.opolisutilities.recipe.NoInventoryRecipe;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

public record MixingRecipe(FluidStack fluid1, FluidStack fluid2, FluidStack fluid3, FluidStack fluid4, FluidStack fluid5, FluidStack fluid6,
                          FluidStack outputFluid) implements Recipe<NoInventoryRecipe> {

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }
    @Override
    public boolean matches(NoInventoryRecipe recipe, Level level) {

            return true;

    }


    @Override
    public ItemStack assemble(NoInventoryRecipe p_345149_, HolderLookup.Provider p_346030_) {
        return ItemStack.EMPTY;
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
    public @NotNull RecipeSerializer<?> getSerializer() {
        return MixingRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return MixingRecipe.Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Type implements RecipeType<MixingRecipe> {
        private Type() {}
        public static final MixingRecipe.Type INSTANCE = new MixingRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<MixingRecipe> {
        public static final MixingRecipe.Serializer INSTANCE = new MixingRecipe.Serializer();

        public final MapCodec<MixingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid1", FluidStack.EMPTY).forGetter(MixingRecipe::fluid1),
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid2", FluidStack.EMPTY).forGetter(MixingRecipe::fluid2),
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid3", FluidStack.EMPTY).forGetter(MixingRecipe::fluid3),
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid4", FluidStack.EMPTY).forGetter(MixingRecipe::fluid4),
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid5", FluidStack.EMPTY).forGetter(MixingRecipe::fluid5),
                        FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluid6", FluidStack.EMPTY).forGetter(MixingRecipe::fluid6),
                        FluidStack.CODEC.fieldOf("output").forGetter(MixingRecipe::outputFluid)
                ).apply(instance, Serializer::createSolidifierRecipe)
        );

        private static final StreamCodec<RegistryFriendlyByteBuf, MixingRecipe> STREAM_CODEC = StreamCodec.of(
                MixingRecipe.Serializer::write, MixingRecipe.Serializer::read);

        @Override
        public @NotNull MapCodec<MixingRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, MixingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static MixingRecipe read(RegistryFriendlyByteBuf buffer) {
            FluidStack fluid1 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack fluid2 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack fluid3 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack fluid4 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack fluid5 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack fluid6 = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            FluidStack output = FluidStack.STREAM_CODEC.decode(buffer);
            return new MixingRecipe(fluid1, fluid2, fluid3, fluid4, fluid5, fluid6, output);
        }

        private static void write(RegistryFriendlyByteBuf buffer, MixingRecipe recipe) {
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid1);
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid2);
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid3);
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid4);
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid5);
            FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluid6);
            FluidStack.STREAM_CODEC.encode(buffer, recipe.outputFluid);
        }

        static MixingRecipe createSolidifierRecipe(FluidStack fluid1, FluidStack fluid2, FluidStack fluid3, FluidStack fluid4, FluidStack fluid5, FluidStack fluid6, FluidStack output) {
            return new MixingRecipe(fluid1, fluid2, fluid3, fluid4, fluid5, fluid6, output);
        }
    }
}
