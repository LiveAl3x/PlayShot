package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;

public class ModifyChatMessage extends Event
{

	private Object arg0;
	private Object result = null;
	
	public ModifyChatMessage(final Object arg0)
	{
		this.arg0 = arg0;
		this.result = arg0;
	}
	
	public Object getarg0()
	{
		return this.arg0;
	}
	
	public Object getResult()
	{
		return this.result;
	}
	
	public void setResult(Object result)
	{
		this.result = result;
	}
}
