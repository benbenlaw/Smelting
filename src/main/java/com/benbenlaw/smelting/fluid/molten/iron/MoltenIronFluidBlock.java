package com.benbenlaw.smelting.fluid.molten.iron;

import com.benbenlaw.smelting.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoltenIronFluidBlock extends LiquidBlock {

    public MoltenIronFluidBlock() {
        super(ModFluids.MOLTEN_IRON_FLUID_SOURCE.get(), Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .replaceable()
                .noCollission()
                .strength(100.0F)
                .pushReaction(PushReaction.DESTROY)
                .noLootTable()
                .liquid()
                .sound(SoundType.EMPTY)
        );
    }
}
