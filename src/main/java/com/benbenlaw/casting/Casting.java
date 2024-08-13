package com.benbenlaw.casting;

import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.block.entity.ModBlockEntities;
import com.benbenlaw.casting.fluid.CastingFluids;
import com.benbenlaw.casting.screen.MixerScreen;
import com.benbenlaw.casting.screen.ModMenuTypes;
import com.benbenlaw.casting.screen.SmelterScreen;
import com.benbenlaw.casting.screen.SolidifierScreen;
import com.benbenlaw.casting.item.ModCreativeModTab;
import com.benbenlaw.casting.item.ModItems;
import com.benbenlaw.casting.recipe.ModRecipes;
import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import org.slf4j.Logger;

@Mod(Casting.MOD_ID)
public class Casting {
    public static final String MOD_ID = "casting";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Casting(IEventBus modEventBus) {

        ModItems.register(modEventBus);
        //    ModDataComponents.COMPONENTS.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModCreativeModTab.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        CastingFluids.FLUIDS.register(modEventBus);

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

    @EventBusSubscriber(modid = Casting.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {


        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.SMELTER_MENU.get(), SmelterScreen::new);
            event.register(ModMenuTypes.SOLIDIFIER_MENU.get(), SolidifierScreen::new);
            event.register(ModMenuTypes.MIXER_MENU.get(), MixerScreen::new);
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(CastingFluids.MOLTEN_BRONZE.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_BRONZE.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_OBSIDIAN.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_OBSIDIAN.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_STEEL.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_STEEL.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_NETHERITE.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_NETHERITE.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_ELECTRUM.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_ELECTRUM.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_INVAR.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_INVAR.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_IRON.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_IRON.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_GOLD.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_GOLD.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_COPPER.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_COPPER.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_TIN.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_TIN.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_LEAD.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_LEAD.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_SILVER.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_SILVER.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_NICKEL.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_NICKEL.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_OSMIUM.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_OSMIUM.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_QUARTZ.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_QUARTZ.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_LAPIS.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_LAPIS.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_REDSTONE.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_REDSTONE.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_DIAMOND.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_DIAMOND.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_EMERALD.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_EMERALD.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_URANIUM.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_URANIUM.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_GLASS.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_GLASS.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_DEBRIS.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_DEBRIS.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_STONE.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_STONE.getFluidType());
            event.registerFluidType(CastingFluids.MOLTEN_COAL.getFluidType().getClientExtensions(),
                    CastingFluids.MOLTEN_COAL.getFluidType());
            
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
