package net.syzygy.rpgmobs.entity.ChimeraComponents;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;
import net.syzygy.rpgmobs.entity.ai.ChimeraAttackGoal;
import org.jetbrains.annotations.Nullable;

public class ChimeraEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(ChimeraEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> SHOOTING =
            DataTracker.registerData(ChimeraEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(ArchangelEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState flyingAnimationState = new AnimationState();
    public final AnimationState slamAnimationState = new AnimationState();
    public final AnimationState fireBreathAnimationState = new AnimationState();
    public int fireBreathAnimationTimeout = 0;
    public int grabTick;
    public float grabYOffset;

    protected boolean slamming = false;

    public ChimeraEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer CHIMERA =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "chimera"), "main");

    @Override
    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ChimeraAttackGoal(this, 1f, true));
        this.goalSelector.add(2, new ShootFireballGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, LivingEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0F));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, (double)32.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)0.30F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double) ModConfig.chimeraAttackDamage)
                .add(EntityAttributes.GENERIC_ARMOR, (double)3.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, (double)65.0F);
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

            if (this.hasNoGravity()) {
                attackAnimationTimeout = 35; // THIS IS LENGTH OF ANIMATION IN TICKS
                slamAnimationState.start(this.age);
            }
            else if (attackTypeChooser == 1) {
                attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                attack1AnimationState.start(this.age);
            }
            else if (attackTypeChooser == 2) {
                attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                attack2AnimationState.start(this.age);
            }
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attack1AnimationState.stop();
            attack2AnimationState.stop();
            slamAnimationState.stop();
        }

        if (this.isShooting() && fireBreathAnimationTimeout <= 0) {
            fireBreathAnimationTimeout = 14;
            fireBreathAnimationState.start(this.age);
        } else {
            --this.fireBreathAnimationTimeout;
        }

        if (!this.isShooting()) {
            fireBreathAnimationState.stop();
        }
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
    }

    public void setSlamming(boolean slam) {
        this.slamming = slam;
    }

    public boolean isSlamming() {
        return this.slamming;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        if (this.hasPassenger(passenger)) {
            float bodyYaw = this.getBodyYaw();
            double x = -Math.sin(Math.toRadians(bodyYaw)) + this.getX();
            double y = passenger.getHeightOffset() + this.grabYOffset + this.getY() + 1;
            double z = Math.cos(Math.toRadians(bodyYaw)) + this.getZ();

            passenger.setPos(x, y, z);

            this.grabTick++;
            this.grabYOffset = calculateYOffset(grabTick);

        } else {
            this.grabTick = 0;
            this.grabYOffset = 0;
        }
    }

    private float calculateYOffset(int tick) {
        float progress = (float) tick / 20f;
        return (float) Math.sin(progress * Math.PI) * 2f; // peaks at 2 blocks
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(SHOOTING, false);
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    public void setShooting(boolean shooting) {
        this.dataTracker.set(SHOOTING, shooting);
    }

    public boolean isShooting() {
        return this.dataTracker.get(SHOOTING);
    }

    public static boolean canSpawn(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) &&
                world.getFluidState(pos).isEmpty() &&
                world.getLightLevel(pos) >= 0;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDER_DRAGON_GROWL;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }

    public static class ShootFireballGoal extends Goal {

        private final ChimeraEntity entity;
        public int cooldown;

        public ShootFireballGoal(ChimeraEntity entity) {
            this.entity = entity;
        }

        @Override
        public boolean canStart() {
            return this.entity.getTarget() != null && this.entity.squaredDistanceTo(this.entity.getTarget()) > 36f;
        }

        @Override
        public void start() {
            this.cooldown = 0;
        }

        @Override
        public void stop() {
            this.entity.setShooting(false);
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.entity.getTarget();
            if (livingEntity != null) {
                if (livingEntity.squaredDistanceTo(this.entity) < 4096.0 && this.entity.canSee(livingEntity)) {
                    World world = this.entity.getWorld();
                    this.cooldown++;

                    if (this.cooldown == 30) {
                        double f = -Math.sin(Math.toRadians(this.entity.getHeadYaw())) * Math.cos(Math.toRadians(this.entity.getPitch()));
                        double g = -Math.sin(Math.toRadians(this.entity.getPitch()));
                        double h = Math.cos(Math.toRadians(this.entity.getHeadYaw())) * Math.cos(Math.toRadians(this.entity.getPitch()));

                        FireballEntity fireBallEntity = new FireballEntity(world, this.entity, f, g, h, 1);
                        fireBallEntity.setPosition(this.entity.getX(), this.entity.getEyeY(), this.entity.getZ());
                        world.spawnEntity(fireBallEntity);
                        this.cooldown = -40;
                    }
                } else if (this.cooldown > 0) {
                    this.cooldown--;
                }

                this.entity.setShooting(this.cooldown > 10);
            }
        }
    }
}