package net.syzygy.rpgmobs.entity.MaleficSorceressComponents;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.WarpedBladeComponents.WarpedBladeEntity;
import net.syzygy.rpgmobs.entity.ai.MaleficSorceressAttackGoal;
import org.jetbrains.annotations.Nullable;

public class MaleficSorceressEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(MaleficSorceressEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> SHOOTING =
            DataTracker.registerData(MaleficSorceressEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> BLOCKING =
            DataTracker.registerData(MaleficSorceressEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(MaleficSorceressEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public final AnimationState attack3AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState blockAnimationState = new AnimationState();
    public int blockAnimationTimeout = 0;

    // protected boolean isBlocking = false;

    public MaleficSorceressEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer MALEFIC_SORCERESS =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "malefic_sorceress"), "main");

    @Override
    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MaleficSorceressAttackGoal(this, 1f, true));
        this.goalSelector.add(2, new ShootWarpedBladeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, LivingEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0F));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, ModConfig.maleficSorceressAttackDamage)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0F);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (!this.isBlocking()) {
            if(this.isAttacking() && attackAnimationTimeout <= 0) {
                int attackTypeChooser = (int) (Math.random() * 3) + 1;
                if (attackTypeChooser == 1) {
                    attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                    attack1AnimationState.start(this.age);
                } else if (attackTypeChooser == 2) {
                    attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                    attack2AnimationState.start(this.age);
                } else {
                    attackAnimationTimeout = 20; // THIS IS LENGTH OF ANIMATION IN TICKS
                    attack3AnimationState.start(this.age);
                }
            } else {
                --this.attackAnimationTimeout;
            }

            if (!this.isAttacking()) {
                attack1AnimationState.stop();
                attack2AnimationState.stop();
                attack3AnimationState.stop();
                blockAnimationState.stop();
            }
        }

        if (this.isBlocking()) {
            attack1AnimationState.stop();
            attack2AnimationState.stop();
            attack3AnimationState.stop();
            blockAnimationState.start(this.age);
        }
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
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isBlocking() && !source.isOf(DamageTypes.FALL) && !source.isOf(DamageTypes.OUT_OF_WORLD)) {
            return false;
        }

        return super.damage(source, amount);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(SHOOTING, false);
        this.dataTracker.startTracking(BLOCKING, false);
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

    public void setBlocking(boolean blocking) {
        this.dataTracker.set(BLOCKING, blocking);
    }

    public boolean isBlocking() {
        return this.dataTracker.get(BLOCKING);
    }

    public static boolean canSpawn(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) &&
                world.getFluidState(pos).isEmpty() &&
                world.getLightLevel(pos) >= 0;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static class ShootWarpedBladeGoal extends Goal {

        private final MaleficSorceressEntity entity;
        public int cooldown;

        public ShootWarpedBladeGoal(MaleficSorceressEntity entity) {
            this.entity = entity;
        }

        @Override
        public boolean canStart() {
            return this.entity.getTarget() != null && this.entity.squaredDistanceTo(this.entity.getTarget()) > 36f;
        }

        @Override
        public void start() {
            this.cooldown = 0;
            // this.entity.setAttacking(true);
        }

        @Override
        public void stop() {
            this.entity.setShooting(false);
            // this.entity.setAttacking(false);
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
                        WarpedBladeEntity warpedBladeEntity = new WarpedBladeEntity(world, entity);
                        warpedBladeEntity.setVelocity(entity, entity.getPitch(), entity.getHeadYaw(), 0.0F, 1.0F, 0.15F);
                        world.spawnEntity(warpedBladeEntity);
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
