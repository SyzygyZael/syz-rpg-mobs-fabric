package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.entity.ai.TwistedTreantActiveTargetGoal;
import net.syzygy.rpgmobs.entity.ai.TwistedTreantAttackGoal;
import org.jetbrains.annotations.Nullable;

public class TwistedTreantAbstractEntity extends TameableEntity {
    public int attackAnimationTimeout = 0;

    protected static int staffTreantCounter = 0;
    protected static boolean spawnedFromStaff = false;

    protected TwistedTreantAbstractEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new TwistedTreantAttackGoal(this, 1f, true));
        this.goalSelector.add(2, new AttackWithOwnerGoal(this));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.5f, 5f, 50f, true));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, LivingEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, (double) 1.0F));
        this.targetSelector.add(2, new TwistedTreantActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        if (spawnedFromStaff && !this.getWorld().isClient()) {
            decrementTreantCounter();
        }
    }

    public int getTreantCounter() {
        return staffTreantCounter;
    }

    public void incrementTreantCounter() {
        staffTreantCounter++;
    }

    public void decrementTreantCounter() {
        if (staffTreantCounter > 0) {
            staffTreantCounter--;
        }
    }

    public void setSpawnedFromStaff(boolean isSpawnedFromStaff) {
        spawnedFromStaff = isSpawnedFromStaff;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
