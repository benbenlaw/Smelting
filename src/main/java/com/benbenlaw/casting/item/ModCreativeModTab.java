package com.benbenlaw.casting.item;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.fluid.CastingFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Casting.MOD_ID);

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

                output.accept(CastingFluids.MOLTEN_IRON.getBucket());
                output.accept(CastingFluids.MOLTEN_GOLD.getBucket());
                output.accept(CastingFluids.MOLTEN_COPPER.getBucket());
                output.accept(CastingFluids.MOLTEN_COAL.getBucket());
                output.accept(CastingFluids.MOLTEN_EMERALD.getBucket());
                output.accept(CastingFluids.MOLTEN_DIAMOND.getBucket());
                output.accept(CastingFluids.MOLTEN_LAPIS.getBucket());
                output.accept(CastingFluids.MOLTEN_REDSTONE.getBucket());
                output.accept(CastingFluids.MOLTEN_OSMIUM.getBucket());
                output.accept(CastingFluids.MOLTEN_TIN.getBucket());
                output.accept(CastingFluids.MOLTEN_URANIUM.getBucket());

                output.accept(CastingFluids.MOLTEN_BRONZE.getBucket());
                output.accept(CastingFluids.MOLTEN_STEEL.getBucket());
                output.accept(CastingFluids.MOLTEN_OBSIDIAN.getBucket());


                output.accept(ModBlocks.SOLIDIFIER.asItem());
                output.accept(ModBlocks.CONTROLLER.asItem());
                output.accept(ModBlocks.MIXER.asItem());
                output.accept(ModBlocks.TANK.asItem());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}