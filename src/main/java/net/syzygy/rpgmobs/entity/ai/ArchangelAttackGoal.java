package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;

public class ArchangelAttackGoal extends MeleeAttackGoal {
    private final ArchangelEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;
    public int cooldown = 0;
    public int wait = 0;
    public int damageDelay = 5;

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
    protected void attack(LivingEntity pEnemy, double squaredDistance ) {
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
        return this.mob.squaredDistanceTo(pEnemy) < 7f;
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

        if (this.wait <= 13 && entity.hasNoGravity() && pEnemy != null) {
            entity.teleport(pEnemy.getX(), pEnemy.getY() + 2, pEnemy.getZ());
            entity.setAttacking(true);

            if (this.damageDelay <= 0) {
                pEnemy.damage(magicDamage, 4.0F);
                // RPGMobs.LOGGER.info(String.valueOf(this.damageDelay));
                this.damageDelay = 5;
            }
            --this.damageDelay;
        }

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

            entity.setNoGravity(false);
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
