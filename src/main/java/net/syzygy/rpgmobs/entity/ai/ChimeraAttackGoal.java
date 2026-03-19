package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraEntity;

public class ChimeraAttackGoal extends MeleeAttackGoal {
    protected final ChimeraEntity entity;
    private LivingEntity pEnemy;
    private double attackDelay = 12.6;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    private int slamCooldown = 0;
    private int grabDelay = 0;
    private int slamDelay = 0;
    private int slamCountdown = 0;
    private boolean slamDamageDone;

    public ChimeraAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((ChimeraEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 12.6;
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
                this.entity.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
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
        this.entity.swingHand(Hand.MAIN_HAND);
        this.entity.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();

        pEnemy = this.entity.getTarget();

        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }

        if (entity.isSlamming()) {
            this.shouldCountTillNextAttack = false;
        }

        if (!entity.isSlamming() && (int)((Math.random() * 15) + 1) == 3 && this.slamCooldown <= 0 && entity.squaredDistanceTo(pEnemy) < 30f) {
            entity.setVelocity(0, 0, 0);
            entity.setNoGravity(true);
            entity.setSlamming(true);

            this.slamCooldown = 150;
            this.grabDelay = 6;
            this.slamDelay = 25;
            this.slamCountdown = 35;
            this.slamDamageDone = false;

        } else if ((this.slamCountdown <= 0 && entity.isSlamming()) || (pEnemy == null) || (!entity.isSlamming() && entity.hasNoGravity())) {
            entity.setSlamming(false);
            entity.setNoGravity(false);
            if (pEnemy != null) {
                pEnemy.stopRiding();
            }

        } else if (entity.isSlamming() && this.slamDelay <= 0 && entity.hasPassenger(pEnemy) && !this.slamDamageDone) {
            pEnemy.damage(entity.getWorld().getDamageSources().mobAttack(entity), 5.0f);
            this.slamDamageDone = true;

        } else if (entity.isSlamming() && this.grabDelay <= 0 && entity.squaredDistanceTo(pEnemy) < 30f) {
            pEnemy.startRiding(this.entity, true);

        } if (this.slamCooldown > 0) {
            --this.slamCooldown;
        } if (this.slamCountdown > 0) {
            --this.slamCountdown;
        } if (this.grabDelay > 0) {
            --this.grabDelay;
        } if (this.slamDelay > 0) {
            --this.slamDelay;
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}