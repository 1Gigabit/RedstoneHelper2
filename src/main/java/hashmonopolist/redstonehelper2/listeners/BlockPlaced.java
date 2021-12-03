package hashmonopolist.redstonehelper2.listeners;

import hashmonopolist.redstonehelper2.Redstonehelper2;
import hashmonopolist.redstonehelper2.util.Flippers;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaced implements Listener {
    Redstonehelper2 plugin;
    FileConfiguration config;
    public BlockPlaced(Redstonehelper2 plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().isSneaking()) {
            Block block = event.getBlockPlaced();

            switch(block.getBlockData().getMaterial().toString()) {
                case "REPEATER":
                    if(!config.getBoolean("blocks.flipping.REPEATER.enabled")) return;
                    Flippers.flipRepeater(block);
                    break;
                case "COMPARATOR":
                    if(!config.getBoolean("blocks.flipping.COMPARATOR.enabled")) return;
                    Flippers.flipComparator(block);
                    break;
                case "OBSERVER":
                    if(!config.getBoolean("blocks.flipping.OBSERVER.enabled")) return;
                    Flippers.flipObserver(block);
                    break;
                case "REDSTONE_WALL_TORCH":
                    if(!config.getBoolean("blocks.flipping.REDSTONE_WALL_TORCH.enabled")) return;
                    Flippers.flipRedstoneWallTorch(block);
                    break;
                case "PISTON":
                    if(!config.getBoolean("blocks.flipping.PISTON.enabled")) return;
                case "STICKY_PISTON":
                    if(!config.getBoolean("blocks.flipping.STICKY_PISTON.enabled")) return;
                    Flippers.flipPiston(block);
                    break;
            }
        }
    }

}
