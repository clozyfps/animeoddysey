
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.animeoddysey.entity.ShigeoKageyamaEntity;
import net.mcreator.animeoddysey.entity.PsychicSlashEntity;
import net.mcreator.animeoddysey.entity.PsychicBlastEntity;
import net.mcreator.animeoddysey.entity.KnockbackProjectileEntity;
import net.mcreator.animeoddysey.entity.KilluaZoldyckEntity;
import net.mcreator.animeoddysey.entity.HollowPurpleWeakEntity;
import net.mcreator.animeoddysey.entity.DetroitSmashEntity;
import net.mcreator.animeoddysey.entity.DelawareSmashEntity;
import net.mcreator.animeoddysey.entity.BlackWhipPinpointFocusEntity;
import net.mcreator.animeoddysey.entity.BlackWhipEntity;
import net.mcreator.animeoddysey.entity.AfterImageEntity;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimeoddyseyModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AnimeoddyseyMod.MODID);
	public static final RegistryObject<EntityType<HollowPurpleWeakEntity>> HOLLOW_PURPLE_WEAK = register("projectile_hollow_purple_weak", EntityType.Builder.<HollowPurpleWeakEntity>of(HollowPurpleWeakEntity::new, MobCategory.MISC)
			.setCustomClientFactory(HollowPurpleWeakEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AfterImageEntity>> AFTER_IMAGE = register("after_image",
			EntityType.Builder.<AfterImageEntity>of(AfterImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AfterImageEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnockbackProjectileEntity>> KNOCKBACK_PROJECTILE = register("projectile_knockback_projectile", EntityType.Builder.<KnockbackProjectileEntity>of(KnockbackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(KnockbackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PsychicBlastEntity>> PSYCHIC_BLAST = register("projectile_psychic_blast",
			EntityType.Builder.<PsychicBlastEntity>of(PsychicBlastEntity::new, MobCategory.MISC).setCustomClientFactory(PsychicBlastEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PsychicSlashEntity>> PSYCHIC_SLASH = register("projectile_psychic_slash",
			EntityType.Builder.<PsychicSlashEntity>of(PsychicSlashEntity::new, MobCategory.MISC).setCustomClientFactory(PsychicSlashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KilluaZoldyckEntity>> KILLUA_ZOLDYCK = register("killua_zoldyck",
			EntityType.Builder.<KilluaZoldyckEntity>of(KilluaZoldyckEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KilluaZoldyckEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DetroitSmashEntity>> DETROIT_SMASH = register("projectile_detroit_smash",
			EntityType.Builder.<DetroitSmashEntity>of(DetroitSmashEntity::new, MobCategory.MISC).setCustomClientFactory(DetroitSmashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DelawareSmashEntity>> DELAWARE_SMASH = register("projectile_delaware_smash",
			EntityType.Builder.<DelawareSmashEntity>of(DelawareSmashEntity::new, MobCategory.MISC).setCustomClientFactory(DelawareSmashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlackWhipEntity>> BLACK_WHIP = register("projectile_black_whip",
			EntityType.Builder.<BlackWhipEntity>of(BlackWhipEntity::new, MobCategory.MISC).setCustomClientFactory(BlackWhipEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlackWhipPinpointFocusEntity>> BLACK_WHIP_PINPOINT_FOCUS = register("projectile_black_whip_pinpoint_focus",
			EntityType.Builder.<BlackWhipPinpointFocusEntity>of(BlackWhipPinpointFocusEntity::new, MobCategory.MISC).setCustomClientFactory(BlackWhipPinpointFocusEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShigeoKageyamaEntity>> SHIGEO_KAGEYAMA = register("shigeo_kageyama",
			EntityType.Builder.<ShigeoKageyamaEntity>of(ShigeoKageyamaEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShigeoKageyamaEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AfterImageEntity.init();
			KilluaZoldyckEntity.init();
			ShigeoKageyamaEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
		event.put(KILLUA_ZOLDYCK.get(), KilluaZoldyckEntity.createAttributes().build());
		event.put(SHIGEO_KAGEYAMA.get(), ShigeoKageyamaEntity.createAttributes().build());
	}
}
