package me.TMSoftwareDev.roseGold;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoseGold extends JavaPlugin implements Listener {
    private static RoseGold instance;

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("@ RoseGold Enabled");


        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "RoseGoldSword"), Items.getRoseGoldSword());
        recipe.shape(
                "GGG",
                "GCG",
                "GGG"
        );
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('C', Material.COPPER_INGOT);

        Bukkit.addRecipe(recipe);
        RecipeManager.registerRecipes();
        Commands commands = new Commands();
        getCommand("Reset").setExecutor(commands);
        getCommand("DragonEvent").setExecutor(commands);
        EntityListener listener = new EntityListener(commands);
        getServer().getPluginManager().registerEvents(listener, this);


    }

    @Override
    public void onDisable() {
        System.out.println("@ RoseGold Disabled");
    }

    public static RoseGold getInstance() {
        return instance;
    }


}
