package net.syzygy.rpgmobs.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class onMobDamagedMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void onMobDamaged(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Entity attacker = source.getAttacker();
        Entity target = (Entity)(Object) this;

        // Only proceed if both attacker and target are mobs (LivingEntity)
        if (attacker instanceof MobEntity && target instanceof CrystallineMagmiteEntity) {
            MobEntity attackingMob = (MobEntity) attacker;
            CrystallineMagmiteEntity damagedMob = (CrystallineMagmiteEntity) target;

            damagedMob.setMagmiteTarget(attackingMob);
        }
    }
}
