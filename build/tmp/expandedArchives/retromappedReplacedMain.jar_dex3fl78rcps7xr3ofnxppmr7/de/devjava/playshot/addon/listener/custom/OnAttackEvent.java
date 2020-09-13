package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;
import net.minecraft.entity.Entity;

public class OnAttackEvent extends Event
{
	private Entity entity;
	
	public OnAttackEvent(final Entity arg0)
	{
		this.entity = arg0;
	}
	
	public Entity getEntity()
	{
		return this.entity;
	}
}
