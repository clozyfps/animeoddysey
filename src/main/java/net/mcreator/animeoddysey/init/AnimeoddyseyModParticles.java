
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.animeoddysey.client.particle.RedElectricityParticle;
import net.mcreator.animeoddysey.client.particle.ElectricityParticleParticle;
import net.mcreator.animeoddysey.client.particle.BlackElectricityParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeoddyseyModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLACK_ELECTRICITY.get(), BlackElectricityParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.ELECTRICITY_PARTICLE.get(), ElectricityParticleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RED_ELECTRICITY.get(), RedElectricityParticle::provider);
	}
}
