package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

public class CooldownCounterDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "["
				+ (new java.text.DecimalFormat("#").format((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.COOLDOWN.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.COOLDOWN.get()).getDuration() : 0) / 20))
				+ "]";
	}
}
