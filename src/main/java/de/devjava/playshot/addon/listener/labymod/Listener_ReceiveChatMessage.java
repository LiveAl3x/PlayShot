
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.ReceiveChatMessage;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import de.devjava.playshot.addon.utils.Server;
import net.labymod.api.LabyModAddon;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;

public class Listener_ReceiveChatMessage implements Listener
{
	@LabyModEvent
	public void onReceiveChatMessage(ReceiveChatMessage event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onReceiveChatMessage(event);
	}
}
