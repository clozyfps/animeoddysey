package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

public class RankValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7lRank: " + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Rank;
	}
}
