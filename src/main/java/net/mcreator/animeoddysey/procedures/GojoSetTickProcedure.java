package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GojoSetTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Character).equals("Teen Gojo")) {
			{
				double _setval = 4;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Moves = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 100;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnergyBase = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Six Eyes , Infinity , Black Flash ";
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Passives = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "RCT";
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Talent = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "\u00A7l\u00A73";
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ColorCode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 1) {
				{
					String _setval = "Lapse Blue";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 50;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 2) {
				{
					String _setval = "Reversal Red";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 90;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 3) {
				{
					String _setval = "Lapse Blue: Maximum Output";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 120;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 4) {
				{
					String _setval = "Hollow Purple";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 200;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Lapse Blue")) {
				LapseBlueProcedure.execute(world, entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 50, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("False Reversal Red")
					|| ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Reversal Red")) {
				ReversalRedProcedure.execute(entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 100, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Lapse Blue: Maximum Output")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 200, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.LAPSE_BLUE_MAXIMUM.get(), 60, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Hollow Purple")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 500, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.HOLLOW_PURPLE_ACTIVE.get(), 50, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
