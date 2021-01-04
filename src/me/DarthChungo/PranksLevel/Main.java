package me.DarthChungo.PranksLevel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main get() {
        return (Main) Bukkit.getPluginManager().getPlugin("PranksLevel");
    }

    @Override
    public void onEnable() {
        PranksCommand.RegisterCommand();
        ConfigManager.InitConfig();

        if (ConfigManager.get().getBoolean("autosave")) {
            RunManager.RunAutoSave();
        }

        getLogger().info("PranksLevel by DarthChungo enabled");
    }

    @Override
    public void onDisable() {
        ConfigManager.SaveConfig();

        getLogger().info("PranksLevel by DarthChungo disabled");
    }
}
