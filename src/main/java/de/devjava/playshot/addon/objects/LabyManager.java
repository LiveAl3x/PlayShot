
package de.devjava.playshot.addon.objects;

public class LabyManager
{

	private LabyClient labyClient;

	public LabyManager()
	{
		this.labyClient = new LabyClient();
	}

	public LabyClient getLabyClient()
	{
		return labyClient;
	}
}
