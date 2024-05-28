
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AnimeoddyseyMod.MODID);
	public static final RegistryObject<SimpleParticleType> BLACK_ELECTRICITY = REGISTRY.register("black_electricity", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ELECTRICITY_PARTICLE = REGISTRY.register("electricity_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> RED_ELECTRICITY = REGISTRY.register("red_electricity", () -> new SimpleParticleType(true));
}
