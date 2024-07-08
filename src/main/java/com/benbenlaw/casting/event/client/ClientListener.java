package com.benbenlaw.casting.event.client;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.block.entity.ModBlockEntities;
import com.benbenlaw.casting.block.entity.client.TankBlockEntityRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Casting.MOD_ID, bus = EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {


        event.registerBlockEntityRenderer(ModBlockEntities.TANK_BLOCK_ENTITY.get(),
                TankBlockEntityRenderer::new);

    }

}
