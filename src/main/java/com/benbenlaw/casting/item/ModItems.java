package com.benbenlaw.casting.item;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Casting.MOD_ID);

    public static final DeferredItem<Item> INGOT_MOLD = ITEMS.register("ingot_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NUGGET_MOLD = ITEMS.register("nugget_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GEAR_MOLD = ITEMS.register("gear_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLATE_MOLD = ITEMS.register("plate_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROD_MOLD = ITEMS.register("rod_mold",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLOCK_MOLD = ITEMS.register("block_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GEM_MOLD = ITEMS.register("gem_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DUST_MOLD = ITEMS.register("dust_mold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACK_BRICK = ITEMS.register("black_brick",
            () -> new Item(new Item.Properties()));



    //BUCKETS


    public static final DeferredItem<BucketItem> MOLTEN_IRON_BUCKET = ITEMS.register("molten_iron_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_IRON_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_GOLD_BUCKET = ITEMS.register("molten_gold_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_GOLD_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_COPPER_BUCKET = ITEMS.register("molten_copper_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_COPPER_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_COAL_BUCKET = ITEMS.register("molten_coal_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_COAL_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_EMERALD_BUCKET = ITEMS.register("molten_emerald_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_EMERALD_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_REDSTONE_BUCKET = ITEMS.register("molten_redstone_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_REDSTONE_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_DIAMOND_BUCKET = ITEMS.register("molten_diamond_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_DIAMOND_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_TIN_BUCKET = ITEMS.register("molten_tin_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_TIN_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_OSMIUM_BUCKET = ITEMS.register("molten_osmium_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_OSMIUM_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final DeferredItem<BucketItem> MOLTEN_URANIUM_BUCKET = ITEMS.register("molten_uranium_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_URANIUM_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_LEAD_BUCKET = ITEMS.register("molten_lead_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_LEAD_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final DeferredItem<BucketItem> MOLTEN_LAPIS_BUCKET = ITEMS.register("molten_lapis_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_LAPIS_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_OBSIDIAN_BUCKET = ITEMS.register("molten_obsidian_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_OBSIDIAN_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final DeferredItem<BucketItem> MOLTEN_BRONZE_BUCKET = ITEMS.register("molten_bronze_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_BRONZE_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final DeferredItem<BucketItem> MOLTEN_STEEL_BUCKET = ITEMS.register("molten_steel_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_STEEL_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
