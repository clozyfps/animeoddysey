package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.init.AnimeoddyseyModEntities;
import net.mcreator.animeoddysey.entity.LapseBlueEnityEntity;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.List;
import java.util.Comparator;

public class LapseBlueProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double numx = 0;
		double numy = 0;
		double numz = 0;
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.LAPSE_BLUE_POITON.get(), 15, 1));
		entity.getPersistentData().putDouble("LapseBlueX",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()));
		entity.getPersistentData().putDouble("LapseBlueY",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()));
		entity.getPersistentData().putDouble("LapseBlueZ",
				(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = AnimeoddyseyModEntities.LAPSE_BLUE_ENITY.get().spawn(_serverLevel,
					BlockPos.containing(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
					MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).getPersistentData().putDouble("LapseBluePlayerID", (Mth.nextInt(RandomSource.create(), 1, 9999999)));
			entity.getPersistentData().putDouble("LapseBluePlayerID", ((entitytospawn).getPersistentData().getDouble("LapseBluePlayerID")));
		}
		AnimeoddyseyMod.queueServerWork(2, () -> {
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (!(entityiterator instanceof LapseBlueEnityEntity)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
						}
					}
				}
			}
			AnimeoddyseyMod.queueServerWork(2, () -> {
				{
					final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if (!(entityiterator instanceof LapseBlueEnityEntity)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
							}
						}
					}
				}
				AnimeoddyseyMod.queueServerWork(2, () -> {
					{
						final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof LapseBlueEnityEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
								}
							}
						}
					}
					AnimeoddyseyMod.queueServerWork(2, () -> {
						{
							final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if (!(entityiterator instanceof LapseBlueEnityEntity)) {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
									}
								}
							}
						}
						AnimeoddyseyMod.queueServerWork(2, () -> {
							{
								final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (!(entityiterator instanceof LapseBlueEnityEntity)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
										}
									}
								}
							}
							AnimeoddyseyMod.queueServerWork(2, () -> {
								{
									final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (!(entityiterator instanceof LapseBlueEnityEntity)) {
												entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
											}
										}
									}
								}
								AnimeoddyseyMod.queueServerWork(2, () -> {
									{
										final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator instanceof LapseBlueEnityEntity)) {
													entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
												}
											}
										}
									}
									AnimeoddyseyMod.queueServerWork(2, () -> {
										{
											final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (!(entityiterator == entity)) {
													if (!(entityiterator instanceof LapseBlueEnityEntity)) {
														entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL), entity), 2);
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null,
																		BlockPos.containing(entity.getPersistentData().getDouble("LapseBlueX"), entity.getPersistentData().getDouble("LapseBlueY"), entity.getPersistentData().getDouble("LapseBlueZ")),
																		ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound((entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")), (entity.getPersistentData().getDouble("LapseBlueZ")),
																		ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel _level)
															_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getPersistentData().getDouble("LapseBlueX")), (entity.getPersistentData().getDouble("LapseBlueY")),
																	(entity.getPersistentData().getDouble("LapseBlueZ")), 3, 2, 2, 2, 0);
													}
												}
											}
										}
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
