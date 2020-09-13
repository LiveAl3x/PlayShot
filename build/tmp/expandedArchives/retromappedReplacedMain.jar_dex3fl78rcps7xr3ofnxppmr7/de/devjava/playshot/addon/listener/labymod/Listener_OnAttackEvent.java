
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.OnAttackEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;

public class Listener_OnAttackEvent implements Listener
{
	@LabyModEvent
	public void OnAttackEvent(OnAttackEvent event)
	{
//		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
//			return;
//		
		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.OnAttackEvent(event);
		
//		if(Minecraft.getMinecraft().thePlayer.getDistance(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ) > 4.5)
			
	}
}
