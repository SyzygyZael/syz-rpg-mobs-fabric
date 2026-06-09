package net.syzygy.rpgmobs.entity.CobbleProjectileComponents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.rule.GameRules;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ModEntities;

public class CobbleProjectileEntity extends ExplosiveProjectileEntity {
    private static final TrackedData<Boolean> HIT =
            DataTracker.registerData(CobbleProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int counter = 0;

    public CobbleProjectileEntity(EntityType<CobbleProjectileEntity> type, World world) {
        super(type, world);
    }

    public CobbleProjectileEntity(World world, LivingEntity entity) {
        super(ModEntities.COBBLE_PROJECTILE, world);
        setOwner(entity);
        BlockPos blockpos = entity.getBlockPos();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getY() + 1.75D;
        double d2 = (double)blockpos.getZ() + 0.5D;
        this.refreshPositionAndAngles(d0, d1, d2, this.getYaw(), this.getPitch());
    }

    public CobbleProjectileEntity(World world, LivingEntity owner, Vec3d velocity) {
        super(ModEntities.COBBLE_PROJECTILE, owner, velocity, world);
    }

    public static final EntityModelLayer COBBLE_PROJECTILE =
            new EntityModelLayer(Identifier.of(RPGMobs.MOD_ID, "cobble_projectile"), "main");


    @Override
    public void tick() {
        super.tick();
        if(this.isInsideWall()) {
            this.discard();
        }

        if(this.dataTracker.get(HIT)) {
            if(this.age >= counter) {
                this.discard();
            }
        }

        if (this.age >= 300) {
            this.remove(RemovalReason.DISCARDED);
        }

        Vec3d vec3 = this.getVelocity();
        HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitresult.getType() != HitResult.Type.MISS)
            this.onCollision(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        if (this.getEntityWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir)) {
            this.discard();
        } else if (this.isSubmergedInWater()) {
            this.discard();
        } else {
            this.setVelocity(vec3.multiply(0.99F));
            this.setPos(d0, d1, d2);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        ServerWorld serverWorld = (ServerWorld) this.getEntityWorld();

        if(hitEntity == owner && this.getEntityWorld().isClient()) {
            return;
        }

        this.getEntityWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL,
                2F, 1F);

        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 5f;
        hitEntity.damage(serverWorld, this.getDamageSources().mobProjectile(this, livingentity), damage);

        boolean bl = serverWorld.getGameRules().getValue(GameRules.DO_MOB_GRIEFING);
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 0, bl, World.ExplosionSourceType.MOB);
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState blockState = this.getEntityWorld().getBlockState(blockHitResult.getBlockPos());
        blockState.onProjectileHit(this.getEntityWorld(), blockState, blockHitResult, this);
        ServerWorld serverWorld = (ServerWorld) this.getEntityWorld();

        boolean bl = serverWorld.getGameRules().getValue(GameRules.DO_MOB_GRIEFING);
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 0, bl, World.ExplosionSourceType.MOB);
        this.discard();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if(this.getEntityWorld().isClient()) {
            return;
        }

        if(hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = this.getOwner();

            if(owner != hit) {
                this.dataTracker.set(HIT, true);
                counter = this.age + 5;
            }
        } else if(hitResult.getType() == HitResult.Type.BLOCK) {
            this.dataTracker.set(HIT, true);
            counter = this.age + 5;
        }
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(HIT, false);
    }
}
