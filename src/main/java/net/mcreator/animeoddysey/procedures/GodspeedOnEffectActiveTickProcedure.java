package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.entity.KilluaZoldyckEntity;

public class GodspeedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Energy - 0.3;
			entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Energy = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.CHIDORI_PARTICLE.get()), x, y, z, 3, 0.1, 1.5, 0.1, 0);
		if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Application).equals("Speed")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5,
						(int) (13 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).SpeedStat / 5), false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 2, false, false));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.DISABLE_CHARGING.get(), 5, 0, false, false));
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Energy <= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(AnimeoddyseyModMobEffects.GODSPEED.get());
		}
		if (entity instanceof KilluaZoldyckEntity) {
			entity.getPersistentData().putDouble("energy", (entity.getPersistentData().getDouble("energy") - 0.1));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 10, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 2, false, false));
			if (entity.getPersistentData().getDouble("energy") <= 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(AnimeoddyseyModMobEffects.GODSPEED.get());
			}
		}
	}
}
