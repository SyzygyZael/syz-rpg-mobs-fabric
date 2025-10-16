package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraEntity;

public class ChimeraAttackGoal extends MeleeAttackGoal {
    private final ChimeraEntity entity;
    private LivingEntity pEnemy;
    private double attackDelay = 12.6;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public ChimeraAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((ChimeraEntity) mob);
        pEnemy = this.entity.getTarget();
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 12.6;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double squaredDistance ) {

        if (isEnemyWithinAttackDistance(pEnemy, squaredDistance)) {
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

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double squaredDistance) {
        return squaredDistance < 36f;
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

    public LivingEntity getpEnemy() {
        return this.pEnemy;
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
