package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class SpiritualAwarenessOnEffectActiveTickProcedure {
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
		xRadius = entity.getPersistentData().getDouble("xincrease");
		zRadius = entity.getPersistentData().getDouble("zincrease");
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle minecraft:dust 0.8 0.2 0.93 2 ^0 ^0 ^0 0.1 0.1 0.1 0 2");
			degree = degree + Math.toRadians(5);
		}
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xdecrease");
		zRadius = entity.getPersistentData().getDouble("zdecrease");
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle minecraft:dust 0.8 0.2 0.93 2 ^0 ^0 ^0 0.1 0.1 0.1 0 2");
			degree = degree + Math.toRadians(5);
		}
		entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.8));
		entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.8));
		entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.8));
		entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.8));
		entity.getPersistentData().putDouble("awarenesstick", (entity.getPersistentData().getDouble("awarenesstick") + 1));
		if (entity.getPersistentData().getDouble("awarenesstick") >= 30) {
			entity.getPersistentData().putDouble("xdecrease", 0);
			entity.getPersistentData().putDouble("xincrease", 0);
			entity.getPersistentData().putDouble("zdecrease", 0);
			entity.getPersistentData().putDouble("zincrease", 0);
			entity.getPersistentData().putDouble("awarenesstick", 0);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 250, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 5, 0, false, false));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("awarenesstick")) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30, 0, false, false));
				}
			}
		}
	}
}
