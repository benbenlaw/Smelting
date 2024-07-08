package com.benbenlaw.casting.fluid.molten.alloys.obsidian;

import com.benbenlaw.casting.Casting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

public class MoltenObsidianFluidType extends FluidType {

    public MoltenObsidianFluidType() {
        super(Properties.create()
                .density(1000)
                .viscosity(1000)
                .temperature(1000)
                .canSwim(true)
                .canDrown(true)
                .fallDistanceModifier(0F)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @Override
    public boolean canConvertToSource(FluidState state, LevelReader reader, BlockPos pos) {
        return false;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            private static final ResourceLocation UNDERWATER_LOCATION = ResourceLocation.withDefaultNamespace("textures/misc/underwater.png"),
                    MOLTEN_OBSIDIAN_STILL = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_obsidian_still"),
                    MOLTEN_OBSIDIAN_FLOW = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_obsidian_flow"),
                    MOLTEN_OBSIDIAN_OVERLAY = ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_obsidian_overlay");

            @Override
            public ResourceLocation getStillTexture() {
                return MOLTEN_OBSIDIAN_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return MOLTEN_OBSIDIAN_FLOW;
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return MOLTEN_OBSIDIAN_OVERLAY;
            }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return UNDERWATER_LOCATION;
            }

            @Override
            public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
                return 0xFFFFFFFF;
            }

        });
    }
}