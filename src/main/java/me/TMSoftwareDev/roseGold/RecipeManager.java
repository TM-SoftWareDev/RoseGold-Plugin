package me.TMSoftwareDev.roseGold;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

    // AmethystBoots

    public static void registerRecipes() {
        ShapedRecipe AmethystBoots = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "amethyst_boots"), Items.getAmethystBoots());
        AmethystBoots.shape
                ("ABA",
                        "ADA",
                        "ABA"
                );
        AmethystBoots.setIngredient('A', Material.AMETHYST_SHARD);
        AmethystBoots.setIngredient('D', Material.DIAMOND_BOOTS);
        AmethystBoots.setIngredient('B', Material.AMETHYST_BLOCK);

        // ThunderChestplate

        ShapedRecipe ThunderChestplate = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "Thunder_ChestPlate"), Items.getThunderChestPlate());
        ThunderChestplate.shape
                (
                        "RIR",
                        "IDI",
                        "RIR"
                );
        ThunderChestplate.setIngredient('R', Material.REDSTONE_BLOCK);
        ThunderChestplate.setIngredient('D', Material.DIAMOND_CHESTPLATE);
        ThunderChestplate.setIngredient('I', Material.IRON_INGOT);

        ShapedRecipe BlazeStick = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "Blaze_Stick"), Items.getBlazeStick());
        BlazeStick.shape
                (
                        "BBB",
                        "BSB",
                        "BBB"
                );
        BlazeStick.setIngredient('B', Material.BLAZE_POWDER);
        BlazeStick.setIngredient('S', Material.STICK);

        ShapedRecipe Gauntletsofrage = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "Gauntletsofrage"), Items.getGauntletsOfRage());
        Gauntletsofrage.shape
                (
                        "RNR",
                        "GWG",
                        "INI"
                );
        Gauntletsofrage.setIngredient('R', Material.REDSTONE_BLOCK);
        Gauntletsofrage.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        Gauntletsofrage.setIngredient('N', Material.NETHER_WART);
        Gauntletsofrage.setIngredient('I', Material.IRON_INGOT);
        Gauntletsofrage.setIngredient('G', Material.GOLD_INGOT);

        ShapedRecipe HaloHelmet = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "HaloHelmet"), Items.getHaloHelmet());
        HaloHelmet.shape
                (
                        " I ",
                        "IDI",
                        " I "
                );
        HaloHelmet.setIngredient('I', Material.IRON_INGOT);
        HaloHelmet.setIngredient('D', Material.DIAMOND);

        ShapedRecipe VampireHelmet = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "VampireHelmet"), Items.getVampireHelmet());
        VampireHelmet.shape
                (
                        " R ",
                        "RDR",
                        " R "
                );
        VampireHelmet.setIngredient('R', Material.REDSTONE_BLOCK);
        VampireHelmet.setIngredient('D', Material.DIAMOND_HELMET);

        ShapedRecipe BloodSword = new ShapedRecipe(new NamespacedKey(RoseGold.getInstance(), "BloodSword"), Items.getBloodSword());
        BloodSword.shape(
                " R ",
                " R ",
                " S "
        );
        BloodSword.setIngredient('R', Material.REDSTONE_BLOCK);
        BloodSword.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(AmethystBoots);
        Bukkit.addRecipe(ThunderChestplate);
        Bukkit.addRecipe(BlazeStick);
        Bukkit.addRecipe(Gauntletsofrage);
        Bukkit.addRecipe(HaloHelmet);
        Bukkit.addRecipe(VampireHelmet);
        Bukkit.addRecipe(BloodSword);
    }
}
