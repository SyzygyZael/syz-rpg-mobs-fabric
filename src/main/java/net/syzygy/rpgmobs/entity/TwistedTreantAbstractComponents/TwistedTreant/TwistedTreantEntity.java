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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantAbstractEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding.TwistedTreantStandingEntity;
import net.syzygy.rpgmobs.sound.ModSounds;

public class TwistedTreantEntity extends TwistedTreantAbstractEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TwistedTreantEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState standingAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();

    private int invincibilityTicks = 0;
    private int treantCounter = 0;
    private int timesInvincible = 0;
    private int standingAnimationCounter = 0;
    private TwistedTreantStandingEntity standingTreant = null;

    public TwistedTreantEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    private TwistedTreantStandingEntity getStandingTreant() {
        if (standingTreant == null) {
            standingTreant = new TwistedTreantStandingEntity(ModEntities.TWISTED_TREANT_STANDING, this.getEntityWorld());
        }
        return standingTreant;
    }

    public static final EntityModelLayer TWISTED_TREANT =
            new EntityModelLayer(Identifier.of(RPGMobs.MOD_ID, "twisted_treant"), "main");

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.FOLLOW_RANGE, (double) 32.0F)
                .add(EntityAttributes.MOVEMENT_SPEED, (double) 0.30F)
                .add(EntityAttributes.ATTACK_DAMAGE, (double) ModConfig.twistedTreantAttackDamage)
                .add(EntityAttributes.ARMOR, (double) 3.0F)
                .add(EntityAttributes.MAX_HEALTH, (double) 36.0F);
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

        this.limbAnimator.updateLimbs(f, 0.2F, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (invincibilityTicks > 0) {
            invincibilityTicks--;
        }

        if (spawnedFromStaff && this.age >= 600 && !this.getEntityWorld().isClient()) {
            this.remove(RemovalReason.DISCARDED);
            decrementTreantCounter();
        }

        if (this.getHealth() <= 18f && this.treantCounter == 0) {
            if (this.timesInvincible == 0 && !this.getEntityWorld().isClient()) {
                this.startInvincibility(70);
                this.setAiDisabled(true);

                this.timesInvincible = 1;
            }

            if (this.standingAnimationCounter == 0 && this.getEntityWorld().isClient()) {
                this.standingAnimationState.start(this.age);

                this.standingAnimationCounter = 1;
            }

            if (this.getInvincibilityTicks() == 15) {
                this.playSound(SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 1.0F, 1.0F);
            }
            if (this.getInvincibilityTicks() == 5) {
                this.playSound(ModSounds.TWISTED_TREANT_ROAR, 1.0F, 1.0F);
            }

            if (this.getInvincibilityTicks() == 0 && this.treantCounter == 0 && this.timesInvincible == 1 && !this.getEntityWorld().isClient()) {
                getStandingTreant().refreshPositionAndAngles(
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        this.getYaw(),
                        this.getPitch()
                );
                if (spawnedFromStaff) {
                    getStandingTreant().age = this.age;
                }

                this.getEntityWorld().spawnEntity(getStandingTreant());
                getStandingTreant().setHealth(18f);
                this.standingAnimationState.stop();
                this.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (invincibilityTicks > 0) {
            return false;
        }

        return super.damage(world, source, amount);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
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
        getStandingTreant().setOwner(staffOwner);
        getStandingTreant().setTamed(true, true);
    }

    @Override
    public boolean canSpawn(WorldView world) {
        if (world instanceof ServerWorld serverWorld) {
            if (serverWorld.getDifficulty() ==  Difficulty.PEACEFUL) {
                return false;
            }
        }

        return super.canSpawn(world);
    }

    public static boolean canSpawn(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) &&
                world.getFluidState(pos).isEmpty() &&
                world.getLightLevel(pos) >= 0;
    }
}
