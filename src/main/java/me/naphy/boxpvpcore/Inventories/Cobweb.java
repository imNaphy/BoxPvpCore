package me.naphy.boxpvpcore.Inventories;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Cobweb {

    public static class CobwebInfo {
        public Location cobwebLoc;
        public int cobwebTimer;
    }

    public static List<CobwebInfo> cobwebs = new ArrayList<>();

    public static ItemStack cobweb() {
        ItemStack item = new ItemStack(Material.COBWEB, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7§lᴄᴏʙᴡᴇʙ");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§8ɪᴛᴇᴍ ᴄᴀʀᴇ ᴘᴏᴀᴛᴇ ғɪ ᴘʟᴀsᴀᴛ ɪɴ ʟᴜᴍᴇ");
        lore.add("§8ᴀᴄᴛɪᴏɴᴇᴀᴢᴀ ᴄᴀ ᴜɴ ᴄᴏʙᴡᴇʙ ɴᴏʀᴍᴀʟ, ᴄᴀʀᴇ");
        lore.add("§8ᴅɪsᴘᴀʀᴇ ᴅᴜᴘᴀ ᴏ ᴘᴇʀɪᴏᴀᴅᴀ ᴅᴇ ᴛɪᴍᴘ");
        lore.add(" ");
        lore.add("§8ᴛɪᴍᴘ ᴅᴇ ᴇxɪsᴛᴇɴᴛᴀ: §c§n2 ᴍɪɴᴜᴛᴇ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
