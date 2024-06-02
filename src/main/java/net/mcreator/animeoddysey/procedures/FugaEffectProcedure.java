package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FugaEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		AnimeoddyseyMod.queueServerWork(7, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.2 ^1.3 ^0.3"));
			AnimeoddyseyMod.queueServerWork(1, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.15 ^1.18 ^0.3"));
				AnimeoddyseyMod.queueServerWork(1, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.11 ^1.13 ^0.3"));
					AnimeoddyseyMod.queueServerWork(1, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.09 ^1.09 ^0.3"));
						AnimeoddyseyMod.queueServerWork(1, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.09 ^1.05 ^0.3"));
							AnimeoddyseyMod.queueServerWork(1, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.04 ^1.01 ^0.3"));
								AnimeoddyseyMod.queueServerWork(1, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.04 ^1.01 ^0.3"));
									AnimeoddyseyMod.queueServerWork(1, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1 ^0.3"));
										AnimeoddyseyMod.queueServerWork(1, () -> {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.1 ^0.9 ^0.3"));
											AnimeoddyseyMod.queueServerWork(1, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.15 ^0.95 ^0.3"));
												AnimeoddyseyMod.queueServerWork(1, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.2 ^1 ^0.3"));
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.2 ^1.3 ^0.3"));
													AnimeoddyseyMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.15 ^1.18 ^0.3"));
														AnimeoddyseyMod.queueServerWork(2, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.11 ^1.13 ^0.3"));
															AnimeoddyseyMod.queueServerWork(2, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.09 ^1.09 ^0.3"));
																AnimeoddyseyMod.queueServerWork(2, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.09 ^1.05 ^0.3"));
																	AnimeoddyseyMod.queueServerWork(2, () -> {
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.04 ^1.01 ^0.3"));
																		AnimeoddyseyMod.queueServerWork(2, () -> {
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.04 ^1.01 ^0.3"));
																			AnimeoddyseyMod.queueServerWork(2, () -> {
																				if (world instanceof ServerLevel _level)
																					_level.getServer().getCommands()
																							.performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1 ^0.3"));
																				AnimeoddyseyMod.queueServerWork(2, () -> {
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands()
																								.performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.1 ^0.9 ^0.3"));
																					AnimeoddyseyMod.queueServerWork(2, () -> {
																						if (world instanceof ServerLevel _level)
																							_level.getServer().getCommands().performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.15 ^0.95 ^0.3"));
																						AnimeoddyseyMod.queueServerWork(2, () -> {
																							if (world instanceof ServerLevel _level)
																								_level.getServer().getCommands().performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^0.2 ^1 ^0.3"));
																						});
																					});
																				});
																			});
																		});
																	});
																});
															});
														});
													});
													AnimeoddyseyMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
														AnimeoddyseyMod.queueServerWork(1, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.2 ^0.3"));
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.17 ^0.3"));
															AnimeoddyseyMod.queueServerWork(1, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.08 ^1.2 ^0.2"));
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.035 ^1.15 ^0.2"));
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.2 ^0.2"));
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.2"));
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.17 ^0.2"));
																AnimeoddyseyMod.queueServerWork(1, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.035 ^1.15 ^0.2"));
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.17 ^0.3"));
																	AnimeoddyseyMod.queueServerWork(2, () -> {
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																		AnimeoddyseyMod.queueServerWork(2, () -> {
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																			AnimeoddyseyMod.queueServerWork(2, () -> {
																				if (world instanceof ServerLevel _level)
																					_level.getServer().getCommands()
																							.performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																				if (world instanceof ServerLevel _level)
																					_level.getServer().getCommands()
																							.performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																				if (world instanceof ServerLevel _level)
																					_level.getServer().getCommands()
																							.performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																				AnimeoddyseyMod.queueServerWork(2, () -> {
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands().performPrefixedCommand(
																								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																										.withSuppressedOutput(),
																								("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands().performPrefixedCommand(
																								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																										.withSuppressedOutput(),
																								("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands().performPrefixedCommand(
																								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																										.withSuppressedOutput(),
																								("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																					AnimeoddyseyMod.queueServerWork(2, () -> {
																						if (world instanceof ServerLevel _level)
																							_level.getServer().getCommands().performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																						if (world instanceof ServerLevel _level)
																							_level.getServer().getCommands().performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																						if (world instanceof ServerLevel _level)
																							_level.getServer().getCommands().performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																						AnimeoddyseyMod.queueServerWork(2, () -> {
																							if (world instanceof ServerLevel _level)
																								_level.getServer().getCommands().performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																							if (world instanceof ServerLevel _level)
																								_level.getServer().getCommands().performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																							if (world instanceof ServerLevel _level)
																								_level.getServer().getCommands().performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																							AnimeoddyseyMod.queueServerWork(2, () -> {
																								if (world instanceof ServerLevel _level)
																									_level.getServer().getCommands().performPrefixedCommand(
																											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																													.withSuppressedOutput(),
																											("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																								if (world instanceof ServerLevel _level)
																									_level.getServer().getCommands().performPrefixedCommand(
																											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																													.withSuppressedOutput(),
																											("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																								if (world instanceof ServerLevel _level)
																									_level.getServer().getCommands().performPrefixedCommand(
																											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																													.withSuppressedOutput(),
																											("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																								AnimeoddyseyMod.queueServerWork(2, () -> {
																									if (world instanceof ServerLevel _level)
																										_level.getServer().getCommands().performPrefixedCommand(
																												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																														.withSuppressedOutput(),
																												("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																									if (world instanceof ServerLevel _level)
																										_level.getServer().getCommands().performPrefixedCommand(
																												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																														.withSuppressedOutput(),
																												("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																									if (world instanceof ServerLevel _level)
																										_level.getServer().getCommands().performPrefixedCommand(
																												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																														.withSuppressedOutput(),
																												("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																								});
																							});
																						});
																					});
																				});
																			});
																		});
																		AnimeoddyseyMod.queueServerWork(31, () -> {
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.18 ^0.3"));
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.1 ^1.2 ^0.2"));
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						("execute at " + entity.getDisplayName().getString() + " rotated ~ 0 run particle minecraft:flame " + "^-0.05 ^1.14 ^0.2"));
																		});
																	});
																});
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
