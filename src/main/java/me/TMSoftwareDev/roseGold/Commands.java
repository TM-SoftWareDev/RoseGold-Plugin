package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Reset")) {
            if (sender instanceof Player p) {

                p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "You Have Opted to Die");
            }

        }
        return true;
    }
}
