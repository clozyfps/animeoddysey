package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class HonoredOneSkyOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"particle minecraft:dust 0.93 0.75 0.31 1 ^0 ^0 ^0 0.3 1.2 0.3 0 3");
		entity.getPersistentData().putDouble("honoredonetimer", (entity.getPersistentData().getDouble("honoredonetimer") + 1));
		if (entity.getPersistentData().getDouble("honoredonetimer") >= 150) {
		} else if (entity.getPersistentData().getDouble("honoredonetimer") < 150) {
		}
	}
}
