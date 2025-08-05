package net.syzygy.rpgmobs.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;
import net.syzygy.rpgmobs.item.custom.StaffOfTheForestMonarchItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class OnPlayerWasHitMixin {

    @Inject(method = "damage", at = @At("HEAD"))
	private void onPlayerDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		LivingEntity entity = (LivingEntity) (Object) this;

		if (entity instanceof PlayerEntity player && source.getAttacker() != null && !player.getWorld().isClient) {
			if (source.getAttacker() instanceof LivingEntity && !(source.getAttacker() instanceof TwistedTreantEntity)) {
				TwistedTreantEntity treant = new TwistedTreantEntity(ModEntities.TWISTED_TREANT, player.getWorld());

				ItemStack mainHandItem = player.getMainHandStack();
				ItemStack offHandItem = player.getOffHandStack();

				if (treant.getTreantCounter() < ModConfig.staffOfTheForestMonarchSpawnLimit && (mainHandItem.getItem() instanceof StaffOfTheForestMonarchItem || offHandItem.getItem() instanceof StaffOfTheForestMonarchItem)) {
					double spawnX = player.getX() + 2;
					double spawnY = player.getY();
					double spawnZ = player.getZ();
					float spawnYaw = player.getYaw();
					float spawnPitch = player.getPitch();

					treant.refreshPositionAndAngles(spawnX, spawnY, spawnZ, spawnYaw, spawnPitch);

					treant.setOwner(player);
					treant.setTamed(true);
					player.getWorld().spawnEntity(treant);
					treant.setStandingPet(player);

					treant.incrementTreantCounter();
				}
			}
		}
	}
}