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

        Bukkit.addRecipe(AmethystBoots);
        Bukkit.addRecipe(ThunderChestplate);
    }
}
