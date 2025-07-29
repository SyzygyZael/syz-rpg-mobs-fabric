package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;

public class CrystallineMagmiteRevengeGoal extends RevengeGoal {
    private LivingEntity targetMob;

    public CrystallineMagmiteRevengeGoal(PathAwareEntity mob, LivingEntity target, Class<?>... noRevengeTypes) {
        super(mob, noRevengeTypes);
        this.targetMob = target;
    }

    @Override
    protected void setMobEntityTarget(MobEntity mob, LivingEntity target) {
        super.setMobEntityTarget(mob, this.targetMob);
    }
}
