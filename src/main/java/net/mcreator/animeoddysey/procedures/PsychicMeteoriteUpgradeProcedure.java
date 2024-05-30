package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.List;
import java.util.Comparator;

public class PsychicMeteoriteUpgradeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:psychicenergy")), SoundSource.NEUTRAL,
								1, 1);
					} else {
						_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:psychicenergy")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.AURA_CONTROL.get(), 10, 0, false, false));
				if (!(entity == entityiterator)) {
					if (!(entityiterator instanceof Player)) {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y() + 10), (entityiterator.getDeltaMovement().z())));
					} else if (entityiterator instanceof Player) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 50), (entityiterator.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 50), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 10), (entity.getDeltaMovement().z())));
			}
		}
		AnimeoddyseyMod.queueServerWork(5, () -> {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:psychicenergy")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:psychicenergy")), SoundSource.NEUTRAL, 1, 1,
										false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.attack_impact")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.attack_impact")), SoundSource.NEUTRAL, 1, 1,
										false);
							}
						}
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
								(float) (20 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.IFRAME.get(), 3, 0, false, false));
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y() - 50), (entityiterator.getDeltaMovement().z())));
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() - 48), (entityiterator.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() - 48), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						}
					}
				}
			}
			AnimeoddyseyMod.queueServerWork(10, () -> {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 50), (entity.getDeltaMovement().z())));
				entity.fallDistance = 0;
				AnimeoddyseyMod.queueServerWork(5, () -> {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.OUTWARDS_POOF.get(), 10, 0, false, false));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 1, 0.1, 1, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 0.1, 1, 0.2);
				});
			});
		});
	}
}
