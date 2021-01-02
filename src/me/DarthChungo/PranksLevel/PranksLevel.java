package me.DarthChungo.PranksLevel;

import org.bukkit.plugin.java.JavaPlugin;

public class PranksLevel extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PranksLevel by DarthChungo enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("PranksLevel by DarthChungo disabled");
    }
}
