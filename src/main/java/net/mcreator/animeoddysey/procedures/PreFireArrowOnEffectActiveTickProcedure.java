package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PreFireArrowOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:flame ^ ^ ^0.75 0.1 0.1 0.1 0.05 2 force"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:lava ^ ^ ^0.75 0.1 0.1 0.1 0 1 force"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/execute at " + entity.getDisplayName().getString() + " positioned ~ ~1.6 ~ run particle minecraft:electric_spark ^ ^ ^0.75 0.1 0.1 0.1 0 1 force"));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7l\u00A76Open."), true);
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xincrease");
		zRadius = entity.getPersistentData().getDouble("zincrease");
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xdecrease");
		zRadius = entity.getPersistentData().getDouble("zdecrease");
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0);
			degree = degree + Math.toRadians(5);
		}
		entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.25));
		entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.25));
		entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.25));
		entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.25));
		if (entity.getPersistentData().getDouble("xincrease") >= 10) {
			entity.getPersistentData().putDouble("xincrease", 0);
		}
		if (entity.getPersistentData().getDouble("zincrease") >= 10) {
			entity.getPersistentData().putDouble("zincrease", 0);
		}
		if (entity.getPersistentData().getDouble("xdecrease") <= -10) {
			entity.getPersistentData().putDouble("xdecrease", 0);
		}
		if (entity.getPersistentData().getDouble("zdecrease") <= -10) {
			entity.getPersistentData().putDouble("zdecrease", 0);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 250, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 250, false, false));
	}
}
