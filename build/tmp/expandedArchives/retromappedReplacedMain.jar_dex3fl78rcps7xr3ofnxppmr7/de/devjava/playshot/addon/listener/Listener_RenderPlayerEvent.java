
package de.devjava.playshot.addon.listener;

import org.lwjgl.opengl.Display;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.render.RenderUtils;
import de.devjava.playshot.addon.utils.Server;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Listener_RenderPlayerEvent
{

	@SubscribeEvent
	public void render(RenderPlayerEvent.Pre event)
	{
		final RenderUtils renderUtils = new RenderUtils();
		
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;
		
		if(LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() == Server.LAZERTAG)
			return;
		
		if(event.entity.func_70093_af())
			return;
				
		if(event.entity.func_70005_c_().equals("JavaVirus") || event.entity.func_70005_c_().equals("DevJava"))
			renderUtils.renderName((RendererLivingEntity) event.renderer, (EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyAddon " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.AQUA + "Developer"), event.entityPlayer, event.x, event.y + 0.6D, event.z);
	}
}
