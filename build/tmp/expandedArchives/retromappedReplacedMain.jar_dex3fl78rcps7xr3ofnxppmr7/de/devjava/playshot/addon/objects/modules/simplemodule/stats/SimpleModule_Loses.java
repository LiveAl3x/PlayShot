
package de.devjava.playshot.addon.objects.modules.simplemodule.stats;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.objects.LabyClient;
import de.devjava.playshot.addon.objects.category.Categorys;
import de.devjava.playshot.addon.objects.settings.Settings;
import de.devjava.playshot.addon.utils.Search;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.settings.elements.NumberElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SimpleModule_Loses extends SimpleModule
{

	private String value;
	private int time;
	private long lastRequest;
	private ExecutorService SCHEDULER;
	private JsonParser PARSER;

	public SimpleModule_Loses()
	{
		this.time = 5;
		this.lastRequest = System.currentTimeMillis() + 1000;
		this.SCHEDULER = Executors.newCachedThreadPool();
		this.PARSER = new JsonParser();

		LabyAddon.getInstance().getApi().registerModule(this);
		LabyAddon.getInstance().getApi().registerForgeListener(this);
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		if(super.getEnabled().size() != 0 && LabyMod.getInstance().isInGame() && isShown() && isDrawn() && System.currentTimeMillis() > this.lastRequest)
		{

			lastRequest = System.currentTimeMillis() + (time * 1000L);
			SCHEDULER.execute(new Runnable()
			{
				public void run()
				{
					try
					{
						JsonArray array = SimpleModule_Loses.this.PARSER.parse(IOUtils.toString(new URL("http://51.195.56.73/stats/" + LabyAddon.getInstance().getLabyManager().getLabyClient().getServer().getValue() + ".php")))
								.getAsJsonArray();
						for(int i = 0; i < array.size(); i++)
							if(((JsonObject) array.get(i)).get("name").getAsString().equals(Minecraft.func_71410_x().field_71439_g.func_70005_c_()))
							{
								SimpleModule_Loses.this.value = ((JsonObject) array.get(i)).get(Search.LOSES.getValue()).getAsString();
								return;
							}

					}
					catch(IOException e)
					{
						SimpleModule_Loses.this.value = e.getMessage();
					}
				}
			});
		}
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String getDisplayName()
	{
		return "Loses";
	}

	@Override
	public String getDisplayValue()
	{
		return this.value == null ? "?" : this.value;
	}

	@Override
	public String getDescription()
	{
		return "View your loses in a game";
	}

	@Override
	public String getControlName()
	{
		return "Stats | Loses";
	}

	@Override
	public IconData getIconData()
	{
		return new IconData(Material.DEAD_BUSH);
	}

	@Override
	public String getSettingName()
	{
		return "";
	}

	@Override
	public int getSortingId()
	{
		return 6;
	}

	@Override
	public void loadSettings()
	{

	}

	@Override
	public String getDefaultValue()
	{
		return "n/A";
	}

	@Override
	public ModuleCategory getCategory()
	{
		return Categorys.CATEGORY_STATS.getModuleCategory();
	}

	@Override
	public boolean isShown()
	{
		final LabyClient labyClient = LabyAddon.getInstance().getLabyManager().getLabyClient();
		return labyClient.isSettingEnabled(Settings.STATS_VIEWER) && labyClient.isConnected() && labyClient.isPlaying();
	}

	@Override
	public void fillSubSettings(List<SettingsElement> settingsElements)
	{
		
		NumberElement numberElement = new NumberElement("Change update time", new IconData(Material.WATCH),  LabyAddon.getInstance().getConfig().has(getDisplayName() + "_time") ? LabyAddon.getInstance().getConfig().get(getDisplayName() + "_time").getAsInt() : 5);
		numberElement.setMinValue(3);
		numberElement.setMaxValue(120);
		numberElement.addCallback(new net.labymod.utils.Consumer<Integer>()
		{
			
			@Override
			public void accept(Integer id)
			{
				time = id;
				if(LabyAddon.getInstance().getConfig().has(getDisplayName() + "_time"))
					LabyAddon.getInstance().getConfig().remove(getDisplayName() + "_time");
				
				LabyAddon.getInstance().getConfig().addProperty(getDisplayName() + "_time", time);
				LabyAddon.getInstance().saveConfig();
				
			}
		});
		
		settingsElements.add(numberElement);
	}
}
