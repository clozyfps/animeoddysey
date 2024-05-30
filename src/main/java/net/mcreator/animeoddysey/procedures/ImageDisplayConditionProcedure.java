package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

public class ImageDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AnimeoddyseyModMobEffects.COOLDOWN.get())) {
			return true;
		}
		return false;
	}
}
