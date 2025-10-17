package me.TMSoftwareDev.roseGold;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoseGold extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("@ RoseGold Enabled");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        System.out.println("@ RoseGold Disabled");
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        if (name.equals("TalllTim")) {
            event.setJoinMessage("Hello Divine King of True Glory and Noble Status Tim");
        } else if (name.equals("airhopman")) {
            event.setJoinMessage("Hello Cheater");
        }
    }
}
