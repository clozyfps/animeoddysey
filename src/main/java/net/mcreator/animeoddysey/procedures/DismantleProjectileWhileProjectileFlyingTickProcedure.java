package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class DismantleProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double randomslice = 0;
		randomslice = Mth.nextInt(RandomSource.create(), 1, 3);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(immediatesourceentity == entityiterator)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("animeoddysey:slice"))), entity),
								(float) (10 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod));
						if (randomslice == 1) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_1.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0.1, 1.5, 0.1, 0);
						} else if (randomslice == 2) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_2.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0.1, 1.5, 0.1, 0);
						} else if (randomslice == 3) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.SLICE_3.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0.1, 1.5, 0.1, 0);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:slice")), SoundSource.NEUTRAL,
										(float) 0.6, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:slice")), SoundSource.NEUTRAL, (float) 0.6, 1,
										false);
							}
						}
						world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
						if (!immediatesourceentity.level().isClientSide())
							immediatesourceentity.discard();
					}
				}
			}
		}
	}
}
