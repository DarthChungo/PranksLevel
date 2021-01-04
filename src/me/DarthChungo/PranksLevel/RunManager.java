package me.DarthChungo.PranksLevel;

import org.bukkit.scheduler.BukkitRunnable;

public class RunManager {
    public static void RunAutoSave() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Main.get().saveConfig();
            }
        }.runTaskTimer(Main.get(), 0, ConfigManager.get().getLong("interval"));
    }
}
