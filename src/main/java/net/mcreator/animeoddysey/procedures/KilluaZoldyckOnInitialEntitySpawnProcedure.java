package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class KilluaZoldyckOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof KilluaZoldyckEntity _datEntSetI)
			_datEntSetI.getEntityData().set(KilluaZoldyckEntity.DATA_Energy, 600);
	}
}
