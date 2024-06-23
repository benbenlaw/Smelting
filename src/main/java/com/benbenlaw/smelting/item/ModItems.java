package com.benbenlaw.smelting.item;

import com.benbenlaw.smelting.Smelting;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Smelting.MOD_ID);

    public static final DeferredItem<Item> BLACK_APPLE = ITEMS.register("black_apple",
            () -> new Item(new Item.Properties().food(Foods.APPLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
