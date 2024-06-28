package com.benbenlaw.smelting.data;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SmeltingBlockStatesProvider extends BlockStateProvider {

    public SmeltingBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Smelting.MOD_ID, existingFileHelper);
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
        return Smelting.MOD_ID + " Block States";
    }
}
