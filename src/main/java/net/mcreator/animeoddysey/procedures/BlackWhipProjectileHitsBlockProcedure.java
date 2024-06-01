package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class BlackWhipProjectileHitsBlockProcedure {
	public static void execute(double x, double y, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(((x - entity.getX()) / 3), ((y - entity.getY()) / 3), ((y - entity.getZ()) / 3)));
	}
}
