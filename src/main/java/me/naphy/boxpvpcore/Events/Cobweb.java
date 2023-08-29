package me.naphy.boxpvpcore.Events;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static me.naphy.boxpvpcore.BoxPvpCore.plugin;

public class Cobweb implements Listener {

    @EventHandler
    public void onBlockPlace (BlockPlaceEvent event) {

        if (!event.getItemInHand().isSimilar(me.naphy.boxpvpcore.Inventories.Cobweb.cobweb())) return;
        Location loc = new Location(event.getBlockPlaced().getWorld(), event.getBlockPlaced().getX(), event.getBlockPlaced().getY(), event.getBlockPlaced().getZ());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(loc));
        Boolean temp = true;
        for (ProtectedRegion pr : set) {
            if (pr.getFlag(Flags.PVP) != null) {
                if (pr.getFlag(Flags.PVP).equals(StateFlag.State.DENY)) temp = false;
            }
        }
        if (temp) {
            event.setCancelled(true);
            me.naphy.boxpvpcore.Inventories.Cobweb.CobwebInfo tempCob = new me.naphy.boxpvpcore.Inventories.Cobweb.CobwebInfo();
            tempCob.cobwebLoc = loc;
            tempCob.cobwebTimer = 120;
            me.naphy.boxpvpcore.Inventories.Cobweb.cobwebs.add(tempCob);
            Bukkit.getScheduler().runTask(plugin, () -> loc.getBlock().setType(Material.COBWEB));
            event.getItemInHand().setAmount(event.getItemInHand().getAmount() - 1);
        }
    }

}
