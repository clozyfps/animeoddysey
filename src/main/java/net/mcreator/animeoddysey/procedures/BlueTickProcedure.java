package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class BlueTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusSphere = (int) 3 - 1;
		int verticalRadiusSphere = (int) 3 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).canOcclude()) {
							if (!((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.BEDROCK)) {
								if (!((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.CHAIN_COMMAND_BLOCK)) {
									if (!((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.REPEATING_COMMAND_BLOCK)) {
										if (!((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.COMMAND_BLOCK)) {
											if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("animeoddysey:domain_blocks")))) {
												if (world instanceof ServerLevel _level)
													FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + i, z + zi), (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.POOF, x + xi, y + i, z + zi, 1, 0.1, 1, 0.1, 0.4);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + xi, y + i, z + zi, 1, 0.1, 1, 0.1, 0.3);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 0.3, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
													}
												}
												{
													final Vec3 _center = new Vec3(x + xi, y + i, z + zi);
													List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
													for (Entity entityiterator : _entfound) {
														if (!(entity == entityiterator) && !(entityiterator instanceof FallingBlockEntity)) {
															entityiterator.setDeltaMovement(new Vec3(((x + xi - entityiterator.getX()) / 5), ((y + i - entityiterator.getY()) / 5), ((z + zi - entityiterator.getZ()) / 5)));
														} else if (entityiterator instanceof ItemEntity) {
															if (!entityiterator.level().isClientSide())
																entityiterator.discard();
														} else if (entityiterator instanceof FallingBlockEntity) {
															entityiterator.setDeltaMovement(new Vec3(((x + xi - entityiterator.getX()) / 4), ((y + i - entityiterator.getY()) / 4), ((z + zi - entityiterator.getZ()) / 4)));
															if (Math.random() < 0.2) {
																{
																	Entity _ent = entityiterator;
																	_ent.teleportTo(x + xi, y + i, z + zi);
																	if (_ent instanceof ServerPlayer _serverPlayer)
																		_serverPlayer.connection.teleport(x + xi, y + i, z + zi, _ent.getYRot(), _ent.getXRot());
																}
															}
														}
													}
												}
												world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
												world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
