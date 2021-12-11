package hashmonopolist.redstonehelper2.util;

import org.bukkit.block.data.Levelled;
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
}
