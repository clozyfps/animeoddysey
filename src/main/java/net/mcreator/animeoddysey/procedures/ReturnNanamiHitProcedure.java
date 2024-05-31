package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnNanamiHitProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("NanamiHited") == true) {
			return true;
		}
		return false;
	}
}
