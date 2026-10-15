package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.syzygy.rpgmobs.entity.MaleficSorceressComponents.MaleficSorceressEntity;

public class MaleficSorceressAttackGoal extends MeleeAttackGoal {
    private final MaleficSorceressEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;
    public int blockCooldown = 0;
    public int blockDuration = 0;

    public MaleficSorceressAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((MaleficSorceressEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 10;
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

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double squaredDistance) {
        return squaredDistance < 16f;
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

        int blockDecision = (int) (Math.random() * 50) + 1;

        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }

        if (blockDecision == 37 && !entity.isBlocking() && this.blockCooldown <= 0) {
            entity.setVelocity(0, 0, 0);
            entity.setNoGravity(true);
            entity.setAttacking(false);
            entity.setBlocking(true);
            this.blockDuration = 60;
            this.blockCooldown = 160;
        } else if (this.blockDuration <= 0 && entity.hasNoGravity()) {
            entity.setBlocking(false);
            entity.setNoGravity(false);
        }

        if (this.blockCooldown > 0) {
            this.blockCooldown--;
        }
        if (this.blockDuration > 0) {
            this.blockDuration--;
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
