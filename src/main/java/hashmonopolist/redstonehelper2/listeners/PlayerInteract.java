package hashmonopolist.redstonehelper2.listeners;

import de.tr7zw.changeme.nbtapi.NBTTileEntity;
import hashmonopolist.redstonehelper2.Redstonehelper2;
import hashmonopolist.redstonehelper2.util.Fillers;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.RedstoneWire;
import org.bukkit.block.data.type.Repeater;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class PlayerInteract implements Listener {
    Redstonehelper2 plugin;

    public PlayerInteract(Redstonehelper2 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!event.getPlayer().isSneaking()) return;
        final String composterMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.composter", ""));
        final String redstoneMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.redstone_level", ""));
        final String comparatorMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.comparator_actionbar", ""));
        switch (Objects.requireNonNull(event.getClickedBlock()).getBlockData().getMaterial().toString()) {
            case "COMPOSTER" -> {
                event.setCancelled(true);
                Fillers.fillComposter(event);
                final Levelled composter = (Levelled) event.getClickedBlock().getBlockData();
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(composterMessage + composter.getLevel()));
            }
            case "REDSTONE_WIRE" -> {
                if (!plugin.getConfig().getBoolean("utility.redstone_action_bar")) return;
                event.setCancelled(true);
                int redstoneLevel = ((RedstoneWire) event.getClickedBlock().getBlockData()).getPower();
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(redstoneMessage + redstoneLevel));
            }
            case "COMPARATOR" -> {
                if (!plugin.getConfig().getBoolean("utility.comparator_action_bar")) return;
                Block block = event.getClickedBlock();
                BlockFace facing = ((Directional) event.getClickedBlock().getBlockData()).getFacing();
                /*
                Thank you Jorel of CommandAPI for this help
                 */
                BlockFace rotateClockwise = switch (facing) {
                    case NORTH -> BlockFace.EAST;
                    case EAST -> BlockFace.SOUTH;
                    case SOUTH -> BlockFace.WEST;
                    case WEST -> BlockFace.NORTH;
                    default -> throw new IllegalArgumentException("Unexpected value: " + facing);
                };
                int left = event.getClickedBlock().getRelative(rotateClockwise).getBlockData() instanceof Repeater repeater && repeater.isPowered() ? 15 : block.getBlockPower(rotateClockwise);
                int right = event.getClickedBlock().getRelative(rotateClockwise.getOppositeFace()).getBlockData() instanceof Repeater repeater && repeater.isPowered() ? 15 : block.getBlockPower(rotateClockwise.getOppositeFace());
                int output = new NBTTileEntity(event.getClickedBlock().getState()).getInteger("OutputSignal");
                final String[] placeholders = new String[]{"%left%", "%right%", "%output%"};
                final String[] placeholderValues = new String[]{String.valueOf(left), String.valueOf(right), String.valueOf(output)};
                event.getPlayer().spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        TextComponent.fromLegacyText(StringUtils.replaceEach(comparatorMessage, placeholders, placeholderValues)));
                event.setCancelled(true);
            }
        }
    }
}
