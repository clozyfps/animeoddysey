package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.network.AnimeoddyseyModVariables;
import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.init.AnimeoddyseyModEntities;
import net.mcreator.animeoddysey.entity.DetroitSmashEntity;
import net.mcreator.animeoddysey.entity.DelawareSmashEntity;
import net.mcreator.animeoddysey.entity.BlackWhipPinpointFocusEntity;
import net.mcreator.animeoddysey.entity.BlackWhipEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DekuSetTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomizebda = 0;
		if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Character).equals("Deku")) {
			{
				double _setval = 10;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Moves = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 20;
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnergyBase = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Danger Sense , Fa Jin , Float";
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Passives = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "\u00A7l\u00A7a";
				entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ColorCode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 1) {
				{
					String _setval = "Detroit Smash";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 20;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 2) {
				{
					String _setval = "Delaware Smash";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 40;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 3) {
				{
					String _setval = "Manchester Smash";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 80;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 4) {
				{
					String _setval = "Full Cowling";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 5) {
				{
					String _setval = "Black Whip Swing";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 120;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 6) {
				{
					String _setval = "Black Whip: Pinpoint Focus";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 130;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 7) {
				{
					String _setval = "Smokescreen";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 200;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 8) {
				{
					String _setval = "Fa Jin";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 50 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).FaJin * 2;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 9) {
				{
					String _setval = "Transmission";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 250;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).MoveNumber == 10) {
				{
					String _setval = "Gearshift Overdrive";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SelectedMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Detroit Smash")) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new DetroitSmashEntity(AnimeoddyseyModEntities.DETROIT_SMASH.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity,
								(float) (8 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 10
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 10
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod),
								4);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 50, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage > (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level / 2) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (5 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 5));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(), 300, 1, false, true));
				}
				if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get())) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (9 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 4));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.FATIGUE.get()).getDuration() : 0) + 200), 0, false, true));
				}
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Delaware Smash")) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new DelawareSmashEntity(AnimeoddyseyModEntities.DELAWARE_SMASH.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity,
								(float) (6 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 10
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 10
										+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod),
								4);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 40, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:delawaresmash")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("animeoddysey:delawaresmash")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage > 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component
								.literal(("\u00A7b" + new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage)
										+ "% DELAWARE SMASH!!")),
								true);
				} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage <= 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("DELAWARE SMASH!!"), true);
				}
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage > (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level / 2) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (5 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 5));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(), 300, 0, false, true));
				}
				if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get())) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (9 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 4));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.FATIGUE.get()).getDuration() : 0) + 200), 0, false, true));
				}
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Manchester Smash")) {
				ManchesterSmashProcedure.execute(world, x, y, z, entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 60, 0, false, false));
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage > (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level / 2) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (5 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 5));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(), 300, 0, false, true));
				}
				if (entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get())) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
							(float) (9 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage / 4));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FATIGUE.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AnimeoddyseyModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(AnimeoddyseyModMobEffects.FATIGUE.get()).getDuration() : 0) + 200), 0, false, true));
				}
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage > 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component
								.literal(("\u00A7b" + new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage)
										+ "% MANCHESTER SMASH")),
								true);
				} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).OFAPercentage <= 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("MANCHESTER SMASH"), true);
				}
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Full Cowling")) {
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level >= 10) {
					if (!(entity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(AnimeoddyseyModMobEffects.FULL_COWLING.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FULL_COWLING.get(), 99999, 0, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 20, 0, false, false));
					} else if (entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(AnimeoddyseyModMobEffects.FULL_COWLING.get())) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(AnimeoddyseyModMobEffects.FULL_COWLING.get());
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 40, 0, false, false));
					}
				} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level < 10) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7lMust be level 10+ | Current Level: "
								+ new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level))), false);
				}
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Black Whip Swing")) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new BlackWhipEntity(AnimeoddyseyModEntities.BLACK_WHIP.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 20, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Black Whip: Pinpoint Focus")) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new BlackWhipPinpointFocusEntity(AnimeoddyseyModEntities.BLACK_WHIP_PINPOINT_FOCUS.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) (15 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
								+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod), 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 6, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 150, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Smokescreen")) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new BlackWhipPinpointFocusEntity(AnimeoddyseyModEntities.BLACK_WHIP_PINPOINT_FOCUS.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) (15 + (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthStat / 5
								+ (entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).StrengthMod), 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 6, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 150, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Smokescreen")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.SMOKESCREEN.get(), 100, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 250, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Transmission")) {
				TransmissionProcedure.execute(world, entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 200, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Gearshift Overdrive")) {
				if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level >= 50) {
					if (!(entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(AnimeoddyseyModMobEffects.GEARSHIFT_OVERDRIVE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.GEARSHIFT_OVERDRIVE.get(), 99999, 0, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 30, 0, false, false));
					} else if (entity instanceof LivingEntity _livEnt64 && _livEnt64.hasEffect(AnimeoddyseyModMobEffects.GEARSHIFT_OVERDRIVE.get())) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(AnimeoddyseyModMobEffects.GEARSHIFT_OVERDRIVE.get());
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 60, 0, false, false));
					}
				} else if ((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level < 50) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7lMust be level 50+ | Current Level: "
								+ new java.text.DecimalFormat("#").format((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).Level))), false);
				}
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeoddyseyModVariables.PlayerVariables())).ActiveMove).equals("Fa Jin")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.COOLDOWN.get(), 100, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AnimeoddyseyModMobEffects.FA_JIN_ACTIVE.get(), 30, 0, false, false));
				{
					String _setval = "";
					entity.getCapability(AnimeoddyseyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ActiveMove = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
