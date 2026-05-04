package net.syzygy.rpgmobs.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ORCHID_BULB = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 3), 0.50f).build();

    public static final FoodComponent COOKED_ORCHID_BULB = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2), 1.0f).build();
}
