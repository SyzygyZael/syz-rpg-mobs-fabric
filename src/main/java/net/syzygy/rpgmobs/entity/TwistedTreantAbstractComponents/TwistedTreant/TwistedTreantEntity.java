package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantAbstractEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding.TwistedTreantStandingEntity;
import net.syzygy.rpgmobs.sound.ModSounds;

public class TwistedTreantEntity extends TwistedTreantAbstractEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TwistedTreantEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(TwistedTreantEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState standingAnimationState = new AnimationState();

    private int invincibilityTicks = 0;
    private int treantCounter = 0;
    private int timesInvincible = 0;
    private int standingAnimationCounter = 0;
    private final TwistedTreantStandingEntity standingTreant =
            new TwistedTreantStandingEntity(ModEntities.TWISTED_TREANT_STANDING, getWorld());

    public TwistedTreantEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer TWISTED_TREANT =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "twisted_treant"), "main");

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, (double) 32.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double) 0.30F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double) ModConfig.twistedTreantAttackDamage)
                .add(EntityAttributes.GENERIC_ARMOR, (double) 3.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, (double) 36.0F);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            int attackTypeChooser = (int) (Math.random() * 2) + 1;
            if (attackTypeChooser == 1) {
                attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                attack1AnimationState.start(this.age);
            }
            if (attackTypeChooser == 2) {
                if (this.isAttacking()) {
                    attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                    attack2AnimationState.start(this.age);
                }
            }
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attack1AnimationState.stop();
            attack2AnimationState.stop();
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

        // this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (invincibilityTicks > 0) {
            invincibilityTicks--;
        }

        if (spawnedFromStaff && this.age >= 600 && !this.getWorld().isClient()) {
            this.remove(RemovalReason.DISCARDED);
            decrementTreantCounter();
        }

        if (this.getHealth() <= 18f && this.treantCounter == 0) {
            if (this.timesInvincible == 0 && !this.getWorld().isClient()) {
                this.startInvincibility(70);
                this.setAiDisabled(true);

                this.timesInvincible = 1;
            }

            if (this.standingAnimationCounter == 0 && this.getWorld().isClient()) {
                this.standingAnimationState.start(this.age);

                this.standingAnimationCounter = 1;
            }

            if (this.getInvincibilityTicks() == 15) {
                this.playSound(SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1.0F, 1.0F);
            }
            if (this.getInvincibilityTicks() == 5) {
                this.playSound(ModSounds.TWISTED_TREANT_ROAR, 1.0F, 1.0F);
            }

            if (this.getInvincibilityTicks() == 0 && this.treantCounter == 0 && this.timesInvincible == 1 && !this.getWorld().isClient()) {
                standingTreant.refreshPositionAndAngles(
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        this.getYaw(),
                        this.getPitch()
                );
                if (spawnedFromStaff) {
                    standingTreant.age = this.age;
                }

                this.getWorld().spawnEntity(standingTreant);
                standingTreant.setHealth(18f);
                this.standingAnimationState.stop();
                this.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (invincibilityTicks > 0) {
            return false;
        }

        return super.damage(source, amount);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    public void startInvincibility(int durationTicks) {
        this.invincibilityTicks = durationTicks;
    }

    public int getInvincibilityTicks() {
        return this.invincibilityTicks;
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    public void setStandingPet(PlayerEntity staffOwner) {
        setSpawnedFromStaff(true);
        standingTreant.setOwner(staffOwner);
        standingTreant.setTamed(true);
    }

    public static boolean canSpawn(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) &&
                world.getFluidState(pos).isEmpty() &&
                world.getLightLevel(pos) >= 0;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.TWISTED_TREANT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }
}
