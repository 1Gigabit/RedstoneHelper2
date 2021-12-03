package hashmonopolist.redstonehelper2.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import hashmonopolist.redstonehelper2.Redstonehelper2;
import org.bukkit.ChatColor;

public class Commands {
    public static void registerRedstonehelper(Redstonehelper2 plugin) {
        new CommandAPICommand("redstonehelper")
                .withPermission(plugin.getConfig().getString("commands.redstonehelper.permission"))
                .withSubcommand(new CommandAPICommand("reload")
                        .executes((player, args) -> {
                            plugin.saveDefaultConfig();
                            plugin.reloadConfig();
                            String message = plugin.getConfig().getString("messages.reload","");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
                        }))
                .executes((player, args) -> {
                    player.sendMessage(plugin.getDescription().getName() + "\n" +
                            "Authors: " + plugin.getDescription().getAuthors() + "\n" +
                            "Description: " + plugin.getDescription().getDescription());
                })
                .register();
    }
    public static void registerDec2Bin(Redstonehelper2 plugin) {
        if(!plugin.getConfig().getBoolean("commands.dec2bin.enabled")) return;
        new CommandAPICommand("dec2bin")
                .withArguments(new IntegerArgument("decimal"))
                .executes((player,args) -> {
                    String message = plugin.getConfig().getString("messages.dec2bin","");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',message) + Integer.toBinaryString((Integer) args[0]));

                })
                .withPermission(CommandPermission.fromString(plugin.getConfig().getString("commands.dec2bin.permission")))
                .register();
    }
    public static void registerBin2Dec(Redstonehelper2 plugin) {
        if(!plugin.getConfig().getBoolean("commands.bin2dec.enabled")) return;
        new CommandAPICommand("bin2dec")
                .withArguments(new StringArgument("binary"))
                .executes((player,args) -> {
                    String message = plugin.getConfig().getString("messages.bin2dec","");
                    String message_error = plugin.getConfig().getString("messages.bin2dec_error","");
                    int decimal;
                    try{
                        decimal = Integer.parseInt((String) args[0],2);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message_error));
                        return;
                    }
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',message) + decimal);
                })
                .withPermission(CommandPermission.fromString(plugin.getConfig().getString("commands.bin2dec.permission")))
                .register();
    }
}
