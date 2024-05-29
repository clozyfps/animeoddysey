package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.entity.KilluaZoldyckEntity;

public class KilluaZoldyckOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof KilluaZoldyckEntity _datEntSetI)
			_datEntSetI.getEntityData().set(KilluaZoldyckEntity.DATA_Energy, 600);
	}
}
