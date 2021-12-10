package hashmonopolist.redstonehelper2;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import hashmonopolist.redstonehelper2.commands.Commands;
import hashmonopolist.redstonehelper2.listeners.BlockBreak;
import hashmonopolist.redstonehelper2.listeners.BlockPlaced;
import hashmonopolist.redstonehelper2.listeners.PlayerInteract;
import org.bukkit.plugin.java.JavaPlugin;

public final class Redstonehelper2 extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("Enabling Redstonehelper2");
        getServer().getPluginManager().registerEvents(new BlockPlaced(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(this),this);
        CommandAPI.onEnable(this);
        Commands.registerDec2Bin(this);
        Commands.registerBin2Dec(this);
        Commands.registerRedstonehelper(this);
        Commands.registerBarrel(this);
        Commands.registerFurnace(this);
        Commands.registerChest(this);
        Commands.registerDropper(this);
        Commands.registerDispenser(this);
        Commands.registerShulkerbox(this);
        Commands.registerHex2Dec(this);
    }

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIConfig());

    }

    @Override
    public void onDisable() {
        System.out.println("Disabling Redstonehelper2");
    }
}
