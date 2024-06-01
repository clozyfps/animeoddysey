package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

public class ShigeoKageyamaOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("energy", 5000);
		entity.getPersistentData().putString("MobCharacter", "Mob");
	}
}
