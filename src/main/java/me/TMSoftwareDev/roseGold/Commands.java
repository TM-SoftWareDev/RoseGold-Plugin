package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class Commands implements CommandExecutor {
    public EnderDragon activeDragon = null;
    private boolean DragonEvent = false;
    private final HashMap<UUID, Long> cooldown;

    public Commands() {
        this.cooldown = new HashMap<>();
    }

    public EnderDragon getActiveDragon() {
        return activeDragon;
    }

    public boolean getDragonBool() {
        return DragonEvent;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("DragonEvent")) {
            if (sender instanceof Player p) {
                p = (Player) sender;
                if (!p.isOp()) {
                    p.sendMessage("You Must Be OP");
                    return true;
                }
                World endWorld = null;
                for (World world : Bukkit.getWorlds()) {
                    if (world.getEnvironment() == World.Environment.THE_END) {
                        endWorld = world;
                        break;
                    }
                }
                if (endWorld == null) {
                    sender.sendMessage("§cEnd world not found!");
                    return true;
                }
                Location endSpawn = endWorld.getSpawnLocation();
                int count = 0;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.teleport(endSpawn.add(10, 0, 10));
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have been teleported to the End!");
                    count++;
                }
                sender.sendMessage("Teleported " + count + " player(s) to the End!");
                activeDragon = endWorld.spawn(endWorld.getSpawnLocation().add(0, 20, 0), EnderDragon.class);
                DragonEvent = true;
                return true;

            }
        }

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
