package com.benbenlaw.casting.fluid.molten.alloys.obsidian;

import com.benbenlaw.casting.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoltenObsidianFluidBlock extends LiquidBlock {

    public MoltenObsidianFluidBlock() {
        super(ModFluids.MOLTEN_OBSIDIAN_SOURCE.get(), Properties.of()
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