package hashmonopolist.redstonehelper2.listeners;

import hashmonopolist.redstonehelper2.Redstonehelper2;
import hashmonopolist.redstonehelper2.util.Fillers;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.block.data.type.RedstoneWire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.material.Redstone;

import java.util.Objects;

public class PlayerInteract implements Listener {
    Redstonehelper2 plugin;
    public PlayerInteract(Redstonehelper2 plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getHand() != EquipmentSlot.HAND) return;
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(!event.getPlayer().isSneaking()) return;
        final String composterMessage = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.composter",""));
        final String endPortalFrameMessage = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("messages.end_portal_frame",""));
        final String redstoneMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.redstone_level",""));
        switch(Objects.requireNonNull(event.getClickedBlock()).getBlockData().getMaterial().toString()) {
            case "COMPOSTER":
                event.setCancelled(true);
                Fillers.fillComposter(event);
                final Levelled composter = (Levelled) event.getClickedBlock().getBlockData();
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(composterMessage + composter.getLevel()));
                break;
            case "END_PORTAL_FRAME":
                event.setCancelled(true);
                Fillers.fillEndPortalFrame(event);
                final EndPortalFrame endPortalFrame = (EndPortalFrame) event.getClickedBlock().getBlockData();
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(endPortalFrameMessage + endPortalFrame.hasEye()));
                break;
            case "REDSTONE_WIRE":
                if(!plugin.getConfig().getBoolean("utility.redstone_action_bar")) return;
                event.setCancelled(true);
                int redstoneLevel = ((RedstoneWire) event.getClickedBlock().getBlockData()).getPower();
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(redstoneMessage + redstoneLevel));
        }
    }
}
