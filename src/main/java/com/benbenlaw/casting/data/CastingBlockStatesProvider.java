package com.benbenlaw.casting.data;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CastingBlockStatesProvider extends BlockStateProvider {

    public CastingBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Casting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    //    blockWithItem(ModBlocks.CONTROLLER);
    //    blockWithItem(ModBlocks.SOLIDIFIER);
    //    blockWithItem(ModBlocks.TANK);
          blockWithItem(ModBlocks.BLACK_BRICKS);


    }


    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    @Override
    public String getName() {
        return Casting.MOD_ID + " Block States";
    }
}
