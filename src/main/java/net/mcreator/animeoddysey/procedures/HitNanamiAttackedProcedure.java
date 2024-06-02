package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModParticleTypes;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.init.AnimeoddyseyModEntities;
import net.mcreator.animeoddysey.entity.NanamiHitEntity;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HitNanamiAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Character).equals("Nanami")) {
			if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).HitNanamiPlayer == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HitNanamiPlayer = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (entity instanceof NanamiHitEntity) {
					sourceentity.getPersistentData().putBoolean("NanamiHited", true);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.IFRAME.get(), 4, 1, false, false));
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:bloody")), SoundSource.NEUTRAL, (float) 0.7, (float) 1.6);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:bloody")), SoundSource.NEUTRAL, (float) 0.7, (float) 1.6, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:explosivepunch")), SoundSource.NEUTRAL, (float) 0.7, (float) 1.4);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:explosivepunch")), SoundSource.NEUTRAL, (float) 0.7, (float) 1.4, false);
							}
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (AnimeoddyseyModParticleTypes.RATIO_HIT.get()), x, y, z, 1, 0, 0, 0, 0);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.NANAMI_HIT_EFFECT.get(), 2, 1, false, false));
					AnimeoddyseyMod.queueServerWork(4, () -> {
						sourceentity.getPersistentData().putBoolean("NanamiHited", false);
						{
							boolean _setval = false;
							sourceentity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.HitNanamiPlayer = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					});
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = AnimeoddyseyModEntities.NANAMI_HIT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							(entitytospawn).getPersistentData().putDouble("NanamiHitX", (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
							(entitytospawn).getPersistentData().putDouble("NanamiHitY", 1.5);
							(entitytospawn).getPersistentData().putDouble("NanamiHitZ", (Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
						}
					}
				}
			}
		} else {
			if (entity instanceof NanamiHitEntity) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
