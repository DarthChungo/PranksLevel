package me.DarthChungo.PranksLevel;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Map;

public class ConfigManager {
    public static void InitConfig() {
        Main.get().saveDefaultConfig();
    }

    public static void SaveConfig() {
        Main.get().saveConfig();
    }

    public static Map<String, Object> getLevels() {
        return Main.get().getConfig().getConfigurationSection("levels").getValues(false);
    }

    public static boolean setPlayer(String level, Player player) {
        if (getLevels().containsKey(level)) {
            Main.get().getConfig().set("players." + player.getUniqueId().toString(), level);
            return true;

        } else {
            return false;
        }
    }

    public static String getPlayer(Player player) {
        return Main.get().getConfig().getString("players." + player.getUniqueId().toString());
    }

    public static FileConfiguration get() {
        return Main.get().getConfig();
    }
}
