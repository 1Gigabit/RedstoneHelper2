package hashmonopolist.redstonehelper2.util;

import hashmonopolist.redstonehelper2.listeners.PlayerInteract;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class Fillers {
    public static void fillComposter(PlayerInteractEvent event) {
        Levelled composter = (Levelled) Objects.requireNonNull(event.getClickedBlock()).getBlockData();
        if(composter.getLevel() == 6 ) {
            composter.setLevel(0);
        } else {
            composter.setLevel(composter.getLevel()+1);
        }
        event.getClickedBlock().setBlockData(composter);
    }
    public static void fillEndPortalFrame(PlayerInteractEvent event) {
        EndPortalFrame endPortalFrame = (EndPortalFrame) Objects.requireNonNull(event.getClickedBlock()).getBlockData();
        endPortalFrame.setEye(!endPortalFrame.hasEye());
        event.getClickedBlock().setBlockData(endPortalFrame);
    }
}
