package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DefenseDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7lDefense: " + new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).DefenseStat);
	}
}
