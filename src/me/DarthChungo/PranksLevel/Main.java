package me.DarthChungo.PranksLevel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static JavaPlugin getInstance() {
        return (JavaPlugin) Bukkit.getPluginManager().getPlugin("PranksLevel");
    }

    @Override
    public void onEnable() {
        PranksCommand.RegisterCommand();
        PrankConfig.InitConfig();

        getLogger().info("PranksLevel by DarthChungo enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("PranksLevel by DarthChungo disabled");
    }
}
