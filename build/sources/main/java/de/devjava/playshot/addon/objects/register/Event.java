package de.devjava.playshot.addon.objects.register;

public class Event
{
	private String name;

	public Event()
	{
	}

	public String getEventName()
	{
		if(this.name == null)
			this.name = getClass().getSimpleName();
		return this.name;
	}
}
