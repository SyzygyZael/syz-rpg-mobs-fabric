package net.syzygy.rpgmobs.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantAbstractEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobSpawnTrackerMixin {
    @Inject(method = "initialize", at = @At("RETURN"))
    private void onInitialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                              EntityData entityData, NbtCompound entityTag, CallbackInfoReturnable<EntityData> cir) {

        if (((Object)this) instanceof TwistedTreantEntity) {
            TwistedTreantEntity treant = (TwistedTreantEntity)(Object)this;

            if (spawnReason == SpawnReason.NATURAL) {
                RPGMobs.LOGGER.info("Spawned Naturally");
            }
        }
    }
}
