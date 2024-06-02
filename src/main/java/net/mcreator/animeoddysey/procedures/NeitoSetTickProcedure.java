package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NeitoSetTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).Character).equals("Neito")) {{
double _setval = 5;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Moves = _setval;
capability.syncPlayerVariables(entity);
});
}
{
double _setval = 120;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.EnergyBase = _setval;
capability.syncPlayerVariables(entity);
});
}
{
String _setval = "";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Passives = _setval;
capability.syncPlayerVariables(entity);
});
}
{
String _setval = "";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Talent = _setval;
capability.syncPlayerVariables(entity);
});
}
{
String _setval = "\u00A7l\u00A76";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.ColorCode = _setval;
capability.syncPlayerVariables(entity);
});
}
if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber==1) {{
String _setval = "Copy";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.SelectedMove = _setval;
capability.syncPlayerVariables(entity);
});
}
if (!().equals("")) {{
double _setval = 20;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Cost = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = 0;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Cost = _setval;
capability.syncPlayerVariables(entity);
});
}
}}if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Copy")) {if (!().equals("")) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(),20,0, false, false));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.DELETED_MOD_ELEMENT.get(),2400,0, false, false));{
String _setval = "";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.ActiveMove = _setval;
capability.syncPlayerVariables(entity);
});
}
}}}else if (!((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).Character).equals("Yuta")) {}
}
}
