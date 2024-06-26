package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

public class ExplosionOfEmotionsOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 25, 1, 1, 1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 5, 1, 1, 1, 0);
		if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.REGENERATION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 6, false, false));
		}
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage == 250) {
			PlayBeepProcedure.execute(world, x, y, z);
			{
				double _setval = 251;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Percentage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage < 250) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.OUTWARDS_POOF.get(), 5, 0, false, false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:stresspercentage")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:stresspercentage")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("title @p title {\"text\":" + "" + new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage)
								+ "\",\"color\":\"#FF0000\"}"));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(
								("\u00A74\u00A7l" + new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage) + "%")),
						true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 0, false, false));
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage + 2;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Percentage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage + 2;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Percentage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage == 101) {
			PlayRageProcedure.execute(world, x, y, z);
		}
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage == 251) {
			PlayMobRageProcedure.execute(world, x, y, z);
			{
				double _setval = 252;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Percentage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Percentage == 252) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7l\u00A7k???"), true);
		}
	}
}
