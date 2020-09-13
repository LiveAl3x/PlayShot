
package de.devjava.playshot.addon.objects.settings;

import java.io.IOException;

import de.devjava.playshot.addon.LabyAddon;
import net.labymod.utils.Material;

public enum Settings
{

	STATS_VIEWER(true, "Stats", "View your stats", "LEVER"),
	AUTO_GG(true, "AUTO-GG", "Automatically writes GG in the chat after a round", "DIAMOND"),
	LAZERTAG_SHOWTEAM(true, "Show Team", "Show you your teammates", "SKULL_ITEM");

	private boolean value;
	private String briefDesc, name, labyIcon;

	Settings(boolean value, String name, String briefDesc, String labyIcon)
	{
		this.value = value;
		this.briefDesc = briefDesc;
		this.name = name;
		this.labyIcon = labyIcon;
		
	}

	public boolean getValue()
	{
		return value;
	}

	public void setValue(boolean value)
	{
		this.value = value;

		try
		{
			LabyAddon.getInstance().getSettingsFetcher().saveSettings();
		}
		catch(IOException e)
		{
			LabyAddon.getInstance().getLogger().info("Failed to save Settings");
			e.printStackTrace();
		}
	}

	public String getBriefDescription()
	{
		return this.briefDesc;
	}

	public void setValueWithoutSaving(boolean value)
	{
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public String getLabyIcon()
	{
		return this.labyIcon;
	}
}