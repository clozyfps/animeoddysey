package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

public class EnergyDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "[" + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ColorCode
				+ new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Energy) + "\u00A7r]";
	}
}
