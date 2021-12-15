package hashmonopolist.redstonehelper2.listeners;

import hashmonopolist.redstonehelper2.Redstonehelper2;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    private final Redstonehelper2 plugin;
    public BlockBreak(Redstonehelper2 plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!plugin.getConfig().getBoolean("utility.delete_items.enabled")) return;
        switch (event.getBlock().getType()) {
            case FURNACE -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.furnace")) return;
                event.setDropItems(false);
            }
            case CHEST -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.chest")) return;
                event.setDropItems(false);
            }
            case DROPPER -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.dropper")) return;
                event.setDropItems(false);
            }
            case DISPENSER -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.dispenser")) return;
                event.setDropItems(false);
            }
            case SHULKER_BOX -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.shulker_box")) return;
                event.setDropItems(false);
            }
            case BARREL -> {
                if (!plugin.getConfig().getBoolean("utility.delete_items.barrel")) return;
                event.setDropItems(false);
            }
        }
    }
}
