package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.init.AnimeoddyseyModMobEffects;
import net.mcreator.animeoddysey.entity.FireArrowMobEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class GoldenSkyRenderProcedure {
	@SubscribeEvent
	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
		try {
			ClientLevel clientLevel = Minecraft.getInstance().level;
			Entity entity = event.getCamera().getEntity();
			execute(null, entity, event);
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
			if (viewport instanceof ViewportEvent.ComputeFogColor _computeFogColor) {
				_computeFogColor.setRed(255 / 255.0F);
				_computeFogColor.setGreen(215 / 255.0F);
				_computeFogColor.setBlue(0 / 255.0F);
			}
		}
		if (entity instanceof FireArrowMobEntity) {
			if (viewport instanceof ViewportEvent.ComputeFogColor _computeFogColor) {
				_computeFogColor.setRed(255 / 255.0F);
				_computeFogColor.setGreen(69 / 255.0F);
				_computeFogColor.setBlue(0 / 255.0F);
			}
		}
	}
}
