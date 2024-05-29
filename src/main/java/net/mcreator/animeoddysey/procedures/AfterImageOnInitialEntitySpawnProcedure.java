package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AfterImageOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		AnimeoddyseyMod.queueServerWork(18, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
