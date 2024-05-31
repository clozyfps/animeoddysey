package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.entity.LapseBlueEnityEntity;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.List;
import java.util.Comparator;

public class LapseBlueEnityOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		AnimeoddyseyMod.queueServerWork(12, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.BLUE_ANIM.get()), x, y, z, 1, 0, 0, 0, 0);
			AnimeoddyseyMod.queueServerWork(4, () -> {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!(entityiterator instanceof LapseBlueEnityEntity)) {
								if (entity.getPersistentData().getDouble("LapseBluePlayerID") != entityiterator.getPersistentData().getDouble("LapseBluePlayerID")) {
									if (!(entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(AnimeoddyseyModMobEffects.LAPSE_BLUE_POITON.get()))) {
										entityiterator.setDeltaMovement(new Vec3(((x - entityiterator.getX()) / 0.7), ((y - entityiterator.getY()) / 0.7), ((z - entityiterator.getZ()) / 0.7)));
									}
								}
							}
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			});
		});
	}
}
