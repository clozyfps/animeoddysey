package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

public class KilluaZoldyckOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("energy", 750);
		entity.getPersistentData().putString("MobCharacter", "Killua");
	}
}
