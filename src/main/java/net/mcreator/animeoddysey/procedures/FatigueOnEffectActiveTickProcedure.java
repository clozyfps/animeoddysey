package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

public class FatigueOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.FATIGUE.get()).getAmplifier() : 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 5,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.FATIGUE.get()).getAmplifier() : 0, false, false));
	}
}
