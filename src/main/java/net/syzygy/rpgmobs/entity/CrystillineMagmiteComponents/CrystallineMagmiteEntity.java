package net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.ai.CrystallineMagmiteAttackGoal;
import net.syzygy.rpgmobs.entity.ai.CrystallineMagmiteRevengeGoal;
import org.jetbrains.annotations.Nullable;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteModel;

public class CrystallineMagmiteEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(CrystallineMagmiteEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> SHOOTING =
            DataTracker.registerData(CrystallineMagmiteEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(CrystallineMagmiteEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack1AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState attack2AnimationState = new AnimationState();

    private LivingEntity attacker;

    public CrystallineMagmiteEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer CRYSTALLINE_MAGMITE =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "crystalline_magmite"), "main");

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new CrystallineMagmiteAttackGoal(this, 1f, true));
        this.goalSelector.add(2, new ShootCobbleProjectileGoal(this));
        this.targetSelector.add(1, new CrystallineMagmiteRevengeGoal(this, this.attacker));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, LivingEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, (double) 1.0F));
    }

    public void setShooting(boolean shooting) {
        this.dataTracker.set(ATTACKING, shooting);
    }

    public int getProjectileStrength() {
        return 1;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, (double)35.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)0.23F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, (double)6.5F)
                .add(EntityAttributes.GENERIC_ARMOR, (double)4.0F)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, (double)3.0F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, (double)3.0F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, (double)70.0F);
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
                attackAnimationTimeout = 30; // THIS IS LENGTH OF ANIMATION IN TICKS
                attack1AnimationState.start(this.age);
            }
            if (attackTypeChooser == 2) {
                if (this.isAttacking()) {
                    attackAnimationTimeout = 30; // THIS IS LENGTH OF ANIMATION IN TICKS
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
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
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

    public boolean isShooting() {
        return this.dataTracker.get(SHOOTING);
    }

    public static class ShootCobbleProjectileGoal extends Goal {

        private final CrystallineMagmiteEntity entity;
        public int cooldown;

        public ShootCobbleProjectileGoal(CrystallineMagmiteEntity entity) {
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
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.entity) < 4096.0 && this.entity.canSee(livingEntity)) {
                    World world = this.entity.getWorld();
                    this.cooldown++;

                    if (this.cooldown == 30) {
                        double e = 4.0;
                        Vec3d vec3d = this.entity.getRotationVec(1.0F);
                        double f = livingEntity.getX() - (this.entity.getX() + vec3d.x * 4.0);
                        double g = livingEntity.getBodyY(0.5) - (0.5 + this.entity.getBodyY(0.5));
                        double h = livingEntity.getZ() - (this.entity.getZ() + vec3d.z * 4.0);

                        CobbleProjectileEntity cobbleEntity = new CobbleProjectileEntity(world, entity);
                        cobbleEntity.setVelocity(entity, entity.getPitch(), entity.getHeadYaw(), 0.0F, 1.0F, 0.15F);
                        world.spawnEntity(cobbleEntity);
                        this.cooldown = -40;
                    }
                } else if (this.cooldown > 0) {
                    this.cooldown--;
                }

                this.entity.setShooting(this.cooldown > 10);
            }
        }
    }

    public void setMagmiteTarget(LivingEntity targetMob) {
        this.attacker = targetMob;
    }

    public static boolean canSpawn(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down()) &&
                world.getFluidState(pos).isEmpty() &&
                world.getLightLevel(pos) >= 0;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WARDEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_RAVAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_RAVAGER_DEATH;
    }
}
