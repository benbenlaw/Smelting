package com.benbenlaw.smelting.item;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;
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
            .icon(() -> ModItems.PLATE_MOLD.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.smelting"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.GEAR_MOLD);
                output.accept(ModItems.PLATE_MOLD);
                output.accept(ModItems.INGOT_MOLD);
                output.accept(ModItems.NUGGET_MOLD);
                output.accept(ModItems.ROD_MOLD);
                output.accept(ModItems.BLOCK_MOLD);
                output.accept(ModItems.GEM_MOLD);
                output.accept(ModItems.DUST_MOLD);
                output.accept(ModItems.BLACK_BRICK);
                output.accept(ModBlocks.BLACK_BRICKS);

                output.accept(ModItems.MOLTEN_IRON_BUCKET);
                output.accept(ModItems.MOLTEN_GOLD_BUCKET);
                output.accept(ModItems.MOLTEN_COPPER_BUCKET);
                output.accept(ModItems.MOLTEN_COAL_BUCKET);
                output.accept(ModItems.MOLTEN_EMERALD_BUCKET);
                output.accept(ModItems.MOLTEN_DIAMOND_BUCKET);
                output.accept(ModItems.MOLTEN_LAPIS_BUCKET);
                output.accept(ModItems.MOLTEN_REDSTONE_BUCKET);
                output.accept(ModItems.MOLTEN_OSMIUM_BUCKET);
                output.accept(ModItems.MOLTEN_TIN_BUCKET);
                output.accept(ModItems.MOLTEN_URANIUM_BUCKET);

                output.accept(ModItems.MOLTEN_BRONZE_BUCKET);
                output.accept(ModItems.MOLTEN_STEEL_BUCKET);
                output.accept(ModItems.MOLTEN_OBSIDIAN_BUCKET);

                output.accept(ModBlocks.SOLIDIFIER.asItem());
                output.accept(ModBlocks.CONTROLLER.asItem());
                output.accept(ModBlocks.MIXER.asItem());
                output.accept(ModBlocks.TANK.asItem());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}