
package de.devjava.playshot.addon.objects.modules;

import java.util.Timer;
import java.util.TimerTask;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Deaths;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_KD;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Kills;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Loses;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Place;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Played;
import de.devjava.playshot.addon.objects.modules.simplemodule.stats.SimpleModule_Wins;
import de.devjava.playshot.addon.objects.settings.Settings;
import net.labymod.ingamegui.enums.EnumDisplayType;
import net.labymod.ingamegui.moduletypes.SimpleModule;

public class Module_Stats extends Module
{

	public Module_Stats()
	{
		super(Settings.STATS_VIEWER);

		new SimpleModule_Kills();
		new SimpleModule_Deaths();
		new SimpleModule_KD();
		new SimpleModule_Place();
		new SimpleModule_Played();
		new SimpleModule_Loses();
		new SimpleModule_Wins();
	}
}
