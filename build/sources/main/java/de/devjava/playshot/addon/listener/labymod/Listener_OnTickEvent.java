
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.OnTickEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import de.devjava.playshot.addon.utils.EnumDyeColor;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;

public class Listener_OnTickEvent implements Listener
{
	@LabyModEvent
	public void OnTickEvent(OnTickEvent event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onTick();

	}
}
