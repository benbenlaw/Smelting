package com.benbenlaw.casting.fluid.molten.redstone;

import com.benbenlaw.casting.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoltenRedstoneFluidBlock extends LiquidBlock {

    public MoltenRedstoneFluidBlock() {
        super(ModFluids.MOLTEN_REDSTONE_SOURCE.get(), Properties.of()
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
