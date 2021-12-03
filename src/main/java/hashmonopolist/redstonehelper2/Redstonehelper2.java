package hashmonopolist.redstonehelper2;

import hashmonopolist.redstonehelper2.commands.Commands;
import hashmonopolist.redstonehelper2.listeners.BlockPlaced;
import hashmonopolist.redstonehelper2.listeners.PlayerInteract;
import org.bukkit.plugin.java.JavaPlugin;

public final class Redstonehelper2 extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("Enabling Redstonehelper2");
        getServer().getPluginManager().registerEvents(new BlockPlaced(this),this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(this),this);
        Commands.registerDec2Bin(this);
        Commands.registerBin2Dec(this);
        Commands.registerRedstonehelper(this);
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling Redstonehelper2");
    }
}
