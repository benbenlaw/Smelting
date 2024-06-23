package com.benbenlaw.smelting.item;

import com.benbenlaw.smelting.Smelting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Smelting.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SMELTING_TAB = CREATIVE_MODE_TABS.register("smelting", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.BLACK_APPLE.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.smelting"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.BLACK_APPLE);

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}