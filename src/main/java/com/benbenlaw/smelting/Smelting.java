package com.benbenlaw.smelting;

import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.block.entity.ModBlockEntities;
import com.benbenlaw.smelting.screen.MixerScreen;
import com.benbenlaw.smelting.screen.ModMenuTypes;
import com.benbenlaw.smelting.screen.SmelterScreen;
import com.benbenlaw.smelting.screen.SolidifierScreen;
import com.benbenlaw.smelting.fluid.ModFluids;
import com.benbenlaw.smelting.item.ModCreativeModTab;
import com.benbenlaw.smelting.item.ModItems;
import com.benbenlaw.smelting.recipe.ModRecipes;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
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
        ModFluids.register(modEventBus);

        modEventBus.addListener(this::registerCapabilities);

        //    ModParticles.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

      //  ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, ConfigFile.SPEC, "smelting.toml");

    }

    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        ModBlockEntities.registerCapabilities(event);
    }

    public void commonSetup(RegisterPayloadHandlersEvent event) {
   //     ModMessages.registerNetworking(event);
    }

    @EventBusSubscriber(modid = Smelting.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {


        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.SMELTER_MENU.get(), SmelterScreen::new);
            event.register(ModMenuTypes.SOLIDIFIER_MENU.get(), SolidifierScreen::new);
            event.register(ModMenuTypes.MIXER_MENU.get(), MixerScreen::new);
        }


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

                // Only Needed if i need a translucent fluid otherwise should be ok? //


           //     ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_URANIUM_SOURCE.get(), RenderType.translucent());
           //     ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_URANIUM_FLOWING.get(), RenderType.translucent());


            });
        }
    }
}
