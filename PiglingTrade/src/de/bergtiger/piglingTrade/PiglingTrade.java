package de.bergtiger.piglingTrade;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Bergtiger
 */
public class PiglingTrade extends JavaPlugin {

	@Override
	public void onEnable() {
		if(Bukkit.getBukkitVersion().startsWith("1.16.1")) {
			getLogger().info("Enabling Piglin-Trade with 1.16.2 values.");
			Bukkit.getPluginManager().registerEvents(new Trade(), this);
		} else
			Bukkit.getPluginManager().disablePlugin(this);
	}
}
