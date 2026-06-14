package net.syzygy.rpgmobs.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.item.ModItems;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class DemonicBladeApplyWitherHandler implements AttackEntityCallback {
    @Override
    public @NonNull ActionResult interact(@NonNull PlayerEntity playerEntity, @NonNull World world, @NonNull Hand hand, @NonNull Entity entity,
                                          @Nullable EntityHitResult entityHitResult) {

        if (entity instanceof LivingEntity target && !world.isClient() && !playerEntity.isSpectator()) {
            if (playerEntity.getStackInHand(hand).getItem() == ModItems.DEMONIC_BLADE) {
                int duration = 100;
                int amplifier = 0;

                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, duration, amplifier));
            }
        }

        return ActionResult.PASS;
    }
}