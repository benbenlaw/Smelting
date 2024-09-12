package com.benbenlaw.casting.item;

import com.benbenlaw.casting.Casting;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CastingDataComponents {

    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.createDataComponents(Casting.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE =
            COMPONENTS.register("fluid_type", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT =
            COMPONENTS.register("fluid_amount", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_1 =
            COMPONENTS.register("fluid_type_1", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_1 =
            COMPONENTS.register("fluid_amount_1", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_2 =
            COMPONENTS.register("fluid_type_2", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_2 =
            COMPONENTS.register("fluid_amount_2", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_3 =
            COMPONENTS.register("fluid_type_3", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_3 =
            COMPONENTS.register("fluid_amount_3", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_4 =
            COMPONENTS.register("fluid_type_4", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_4 =
            COMPONENTS.register("fluid_amount_4", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_5 =
            COMPONENTS.register("fluid_type_5", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_5 =
            COMPONENTS.register("fluid_amount_5", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FLUID_TYPE_6 =
            COMPONENTS.register("fluid_type_6", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLUID_AMOUNT_6 =
            COMPONENTS.register("fluid_amount_6", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> OUTPUT_FLUID_1 =
            COMPONENTS.register("output_fluid_1", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> OUTPUT_FLUID_AMOUNT_1 =
            COMPONENTS.register("output_fluid_amount_1", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> OUTPUT_FLUID_2 =
            COMPONENTS.register("output_fluid_2", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> OUTPUT_FLUID_AMOUNT_2 =
            COMPONENTS.register("output_fluid_amount_2", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> OUTPUT_FLUID_3 =
            COMPONENTS.register("output_fluid_3", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> OUTPUT_FLUID_AMOUNT_3 =
            COMPONENTS.register("output_fluid_amount_3", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> OUTPUT_FLUID_4 =
            COMPONENTS.register("output_fluid_4", () ->
                    DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> OUTPUT_FLUID_AMOUNT_4 =
            COMPONENTS.register("output_fluid_amount_4", () ->
                    DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());









    private static @NotNull <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, final Codec<T> codec, @Nullable final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        if (streamCodec == null) {
            return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).build());
        } else {
            return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).networkSynchronized(streamCodec).build());
        }
    }



}
