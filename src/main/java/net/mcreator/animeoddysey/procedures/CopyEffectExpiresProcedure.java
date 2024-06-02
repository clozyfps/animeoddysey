package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CopyEffectExpiresProcedure {
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
{
String _setval = "Copy";
entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.SelectedMove = _setval;
capability.syncPlayerVariables(entity);
});
}
if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(),500,1, false, false));
}
}
