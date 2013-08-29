package net.techmastary.plugins.chatmaster;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatMaster extends JavaPlugin implements Listener {
	public static boolean Silenced;
	ChatCommand chatcmds = new ChatCommand();
	public static double version = 1.1;
	ChatEventListener chateventlistener = new ChatEventListener();

	@Override
	public void onDisable() {
		System.out.println("Disabled ChatMaster " + version + ".");
	}

	@Override
	public void onEnable() {
		loadConf();
		System.out.println("Enabled ChatMaster " + version + ".");
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(this.chateventlistener, this);
		getServer().getPluginCommand("cm").setExecutor(this.chatcmds);
		Silenced = false;
	}

	private void loadConf() {
		getConfig().addDefault("Silence player without permissions", false);
		getConfig().addDefault("Deafen player without permissions", false);
	}
}