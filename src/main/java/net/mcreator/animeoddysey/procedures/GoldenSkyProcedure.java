package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.entity.FireArrowMobEntity;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class GoldenSkyProcedure {
	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		try {
			if (event.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
				ClientLevel clientLevel = Minecraft.getInstance().level;
				Entity entity = event.getCamera().getEntity();
				execute(null, entity, event);
				event.setCanceled(true);
			}
		} catch (Exception e) {
		}
	}

	public static void execute(Entity entity, ViewportEvent viewport) {
		execute(null, entity, viewport);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent viewport) {
		if (entity == null || viewport == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AnimeoddyseyModMobEffects.HONORED_ONE_SKY.get())) {
			if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
				_renderFog.setNearPlaneDistance(1);
				_renderFog.setFarPlaneDistance(35);
			}
			if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
				_renderFog.setFogShape(FogShape.SPHERE);
			}
		}
		if (entity instanceof FireArrowMobEntity) {
			if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
				_renderFog.setNearPlaneDistance(1);
				_renderFog.setFarPlaneDistance(100);
			}
			if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
				_renderFog.setFogShape(FogShape.SPHERE);
			}
		}
	}
}
