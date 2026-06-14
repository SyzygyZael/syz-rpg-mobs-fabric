package net.syzygy.rpgmobs.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final ConsumableComponent ORCHID_BULB_EFFECTS = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 3), 0.5f))
            .build();

    public static final ConsumableComponent ORCHID_BULB_COOKED_EFFECTS = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2), 1.0f))
            .build();

    public static final FoodComponent ORCHID_BULB = new FoodComponent.Builder()
            .nutrition(0)
            .saturationModifier(0)
            .build();

    public static final FoodComponent COOKED_ORCHID_BULB = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.5f)
            .build();
}