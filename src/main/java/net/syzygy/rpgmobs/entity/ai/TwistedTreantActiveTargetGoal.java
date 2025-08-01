package net.syzygy.rpgmobs.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantAbstractEntity;
import net.syzygy.rpgmobs.item.custom.StaffOfTheForestMonarchItem;

public class TwistedTreantActiveTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {

    public TwistedTreantActiveTargetGoal(TwistedTreantAbstractEntity treant, Class<T> targetClass, boolean checkVisibility) {
        super(treant, targetClass, checkVisibility);
    }

    public boolean hasStaff() {
        if (this.targetEntity instanceof PlayerEntity player && !player.getWorld().isClient()) {
            ItemStack mainhandItem = player.getMainHandStack();
            ItemStack offhandItem = player.getOffHandStack();

            if (mainhandItem.getItem() instanceof StaffOfTheForestMonarchItem || offhandItem.getItem() instanceof StaffOfTheForestMonarchItem) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean canStart() {
        if (hasStaff()) {
            return false;
        } else {
            return super.canStart();
        }
    }

    @Override
    public boolean shouldContinue() {
        if (hasStaff()) {
            return false;
        } else {
            return super.shouldContinue();
        }
    }
}
