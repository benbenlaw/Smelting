package com.benbenlaw.casting.data;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;

import com.benbenlaw.casting.fluid.CastingFluids;
import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
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
        fluidBlocks("molten_nickel", CastingFluids.MOLTEN_NICKEL.getBlock());
        fluidBlocks("molten_aluminum", CastingFluids.MOLTEN_ALUMINUM.getBlock());
        fluidBlocks("molten_zinc", CastingFluids.MOLTEN_ZINC.getBlock());
        fluidBlocks("molten_platinum", CastingFluids.MOLTEN_PLATINUM.getBlock());
        fluidBlocks("molten_iridium", CastingFluids.MOLTEN_IRIDIUM.getBlock());
        fluidBlocks("molten_glowstone", CastingFluids.MOLTEN_GLOWSTONE.getBlock());
        fluidBlocks("molten_ender", CastingFluids.MOLTEN_ENDER.getBlock());
        fluidBlocks("molten_end_stone", CastingFluids.MOLTEN_END_STONE.getBlock());
        fluidBlocks("molten_silicon", CastingFluids.MOLTEN_SILICON.getBlock());
        fluidBlocks("molten_soul", CastingFluids.MOLTEN_SOUL.getBlock());

        fluidBlocks("molten_bronze", CastingFluids.MOLTEN_BRONZE.getBlock());
        fluidBlocks("molten_obsidian", CastingFluids.MOLTEN_OBSIDIAN.getBlock());
        fluidBlocks("molten_steel", CastingFluids.MOLTEN_STEEL.getBlock());
        fluidBlocks("molten_netherite", CastingFluids.MOLTEN_NETHERITE.getBlock());
        fluidBlocks("molten_electrum", CastingFluids.MOLTEN_ELECTRUM.getBlock());
        fluidBlocks("molten_invar", CastingFluids.MOLTEN_INVAR.getBlock());
        fluidBlocks("molten_signalum", CastingFluids.MOLTEN_SIGNALUM.getBlock());
        fluidBlocks("molten_lumium", CastingFluids.MOLTEN_LUMIUM.getBlock());
        fluidBlocks("molten_enderium", CastingFluids.MOLTEN_ENDERIUM.getBlock());
        fluidBlocks("molten_constantan", CastingFluids.MOLTEN_CONSTANTAN.getBlock());
        fluidBlocks("molten_brass", CastingFluids.MOLTEN_BRASS.getBlock());
        fluidBlocks("molten_energetic_alloy", CastingFluids.MOLTEN_ENERGETIC_ALLOY.getBlock());
        fluidBlocks("molten_vibrant_alloy", CastingFluids.MOLTEN_VIBRANT_ALLOY.getBlock());
        fluidBlocks("molten_pulsating_alloy", CastingFluids.MOLTEN_PULSATING_ALLOY.getBlock());
        fluidBlocks("molten_copper_alloy", CastingFluids.MOLTEN_COPPER_ALLOY.getBlock());
        fluidBlocks("molten_dark_steel", CastingFluids.MOLTEN_DARK_STEEL.getBlock());
        fluidBlocks("molten_soularium", CastingFluids.MOLTEN_SOULARIUM.getBlock());
        fluidBlocks("molten_end_steel", CastingFluids.MOLTEN_END_STEEL.getBlock());
        fluidBlocks("molten_conductive_alloy", CastingFluids.MOLTEN_CONDUCTIVE_ALLOY.getBlock());
        fluidBlocks("molten_redstone_alloy", CastingFluids.MOLTEN_REDSTONE_ALLOY.getBlock());

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
