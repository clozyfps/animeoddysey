package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CopyEffectStartedappliedProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
{
String _setval = ;
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Character = _setval;
capability.syncPlayerVariables(entity);
});
}
}
}
