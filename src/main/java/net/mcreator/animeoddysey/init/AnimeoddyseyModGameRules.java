
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimeoddyseyModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> CONSTANT_BLACK_FLASHES = GameRules.register("constantBlackFlashes", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
