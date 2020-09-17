package de.devjava.playshot.addon.render;

import org.lwjgl.opengl.GL11;

import net.labymod.core.LabyModCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class RenderUtils
{

	public RenderUtils()
	{
		
	}
	
	public void renderName(String str, Entity entity, double x, double y, double z)
	{
		FontRenderer fontrenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
		float f = 1.6F;
		float f3 = 0.021133334F;
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.0F, (float) y + entity.height + 1F, (float) z);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(-f3, -f3, f3);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(false);
		GlStateManager.disableDepth();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		int i = 4;
		int j = fontrenderer.getStringWidth(str) / 2;
		GlStateManager.disableTexture2D();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		worldrenderer.pos((-j - 1), (-1 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((-j - 1), (8 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((j + 1), (8 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((j + 1), (-1 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		fontrenderer.drawString(str, -fontrenderer.getStringWidth(str) / 2, i, 1);
		GlStateManager.enableDepth();
		GlStateManager.depthMask(true);
		fontrenderer.drawString(str, -fontrenderer.getStringWidth(str) / 2, i, 1);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();

	}
	
	public void renderNameBigger(String str, Entity entity, double x, double y, double z)
	{
		FontRenderer fontrenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
		float f = 1.6F;
		float f3 = 0.031133334F;
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.0F, (float) y + entity.height + 1.1F, (float) z);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(-f3, -f3, f3);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(false);
		GlStateManager.disableDepth();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		int i = 4;
		int j = fontrenderer.getStringWidth(str) / 2;
		GlStateManager.disableTexture2D();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		worldrenderer.pos((-j - 1), (-1 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((-j - 1), (8 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((j + 1), (8 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		worldrenderer.pos((j + 1), (-1 + i), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		fontrenderer.drawString(str, -fontrenderer.getStringWidth(str) / 2, i, 1);
		GlStateManager.enableDepth();
		GlStateManager.depthMask(true);
		fontrenderer.drawString(str, -fontrenderer.getStringWidth(str) / 2, i, 1);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();
	}
}
