package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FireArrowCircle10Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		degree = Math.toRadians(entity.getYRot());
		xRadius = 5;
		zRadius = 5;
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 20;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		xRadius = -5;
		zRadius = -5;
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 20;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
	}
}
