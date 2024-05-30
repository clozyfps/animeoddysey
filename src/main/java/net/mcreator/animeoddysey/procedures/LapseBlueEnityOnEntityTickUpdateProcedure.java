package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.entity.LapseBlueEnityEntity;

import java.util.List;
import java.util.Comparator;

public class LapseBlueEnityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"particle minecraft:dust 0.31 0.71 0.93 5 ^0 ^0 ^0 1 1 1 0 5");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/particle minecraft:enchant ~ ~1.3 ~ 0 0 0 1 60");
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 2, 2, 2, 0);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(entityiterator instanceof LapseBlueEnityEntity)) {
						if (entityiterator.getPersistentData().getDouble("LapseBluePlayerID") != entity.getPersistentData().getDouble("LapseBluePlayerID")) {
							if (!(entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(AnimeoddyseyModMobEffects.LAPSE_BLUE_POITON.get()))) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
								entityiterator.setDeltaMovement(new Vec3(((x - entityiterator.getX()) / 4), ((y - entityiterator.getY()) / 4), ((z - entityiterator.getZ()) / 4)));
								if (entityiterator instanceof Player) {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo(x, y, z);
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
