package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StoredCharacterDisplayProcedure {
public static String execute(
Entity entity
) {
if(
entity == null
) return "";
return
(entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeoddyseyModVariables.PlayerVariables())).ColorCode+""+;
}
}
