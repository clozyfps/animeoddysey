package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

public class PreTimeSkipSasukeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(AnimeoddyseyModMobEffects.COOLDOWN.get()))) {
				if (Mth.nextInt(RandomSource.create(), 1, 80) == 2) {
					FireballJutsuProcedure.execute(world, x, y, z, entity);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 30, 0, false, false));
					if (entity.getPersistentData().getDouble("energy") >= 20) {
						entity.getPersistentData().putDouble("energy", (entity.getPersistentData().getDouble("energy") - 20));
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 80) == 3) {
					LionsBarrageProcedure.execute(world, x, y, z, entity);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 35, 0, false, false));
					if (entity.getPersistentData().getDouble("energy") >= 30) {
						entity.getPersistentData().putDouble("energy", (entity.getPersistentData().getDouble("energy") - 20));
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 80) == 10) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.CHIDORI_ACTIVE.get(), 100, 0, false, false));
				} else if (Mth.nextInt(RandomSource.create(), 1, 80) >= 70) {
					StrongDashPunchProcedure.execute(world, entity);
				}
			}
		}
		if (entity.getPersistentData().getDouble("energy") < 750) {
			entity.getPersistentData().putDouble("energy", (entity.getPersistentData().getDouble("energy") + 0.1));
		}
	}
}
