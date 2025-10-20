package me.TMSoftwareDev.roseGold;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class EntityListener implements Listener {


    private void LaunchFireBall() {


    }


    private final HashMap<UUID, Long> cooldown;
    private final HashMap<UUID, Long> Gaunletcooldown;

    public EntityListener() {
        this.cooldown = new HashMap<>();
        this.Gaunletcooldown = new HashMap<>();
    }

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
    public void BlazeStickFireBall(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();

            if (event.getItem() == null) return;

            ItemStack item = event.getItem();
            if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
                return;
            }


            if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Blaze Stick")) {
                if (!this.cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) >= 10000) {
                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    event.setCancelled(true);
                    player.launchProjectile(Fireball.class);
                } else {
                    event.setCancelled(true);
                    double result = 10000 - (System.currentTimeMillis() - this.cooldown.get(player.getUniqueId()));
                    player.sendMessage("You Cant Use Ability For Another " + result / 1000 + " Seconds");

                }
            }


        }

    }

    @EventHandler
    public void Tracker(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            if (player.getName().equalsIgnoreCase("TalllTim")) {
                if (event.getItem() != null && event.getItem().getType() == Material.STICK) {
                    Player target = Bukkit.getPlayer("blocksurfer123");
                    if (target != null && target.isOnline()) {
                        Location loc = target.getLocation();
                        player.sendMessage("X = " + loc.getBlockX() + "Y = " + loc.getBlockY() + "Z = " + loc.getBlockZ());
                    } else {
                        player.sendMessage("Player Offline");
                    }

                }
            }
        }

    }


    @EventHandler
    public void GauntLetsOfRage(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        ItemStack Leggings = player.getInventory().getLeggings();
        if (Leggings == null) {
            return;
        }
        if (!Leggings.hasItemMeta() || !Leggings.getItemMeta().hasDisplayName()) {
            return;
        }

        if (Leggings.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Gauntlets Of Rage")) {
            if (!this.Gaunletcooldown.containsKey(player.getUniqueId()) || (System.currentTimeMillis() -
                    this.Gaunletcooldown.get(player.getUniqueId()) >= 30000)) {
                this.Gaunletcooldown.put(player.getUniqueId(), System.currentTimeMillis());
                event.setCancelled(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 400, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 200, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 3));
                player.sendMessage(ChatColor.RED + "Your Rage Blinds You");
            } else {
                event.setCancelled(true);
                double result = 30000 - (System.currentTimeMillis() - this.Gaunletcooldown.get(player.getUniqueId()));
                player.sendMessage("You Cant Use Ability For Another " + result / 1000 + " Seconds");
            }

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
