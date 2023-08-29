package me.naphy.boxpvpcore;

import me.naphy.boxpvpcore.Commands.GiveCobweb;
import me.naphy.boxpvpcore.Commands.GiveSavingGrace;
import me.naphy.boxpvpcore.Events.Cobweb;
import me.naphy.boxpvpcore.Events.NetherStar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class BoxPvpCore extends JavaPlugin {

    public static BoxPvpCore plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("givesavinggrace").setExecutor(new GiveSavingGrace());
        getCommand("givecobweb").setExecutor(new GiveCobweb());
        getServer().getPluginManager().registerEvents(new NetherStar(), this);
        getServer().getPluginManager().registerEvents(new Cobweb(), this);
        Scheduler.start();
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[BoxPvpCore] The plugin has been loaded!"));
    }

    @Override
    public void onDisable() {
        for (me.naphy.boxpvpcore.Inventories.Cobweb.CobwebInfo cobweb : me.naphy.boxpvpcore.Inventories.Cobweb.cobwebs) {
            cobweb.cobwebLoc.getBlock().setType(Material.AIR);
        }
        me.naphy.boxpvpcore.Inventories.Cobweb.cobwebs = new ArrayList<>();
        Scheduler.stop();
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[BoxPvpCore] The plugin has been unloaded!"));
    }
}
