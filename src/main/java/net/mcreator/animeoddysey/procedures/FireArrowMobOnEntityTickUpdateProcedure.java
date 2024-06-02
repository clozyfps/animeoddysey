package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

import java.util.List;
import java.util.Comparator;

public class FireArrowMobOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		entity.getPersistentData().putDouble("rex", (Mth.nextInt(RandomSource.create(), -50, 50)));
		entity.getPersistentData().putDouble("rey", (Mth.nextInt(RandomSource.create(), 1, 20)));
		entity.getPersistentData().putDouble("rez", (Mth.nextInt(RandomSource.create(), -50, 50)));
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 80, 8, 2, 8, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 10, 8, 2, 8, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 150, 8, 2, 8, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 2, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
								(float) (9
										+ ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
										+ ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod));
					}
				}
			}
		}
		degree = Math.toRadians(entity.getYRot());
		xRadius = 5;
		zRadius = 5;
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 2;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		xRadius = -5;
		zRadius = -5;
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 2;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		FireArrowCircle2Procedure.execute(world, x, y, z, entity);
		FireArrowCircle3Procedure.execute(world, x, y, z, entity);
		FireCircle4Procedure.execute(world, x, y, z, entity);
		FireArrowCircle5Procedure.execute(world, x, y, z, entity);
		FireArrowCircle6Procedure.execute(world, x, y, z, entity);
		FireArrowCircle7Procedure.execute(world, x, y, z, entity);
		FireArrowCircle8Procedure.execute(world, x, y, z, entity);
		FireArrowCircle9Procedure.execute(world, x, y, z, entity);
		FireArrowCircle10Procedure.execute(world, x, y, z, entity);
	}
}
