package me.DarthChungo.PranksLevel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PranksCommand implements TabExecutor {
    public static void RegisterCommand() {
        Main.get().getCommand("pranks").setExecutor(new PranksCommand());
    }

    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            try {
                if (strings[0].equals("set") && strings.length == 2) {
                    if (ConfigManager.setPlayer(strings[1], (Player) commandSender)) {
                        commandSender.sendMessage(format("&7Prank level set to &a&l" + strings[1] + "&r&7."));
                    } else {
                        commandSender.sendMessage(format("&cUnknown level"));
                    }

                } else if (strings[0].equals("get")) {
                    Player p = Bukkit.getPlayer(strings[1]);

                    if (p != null) {
                        String l = ConfigManager.getPlayer(p);

                        if (l != null) {
                            commandSender.sendMessage(format("&7Prank level for &a&l" + p.getName() +
                                    "&r&7 is set to &a&l" + l + "&r&7."));

                        } else {
                            commandSender.sendMessage(format("&cPlayer has not set a level"));
                        }

                    } else {
                        commandSender.sendMessage(format("&cPlayer not found"));
                    }

                } else if (strings[0].equals("list")) {
                    Map<String, Object> levels = ConfigManager.getLevels();
                    commandSender.sendMessage(format("&7Available&a&l prank levels&r&7 are:"));

                    levels.forEach((string, object) -> {
                        commandSender.sendMessage(format("&a&l " + string + ": &r&7" + object.toString() + "."));
                    });

                } else {
                    throw new ArrayIndexOutOfBoundsException(); // Avoid repeating code, jump directly to catch block
                }

            } catch (ArrayIndexOutOfBoundsException ignore) { // string[0] might not exist, easier than checking length
                commandSender.sendMessage(format("&cIncorrect usage, please use one of: "));
                commandSender.sendMessage(format("&c /pranks set <level>"));
                commandSender.sendMessage(format("&c /pranks get [<player>]"));
                commandSender.sendMessage(format("&c /pranks list"));
            }

        } else {
            commandSender.sendMessage(format("&cThis command cannot be run from console!"));
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> options = new ArrayList<>();

        if (strings.length == 1) {
            options.add("set");
            options.add("get");
            options.add("list");

        } else if (strings.length == 2) {
            if (strings[0].equals("set")) {
                options.addAll(ConfigManager.getLevels().keySet());

            } else if (strings[0].equals("get")) {
                Arrays.stream(Bukkit.getServer().getOfflinePlayers()).forEach(player -> options.add(player.getName()));
            }
        }

        return options;
    }
}
