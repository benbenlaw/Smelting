package com.benbenlaw.casting.fluid;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
import com.benbenlaw.opolisutilities.fluid.FluidRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class CastingFluids {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(Casting.MOD_ID);


    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_COAL;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_COPPER;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_DIAMOND;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_EMERALD;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_GOLD;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_IRON;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_LAPIS;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_LEAD;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_OSMIUM;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_REDSTONE;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_TIN;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_URANIUM;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_DEBRIS;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_QUARTZ;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_GLASS;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_STONE;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_SILVER;



    //ALLOYS

    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_BRONZE;
        public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_ELECTRUM;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_OBSIDIAN;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_STEEL;
    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> MOLTEN_NETHERITE;



    private CastingFluids() {
    }

    static {

        MOLTEN_COAL = FLUIDS.register("molten_coal", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_coal_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_coal_flow")));

        MOLTEN_COPPER = FLUIDS.register("molten_copper", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_copper_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_copper_flow")));

        MOLTEN_DIAMOND = FLUIDS.register("molten_diamond", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_diamond_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_diamond_flow")));

        MOLTEN_EMERALD = FLUIDS.register("molten_emerald", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_emerald_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_emerald_flow")));

        MOLTEN_GOLD = FLUIDS.register("molten_gold", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_gold_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_gold_flow")));

        MOLTEN_IRON = FLUIDS.register("molten_iron", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_iron_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_iron_flow")));

        MOLTEN_LAPIS = FLUIDS.register("molten_lapis", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_lapis_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_lapis_flow")));

        MOLTEN_LEAD = FLUIDS.register("molten_lead", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_lead_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_lead_flow")));

        MOLTEN_OSMIUM = FLUIDS.register("molten_osmium", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_osmium_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_osmium_flow")));

        MOLTEN_REDSTONE = FLUIDS.register("molten_redstone", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_redstone_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_redstone_flow")));

        MOLTEN_TIN = FLUIDS.register("molten_tin", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_tin_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_tin_flow")));

        MOLTEN_URANIUM = FLUIDS.register("molten_uranium", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_uranium_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_uranium_flow")));

        MOLTEN_DEBRIS = FLUIDS.register("molten_debris", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_debris_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_debris_flow")));

        MOLTEN_QUARTZ = FLUIDS.register("molten_quartz", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_quartz_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_quartz_flow")));

        MOLTEN_GLASS = FLUIDS.register("molten_glass", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_glass_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_glass_flow")));

        MOLTEN_STONE = FLUIDS.register("molten_stone", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_stone_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_stone_flow")));

        MOLTEN_SILVER = FLUIDS.register("molten_silver", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_silver_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_silver_flow")));





        //ALLOYS

        MOLTEN_BRONZE = FLUIDS.register("molten_bronze", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_bronze_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_bronze_flow")));

        MOLTEN_OBSIDIAN = FLUIDS.register("molten_obsidian", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_obsidian_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_obsidian_flow")));

        MOLTEN_STEEL = FLUIDS.register("molten_steel", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_steel_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_steel_flow")));

        MOLTEN_NETHERITE = FLUIDS.register("molten_netherite", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_netherite_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_netherite_flow")));

        MOLTEN_ELECTRUM = FLUIDS.register("molten_electrum", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_electrum_still"),
                        ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "block/molten_electrum_flow")));


    }

}
