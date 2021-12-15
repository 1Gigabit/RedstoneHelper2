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
    }
}
