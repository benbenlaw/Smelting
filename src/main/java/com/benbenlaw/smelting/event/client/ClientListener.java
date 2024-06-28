package com.benbenlaw.smelting.event.client;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.entity.ModBlockEntities;
import com.benbenlaw.smelting.block.entity.client.TankBlockEntityRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Smelting.MOD_ID, bus = EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {


        event.registerBlockEntityRenderer(ModBlockEntities.TANK_BLOCK_ENTITY.get(),
                TankBlockEntityRenderer::new);

    }

}
