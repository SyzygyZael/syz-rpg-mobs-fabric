package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;

public class ArchangelAttackGoal extends MeleeAttackGoal {
    private final ArchangelEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;
    public int cooldown = 0;
    public int wait = 0;
    public int damageDelay = 5;
    public int teleCount = 0;

    public ArchangelAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((ArchangelEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 10;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.mob.squaredDistanceTo(pEnemy) < 8f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = 20;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity pEnemy = this.entity.getTarget();
        World world = pEnemy.getWorld();
        DamageSources sources = world.getDamageSources();
        DamageSource magicDamage = sources.mobAttack(entity);
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }

        int randNum = (int) (Math.random() * 18) + 1;

        // initial teleport wind up
        if (randNum == 5 && cooldown <= 0 && entity.isAttacking()) {
            if (ArchangelCompassDirection(entity).equals("NORTH")) {
                entity.teleport(entity.getX(), entity.getY() + 7, entity.getZ() + 10);
            }
            else if (ArchangelCompassDirection(entity).equals("EAST")) {
                entity.teleport(entity.getX() - 10, entity.getY() + 7, entity.getZ());
            }
            else if (ArchangelCompassDirection(entity).equals("SOUTH")) {
                entity.teleport(entity.getX(), entity.getY() + 7, entity.getZ() - 10);
            }
            else {
                entity.teleport(entity.getX() + 10, entity.getY() + 7, entity.getZ());
            }
            entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);

            entity.setAttacking(false);
            entity.setVelocity(0, 0, 0);
            entity.velocityDirty = true;
            entity.setNoGravity(true);
            this.wait = 60;
            this.cooldown = 120;
            this.damageDelay = 5;
        } else {
            --this.cooldown;
        }

        // teleport to enemy and deal damage if not blocking
        if (this.wait <= 13 && entity.hasNoGravity() && pEnemy != null) {
            if (teleCount == 0) {
                entity.teleport(pEnemy.getX(), pEnemy.getY() + 2, pEnemy.getZ());
                entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                teleCount = 1;
            }

            entity.setAttacking(true);

            // forge damage upon enemy
            if (this.damageDelay <= 0 && !pEnemy.isBlocking()) {
                pEnemy.damage(magicDamage, 6.5F);
                // RPGMobs.LOGGER.info(String.valueOf(this.damageDelay));
                this.damageDelay = 5;
            } else if (this.damageDelay <= 0) {

                // animate shield block, damage the shield, and call the sound
                PlayerEntity player = ((PlayerEntity) pEnemy);
                ItemStack shield = player.getOffHandStack();
                if (shield.isOf(Items.SHIELD)) {
                    player.setCurrentHand(Hand.OFF_HAND);
                    player.getItemCooldownManager().set(shield.getItem(), 5);

                    // damage the shield
                    shield.damage(1, player, (p) -> {
                        p.sendToolBreakStatus(Hand.OFF_HAND);
                    });

                    player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ITEM_SHIELD_BLOCK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                }

                // set delay to 10 so shield is not damaged every tick
                this.damageDelay = 10;
            }
            --this.damageDelay;
        }

        // teleport away short distance
        if (this.wait <= 0 && entity.hasNoGravity()) {
            entity.airAttackAnimationState.stop();

            if (ArchangelCompassDirection(entity).equals("NORTH")) {
                entity.teleport(entity.getX(), entity.getY(), entity.getZ() + 5);
            }
            else if (ArchangelCompassDirection(entity).equals("EAST")) {
                entity.teleport(entity.getX() - 5, entity.getY(), entity.getZ());
            }
            else if (ArchangelCompassDirection(entity).equals("SOUTH")) {
                entity.teleport(entity.getX(), entity.getY(), entity.getZ() - 5);
            }
            else {
                entity.teleport(entity.getX() + 5, entity.getY(), entity.getZ());
            }

            entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            entity.setNoGravity(false);
            this.teleCount = 0;
        } else {
            --this.wait;
        }
    }

    public static String ArchangelCompassDirection(MobEntity archangel) {
        Direction CompDir = archangel.getHorizontalFacing();
        if (CompDir == Direction.NORTH) {
            return "NORTH";
        }
        else if (CompDir == Direction.EAST) {
            return "EAST";
        }
        else if (CompDir == Direction.SOUTH) {
            return "SOUTH";
        }
        else {
            return "WEST";
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
