package com.benbenlaw.smelting.item;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.fluid.ModFluids;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Smelting.MOD_ID);

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


    //BUCKETS


    public static final DeferredItem<BucketItem> MOLTEN_IRON_BUCKET = ITEMS.register("molten_iron_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_IRON_FLUID_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final DeferredItem<BucketItem> MOLTEN_GOLD_BUCKET = ITEMS.register("molten_gold_bucket",
            () -> new BucketItem(ModFluids.MOLTEN_GOLD_FLUID_SOURCE.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
