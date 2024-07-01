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

public class MixerScreen extends AbstractContainerScreen<MixerMenu> {

    Level level;
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "textures/gui/mixer_gui.png");

    public MixerScreen(MixerMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.level = menu.level;
    }

    @Override
    protected void init() {
        super.init();
        addFluidWidgets();
    }

    public void addFluidWidgets() {
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_1, this.leftPos + 9, this.topPos + 15, 14, 56));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_2, this.leftPos + 27, this.topPos + 15, 14, 56));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_3, this.leftPos + 45, this.topPos + 15, 14, 56));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_4, this.leftPos + 63, this.topPos + 15, 14, 56));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_5, this.leftPos + 81, this.topPos + 15, 14, 56));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_6, this.leftPos + 99, this.topPos + 15, 14, 56));

        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.OUTPUT_TANK, this.leftPos + 153, this.topPos + 15, 14, 56));
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        renderProgressBars(guiGraphics);  // Draw progress bars over the item stacks

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

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
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x + 122 , y + 35 , 176, 30, menu.getScaledProgress(), 16);
    }
}
