package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        if (name.equals("TalllTim")) {
            event.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Hello Divine King of True Glory and Noble Status Tim");
        } else if (name.equals("airhopman")) {
            event.setJoinMessage(ChatColor.RED + "Hello Cheater");
        }
    }


}
