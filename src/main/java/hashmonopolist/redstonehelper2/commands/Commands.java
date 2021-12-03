package hashmonopolist.redstonehelper2.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import hashmonopolist.redstonehelper2.Redstonehelper2;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Commands {
    public static void registerRedstonehelper(Redstonehelper2 plugin) {
        new CommandAPICommand("redstonehelper")
                .withPermission(plugin.getConfig().getString("commands.redstonehelper.permission"))
                .withSubcommand(new CommandAPICommand("reload")
                        .executes((player, args) -> {
                            plugin.saveDefaultConfig();
                            plugin.reloadConfig();
                            String message = plugin.getConfig().getString("messages.reload", "");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                        }))
                .executes((player, args) -> {
                    player.sendMessage(plugin.getDescription().getName() + "\n" +
                            "Authors: " + plugin.getDescription().getAuthors() + "\n" +
                            "Description: " + plugin.getDescription().getDescription());
                })
                .register();
    }

    public static void registerDec2Bin(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.dec2bin.enabled")) return;
        new CommandAPICommand("dec2bin")
                .withArguments(new IntegerArgument("decimal"))
                .executes((player, args) -> {
                    String message = plugin.getConfig().getString("messages.dec2bin", "");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message) + Integer.toBinaryString((Integer) args[0]));

                })
                .withPermission(plugin.getConfig().getString("commands.dec2bin.permission"))
                .register();
    }

    public static void registerBin2Dec(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.bin2dec.enabled")) return;
        new CommandAPICommand("bin2dec")
                .withArguments(new StringArgument("binary"))
                .executes((player, args) -> {
                    String message = plugin.getConfig().getString("messages.bin2dec", "");
                    String message_error = plugin.getConfig().getString("messages.bin2dec_error", "");
                    int decimal;
                    try {
                        decimal = Integer.parseInt((String) args[0], 2);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message_error));
                        return;
                    }
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message) + decimal);
                })
                .withPermission(CommandPermission.fromString(plugin.getConfig().getString("commands.bin2dec.permission")))
                .register();
    }

    public static void registerBarrel(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.barrel.enabled")) return;
        new CommandAPICommand("barrel")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.BARREL, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.barrel.permission"))
                .register();
    }

    public static void registerFurnace(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.furnace.enabled")) return;
        new CommandAPICommand("furnace")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.FURNACE, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.furnace.permission"))
                .register();
    }

    public static void registerChest(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.chest.enabled")) return;
        new CommandAPICommand("chest")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.CHEST, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.chest.permission"))
                .register();
    }

    public static void registerDropper(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.dropper.enabled")) return;
        new CommandAPICommand("dropper")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.DROPPER, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.dropper.permission"))
                .register();
    }

    public static void registerDispenser(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.dispenser.enabled")) return;
        new CommandAPICommand("dispenser")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.DISPENSER, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.dispenser.permission"))
                .register();
    }

    public static void registerShulkerbox(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.shulkerbox.enabled")) return;
        new CommandAPICommand("shulkerbox")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    Objects.requireNonNull(player.getServer().getPlayer(player.getName())).getInventory().addItem(createItemStack(Material.SHULKER_BOX, String.valueOf(args[0])));
                })
                .withPermission(plugin.getConfig().getString("commands.shulkerbox.permission"))
                .register();
    }

    private static ItemStack createItemStack(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
