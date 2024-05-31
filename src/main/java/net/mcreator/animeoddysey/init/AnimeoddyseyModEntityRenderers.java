
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.animeoddysey.client.renderer.ShigeoKageyamaRenderer;
import net.mcreator.animeoddysey.client.renderer.NanamiHitRenderer;
import net.mcreator.animeoddysey.client.renderer.LapseBlueEnityRenderer;
import net.mcreator.animeoddysey.client.renderer.KilluaZoldyckRenderer;
import net.mcreator.animeoddysey.client.renderer.AfterImageRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeoddyseyModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AnimeoddyseyModEntities.HOLLOW_PURPLE_WEAK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.AFTER_IMAGE.get(), AfterImageRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.KNOCKBACK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.PSYCHIC_BLAST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.PSYCHIC_SLASH.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.KILLUA_ZOLDYCK.get(), KilluaZoldyckRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.DETROIT_SMASH.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.DELAWARE_SMASH.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.BLACK_WHIP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.BLACK_WHIP_PINPOINT_FOCUS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.SHIGEO_KAGEYAMA.get(), ShigeoKageyamaRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.LAPSE_BLUE_ENITY.get(), LapseBlueEnityRenderer::new);
		event.registerEntityRenderer(AnimeoddyseyModEntities.NANAMI_HIT.get(), NanamiHitRenderer::new);
	}
}
