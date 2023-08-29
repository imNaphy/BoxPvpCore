package me.naphy.boxpvpcore.Commands;

import me.naphy.boxpvpcore.Inventories.SavingGrace;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveSavingGrace implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("givesavinggrace")) return true;
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                sender.sendMessage("You can only give saving graces to players!");
                return true;
            }
            else {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Bukkit.getPlayer(args[0]).getInventory().addItem(SavingGrace.savingGrace());
                    return true;
                }
            }
        }
        if (!sender.hasPermission("boxpvpcore.givesavinggrace")) {
            return true;
        }
        else {
            if (args.length == 0) {
                ((Player) sender).getInventory().addItem(SavingGrace.savingGrace());
            }
            else {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Bukkit.getPlayer(args[0]).getInventory().addItem(SavingGrace.savingGrace());
                }
            }
        }
        return true;
    }
}
