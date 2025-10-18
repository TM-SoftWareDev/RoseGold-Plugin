package me.TMSoftwareDev.roseGold;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

    public static ItemStack getRoseGoldSword() {
        ItemStack roseGoldSword = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta swordMeta = roseGoldSword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.RED + "Rose Gold Sword");
        swordMeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        swordMeta.addEnchant(Enchantment.UNBREAKING, 1, true);
        swordMeta.addEnchant(Enchantment.SHARPNESS, 2, true);
        roseGoldSword.setItemMeta(swordMeta);
        return roseGoldSword;
    }


}
