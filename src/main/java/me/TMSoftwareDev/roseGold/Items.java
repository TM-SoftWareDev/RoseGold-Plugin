package me.TMSoftwareDev.roseGold;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

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

    public static ItemStack getThunderChestPlate() {
        ItemStack ThunderChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta Meta = ThunderChestPlate.getItemMeta();
        Meta.setDisplayName(ChatColor.DARK_BLUE + "Thunder Chestplate");
        Meta.setLore(List.of("Crafted By the Gods"));
        Meta.setMaxStackSize(1);
        Meta.setUnbreakable(true);
        Meta.setRarity(ItemRarity.EPIC);
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "Armor_key");
        AttributeModifier Armor_Boost = new AttributeModifier(Armor_Key, 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST);
        Meta.addAttributeModifier(Attribute.ARMOR, Armor_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, Armor_Boost);
        ThunderChestPlate.setItemMeta(Meta);
        return ThunderChestPlate;
    }


    public static ItemStack getAmethystBoots() {
        ItemStack AmethystBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta Meta = AmethystBoots.getItemMeta();
        Meta.setDisplayName(ChatColor.DARK_PURPLE + "Amethyst Boots");
        Meta.setLore(List.of("Reduces Fall Damage"));
        Meta.setUnbreakable(true);
        Meta.setMaxStackSize(1);
        NamespacedKey Speed_Key = new NamespacedKey(RoseGold.getInstance(), "Speed_key");
        NamespacedKey Fall_Key = new NamespacedKey(RoseGold.getInstance(), "Fall_key");
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "Armor_key");
        AttributeModifier Armor_Boost = new AttributeModifier(Armor_Key, 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET);
        AttributeModifier Speed_Boost = new AttributeModifier(Speed_Key, 0.2, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlotGroup.FEET);
        AttributeModifier Fall_Damage = new AttributeModifier(Fall_Key, -0.3, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.FEET);
        Meta.addAttributeModifier(Attribute.MOVEMENT_SPEED, Speed_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR, Armor_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, Armor_Boost);
        Meta.addAttributeModifier(Attribute.FALL_DAMAGE_MULTIPLIER, Fall_Damage);
        AmethystBoots.setItemMeta(Meta);
        return AmethystBoots;
    }


}
