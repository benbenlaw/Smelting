package com.benbenlaw.casting.data;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;

import com.benbenlaw.casting.fluid.CastingFluids;
import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
import mekanism.common.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class CastingBlockStatesProvider extends BlockStateProvider {

    public CastingBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Casting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.BLACK_BRICKS);

        fluidBlocks("molten_coal", CastingFluids.MOLTEN_COAL.getBlock());
        fluidBlocks("molten_copper", CastingFluids.MOLTEN_COPPER.getBlock());
        fluidBlocks("molten_diamond", CastingFluids.MOLTEN_DIAMOND.getBlock());
        fluidBlocks("molten_emerald", CastingFluids.MOLTEN_EMERALD.getBlock());
        fluidBlocks("molten_gold", CastingFluids.MOLTEN_GOLD.getBlock());
        fluidBlocks("molten_iron", CastingFluids.MOLTEN_IRON.getBlock());
        fluidBlocks("molten_lapis", CastingFluids.MOLTEN_LAPIS.getBlock());
        fluidBlocks("molten_lead", CastingFluids.MOLTEN_LEAD.getBlock());
        fluidBlocks("molten_osmium", CastingFluids.MOLTEN_OSMIUM.getBlock());
        fluidBlocks("molten_redstone", CastingFluids.MOLTEN_REDSTONE.getBlock());
        fluidBlocks("molten_tin", CastingFluids.MOLTEN_TIN.getBlock());
        fluidBlocks("molten_uranium", CastingFluids.MOLTEN_URANIUM.getBlock());
        fluidBlocks("molten_glass", CastingFluids.MOLTEN_GLASS.getBlock());
        fluidBlocks("molten_debris", CastingFluids.MOLTEN_DEBRIS.getBlock());
        fluidBlocks("molten_quartz", CastingFluids.MOLTEN_QUARTZ.getBlock());
        fluidBlocks("molten_stone", CastingFluids.MOLTEN_STONE.getBlock());
        fluidBlocks("molten_silver", CastingFluids.MOLTEN_SILVER.getBlock());

        fluidBlocks("molten_bronze", CastingFluids.MOLTEN_BRONZE.getBlock());
        fluidBlocks("molten_obsidian", CastingFluids.MOLTEN_OBSIDIAN.getBlock());
        fluidBlocks("molten_steel", CastingFluids.MOLTEN_STEEL.getBlock());
        fluidBlocks("molten_netherite", CastingFluids.MOLTEN_NETHERITE.getBlock());
        fluidBlocks("molten_electrum", CastingFluids.MOLTEN_ELECTRUM.getBlock());





    }

    private void fluidBlocks(String name, Block block) {
        simpleBlock(block, models().getBuilder(name).texture("particle", ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/" + name + "_still")));
    }


    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    @Override
    public String getName() {
        return Casting.MOD_ID + " Block States";
    }
}
