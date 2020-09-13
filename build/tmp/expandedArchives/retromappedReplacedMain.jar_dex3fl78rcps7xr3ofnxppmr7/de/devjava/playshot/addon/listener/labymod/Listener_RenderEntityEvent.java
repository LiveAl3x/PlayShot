
package de.devjava.playshot.addon.listener.labymod;

import org.fusesource.jansi.Ansi.Color;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.RenderEntityEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import de.devjava.playshot.addon.render.RenderUtils;
import de.devjava.playshot.addon.utils.EnumDyeColor;
import de.devjava.playshot.addon.utils.Server;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class Listener_RenderEntityEvent implements Listener
{
	@LabyModEvent
	public void onRenderEntityEvent(RenderEntityEvent event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;
		
		if(event.getEntity().func_70005_c_().equals("DevJava") || event.getEntity().func_70005_c_().equals("JavaVirus"))
			if(LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected() && LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() != Server.LAZERTAG)
				new RenderUtils().renderName(EnumChatFormatting.WHITE + "LabyAddon " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.AQUA + "Developer", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());
			else if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())

				new RenderUtils().renderName(EnumChatFormatting.WHITE + "PlayShot " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.AQUA + "Developer", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());

		if(event.getEntity().func_70005_c_().equals("Baum_Kind"))
			if(LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected() && LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() != Server.LAZERTAG)
				new RenderUtils().renderName(EnumChatFormatting.WHITE + "PlayShot " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.DARK_RED + "Inhaber", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());

		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onRenderEntityEvent(event);

	}
}
