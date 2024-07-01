package com.benbenlaw.smelting.data;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class SmeltingItemModelProvider extends ItemModelProvider {

    public SmeltingItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Smelting.MOD_ID, existingFileHelper);
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

        simpleBucketItem(ModItems.MOLTEN_GOLD_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_IRON_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_REDSTONE_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_OSMIUM_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_URANIUM_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_COPPER_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_TIN_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_LEAD_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_EMERALD_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_DIAMOND_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_LAPIS_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_COAL_BUCKET);

        simpleBucketItem(ModItems.MOLTEN_OBSIDIAN_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_STEEL_BUCKET);
        simpleBucketItem(ModItems.MOLTEN_BRONZE_BUCKET);


    }


    private void simpleItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void simpleBucketItem(DeferredItem<BucketItem> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID,"item/" + item.getId().getPath()));
    }


    @Override
    public String getName() {
        return Smelting.MOD_ID + " Item Models";
    }
}
