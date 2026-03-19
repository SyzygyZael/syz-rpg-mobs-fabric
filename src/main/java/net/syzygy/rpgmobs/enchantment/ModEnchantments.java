package net.syzygy.rpgmobs.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.syzygy.rpgmobs.RPGMobs;

public class ModEnchantments {
    public static final Enchantment WITHERING_1 = register("withering_1",
            new WitheringEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(RPGMobs.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        RPGMobs.LOGGER.info("Registering ModEnchantments for " + RPGMobs.MOD_ID);
    }
}