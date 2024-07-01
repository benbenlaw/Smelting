package com.benbenlaw.smelting.screen;

import com.benbenlaw.opolisutilities.screen.utils.FluidStackWidget;
import com.benbenlaw.opolisutilities.screen.utils.FluidTankRenderer;
import com.benbenlaw.smelting.Smelting;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;

public class SolidifierScreen extends AbstractContainerScreen<SolidifierMenu> {

    private Level level;
    private FluidTankRenderer tank;
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "textures/gui/solidifier_gui.png");

    public SolidifierScreen(SolidifierMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.level = menu.level;
    }

    @Override
    protected void init() {
        super.init();
        addFluidWidgets();
    }

    private void addFluidWidgets() {
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK, leftPos + 27, topPos + 15, 14, 56));
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        renderProgressBars(guiGraphics);  // Draw progress bars over the item stacks

        int x = leftPos;
        int y = topPos;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderProgressBars(guiGraphics);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }


    private void renderProgressBars(GuiGraphics guiGraphics) {
        int x = leftPos;
        int y = topPos;
        guiGraphics.blit(TEXTURE, x + 104, y + 35, 176, 30, menu.getScaledProgress(), 16);
    }
}
