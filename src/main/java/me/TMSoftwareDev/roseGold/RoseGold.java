package me.TMSoftwareDev.roseGold;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoseGold extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("@ RoseGold Enabled");
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getCommand("Reset").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        System.out.println("@ RoseGold Disabled");
    }


}
