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


    public static ItemStack getVampireHelmet() {
        ItemStack VampireHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta Meta = VampireHelmet.getItemMeta();
        Meta.setDisplayName(ChatColor.RED + "Vampire helmet");
        Meta.setLore(List.of("Life steal"));
        Meta.setMaxStackSize(1);
        Meta.setUnbreakable(true);
        Meta.setRarity(ItemRarity.EPIC);
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "VampireHelmet_key");
        NamespacedKey Toughness_Key = new NamespacedKey(RoseGold.getInstance(), "VampireHelmetToughness_key");
        AttributeModifier Armor_Boost = new AttributeModifier(Armor_Key, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD);
        AttributeModifier Toughness = new AttributeModifier(Toughness_Key, 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD);
        Meta.addAttributeModifier(Attribute.ARMOR, Armor_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, Toughness);
        VampireHelmet.setItemMeta(Meta);
        return VampireHelmet;
    }

    public static ItemStack getXrayPotion() {
        ItemStack XrayPotion = new ItemStack(Material.POTION, 1);
        ItemMeta Meta = XrayPotion.getItemMeta();
        Meta.setMaxStackSize(1);
        Meta.setDisplayName("Potion Of Xray");
        XrayPotion.setItemMeta(Meta);
        return XrayPotion;
    }

    public static ItemStack getNuke() {
        ItemStack Nuke = new ItemStack(Material.TNT, 1);
        ItemMeta Meta = Nuke.getItemMeta();
        Meta.setMaxStackSize(1);
        Meta.setDisplayName(ChatColor.RED + "NUKE");
        Nuke.setItemMeta(Meta);
        return Nuke;

    }


    public static ItemStack getBloodSword() {
        ItemStack BloodSword = new ItemStack(Material.COPPER_SWORD, 1);
        ItemMeta Meta = BloodSword.getItemMeta();
        Meta.setDisplayName(ChatColor.RED + "Blood Sword");
        Meta.setUnbreakable(true);
        BloodSword.setItemMeta(Meta);
        return BloodSword;

    }


    public static ItemStack getHaloHelmet() {
        ItemStack Halo = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta Meta = Halo.getItemMeta();
        Meta.setDisplayName(ChatColor.YELLOW + "Halo");
        Meta.setMaxStackSize(1);
        Meta.setUnbreakable(true);
        Meta.setRarity(ItemRarity.EPIC);
        NamespacedKey HealthKey = new NamespacedKey(RoseGold.getInstance(), "HaloHealth_Key");
        NamespacedKey ArmourKey = new NamespacedKey(RoseGold.getInstance(), "HaloArmour_Key");
        NamespacedKey FallKey = new NamespacedKey(RoseGold.getInstance(), "HaloFall_Key");
        NamespacedKey GravityKey = new NamespacedKey(RoseGold.getInstance(), "HaloGravity_Key");
        AttributeModifier Health_Mod = new AttributeModifier(HealthKey, 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD);
        AttributeModifier Armour_Mod = new AttributeModifier(ArmourKey, 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD);
        AttributeModifier Fall_Mod = new AttributeModifier(FallKey, -1, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.HEAD);
        AttributeModifier Gravity_Mod = new AttributeModifier(GravityKey, -0.35, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.HEAD);
        Meta.addAttributeModifier(Attribute.MAX_HEALTH, Health_Mod);
        Meta.addAttributeModifier(Attribute.ARMOR, Armour_Mod);
        Meta.addAttributeModifier(Attribute.FALL_DAMAGE_MULTIPLIER, Fall_Mod);
        Meta.addAttributeModifier(Attribute.GRAVITY, Gravity_Mod);
        Halo.setItemMeta(Meta);
        return Halo;
    }

    public static ItemStack getThunderChestPlate() {
        ItemStack ThunderChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta Meta = ThunderChestPlate.getItemMeta();
        Meta.setDisplayName(ChatColor.DARK_BLUE + "Thunder Chestplate");
        Meta.setLore(List.of("Crafted By the Gods"));
        Meta.setMaxStackSize(1);
        Meta.setUnbreakable(true);
        Meta.setRarity(ItemRarity.EPIC);
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "ThunderChestPlate_key");
        NamespacedKey Armor_Toughnesskey = new NamespacedKey(RoseGold.getInstance(), "ThunderChestPlateToughness_key");
        AttributeModifier Armor_Boost = new AttributeModifier(Armor_Key, 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST);
        AttributeModifier Armor_Toughness = new AttributeModifier(Armor_Toughnesskey, 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST);
        Meta.addAttributeModifier(Attribute.ARMOR, Armor_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, Armor_Toughness);
        ThunderChestPlate.setItemMeta(Meta);
        return ThunderChestPlate;
    }

    public static ItemStack getBlazeStick() {
        ItemStack BlazeStick = new ItemStack(Material.STICK, 1);
        ItemMeta Meta = BlazeStick.getItemMeta();
        Meta.setDisplayName(ChatColor.YELLOW + "Blaze Stick");
        Meta.setLore(List.of("Right Click :)"));
        Meta.setMaxStackSize(1);
        Meta.setRarity(ItemRarity.EPIC);
        BlazeStick.setItemMeta(Meta);
        return BlazeStick;
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
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "AmethystBoots_key");
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

    public static ItemStack getGauntletsOfRage() {
        ItemStack GauntletsOfRage = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta Meta = GauntletsOfRage.getItemMeta();
        Meta.setDisplayName(ChatColor.RED + "Gauntlets Of Rage");
        Meta.setLore(List.of("Press F grants Buffs But comes with A downside"));
        Meta.setUnbreakable(true);
        Meta.setMaxStackSize(1);
        NamespacedKey Armor_Key = new NamespacedKey(RoseGold.getInstance(), "GauntletsOfrage_key");
        NamespacedKey Toughness_Key = new NamespacedKey(RoseGold.getInstance(), "Toughness_Key");
        AttributeModifier Armor_Boost = new AttributeModifier(Armor_Key, 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS);
        AttributeModifier Toughness_Boost = new AttributeModifier(Toughness_Key, 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS);
        Meta.addAttributeModifier(Attribute.ARMOR, Armor_Boost);
        Meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, Toughness_Boost);
        GauntletsOfRage.setItemMeta(Meta);
        return GauntletsOfRage;
    }


}
