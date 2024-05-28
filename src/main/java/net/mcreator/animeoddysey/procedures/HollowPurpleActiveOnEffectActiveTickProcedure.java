package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModEntities;
import net.mcreator.animeoddysey.entity.HollowPurpleWeakEntity;

public class HollowPurpleActiveOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("hollowPurple") > 0) {
			entity.getPersistentData().putDouble("hollowPurple", (entity.getPersistentData().getDouble("hollowPurple") - 1));
			if (entity.getPersistentData().getDouble("hollowPurple") >= 1) {
				if (entity.getPersistentData().getBoolean("initial") != true) {
					entity.getPersistentData().putDouble("hollowDistance", 4.5);
					entity.getPersistentData().putBoolean("initial", true);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
									new Vec3(Math.round(x - entity.getPersistentData().getDouble("hollowDistance") * Math.sin(Math.toRadians(entity.getYRot() + 90))), (y + 0.5),
											Math.round(z + entity.getPersistentData().getDouble("hollowDistance") * Math.cos(Math.toRadians(entity.getYRot() + 90)))),
									Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle minecraft:dust 0.14 0.32 0.92 2 ^0 ^0 ^0 0.1 0.1 0.1 0 1");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
									new Vec3(Math.round(x - entity.getPersistentData().getDouble("hollowDistance") * Math.sin(Math.toRadians(entity.getYRot() - 90))), (y + 0.5),
											Math.round(z + entity.getPersistentData().getDouble("hollowDistance") * Math.cos(Math.toRadians(entity.getYRot() - 90)))),
									Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle minecraft:dust 0.94 0.12 0.14 2 ^0 ^0 ^0 0.1 0.1 0.1 0 1");
				entity.getPersistentData().putDouble("hollowDistance", (entity.getPersistentData().getDouble("hollowDistance") - 0.12857143));
			}
			if (entity.getPersistentData().getDouble("hollowPurple") == 1) {
				entity.getPersistentData().putDouble("purpleDistance", 0);
				entity.getPersistentData().putDouble("hollowPurple", 0);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new HollowPurpleWeakEntity(AnimeoddyseyModEntities.HOLLOW_PURPLE_WEAK.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) (25 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3
								+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod), 0, (byte) 25);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				entity.getPersistentData().putDouble("hollowPurple", 0);
				entity.getPersistentData().putBoolean("initial", false);
			}
		}
	}
}
