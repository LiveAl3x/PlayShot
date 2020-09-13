
package de.devjava.playshot.addon.objects.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import de.devjava.playshot.addon.LabyAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;

public class SettingsFetcher
{

	private Properties props;

	public SettingsFetcher()
	{
		this.props = new Properties();

		if(!new File(LabyAddon.getInstance().getMcFile().getAbsolutePath()).exists())
			new File(LabyAddon.getInstance().getMcFile().getAbsolutePath()).mkdirs();

		if(!new File(LabyAddon.getInstance().getMcFile().getAbsolutePath(), "/settings.properties").exists())
			try
			{
				new File(LabyAddon.getInstance().getMcFile().getAbsolutePath(), "/settings.properties").createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

	public void addSettings(List<SettingsElement> settings)
	{
		for(Settings setting : Settings.values())
			if(setting.getLabyIcon() == "online_players")
				settings.add(new BooleanElement(setting.getName(), new ControlElement.IconData("online_players"), setting::setValue, setting.getValue()));
			else
				settings.add(new BooleanElement(setting.getName(), new ControlElement.IconData(Material.valueOf(setting.getLabyIcon())), setting::setValue, setting.getValue()));

	}

	public void loadSettings() throws IOException
	{

		this.props = new Properties();
		FileInputStream fis = new FileInputStream(LabyAddon.getInstance().getMcFile().getAbsolutePath() + "/settings.properties");
		this.props.load(fis);
		fis.close();
		for(Object os : this.props.keySet())
		{
			if(os instanceof String)
			{
				String s = (String) os;
				try
				{
					Settings sett = Settings.valueOf(s.toUpperCase());

					sett.setValueWithoutSaving(Boolean.valueOf(this.props.getProperty(s)));

				}
				catch(IllegalArgumentException ignored)
				{
				}
			}
		}
		System.out.println("Succesfully loaded settings.");
	}

	public void saveSetting(Settings sett) throws IOException
	{
		if(this.props == null)
			this.props = new Properties();

		final FileOutputStream fos = new FileOutputStream(LabyAddon.getInstance().getMcFile().getAbsolutePath() + "/settings.properties");

		this.props.setProperty(sett.name().toUpperCase(), sett.getValue() + "");
		this.props.store(fos, "");
	}

	public void saveSettings() throws IOException
	{
		for(Settings s : Settings.values())
			this.saveSetting(s);
		System.out.println("Succesfully saved settings.");
	}
}