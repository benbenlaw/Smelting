package com.benbenlaw.smelting.fluid;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.fluid.molten.alloys.bronze.MoltenBronzeFluid;
import com.benbenlaw.smelting.fluid.molten.alloys.bronze.MoltenBronzeFluidBlock;
import com.benbenlaw.smelting.fluid.molten.alloys.bronze.MoltenBronzeFluidType;
import com.benbenlaw.smelting.fluid.molten.alloys.obsidian.MoltenObsidianFluid;
import com.benbenlaw.smelting.fluid.molten.alloys.obsidian.MoltenObsidianFluidBlock;
import com.benbenlaw.smelting.fluid.molten.alloys.obsidian.MoltenObsidianFluidType;
import com.benbenlaw.smelting.fluid.molten.alloys.steel.MoltenSteelFluid;
import com.benbenlaw.smelting.fluid.molten.alloys.steel.MoltenSteelFluidBlock;
import com.benbenlaw.smelting.fluid.molten.alloys.steel.MoltenSteelFluidType;
import com.benbenlaw.smelting.fluid.molten.coal.MoltenCoalFluid;
import com.benbenlaw.smelting.fluid.molten.coal.MoltenCoalFluidBlock;
import com.benbenlaw.smelting.fluid.molten.coal.MoltenCoalFluidType;
import com.benbenlaw.smelting.fluid.molten.copper.MoltenCopperFluid;
import com.benbenlaw.smelting.fluid.molten.copper.MoltenCopperFluidBlock;
import com.benbenlaw.smelting.fluid.molten.copper.MoltenCopperFluidType;
import com.benbenlaw.smelting.fluid.molten.diamond.MoltenDiamondFluid;
import com.benbenlaw.smelting.fluid.molten.diamond.MoltenDiamondFluidBlock;
import com.benbenlaw.smelting.fluid.molten.diamond.MoltenDiamondFluidType;
import com.benbenlaw.smelting.fluid.molten.emerald.MoltenEmeraldFluid;
import com.benbenlaw.smelting.fluid.molten.emerald.MoltenEmeraldFluidBlock;
import com.benbenlaw.smelting.fluid.molten.emerald.MoltenEmeraldFluidType;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluid;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluidBlock;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluidType;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluid;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluidBlock;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluidType;
import com.benbenlaw.smelting.fluid.molten.lapis.MoltenLapisFluid;
import com.benbenlaw.smelting.fluid.molten.lapis.MoltenLapisFluidBlock;
import com.benbenlaw.smelting.fluid.molten.lapis.MoltenLapisFluidType;
import com.benbenlaw.smelting.fluid.molten.lead.MoltenLeadFluid;
import com.benbenlaw.smelting.fluid.molten.lead.MoltenLeadFluidBlock;
import com.benbenlaw.smelting.fluid.molten.lead.MoltenLeadFluidType;
import com.benbenlaw.smelting.fluid.molten.osmium.MoltenOsmiumFluid;
import com.benbenlaw.smelting.fluid.molten.osmium.MoltenOsmiumFluidBlock;
import com.benbenlaw.smelting.fluid.molten.osmium.MoltenOsmiumFluidType;
import com.benbenlaw.smelting.fluid.molten.redstone.MoltenRedstoneFluid;
import com.benbenlaw.smelting.fluid.molten.redstone.MoltenRedstoneFluidBlock;
import com.benbenlaw.smelting.fluid.molten.redstone.MoltenRedstoneFluidType;
import com.benbenlaw.smelting.fluid.molten.tin.MoltenTinFluid;
import com.benbenlaw.smelting.fluid.molten.tin.MoltenTinFluidBlock;
import com.benbenlaw.smelting.fluid.molten.tin.MoltenTinFluidType;
import com.benbenlaw.smelting.fluid.molten.uranium.MoltenUraniumFluid;
import com.benbenlaw.smelting.fluid.molten.uranium.MoltenUraniumFluidBlock;
import com.benbenlaw.smelting.fluid.molten.uranium.MoltenUraniumFluidType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Smelting.MOD_ID);
    public static final DeferredRegister.Blocks FLUID_BLOCKS =
            DeferredRegister.createBlocks(Smelting.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Smelting.MOD_ID);


    //Molten Iron

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_IRON_TYPE = FLUID_TYPES.register("molten_iron",
            MoltenIronFluidType::new);
    public static final DeferredHolder<Fluid, MoltenIronFluid> MOLTEN_IRON_FLOWING = FLUIDS.register("molten_iron_flowing",
            MoltenIronFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenIronFluid> MOLTEN_IRON_SOURCE = FLUIDS.register("molten_iron",
            MoltenIronFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_IRON_BLOCK = FLUID_BLOCKS.register("molten_iron_block",
            MoltenIronFluidBlock::new);

    //Molten Gold

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_GOLD_TYPE = FLUID_TYPES.register("molten_gold",
            MoltenGoldFluidType::new);
    public static final DeferredHolder<Fluid, MoltenGoldFluid> MOLTEN_GOLD_FLOWING = FLUIDS.register("molten_gold_flowing",
            MoltenGoldFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenGoldFluid> MOLTEN_GOLD_SOURCE = FLUIDS.register("molten_gold",
            MoltenGoldFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_GOLD_BLOCK = FLUID_BLOCKS.register("molten_gold_block",
            MoltenGoldFluidBlock::new);

    //Molten Copper

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_COPPER_TYPE = FLUID_TYPES.register("molten_copper",
            MoltenCopperFluidType::new);
    public static final DeferredHolder<Fluid, MoltenCopperFluid> MOLTEN_COPPER_FLOWING = FLUIDS.register("molten_copper_flowing",
            MoltenCopperFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenCopperFluid> MOLTEN_COPPER_SOURCE = FLUIDS.register("molten_copper",
            MoltenCopperFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_COPPER_BLOCK = FLUID_BLOCKS.register("molten_copper_block",
            MoltenCopperFluidBlock::new);

    //Molten Coal

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_COAL_TYPE = FLUID_TYPES.register("molten_coal",
            MoltenCoalFluidType::new);
    public static final DeferredHolder<Fluid, MoltenCoalFluid> MOLTEN_COAL_FLOWING = FLUIDS.register("molten_coal_flowing",
            MoltenCoalFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenCoalFluid> MOLTEN_COAL_SOURCE = FLUIDS.register("molten_coal",
            MoltenCoalFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_COAL_BLOCK = FLUID_BLOCKS.register("molten_coal_block",
            MoltenCoalFluidBlock::new);

    //Molted Emerald

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_EMERALD_TYPE = FLUID_TYPES.register("molten_emerald",
            MoltenEmeraldFluidType::new);
    public static final DeferredHolder<Fluid, MoltenEmeraldFluid> MOLTEN_EMERALD_FLOWING = FLUIDS.register("molten_emerald_flowing",
            MoltenEmeraldFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenEmeraldFluid> MOLTEN_EMERALD_SOURCE = FLUIDS.register("molten_emerald",
            MoltenEmeraldFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_EMERALD_BLOCK = FLUID_BLOCKS.register("molten_emerald_block",
            MoltenEmeraldFluidBlock::new);

    //Molten Redstone

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_REDSTONE_TYPE = FLUID_TYPES.register("molten_redstone",
            MoltenRedstoneFluidType::new);
    public static final DeferredHolder<Fluid, MoltenRedstoneFluid> MOLTEN_REDSTONE_FLOWING = FLUIDS.register("molten_redstone_flowing",
            MoltenRedstoneFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenRedstoneFluid> MOLTEN_REDSTONE_SOURCE = FLUIDS.register("molten_redstone",
            MoltenRedstoneFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_REDSTONE_BLOCK = FLUID_BLOCKS.register("molten_redstone_block",
            MoltenRedstoneFluidBlock::new);

    //Lapis

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_LAPIS_TYPE = FLUID_TYPES.register("molten_lapis",
            MoltenLapisFluidType::new);
    public static final DeferredHolder<Fluid, MoltenLapisFluid> MOLTEN_LAPIS_FLOWING = FLUIDS.register("molten_lapis_flowing",
            MoltenLapisFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenLapisFluid> MOLTEN_LAPIS_SOURCE = FLUIDS.register("molten_lapis",
            MoltenLapisFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_LAPIS_BLOCK = FLUID_BLOCKS.register("molten_lapis_block",
            MoltenLapisFluidBlock::new);

    //Diamond

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_DIAMOND_TYPE = FLUID_TYPES.register("molten_diamond",
            MoltenDiamondFluidType::new);
    public static final DeferredHolder<Fluid, MoltenDiamondFluid> MOLTEN_DIAMOND_FLOWING = FLUIDS.register("molten_diamond_flowing",
            MoltenDiamondFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenDiamondFluid> MOLTEN_DIAMOND_SOURCE = FLUIDS.register("molten_diamond",
            MoltenDiamondFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_DIAMOND_BLOCK = FLUID_BLOCKS.register("molten_diamond_block",
            MoltenDiamondFluidBlock::new);

    //Molten Tin
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_TIN_TYPE = FLUID_TYPES.register("molten_tin",
            MoltenTinFluidType::new);
    public static final DeferredHolder<Fluid, MoltenTinFluid> MOLTEN_TIN_FLOWING = FLUIDS.register("molten_tin_flowing",
            MoltenTinFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenTinFluid> MOLTEN_TIN_SOURCE = FLUIDS.register("molten_tin",
            MoltenTinFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_TIN_BLOCK = FLUID_BLOCKS.register("molten_tin_block",
            MoltenTinFluidBlock::new);

    //Molten Osmium
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_OSMIUM_TYPE = FLUID_TYPES.register("molten_osmium",
            MoltenOsmiumFluidType::new);
    public static final DeferredHolder<Fluid, MoltenOsmiumFluid> MOLTEN_OSMIUM_FLOWING = FLUIDS.register("molten_osmium_flowing",
            MoltenOsmiumFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenOsmiumFluid> MOLTEN_OSMIUM_SOURCE = FLUIDS.register("molten_osmium",
            MoltenOsmiumFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_OSMIUM_BLOCK = FLUID_BLOCKS.register("molten_osmium_block",
            MoltenOsmiumFluidBlock::new);

    //Molten Uranium
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_URANIUM_TYPE = FLUID_TYPES.register("molten_uranium",
            MoltenUraniumFluidType::new);
    public static final DeferredHolder<Fluid, MoltenUraniumFluid> MOLTEN_URANIUM_FLOWING = FLUIDS.register("molten_uranium_flowing",
            MoltenUraniumFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenUraniumFluid> MOLTEN_URANIUM_SOURCE = FLUIDS.register("molten_uranium",
            MoltenUraniumFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_URANIUM_BLOCK = FLUID_BLOCKS.register("molten_uranium_block",
            MoltenUraniumFluidBlock::new);

    //Molten Lead
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_LEAD_TYPE = FLUID_TYPES.register("molten_lead",
            MoltenLeadFluidType::new);
    public static final DeferredHolder<Fluid, MoltenLeadFluid> MOLTEN_LEAD_FLOWING = FLUIDS.register("molten_lead_flowing",
            MoltenLeadFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenLeadFluid> MOLTEN_LEAD_SOURCE = FLUIDS.register("molten_lead",
            MoltenLeadFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_LEAD_BLOCK = FLUID_BLOCKS.register("molten_lead_block",
            MoltenLeadFluidBlock::new);



    // *********** Obsidian *********** //

    //Molten Obsidian
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_OBSIDIAN_TYPE = FLUID_TYPES.register("molten_obsidian",
            MoltenObsidianFluidType::new);

    public static final DeferredHolder<Fluid, MoltenObsidianFluid> MOLTEN_OBSIDIAN_FLOWING = FLUIDS.register("molten_obsidian_flowing",
            MoltenObsidianFluid.Flowing::new);

    public static final DeferredHolder<Fluid, MoltenObsidianFluid> MOLTEN_OBSIDIAN_SOURCE = FLUIDS.register("molten_obsidian",
            MoltenObsidianFluid.Source::new);

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_OBSIDIAN_BLOCK = FLUID_BLOCKS.register("molten_obsidian_block",
            MoltenObsidianFluidBlock::new);

    //Molten Bronze

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_BRONZE_TYPE = FLUID_TYPES.register("molten_bronze",
            MoltenBronzeFluidType::new);
    public static final DeferredHolder<Fluid, MoltenBronzeFluid> MOLTEN_BRONZE_FLOWING = FLUIDS.register("molten_bronze_flowing",
            MoltenBronzeFluid.Flowing::new);

    public static final DeferredHolder<Fluid, MoltenBronzeFluid> MOLTEN_BRONZE_SOURCE = FLUIDS.register("molten_bronze",
            MoltenBronzeFluid.Source::new);

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_BRONZE_BLOCK = FLUID_BLOCKS.register("molten_bronze_block",
            MoltenBronzeFluidBlock::new);

    //Molten Steel

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_STEEL_TYPE = FLUID_TYPES.register("molten_steel",
            MoltenSteelFluidType::new);

    public static final DeferredHolder<Fluid, MoltenSteelFluid> MOLTEN_STEEL_FLOWING = FLUIDS.register("molten_steel_flowing",
            MoltenSteelFluid.Flowing::new);

    public static final DeferredHolder<Fluid, MoltenSteelFluid> MOLTEN_STEEL_SOURCE = FLUIDS.register("molten_steel",
            MoltenSteelFluid.Source::new);

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_STEEL_BLOCK = FLUID_BLOCKS.register("molten_steel_block",
            MoltenSteelFluidBlock::new);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_BLOCKS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}