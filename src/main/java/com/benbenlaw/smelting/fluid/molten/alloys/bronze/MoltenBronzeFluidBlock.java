package com.benbenlaw.smelting.fluid.molten.alloys.bronze;

import com.benbenlaw.smelting.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoltenBronzeFluidBlock extends LiquidBlock {

    public MoltenBronzeFluidBlock() {
        super(ModFluids.MOLTEN_BRONZE_SOURCE.get(), Properties.of()
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
