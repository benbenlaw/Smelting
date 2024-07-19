package com.benbenlaw.casting.data;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.fluid.CastingFluids;
import com.benbenlaw.casting.item.ModItems;
import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.DynamicFluidContainerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class CastingItemModelProvider extends ItemModelProvider {

    public CastingItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Casting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Misc Items
        simpleItem(ModItems.BLOCK_MOLD);
        simpleItem(ModItems.GEAR_MOLD);
        simpleItem(ModItems.INGOT_MOLD);
        simpleItem(ModItems.NUGGET_MOLD);
        simpleItem(ModItems.PLATE_MOLD);
        simpleItem(ModItems.ROD_MOLD);
        simpleItem(ModItems.GEM_MOLD);
        simpleItem(ModItems.DUST_MOLD);
        simpleItem(ModItems.BLACK_BRICK);

        simpleBucketItem("molten_coal_bucket", CastingFluids.MOLTEN_COAL.getFluid());
        simpleBucketItem("molten_copper_bucket", CastingFluids.MOLTEN_COPPER.getFluid());
        simpleBucketItem("molten_diamond_bucket", CastingFluids.MOLTEN_DIAMOND.getFluid());
        simpleBucketItem("molten_emerald_bucket", CastingFluids.MOLTEN_EMERALD.getFluid());
        simpleBucketItem("molten_gold_bucket", CastingFluids.MOLTEN_GOLD.getFluid());
        simpleBucketItem("molten_iron_bucket", CastingFluids.MOLTEN_IRON.getFluid());
        simpleBucketItem("molten_lapis_bucket", CastingFluids.MOLTEN_LAPIS.getFluid());
        simpleBucketItem("molten_lead_bucket", CastingFluids.MOLTEN_LEAD.getFluid());
        simpleBucketItem("molten_osmium_bucket", CastingFluids.MOLTEN_OSMIUM.getFluid());
        simpleBucketItem("molten_redstone_bucket", CastingFluids.MOLTEN_REDSTONE.getFluid());
        simpleBucketItem("molten_tin_bucket", CastingFluids.MOLTEN_TIN.getFluid());
        simpleBucketItem("molten_uranium_bucket", CastingFluids.MOLTEN_URANIUM.getFluid());
        simpleBucketItem("molten_glass_bucket", CastingFluids.MOLTEN_GLASS.getFluid());
        simpleBucketItem("molten_debris_bucket", CastingFluids.MOLTEN_DEBRIS.getFluid());
        simpleBucketItem("molten_quartz_bucket", CastingFluids.MOLTEN_QUARTZ.getFluid());
        simpleBucketItem("molten_stone_bucket", CastingFluids.MOLTEN_STONE.getFluid());
        simpleBucketItem("molten_silver_bucket", CastingFluids.MOLTEN_SILVER.getFluid());

        simpleBucketItem("molten_bronze_bucket", CastingFluids.MOLTEN_BRONZE.getFluid());
        simpleBucketItem("molten_obsidian_bucket", CastingFluids.MOLTEN_OBSIDIAN.getFluid());
        simpleBucketItem("molten_steel_bucket", CastingFluids.MOLTEN_STEEL.getFluid());
        simpleBucketItem("molten_netherite_bucket", CastingFluids.MOLTEN_NETHERITE.getFluid());
        simpleBucketItem("molten_electrum_bucket", CastingFluids.MOLTEN_ELECTRUM.getFluid());





    }

    private void simpleBucketItem(String name, Fluid fluid) {
        withExistingParent(name, ResourceLocation.fromNamespaceAndPath(NeoForgeVersion.MOD_ID, "item/bucket"))
                .customLoader(DynamicFluidContainerModelBuilder::begin)
                .fluid(fluid);
    }


    private void simpleItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID,"item/" + item.getId().getPath()));
    }


    @Override
    public String getName() {
        return Casting.MOD_ID + " Item Models";
    }
}
