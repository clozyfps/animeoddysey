package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StatTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomizebda = 0;
		if (entity.isAlive()) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				{
					double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).EnergyMax;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Exp >= (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AnimeoddyseyModVariables.PlayerVariables())).ExpMax) {
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Exp
						- (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ExpMax;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ExpMax + 3;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ExpMax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level + 1;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Level = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).SP + 2;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ColorCode + "Level Up!")), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).SpeedStat >= 30) {
			entity.setMaxUpStep(1);
		}
	}
}
