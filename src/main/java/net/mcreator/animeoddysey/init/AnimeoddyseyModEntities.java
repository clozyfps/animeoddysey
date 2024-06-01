
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
import net.mcreator.animeoddysey.entity.PreTimeSkipSasukeEntity;
import net.mcreator.animeoddysey.entity.NanamiHitEntity;
import net.mcreator.animeoddysey.entity.LapseBlueEnityEntity;
import net.mcreator.animeoddysey.entity.KnockbackProjectileEntity;
import net.mcreator.animeoddysey.entity.KilluaZoldyckEntity;
import net.mcreator.animeoddysey.entity.HollowPurpleWeakEntity;
import net.mcreator.animeoddysey.entity.FireballJutsuProjectileEntity;
import net.mcreator.animeoddysey.entity.FireArrowProjectileEntity;
import net.mcreator.animeoddysey.entity.FireArrowMobEntity;
import net.mcreator.animeoddysey.entity.ElThorEntity;
import net.mcreator.animeoddysey.entity.DismantleProjectileEntity;
import net.mcreator.animeoddysey.entity.DetroitSmashEntity;
import net.mcreator.animeoddysey.entity.DelawareSmashEntity;
import net.mcreator.animeoddysey.entity.CleaveProjectileEntity;
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
	public static final RegistryObject<EntityType<LapseBlueEnityEntity>> LAPSE_BLUE_ENITY = register("lapse_blue_enity", EntityType.Builder.<LapseBlueEnityEntity>of(LapseBlueEnityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LapseBlueEnityEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<NanamiHitEntity>> NANAMI_HIT = register("nanami_hit",
			EntityType.Builder.<NanamiHitEntity>of(NanamiHitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NanamiHitEntity::new)

					.sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<ElThorEntity>> EL_THOR = register("el_thor",
			EntityType.Builder.<ElThorEntity>of(ElThorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ElThorEntity::new).fireImmune().sized(0.6f, 8f));
	public static final RegistryObject<EntityType<FireballJutsuProjectileEntity>> FIREBALL_JUTSU_PROJECTILE = register("projectile_fireball_jutsu_projectile",
			EntityType.Builder.<FireballJutsuProjectileEntity>of(FireballJutsuProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FireballJutsuProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PreTimeSkipSasukeEntity>> PRE_TIME_SKIP_SASUKE = register("pre_time_skip_sasuke",
			EntityType.Builder.<PreTimeSkipSasukeEntity>of(PreTimeSkipSasukeEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PreTimeSkipSasukeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DismantleProjectileEntity>> DISMANTLE_PROJECTILE = register("projectile_dismantle_projectile", EntityType.Builder.<DismantleProjectileEntity>of(DismantleProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(DismantleProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CleaveProjectileEntity>> CLEAVE_PROJECTILE = register("projectile_cleave_projectile", EntityType.Builder.<CleaveProjectileEntity>of(CleaveProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(CleaveProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FireArrowMobEntity>> FIRE_ARROW_MOB = register("fire_arrow_mob", EntityType.Builder.<FireArrowMobEntity>of(FireArrowMobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireArrowMobEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FireArrowProjectileEntity>> FIRE_ARROW_PROJECTILE = register("projectile_fire_arrow_projectile", EntityType.Builder.<FireArrowProjectileEntity>of(FireArrowProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FireArrowProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AfterImageEntity.init();
			KilluaZoldyckEntity.init();
			ShigeoKageyamaEntity.init();
			LapseBlueEnityEntity.init();
			NanamiHitEntity.init();
			ElThorEntity.init();
			PreTimeSkipSasukeEntity.init();
			FireArrowMobEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
		event.put(KILLUA_ZOLDYCK.get(), KilluaZoldyckEntity.createAttributes().build());
		event.put(SHIGEO_KAGEYAMA.get(), ShigeoKageyamaEntity.createAttributes().build());
		event.put(LAPSE_BLUE_ENITY.get(), LapseBlueEnityEntity.createAttributes().build());
		event.put(NANAMI_HIT.get(), NanamiHitEntity.createAttributes().build());
		event.put(EL_THOR.get(), ElThorEntity.createAttributes().build());
		event.put(PRE_TIME_SKIP_SASUKE.get(), PreTimeSkipSasukeEntity.createAttributes().build());
		event.put(FIRE_ARROW_MOB.get(), FireArrowMobEntity.createAttributes().build());
	}
}
