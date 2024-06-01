package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ChidoriActiveOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 0.1, 0.5, 0.1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.CHIDORI_PARTICLE.get()), x, y, z, 15, 0.1, 0.5, 0.1, 0.3);
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.CHIDORI_ACTIVE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.CHIDORI_ACTIVE.get()).getDuration() : 0) > 60) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 3, false, false));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.CHIDORI_ACTIVE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.CHIDORI_ACTIVE.get()).getDuration() : 0) <= 60) {
			entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().x), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().z)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.NEUTRAL, 1, 1,
										false);
							}
						}
						entityiterator.setDeltaMovement(new Vec3((2.5 * entity.getLookAngle().x), (entity.getDeltaMovement().y()), (2.5 * entity.getLookAngle().z)));
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
								(float) (7 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod));
					}
				}
			}
		}
	}
}
