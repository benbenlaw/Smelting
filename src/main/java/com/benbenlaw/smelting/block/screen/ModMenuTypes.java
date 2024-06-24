package com.benbenlaw.smelting.block.screen;

import com.benbenlaw.smelting.Smelting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, Smelting.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<SmelterMenu>> SMELTER_MENU;
    public static final DeferredHolder<MenuType<?>, MenuType<SolidifierMenu>> SOLIDIFIER_MENU;

    static {
        SMELTER_MENU = MENUS.register("smelter_menu", () ->
                IMenuTypeExtension.create(SmelterMenu::new));

        SOLIDIFIER_MENU = MENUS.register("solidifier_menu", () ->
                IMenuTypeExtension.create(SolidifierMenu::new));
    }


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);


    }
}