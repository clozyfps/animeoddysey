
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.animeoddysey.client.model.Modelstone;
import net.mcreator.animeoddysey.client.model.Modelsmallcube;
import net.mcreator.animeoddysey.client.model.ModelHitNanami;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AnimeoddyseyModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsmallcube.LAYER_LOCATION, Modelsmallcube::createBodyLayer);
		event.registerLayerDefinition(ModelHitNanami.LAYER_LOCATION, ModelHitNanami::createBodyLayer);
		event.registerLayerDefinition(Modelstone.LAYER_LOCATION, Modelstone::createBodyLayer);
	}
}
