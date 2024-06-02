
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.animeoddysey.client.particle.WhiteParticlesParticle;
import net.mcreator.animeoddysey.client.particle.StoneParticlePreParticle;
import net.mcreator.animeoddysey.client.particle.StarPurpleParticle;
import net.mcreator.animeoddysey.client.particle.StarPurpleBigParticle;
import net.mcreator.animeoddysey.client.particle.SmallCubeRedParticle;
import net.mcreator.animeoddysey.client.particle.SmallCubePurpleParticle;
import net.mcreator.animeoddysey.client.particle.Slice3SmallParticle;
import net.mcreator.animeoddysey.client.particle.Slice3Particle;
import net.mcreator.animeoddysey.client.particle.Slice2SmallParticle;
import net.mcreator.animeoddysey.client.particle.Slice2Particle;
import net.mcreator.animeoddysey.client.particle.Slice1SmallParticle;
import net.mcreator.animeoddysey.client.particle.Slice1Particle;
import net.mcreator.animeoddysey.client.particle.SharinganAnimParticle;
import net.mcreator.animeoddysey.client.particle.RedParticle;
import net.mcreator.animeoddysey.client.particle.RedElectricityParticle;
import net.mcreator.animeoddysey.client.particle.RedAnimParticle;
import net.mcreator.animeoddysey.client.particle.Red2Particle;
import net.mcreator.animeoddysey.client.particle.RatioHitParticle;
import net.mcreator.animeoddysey.client.particle.PurpleSmokeParticle;
import net.mcreator.animeoddysey.client.particle.OneForAllSparksParticle;
import net.mcreator.animeoddysey.client.particle.LapseBlueMaxParticle;
import net.mcreator.animeoddysey.client.particle.LapseBlueMax2Particle;
import net.mcreator.animeoddysey.client.particle.FullCrowlingParticle;
import net.mcreator.animeoddysey.client.particle.FugaParicleParticle;
import net.mcreator.animeoddysey.client.particle.FireArrowParticleParticle;
import net.mcreator.animeoddysey.client.particle.FaJinBlitzParticle;
import net.mcreator.animeoddysey.client.particle.ElectrisityParticleSmallParticle;
import net.mcreator.animeoddysey.client.particle.ElectricityParticleParticle;
import net.mcreator.animeoddysey.client.particle.ElThorElectrisityParticle;
import net.mcreator.animeoddysey.client.particle.ChidoriParticleParticle;
import net.mcreator.animeoddysey.client.particle.BlueflashParticle;
import net.mcreator.animeoddysey.client.particle.BlueAnimParticle;
import net.mcreator.animeoddysey.client.particle.BlackFlashParticleParticle;
import net.mcreator.animeoddysey.client.particle.BlackFlashBigParticle;
import net.mcreator.animeoddysey.client.particle.BlackElectricityParticle;
import net.mcreator.animeoddysey.client.particle.AirPulseParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeoddyseyModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLACK_ELECTRICITY.get(), BlackElectricityParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.ELECTRICITY_PARTICLE.get(), ElectricityParticleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RED_ELECTRICITY.get(), RedElectricityParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.LAPSE_BLUE_MAX.get(), LapseBlueMaxParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.LAPSE_BLUE_MAX_2.get(), LapseBlueMax2Particle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RED_2.get(), Red2Particle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RED.get(), RedParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLUEFLASH.get(), BlueflashParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RED_ANIM.get(), RedAnimParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.STONE_PARTICLE_PRE.get(), StoneParticlePreParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SMALL_CUBE_RED.get(), SmallCubeRedParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SMALL_CUBE_PURPLE.get(), SmallCubePurpleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.AIR_PULSE.get(), AirPulseParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.ONE_FOR_ALL_SPARKS.get(), OneForAllSparksParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.PURPLE_SMOKE.get(), PurpleSmokeParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.FA_JIN_BLITZ.get(), FaJinBlitzParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.FULL_CROWLING.get(), FullCrowlingParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLUE_ANIM.get(), BlueAnimParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.STAR_PURPLE.get(), StarPurpleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.STAR_PURPLE_BIG.get(), StarPurpleBigParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.RATIO_HIT.get(), RatioHitParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLACK_FLASH_PARTICLE.get(), BlackFlashParticleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.BLACK_FLASH_BIG.get(), BlackFlashBigParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SHARINGAN_ANIM.get(), SharinganAnimParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.EL_THOR_ELECTRISITY.get(), ElThorElectrisityParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.CHIDORI_PARTICLE.get(), ChidoriParticleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_1.get(), Slice1Particle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_2.get(), Slice2Particle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_3.get(), Slice3Particle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.FIRE_ARROW_PARTICLE.get(), FireArrowParticleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_1_SMALL.get(), Slice1SmallParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_2_SMALL.get(), Slice2SmallParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.SLICE_3_SMALL.get(), Slice3SmallParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.FUGA_PARICLE.get(), FugaParicleParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.ELECTRISITY_PARTICLE_SMALL.get(), ElectrisityParticleSmallParticle::provider);
		event.registerSpriteSet(AnimeoddyseyModParticleTypes.WHITE_PARTICLES.get(), WhiteParticlesParticle::provider);
	}
}
