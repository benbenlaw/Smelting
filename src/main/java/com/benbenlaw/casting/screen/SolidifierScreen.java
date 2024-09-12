package com.benbenlaw.casting.screen;

import com.benbenlaw.casting.networking.payload.ClearTankPayload;
import com.benbenlaw.opolisutilities.screen.utils.FluidStackWidget;
import com.benbenlaw.opolisutilities.screen.utils.FluidTankRenderer;
import com.benbenlaw.casting.Casting;
import com.benbenlaw.opolisutilities.util.MouseUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

public class SolidifierScreen extends AbstractContainerScreen<SolidifierMenu> {

    private Level level;
    private FluidTankRenderer tank;
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "textures/gui/solidifier_gui.png");

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

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderProgressBars(guiGraphics);
        renderTickRate(guiGraphics, mouseX, mouseY, x, y);
        renderWarning(guiGraphics, mouseX, mouseY);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }


    private void renderProgressBars(GuiGraphics guiGraphics) {
        int x = leftPos;
        int y = topPos;
        guiGraphics.blit(TEXTURE, x + 104, y + 34, 176, 30, menu.getScaledProgress(), 16);
    }

    private void renderTickRate(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {
        if (MouseUtil.isMouseAboveArea(mouseX, mouseY, x, y, 80, 36, 90, 16)) {
            guiGraphics.drawString(this.font, this.menu.blockEntity.maxProgress + " ticks", this.leftPos + 120,
                    this.topPos + 68, 0x3F3F3F, false);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        boolean handled = super.mouseClicked(mouseX, mouseY, mouseButton);

        int tankX = leftPos + 27;
        int tankY = topPos + 15;
        int tankWidth = 14;
        int tankHeight = 56;

        if (MouseUtil.isMouseOver(mouseX, mouseY, tankX, tankY, tankWidth, tankHeight)) {

            int tank = this.menu.blockEntity.TANK.getTanks();

            boolean hasShiftDown = SolidifierScreen.hasShiftDown();
            PacketDistributor.sendToServer(new ClearTankPayload(menu.blockEntity.getBlockPos(), hasShiftDown, tank));

        }
        return handled;
    }
    private void renderWarning(GuiGraphics guiGraphics, int mouseX, int mouseY) {

        int tankX = leftPos + 27;
        int tankY = topPos + 15;
        int tankWidth = 14;
        int tankHeight = 56;

        if (MouseUtil.isMouseOver(mouseX, mouseY, tankX, tankY, tankWidth, tankHeight) && SolidifierScreen.hasShiftDown()) {

            guiGraphics.renderTooltip(this.font, Component.translatable("screen.casting.warning").withStyle(ChatFormatting.RED), mouseX, mouseY - 14);
        }
    }

}
