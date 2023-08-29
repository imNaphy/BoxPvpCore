package me.naphy.boxpvpcore.Events;

import me.naphy.boxpvpcore.Inventories.SavingGrace;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class NetherStar implements Listener {

    @EventHandler
    public void OnDeath (PlayerDeathEvent event) {
        if (SavingGrace.ListHasSavingGrace(event.getDrops())) {
            event.setKeepInventory(true);
            for (int i = 0; i < 36; ++i) {
                if (event.getEntity().getInventory().getItem(i) != null) {
                    if (event.getEntity().getInventory().getItem(i).isSimilar(SavingGrace.savingGrace())) {
                        event.getEntity().getInventory().setItem(i, null);
                    }
                }
            }
            for (int i = 1; i < 36; ++i) {
                event.getEntity().getInventory().setItem(i, null);
            }
            event.getEntity().getInventory().setItem(40, null);
            ItemStack sword = null;
            ItemStack helmet = null;
            ItemStack chestplate = null;
            ItemStack leggings = null;
            ItemStack boots = null;
            if (event.getEntity().getInventory().getItem(0) != null)
                sword = new ItemStack(event.getEntity().getInventory().getItem(0));
            if (event.getEntity().getInventory().getHelmet() != null)
                helmet = new ItemStack(event.getEntity().getInventory().getHelmet());
            if (event.getEntity().getInventory().getChestplate() != null)
                chestplate = new ItemStack(event.getEntity().getInventory().getChestplate());
            if (event.getEntity().getInventory().getLeggings() != null)
                leggings = new ItemStack(event.getEntity().getInventory().getLeggings());
            if (event.getEntity().getInventory().getBoots() != null)
                boots = new ItemStack(event.getEntity().getInventory().getBoots());
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < event.getDrops().size(); ++i) {
                if (event.getDrops().get(i).isSimilar(SavingGrace.savingGrace())) {
                    temp.add(i);
                }
            }
            Integer j = 0;
            for (int i = 0; i < temp.size(); ++i) {
                event.getDrops().remove(temp.get(i) - j++);
            }
            System.out.println(event.getDrops());
            event.getDrops().remove(sword);
            event.getDrops().remove(helmet);
            event.getDrops().remove(chestplate);
            event.getDrops().remove(leggings);
            event.getDrops().remove(boots);

            event.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lSaving Grace&7-urile tale au fost folosite cu succes!"));
            getServer().getConsoleSender().sendMessage(event.getEntity().getName() + "a spart un saving grace!");
        }
    }
}
