package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class DismantleProjectileHUProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double slicex = 0;
		double slicey = 0;
		double slicez = 0;
		double randomslice = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:slice")),
						SoundSource.PLAYERS, 1, (float) 1.1);
			} else {
				_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:slice")), SoundSource.PLAYERS, 1,
						(float) 1.1, false);
			}
		}
		entity.getPersistentData().putDouble("randomslice", (Mth.nextInt(RandomSource.create(), 1, 3)));
		if (entity.getPersistentData().getDouble("randomslice") == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_1.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 1, 0.1, 1.5, 0.1, 0);
		} else if (entity.getPersistentData().getDouble("randomslice") == 2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_2.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 1, 0.1, 1.5, 0.1, 0);
		} else if (entity.getPersistentData().getDouble("randomslice") == 3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_3.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 1, 0.1, 1.5, 0.1, 0);
		}
		{
			final Vec3 _center = new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity),
						(float) (6 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 3));
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
