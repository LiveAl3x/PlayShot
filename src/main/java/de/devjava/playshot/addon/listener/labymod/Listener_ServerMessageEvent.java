package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.ServerMessageEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;

public class Listener_ServerMessageEvent implements Listener
{
	@LabyModEvent
	public void onServerMessageEvent(ServerMessageEvent event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;
		
		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onServerMessageEvent(event);		
	}
}
