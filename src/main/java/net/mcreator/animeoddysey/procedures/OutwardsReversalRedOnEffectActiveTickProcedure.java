package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

import java.util.List;
import java.util.Comparator;

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
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("animeoddysey:post_mortem"))).isDone())) {
			degree = Math.toRadians(entity.getYRot());
			xRadius = entity.getPersistentData().getDouble("xincrease");
			zRadius = entity.getPersistentData().getDouble("zincrease");
			for (int index0 = 0; index0 < 36; index0++) {
				x_pos = x + Math.cos(degree) * xRadius;
				y_pos = y + 0.1;
				z_pos = z + Math.sin(degree) * zRadius;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:dust 1 0 0 2.5 ^0 ^0 ^0 0.1 0.1 0.1 0 2");
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION), entity),
										(float) (5 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3));
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() + entityiterator.getX()) / 25), ((entity.getY() + entityiterator.getY()) / 25), ((entity.getZ() + entityiterator.getZ()) / 25)));
							}
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId((world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)))));
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
							"particle minecraft:dust 1 0 0 2.5 ^0 ^0 ^0 0.1 0.1 0.1 0 2");
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION), entity),
										(float) (5 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3));
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() + entityiterator.getX()) / 15), ((entity.getY() + entityiterator.getY()) / 15), ((entity.getZ() + entityiterator.getZ()) / 15)));
							}
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId((world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)))));
				degree = degree + Math.toRadians(5);
			}
			entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.8));
			entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.8));
			entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.8));
			entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.8));
		} else if (entity instanceof ServerPlayer _plr45 && _plr45.level() instanceof ServerLevel
				&& _plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("animeoddysey:post_mortem"))).isDone()) {
			degree = Math.toRadians(entity.getYRot());
			xRadius = entity.getPersistentData().getDouble("xincrease");
			zRadius = entity.getPersistentData().getDouble("zincrease");
			for (int index2 = 0; index2 < 36; index2++) {
				x_pos = x + Math.cos(degree) * xRadius;
				y_pos = y + 0.1;
				z_pos = z + Math.sin(degree) * zRadius;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:dust 1 0 0 4 ^0 ^0 ^0 0.1 0.1 0.1 0 5");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 2, 3, 3, 3, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0);
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION), entity),
										(float) (10 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3));
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() + entityiterator.getX()) / 25), ((entity.getY() + entityiterator.getY()) / 25), ((entity.getZ() + entityiterator.getZ()) / 25)));
							}
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId((world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)))));
				degree = degree + Math.toRadians(5);
			}
			degree = Math.toRadians(entity.getYRot());
			xRadius = entity.getPersistentData().getDouble("xdecrease");
			zRadius = entity.getPersistentData().getDouble("zdecrease");
			for (int index3 = 0; index3 < 36; index3++) {
				x_pos = x + Math.cos(degree) * xRadius;
				y_pos = y + 0.1;
				z_pos = z + Math.sin(degree) * zRadius;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:dust 1 0 0 4 ^0 ^0 ^0 0.1 0.1 0.1 0 2");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 2, 3, 3, 3, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0);
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION), entity),
										(float) (10 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3));
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() + entityiterator.getX()) / 15), ((entity.getY() + entityiterator.getY()) / 15), ((entity.getZ() + entityiterator.getZ()) / 15)));
							}
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId((world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)))));
				degree = degree + Math.toRadians(5);
			}
			entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.8));
			entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.8));
			entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.8));
			entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.8));
		}
	}
}
