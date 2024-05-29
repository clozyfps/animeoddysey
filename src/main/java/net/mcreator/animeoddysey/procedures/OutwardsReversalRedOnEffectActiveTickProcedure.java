package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class OutwardsReversalRedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:dust_color_transition 1 0.09 0.09 0.2 1 0.44 0.44 ^-0.2 ^ ^0.5 0.01 0.01 0.01 0.01 30 normal"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~2.05 ~ run particle animeoddysey:small_cube_red ^-0.2 ^ ^0.5 0.01 0.01 0.01 0 10 normal"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:dust_color_transition 1 0.09 0.09 0.2 1 0.44 0.44 ^-0.2 ^ ^0.5 0.01 0.01 0.01 0.01 30 normal"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:dust_color_transition 1 0.09 0.09 0.5 1 0.44 0.44 ^-0.2 ^ ^0.5 0.03 0.03 0.03 0.01 30 normal"));
		AnimeoddyseyMod.queueServerWork(10, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle animeoddysey:red_anim ^-0.2 ^ ^0.5 0.03 0.03 0.03 1 1 normal"));
		});
	}
}
