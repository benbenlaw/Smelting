package com.benbenlaw.smelting.fluid;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluid;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluidBlock;
import com.benbenlaw.smelting.fluid.molten.gold.MoltenGoldFluidType;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluid;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluidBlock;
import com.benbenlaw.smelting.fluid.molten.iron.MoltenIronFluidType;
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

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_IRON_FLUID_TYPE = FLUID_TYPES.register("molten_iron_fluid",
            MoltenIronFluidType::new);
    public static final DeferredHolder<Fluid, MoltenIronFluid> MOLTEN_IRON_FLUID_FLOWING = FLUIDS.register("molten_iron_fluid_flowing",
            MoltenIronFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenIronFluid> MOLTEN_IRON_FLUID_SOURCE = FLUIDS.register("molten_iron_fluid",
            MoltenIronFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_IRON_FLUID_BLOCK = FLUID_BLOCKS.register("molten_iron_fluid_block",
            MoltenIronFluidBlock::new);

    //Molten Gold

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_GOLD_FLUID_TYPE = FLUID_TYPES.register("molten_gold_fluid",
            MoltenGoldFluidType::new);
    public static final DeferredHolder<Fluid, MoltenGoldFluid> MOLTEN_GOLD_FLUID_FLOWING = FLUIDS.register("molten_gold_fluid_flowing",
            MoltenGoldFluid.Flowing::new);
    public static final DeferredHolder<Fluid, MoltenGoldFluid> MOLTEN_GOLD_FLUID_SOURCE = FLUIDS.register("molten_gold_fluid",
            MoltenGoldFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_GOLD_FLUID_BLOCK = FLUID_BLOCKS.register("molten_gold_fluid_block",
            MoltenGoldFluidBlock::new);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_BLOCKS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}