package me.TMSoftwareDev.roseGold;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class EntityListener implements Listener {


    private final HashMap<UUID, Long> cooldown;
    private final HashMap<UUID, Long> Gaunletcooldown;
    private final HashMap<Location, BlockDisplay> highlightedBlocks = new HashMap<>();

    public EntityListener() {
        this.cooldown = new HashMap<>();
        this.Gaunletcooldown = new HashMap<>();
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) throws IOException {
        Player player = event.getPlayer();
        String name = player.getName();
        String Locx = Integer.toString(player.getLocation().getBlockX());
        String Locy = Integer.toString(player.getLocation().getBlockY());
        String Locz = Integer.toString(player.getLocation().getBlockZ());
        Webhook(name, Locx, Locy, Locz);
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
                    Fireball fireball = player.launchProjectile(Fireball.class);
                    fireball.setYield(20);
                } else {
                    event.setCancelled(true);
                    double result = 10000 - (System.currentTimeMillis() - this.cooldown.get(player.getUniqueId()));
                    player.sendMessage("You Cant Use Ability For Another " + result / 1000 + " Seconds");

                }
            }


        }

    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        ItemStack item = event.getItemInHand();
        if (item == null) return;
        if (block.getType() == Material.TNT &&
                item.hasItemMeta() &&
                item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "NUKE")) {


            block.setMetadata("NUKE", new FixedMetadataValue(RoseGold.getInstance(), true));
        }

    }

    @EventHandler
    public void OntntIgnite(TNTPrimeEvent event) {
        Block block = event.getBlock();
        if (block == null) return;
        if (block.hasMetadata("NUKE")) {
            event.setCancelled(true);
            TNTPrimed tnt = block.getWorld().spawn(block.getLocation().add(0.5, 0, 0.5), TNTPrimed.class);
            tnt.setFuseTicks(200);

            block.setType(Material.AIR);
        }
    }

    @EventHandler
    public void OntntExplode(EntityExplodeEvent event) {
        Entity entity = event.getEntity();
        Block Tblock = event.getLocation().getBlock();
        if (Tblock.hasMetadata("NUKE")) {


            if (!(entity instanceof TNTPrimed)) return;
            event.blockList().clear();

            World world = entity.getWorld();
            int radius = 25;
            int centerX = entity.getLocation().getBlockX();
            int centerY = entity.getLocation().getBlockY();
            int centerZ = entity.getLocation().getBlockZ();


            List<Block> blocksToDestroy = new ArrayList<>();

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        if (x * x + y * y + z * z <= radius * radius) {
                            Block block = world.getBlockAt(centerX + x, centerY + y, centerZ + z);
                            if (block.getType() != Material.AIR && block.getType() != Material.BEDROCK) {
                                blocksToDestroy.add(block);
                            }
                        }
                    }
                }
            }

            new BukkitRunnable() {
                int Index = 0;
                int blockspertick = 100;


                @Override
                public void run() {

                    if (Bukkit.getTPS()[0] < 18.0) {
                        blockspertick = 60;
                    }


                    for (int i = 0; i < blockspertick && Index < blocksToDestroy.size(); i++, Index++) {
                        Block block = blocksToDestroy.get(Index);
                        block.setType(Material.AIR);
                    }

                    if (Index >= blocksToDestroy.size()) {
                        cancel();
                    }

                }

            }.runTaskTimer(RoseGold.getInstance(), 0, 1);


        }
    }

    @EventHandler
    public void CustomBrew2(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getClickedBlock() == null || event.getClickedBlock().getType() != Material.BREWING_STAND)
            return;
        int Check = 0;
        ItemStack item = event.getItem();
        if (item != null && item.getType() == Material.GOLD_BLOCK) {
            event.setCancelled(true);
            BrewingStand stand = (BrewingStand) event.getClickedBlock().getState();
            BrewerInventory inv = stand.getInventory();
            ItemStack ingredient = inv.getIngredient();
            for (int i = 0; i < 3; i++) {
                ItemStack potion = inv.getItem(i);
                if (potion != null && potion.getType() == Material.POTION) {

                    if (potion.hasItemMeta() && potion.getItemMeta() instanceof PotionMeta Meta) {
                        PotionType Type = Meta.getBasePotionType();
                        if (Type == PotionType.AWKWARD) {
                            inv.setItem(i, Items.getXrayPotion());
                            Check++;
                        }
                    }
                }
            }
            if (Check > 0) {
                item.setAmount(item.getAmount() - 1);
            }


        }

    }


    @EventHandler
    public void ClosestDiamondBlock(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();
        ItemStack Potion = event.getItem();
        int Radius = 12;
        Location nearestlocation = null;

        if (Potion.getItemMeta().getDisplayName().equalsIgnoreCase("Potion Of Xray")) {
            nearestlocation = getNearestDiamondBlock(player, 12);
            if (nearestlocation == null) {
                player.sendMessage("No Diamonds Found Within Radius of: " + Radius);
                return;
            }
            player.sendMessage("Closest Diamond Ore at " + "X: " + nearestlocation.getBlockX() + " Y: " + nearestlocation.getBlockY()
                    + " Z: " + nearestlocation.getBlockZ());

            BlockDisplay block = HighlightBlock(nearestlocation.getBlock(), 10);

            highlightedBlocks.put(nearestlocation, (block));
        }


    }


    @EventHandler
    public void BloodSword(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player damager && !(event.getDamager() instanceof Projectile)) {
            ItemStack Sword = damager.getInventory().getItemInMainHand();
            if (Sword == null || Sword.getType() == Material.AIR) {
                return;
            }
            if (!Sword.getItemMeta().hasDisplayName()) {
                return;
            }
            if (Sword.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Blood Sword")) {
                double Damage = event.getDamage();
                double MaxHealth = damager.getMaxHealth();
                double CurrentHealth = damager.getHealth();
                double HealthPercent = CurrentHealth / MaxHealth;
                double Multiplier = 1 + (1 - HealthPercent);
                event.setDamage(Damage * Multiplier);
                Entity entity = event.getEntity();
                Location location = entity.getLocation();
                int particleAmount = (int) Math.round(Damage * Multiplier * 4);
                particleAmount = Math.max(5, Math.min(particleAmount, 150));
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 0.5f);
                entity.getWorld().spawnParticle(Particle.DUST, location.add(0, 1, 0), particleAmount, 0.4, 0.5, 0.4, dustOptions);
                damager.sendActionBar(Component.text("Damge Boost%: " + (int) Math.round((Multiplier - 1) * 100)));
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
    public void LifeSteal(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player damager && !(event.getDamager() instanceof Projectile)) {
            double damage = event.getDamage();

            ItemStack Helmet = damager.getInventory().getHelmet();
            if (Helmet == null) {
                return;
            }
            if (!Helmet.hasItemMeta() || !(Helmet.getItemMeta().hasDisplayName())) {
                return;
            }

            if (Helmet.getItemMeta().getDisplayName().equalsIgnoreCase(org.bukkit.ChatColor.RED + "Vampire helmet")) {
                damager.heal(damage / 4);

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
                player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 300, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                ;
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

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Location loc = block.getLocation();

        BlockDisplay display = highlightedBlocks.remove(loc);
        if (display != null && !(display.isDead())) {
            display.remove();
        }
    }

    public void Webhook(String playerName, String Locx, String Locy, String Locz) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ");
        sb.append(playerName);
        sb.append(" X Pos: ");
        sb.append(Locx);
        sb.append(" Y Pos: ");
        sb.append(Locy);
        sb.append(" Z Pos: ");
        sb.append(Locz);
        String result = sb.toString();
        String WebhookUrl = "https://discord.com/api/webhooks/1430221104466624523/LmKJc1FDF2sxYD5D-kW-Qon-HUrjKzYtx1A2gwRiz1sAmy7bS_0Xy9K5vKAtICM6KXz3";
        String jsonPayload = "{\"content\": \"" + result + "\"}";
        URL url = new URL(WebhookUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonPayload.getBytes());
        }

        connection.getResponseCode();
        return;
    }


    public Location getNearestDiamondBlock(Player player, int Radius) {
        Location Playerloc = player.getLocation();
        World world = player.getWorld();
        double nearestDistance = Double.MAX_VALUE;
        Location nearestLocation = null;

        for (int x = -Radius; x <= Radius; x++) {
            for (int y = -Radius; y <= Radius; y++) {
                for (int z = -Radius; z <= Radius; z++) {
                    Block block = world.getBlockAt(Playerloc.clone().add(x, y, z));
                    if (block.getType() == Material.DIAMOND_ORE || block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                        double distance = block.getLocation().distanceSquared(Playerloc);
                        if (distance < nearestDistance) {
                            nearestDistance = distance;
                            nearestLocation = block.getLocation();
                        }
                    }
                }
            }
        }

        return nearestLocation;
    }

    public BlockDisplay HighlightBlock(Block block, long Duration) {
        World word = block.getWorld();
        Location loc = block.getLocation();

        BlockDisplay blockDisplay = (BlockDisplay) word.spawnEntity(loc, EntityType.BLOCK_DISPLAY);
        blockDisplay.setBlock(block.getBlockData());
        blockDisplay.setGlowing(true);
        blockDisplay.setInvulnerable(true);
        blockDisplay.setPersistent(false);


        new BukkitRunnable() {
            @Override
            public void run() {
                if (!blockDisplay.isDead()) {
                    blockDisplay.remove();
                }
            }

        }.runTaskLater(RoseGold.getInstance(), 20 * Duration);

        return blockDisplay;
    }


}
