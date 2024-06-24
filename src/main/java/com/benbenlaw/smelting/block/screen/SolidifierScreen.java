package com.benbenlaw.smelting.block.screen;

import com.benbenlaw.opolisutilities.screen.utils.FluidTankRenderer;
import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.screen.utils.FluidStackWidget;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;

public class SolidifierScreen extends AbstractContainerScreen<SolidifierMenu> {

    Level level;

    private FluidTankRenderer tank1;
    private FluidTankRenderer tank2;
    private FluidTankRenderer tank3;
    private FluidTankRenderer tank4;
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "textures/gui/solidifier_gui.png");

    public SolidifierScreen(SolidifierMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.level = menu.level;
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

        assignFluidRenderer();

        renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);  // This draws the background and item stacks
        renderProgressBars(guiGraphics);  // Draw progress bars over the item stacks
        renderTooltip(guiGraphics, mouseX, mouseY);

        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_1, this.leftPos + 8, this.topPos + 15, 14, 26));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_2, this.leftPos + 90, this.topPos + 15, 14, 26));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_3, this.leftPos + 8, this.topPos + 45, 14, 26));
        addRenderableOnly(new FluidStackWidget(this, getMenu().blockEntity.TANK_4, this.leftPos + 90, this.topPos + 45, 14, 26));

    }

    private void renderProgressBars(GuiGraphics guiGraphics) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        for (int slot = 0; slot <= 3; slot++) {
            int progress = menu.getScaledProgress(slot);
            int slotX = getSlotX(slot);
            int slotY = getSlotY(slot);
            guiGraphics.blit(TEXTURE, x + slotX, y + slotY, 176, 30, progress, 16);
        }
    }

    private int getSlotX(int slot) {
        return switch (slot) {
            case 0, 2 -> 25;
            case 1, 3 -> 106;
            default -> 0;
        };
    }

    private int getSlotY(int slot) {
        return switch (slot) {
            case 0, 1 -> 19;
            case 2, 3 -> 51;
            default -> 0;
        };
    }

    private void assignFluidRenderer() {
        tank1 = new FluidTankRenderer(menu.blockEntity.TANK_1.getCapacity(), this.leftPos + 14, this.topPos + 15, 14);
        tank2 = new FluidTankRenderer(menu.blockEntity.TANK_2.getCapacity(), this.leftPos + 14, this.topPos + 15, 14);
        tank3 = new FluidTankRenderer(menu.blockEntity.TANK_3.getCapacity(), this.leftPos + 14, this.topPos + 15, 14);
        tank4 = new FluidTankRenderer(menu.blockEntity.TANK_4.getCapacity(), this.leftPos + 14, this.topPos + 15, 14);
    }

}
