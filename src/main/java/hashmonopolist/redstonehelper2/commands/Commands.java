package hashmonopolist.redstonehelper2.commands;

import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTCompoundList;
import de.tr7zw.changeme.nbtapi.NBTItem;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import hashmonopolist.redstonehelper2.Redstonehelper2;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

    public static void registerHex2Dec(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.hex2dec.enabled")) return;
        new CommandAPICommand("hex2dec")
                .withArguments(new StringArgument("hexadecimal"))
                .executes((player, args) -> {
                    String message = plugin.getConfig().getString("messages.hex2dec", "");
                    String message_error = plugin.getConfig().getString("messages.hex2dec_error", "");
                    int decimal;
                    try {
                        decimal = Integer.parseInt((String) args[0], 16);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message_error));
                        return;
                    }
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message) + decimal);

                })
                .withPermission(CommandPermission.fromString(plugin.getConfig().getString("commands.hex2dec.permission")))
                .register();
    }

    public static void registerBarrel(Redstonehelper2 plugin) {
        if (!plugin.getConfig().getBoolean("commands.barrel.enabled")) return;
        new CommandAPICommand("barrel")
                .withArguments(new IntegerArgument("0-15"))
                .executes((player, args) -> {
                    if ((int) args[0] > 15 || (int) args[0] < 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.BARREL);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 27));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.FURNACE);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 3));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.CHEST);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 27));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.DROPPER);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 9));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.DISPENSER);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 9));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
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
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.not_within_range", "")));
                        return;
                    }
                    ItemStack itemStack = new ItemStack(Material.SHULKER_BOX);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(String.valueOf(args[0]));
                    itemStack.setItemMeta(itemMeta);
                    NBTItem nbtItem = new NBTItem(itemStack);
                    addItems(nbtItem, calculateItemCount((Integer) args[0], 27));
                    player.getServer().getPlayer(player.getName()).getInventory().addItem(nbtItem.getItem());
                })
                .withPermission(plugin.getConfig().getString("commands.shulkerbox.permission"))
                .register();
    }

    public static int calculateItemCount(int desiredSignalStrength, int slotCount) {
        return Math.max(desiredSignalStrength, Math.round((slotCount * 64 / 14) * desiredSignalStrength - 1));
    }

    private static void addItems(NBTItem nbtItem, int count) {
        NBTCompound nbtCompound = nbtItem.getOrCreateCompound("BlockEntityTag");
        NBTCompoundList nbtCompoundList = nbtCompound.getCompoundList("Items");
        int remainder = count % 64;
        for (int i = 0; i < count / 64; i++) {
            NBTCompound slot = nbtCompoundList.addCompound();
            slot.setString("id", "minecraft:redstone");
            slot.setByte("Count", (byte) 64);
            slot.setByte("Slot", (byte) i);
        }
        if (remainder != 0) {
            NBTCompound slot = nbtCompoundList.addCompound();
            slot.setString("id", "minecraft:redstone");
            slot.setByte("Count", (byte) remainder);
            slot.setByte("Slot", (byte) (nbtCompoundList.size() - 1));
        }
    }
}
