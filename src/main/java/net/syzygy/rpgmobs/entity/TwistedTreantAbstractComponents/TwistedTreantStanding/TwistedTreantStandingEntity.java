package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantAbstractEntity;

public class TwistedTreantStandingEntity extends TwistedTreantAbstractEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TwistedTreantEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(TwistedTreantEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState standingIdleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState standingAttack1AnimationState = new AnimationState();
    public final AnimationState standingAttack2AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TwistedTreantStandingEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer TWISTED_TREANT_STANDING =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "twisted_treant_standing"), "main");

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, (double) 32.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double) 0.35F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double) ModConfig.standingTwistedTreantAttackDamage)
                .add(EntityAttributes.GENERIC_ARMOR, (double) 3.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, (double) 36.0F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, (double) 2.0F);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.standingIdleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            int attackTypeChooser = (int) (Math.random() * 2) + 1;
            if (attackTypeChooser == 1) {
                attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                standingAttack1AnimationState.start(this.age);
            }
            if (attackTypeChooser == 2) {
                if (this.isAttacking()) {
                    attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                    standingAttack2AnimationState.start(this.age);
                }
            }
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            standingAttack1AnimationState.stop();
            standingAttack2AnimationState.stop();
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    protected void updateLimbs(float v) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (this.age >= 600 && !this.getWorld().isClient()) {
            this.remove(RemovalReason.DISCARDED);
            decrementTreantCounter();
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }
}
