
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

import net.mcreator.animeoddysey.entity.PsychicBlastEntity;
import net.mcreator.animeoddysey.entity.KnockbackProjectileEntity;
import net.mcreator.animeoddysey.entity.HollowPurpleWeakEntity;
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

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AfterImageEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
	}
}
