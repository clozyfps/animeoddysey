package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

public class BlackOutwardsEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("increasex", 0);
		entity.getPersistentData().putDouble("increasez", 0);
		entity.getPersistentData().putDouble("decreasex", 0);
		entity.getPersistentData().putDouble("decreasez", 0);
	}
}
