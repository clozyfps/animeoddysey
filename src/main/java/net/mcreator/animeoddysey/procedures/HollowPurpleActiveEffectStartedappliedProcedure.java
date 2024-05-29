package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

public class HollowPurpleActiveEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("hollowPurple", 40);
	}
}
