package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

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

    @EventHandler
    public void LightningImmunity(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                ItemStack ChestPlate = player.getInventory().getChestplate();
                if (ChestPlate == null) {
                    return;
                }
                ItemMeta meta = ChestPlate.getItemMeta();
                if (meta == null) {
                    return;
                }
                if (!meta.hasDisplayName()) {
                    return;
                }
                if (meta.hasDisplayName() && meta.getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "Thunder Chestplate")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    Random random = new Random();

    @EventHandler
    public void OnPlayerHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player damager && !(event.getDamager() instanceof Projectile)) {
            Entity target = event.getEntity();
            Location targetLocation = target.getLocation();
            ItemStack Chestplate = damager.getInventory().getChestplate();
            if (Chestplate == null) {
                return;
            }
            ItemMeta meta = Chestplate.getItemMeta();
            if (meta == null) {
                return;
            }
            if (!meta.hasDisplayName()) {
                return;
            }
            if (meta.hasDisplayName() && meta.getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE + "Thunder Chestplate")) {
                int Randomnum = random.nextInt(10);
                if (Randomnum == 5) {
                    target.getWorld().strikeLightning(targetLocation);
                } else {
                    return;
                }

            }
        }
    }


}
