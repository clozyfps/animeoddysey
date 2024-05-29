package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

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

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
double randomizebda = 0;
if (entity.isAlive()) {if (new Object(){
public boolean checkGamemode(Entity _ent){
if(_ent instanceof ServerPlayer _serverPlayer) {
return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
} else if(_ent.level().isClientSide() && _ent instanceof Player _player) {
return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
}
return false;
}
}.checkGamemode(entity)) {{
double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).EnergyMax;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Energy = _setval;
capability.syncPlayerVariables(entity);
});
}
}}if (>=) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).ColorCode+"Level Up!")), true);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
}
}
}
