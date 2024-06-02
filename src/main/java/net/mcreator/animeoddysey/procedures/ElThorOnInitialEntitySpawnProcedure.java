package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ElThorOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"particle minecraft:campfire_cosy_smoke ~ ~16 ~ 2.5 1 2.5 0 2000");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 200");
		AnimeoddyseyMod.queueServerWork(7, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
			AnimeoddyseyMod.queueServerWork(7, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
				AnimeoddyseyMod.queueServerWork(7, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
					AnimeoddyseyMod.queueServerWork(7, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
						AnimeoddyseyMod.queueServerWork(7, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
							AnimeoddyseyMod.queueServerWork(7, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
								AnimeoddyseyMod.queueServerWork(7, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
									AnimeoddyseyMod.queueServerWork(7, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/particle animeoddysey:el_thor_electrisity ~ ~ ~ 1 6 1 0 100");
									});
								});
							});
						});
					});
				});
			});
		});
		AnimeoddyseyMod.queueServerWork(40, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
