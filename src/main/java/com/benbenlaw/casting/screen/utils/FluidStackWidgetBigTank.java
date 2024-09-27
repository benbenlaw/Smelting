package com.benbenlaw.casting.screen.utils;

import com.benbenlaw.opolisutilities.screen.utils.OpolisUtilitiesWidget;
import com.benbenlaw.opolisutilities.util.MouseUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

import java.util.Arrays;

public class FluidStackWidgetBigTank extends OpolisUtilitiesWidget {
    private final Screen screen;
    private final FluidTank getFluid;

    public FluidStackWidgetBigTank(Screen screen, FluidTank getFluid, int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight);
        this.screen = screen;
        this.getFluid = getFluid;
    }

    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        FluidTank fluidTank = this.getFluid;

        this.renderToolTip(guiGraphics, mouseX, mouseY);


        if (!fluidTank.getFluid().isEmpty()) {
            FluidStack fluidStack = fluidTank.getFluid();
            IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluidStack.getFluid());
            ResourceLocation still = props.getStillTexture(fluidStack);
            AbstractTexture texture = minecraft.getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
            if (texture instanceof TextureAtlas) {
                TextureAtlas atlas = (TextureAtlas)texture;
                TextureAtlasSprite sprite = atlas.getSprite(still);
                int color = props.getTintColor();
                RenderSystem.setShaderColor((float) FastColor.ARGB32.red(color) / 255.0F, (float) FastColor.ARGB32.green(color) / 255.0F, (float) FastColor.ARGB32.blue(color) / 255.0F, (float) FastColor.ARGB32.alpha(color) / 255.0F);
                RenderSystem.enableBlend();
                int stored = fluidTank.getFluidAmount();
                float capacity = (float)fluidTank.getCapacity();
                float filledVolume = (float)stored / capacity;
                int renderableHeight = (int)(filledVolume * (float)this.height);
                int atlasWidth = (int)((float)sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
                int atlasHeight = (int)((float)sprite.contents().height() / (sprite.getV1() - sprite.getV0()));
                guiGraphics.pose().pushPose();
                guiGraphics.pose().translate(0.0F, (float)(this.height - 16), 0.0F);

                for(int i = 0; (double)i < Math.ceil((double)((float)renderableHeight / 16.0F)); ++i) {
                    int drawingHeight = Math.min(16, renderableHeight - 16 * i);
                    int notDrawingHeight = 16 - drawingHeight;
                    guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, this.x, this.y + notDrawingHeight, 0, sprite.getU0() * (float)atlasWidth, sprite.getV0() * (float)atlasHeight + (float)notDrawingHeight, this.width, drawingHeight, atlasWidth, atlasHeight);
                    guiGraphics.pose().translate(0.0F, -16.0F, 0.0F);
                }

                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                guiGraphics.pose().popPose();
            }

        }

        RenderSystem.disableDepthTest();
    }

    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {
    }

    public void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (MouseUtil.isMouseAboveArea(mouseX, mouseY, this.x, this.y, 0, 0, 14, 52)) {
            Font font = this.screen.getMinecraft().font;
            FormattedCharSequence[] tooltipText = new FormattedCharSequence[2];
            int fluidAmount;

            if (!this.getFluid.getFluid().isEmpty()) {
                tooltipText[0] = this.getFluid.getFluid().getHoverName().getVisualOrderText();
                fluidAmount = this.getFluid.getFluidAmount();
            } else {
                tooltipText[0] = Component.literal("Air").getVisualOrderText();
                fluidAmount = 0;
            }

            tooltipText[1] = Component.literal(fluidAmount + "mB / " + this.getFluid.getCapacity() + "mB").getVisualOrderText();

            guiGraphics.renderTooltip(font, Arrays.asList(tooltipText), mouseX, mouseY);
        }
    }

}