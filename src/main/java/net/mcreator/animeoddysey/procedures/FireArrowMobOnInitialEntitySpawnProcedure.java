package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class FireArrowMobOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().invulnerable = true;
			_player.onUpdateAbilities();
		}
		AnimeoddyseyMod.queueServerWork(100, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
