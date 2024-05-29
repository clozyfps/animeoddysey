package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;

public class SwitchSkillOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber < (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AnimeoddyseyModVariables.PlayerVariables())).Moves) {
				{
					double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber + 1;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveNumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber >= (entity
					.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Moves) {
				{
					double _setval = 1;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveNumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (entity.isShiftKeyDown()) {
			if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber > 1) {
				{
					double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber - 1;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveNumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 1) {
				{
					double _setval = (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Moves;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveNumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
