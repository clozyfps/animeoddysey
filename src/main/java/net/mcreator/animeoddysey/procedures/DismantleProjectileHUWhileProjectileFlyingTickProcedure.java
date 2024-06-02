package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class DismantleProjectileHUWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
		AnimeoddyseyMod.queueServerWork(20, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK)) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.destroyBlock(BlockPos.containing(x + 1, y + -1, z), false);
			world.destroyBlock(BlockPos.containing(x + 2, y + -2, z), false);
			world.destroyBlock(BlockPos.containing(x + 3, y + -3, z), false);
			world.destroyBlock(BlockPos.containing(x + 4, y + -4, z), false);
			world.destroyBlock(BlockPos.containing(x + 5, y + -5, z), false);
			world.destroyBlock(BlockPos.containing(x, y + 1, z + 1), false);
			world.destroyBlock(BlockPos.containing(x, y + 2, z + 2), false);
			world.destroyBlock(BlockPos.containing(x, y + 3, z + 3), false);
			world.destroyBlock(BlockPos.containing(x, y + 4, z + 4), false);
			world.destroyBlock(BlockPos.containing(x, y + 5, z + 5), false);
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.destroyBlock(BlockPos.containing(x + 1, y + 1, z), false);
			world.destroyBlock(BlockPos.containing(x + 2, y + 2, z), false);
			world.destroyBlock(BlockPos.containing(x + 3, y + 3, z), false);
			world.destroyBlock(BlockPos.containing(x + 4, y + 4, z), false);
			world.destroyBlock(BlockPos.containing(x + 5, y + 5, z), false);
			world.destroyBlock(BlockPos.containing(x, y + -1, z + 1), false);
			world.destroyBlock(BlockPos.containing(x, y + -2, z + 2), false);
			world.destroyBlock(BlockPos.containing(x, y + -3, z + 3), false);
			world.destroyBlock(BlockPos.containing(x, y + -4, z + 4), false);
			world.destroyBlock(BlockPos.containing(x, y + -5, z + 5), false);
			world.destroyBlock(BlockPos.containing(x, y + -5, z + 6), false);
			world.destroyBlock(BlockPos.containing(x, y + -5, z + -5), false);
			world.destroyBlock(BlockPos.containing(x, y + -5, z + -1), false);
			world.destroyBlock(BlockPos.containing(x, y + -5, z + -2), false);
		}
	}
}
