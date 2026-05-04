package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeaterFlower;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater.OrchidManeaterEntity;
import org.jetbrains.annotations.Nullable;

public class OrchidManeaterFlowerEntity extends AnimalEntity {

    private final OrchidManeaterEntity orchidManeater =
            new OrchidManeaterEntity(ModEntities.ORCHID_MANEATER, getWorld());

    public OrchidManeaterFlowerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static final EntityModelLayer ORCHID_MANEATER_FLOWER =
            new EntityModelLayer(new Identifier(RPGMobs.MOD_ID, "orchid_maneater_flower"), "main");

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, (double)30.0F);
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    @Override
    public boolean canMoveVoluntarily() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient()) {
            PlayerEntity nearbyPlayer = this.getWorld().getClosestPlayer(
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    3.0,
                    false
            );

            if (nearbyPlayer != null || this.getHealth() < 30.0F) {
                orchidManeater.refreshPositionAndAngles(
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        this.getYaw(),
                        this.getPitch()
                );

                this.getWorld().spawnEntity(orchidManeater);
                this.remove(Entity.RemovalReason.DISCARDED);
            }
        }
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
}