package com.benbenlaw.smelting;

import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.block.entity.ModBlockEntities;
import com.benbenlaw.smelting.block.screen.ModMenuTypes;
import com.benbenlaw.smelting.block.screen.SmelterScreen;
import com.benbenlaw.smelting.item.ModCreativeModTab;
import com.benbenlaw.smelting.item.ModItems;
import com.benbenlaw.smelting.recipe.ModRecipes;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import org.slf4j.Logger;

@Mod(Smelting.MOD_ID)
public class Smelting {
    public static final String MOD_ID = "smelting";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Smelting(IEventBus modEventBus) {

        ModItems.register(modEventBus);
        //    ModDataComponents.COMPONENTS.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModCreativeModTab.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::registerCapabilities);

        //    ModParticles.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

      //  ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, ConfigFile.SPEC, "smelting.toml");

    }

    public void registerCapabilities(RegisterCapabilitiesEvent event) {
   //     ModBlockEntities.registerCapabilities(event);
    }

    public void commonSetup(RegisterPayloadHandlersEvent event) {
   //     ModMessages.registerNetworking(event);
    }

    @EventBusSubscriber(modid = Smelting.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.SMELTER_MENU.get(), SmelterScreen::new);
        }
    }
}
