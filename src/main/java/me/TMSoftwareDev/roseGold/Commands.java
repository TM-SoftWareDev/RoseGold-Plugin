package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class Commands implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public Commands() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("Reset")) {
            if (sender instanceof Player p) {
                p = (Player) sender;
                if (!this.cooldown.containsKey(p.getUniqueId())) {
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                    p.setHealth(0.0);
                    p.sendMessage(ChatColor.RED + "You Have Opted to Die");
                } else {
                    long TimeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());

                    if (TimeElapsed >= 10000) {
                        this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        p.setHealth(0.0);
                        p.sendMessage(ChatColor.RED + "You Have Opted to Die");
                    } else {
                        p.sendMessage("You Cant Reset for another " + (10000 - TimeElapsed) + " Milliseconds");
                    }
                }


            }

        }
        return true;
    }


}
