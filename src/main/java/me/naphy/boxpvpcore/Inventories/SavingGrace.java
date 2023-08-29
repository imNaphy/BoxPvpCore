package me.naphy.boxpvpcore.Inventories;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SavingGrace {

    public static ItemStack savingGrace() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9§lsᴀᴠɪɴɢ ɢʀᴀᴄᴇ");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§8ᴀᴄᴇsᴛ ɪᴛᴇᴍ ᴘᴇʀᴍɪᴛᴇ sᴀʟᴠᴀʀᴇᴀ ᴀʀᴍᴜʀɪɪ");
        lore.add("§8sɪ ᴀ ɪᴛᴇᴍ-ᴜʟᴜɪ ᴅɪɴ sʟᴏᴛ-ᴜʟ 1 ᴀʟ");
        lore.add("§8ɪɴᴠᴇɴᴛᴀʀᴜʟᴜɪ ʟᴀ ᴍᴏᴀʀᴛᴇ");
        lore.add(" ");
        lore.add("§4§nᴛᴏᴀᴛᴇ §9§nsᴀᴠɪɴɢ ɢʀᴀᴄᴇ§4§n-ᴜʀɪʟᴇ ᴅɪɴ");
        lore.add("§4§nɪɴᴠᴇɴᴛᴀʀ ᴠᴏʀ ғɪ sᴛᴇʀsᴇ ʟᴀ ᴍᴏᴀʀᴛᴇ");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static boolean ListHasSavingGrace (List<ItemStack> list) {
        for (ItemStack item : list) {
            if (item != null) {
                if (item.isSimilar(SavingGrace.savingGrace())) {
                    return true;
                }
            }
        }
        return false;
    }
}
