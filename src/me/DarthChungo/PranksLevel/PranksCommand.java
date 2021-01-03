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

public class PranksCommand implements TabExecutor {
    public static void RegisterCommand() {
        Main.getInstance().getCommand("pranks").setExecutor(new PranksCommand());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            try {
                if (strings[0].equals("set") ||
                    strings[0].equals("get") ||
                    strings[0].equals("list")) {

                    commandSender.sendMessage(ChatColor.GOLD + "To be implemented :)");

                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }

            } catch (ArrayIndexOutOfBoundsException ignore) {
                commandSender.sendMessage(ChatColor.RED + "Incorrect usage, please use one of: ");
                commandSender.sendMessage(ChatColor.RED + " /pranks set <level>");
                commandSender.sendMessage(ChatColor.RED + " /pranks get [<player>]");
                commandSender.sendMessage(ChatColor.RED + " /pranks list");
            }

        } else {
            commandSender.sendMessage(ChatColor.RED + "This command cannot be run from console!");
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
                options.addAll(PrankConfig.getLevels().keySet());

            } else if (strings[0].equals("get")) {
                Arrays.stream(Bukkit.getServer().getOfflinePlayers()).forEach(player -> options.add(player.getName()));
            }
        }

        return options;
    }
}
