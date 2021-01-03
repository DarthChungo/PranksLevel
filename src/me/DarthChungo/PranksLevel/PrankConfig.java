package me.DarthChungo.PranksLevel;

import java.util.Map;

public class PrankConfig {
    public static void InitConfig() {
        Main.getInstance().saveDefaultConfig();
    }

    public static Map<String, Object> getLevels() {
        return Main.getInstance().getConfig().getConfigurationSection("levels").getValues(false);
    }
}
