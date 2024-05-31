package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ColapseAbilityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AnimeoddyseyModMobEffects.COOLDOWN.get()))) {
			entity.getPersistentData().putDouble("ColapseX",
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()));
			entity.getPersistentData().putDouble("ColapseY",
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0.5));
			entity.getPersistentData().putDouble("ColapseZ",
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.BLUE_ANIM.get()), (entity.getPersistentData().getDouble("ColapseX")), (entity.getPersistentData().getDouble("ColapseY")),
						(entity.getPersistentData().getDouble("ColapseZ")), 1, 0, 0, 0, 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 2, false, false));
			AnimeoddyseyMod.queueServerWork(3, () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 5, false, false));
				AnimeoddyseyMod.queueServerWork(1, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (entity.getPersistentData().getDouble("ColapseX")), (entity.getPersistentData().getDouble("ColapseY")), (entity.getPersistentData().getDouble("ColapseZ")),
								(float) (1 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3), Level.ExplosionInteraction.TNT);
				});
			});
		}
	}
}
