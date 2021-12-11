package hashmonopolist.redstonehelper2.listeners;

import hashmonopolist.redstonehelper2.Redstonehelper2;
import hashmonopolist.redstonehelper2.util.Flippers;
import org.bukkit.Material;
import org.bukkit.Nameable;
import org.bukkit.block.*;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BlockPlaced implements Listener {
    Redstonehelper2 plugin;
    FileConfiguration config;

    public BlockPlaced(Redstonehelper2 plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        if (event.getPlayer().isSneaking()) {

            switch (block.getBlockData().getMaterial().toString()) {
                case "REPEATER" -> {
                    if (!config.getBoolean("blocks.flipping.REPEATER.enabled")) return;
                    Flippers.flipRepeater(block);
                }
                case "COMPARATOR" -> {
                    if (!config.getBoolean("blocks.flipping.COMPARATOR.enabled")) return;
                    Flippers.flipComparator(block);
                }
                case "OBSERVER" -> {
                    if (!config.getBoolean("blocks.flipping.OBSERVER.enabled")) return;
                    Flippers.flipObserver(block);
                }
                case "REDSTONE_WALL_TORCH" -> {
                    if (!config.getBoolean("blocks.flipping.REDSTONE_WALL_TORCH.enabled")) return;
                    Flippers.flipRedstoneWallTorch(block);
                }
                case "PISTON" -> {
                    if (!config.getBoolean("blocks.flipping.PISTON.enabled")) return;
                    Flippers.flipPiston(block);
                }
                case "STICKY_PISTON" -> {
                    if (!config.getBoolean("blocks.flipping.STICKY_PISTON.enabled")) return;
                    Flippers.flipPiston(block);
                }
                case "END_PORTAL_FRAME" -> {
                    EndPortalFrame endPortalFrame = (EndPortalFrame) Objects.requireNonNull(event.getBlockPlaced()).getBlockData();
                    endPortalFrame.setEye(!endPortalFrame.hasEye());
                    event.getBlockPlaced().setBlockData(endPortalFrame);
                }
            }
        }
        switch (block.getBlockData().getMaterial().toString()) {
            case "BARREL" -> {
                if (!config.getBoolean("blocks.naming.BARREL.enabled")) return;
                if (((Nameable) event.getBlockPlaced().getState()).getCustomName() == null) return;
                ((Barrel) block.getState())
                        .getInventory()
                        .addItem(new ItemStack(Material.REDSTONE, calculateItemCount(getDesiredSignalStrength((Nameable) block.getState()), 27)));
            }
            case "CHEST" -> {
                if (!config.getBoolean("blocks.naming.CHEST.enabled")) return;
                if (((Nameable) event.getBlockPlaced().getState()).getCustomName() == null) return;
                ((Chest) block.getState())
                        .getInventory()
                        .addItem(new ItemStack(Material.REDSTONE, calculateItemCount(getDesiredSignalStrength((Nameable) block.getState()), 27)));
            }
            case "DISPENSER" -> {
                if (!config.getBoolean("blocks.naming.DISPENSER.enabled")) return;
                if (((Nameable) event.getBlockPlaced().getState()).getCustomName() == null) return;
                ((Dispenser) block.getState())
                        .getInventory()
                        .addItem(new ItemStack(Material.REDSTONE, calculateItemCount(getDesiredSignalStrength((Nameable) block.getState()), 9)));
            }
            case "DROPPER" -> {
                if (!config.getBoolean("blocks.naming.DROPPER.enabled")) return;
                if (((Nameable) event.getBlockPlaced().getState()).getCustomName() == null) return;
                ((Dropper) block.getState())
                        .getInventory()
                        .addItem(new ItemStack(Material.REDSTONE, calculateItemCount(getDesiredSignalStrength((Nameable) block.getState()), 9)));
            }
            case "FURNACE" -> {
                if (!config.getBoolean("blocks.naming.FURNACE.enabled")) return;
                if (((Nameable) event.getBlockPlaced().getState()).getCustomName() == null) return;
                ((Furnace) block.getState())
                        .getInventory()
                        .addItem(new ItemStack(Material.REDSTONE, calculateItemCount(getDesiredSignalStrength((Nameable) block.getState()), 3)));
            }
        }
    }

    private int getDesiredSignalStrength(Nameable nameable) {
        return Integer.parseInt(Objects.requireNonNull(nameable.getCustomName()));
    }

    private int calculateItemCount(int desiredSignalStrength, int slotCount) {
        return Math.max(desiredSignalStrength, Math.round((slotCount * 64 / 14) * desiredSignalStrength - 1));
    }
}
