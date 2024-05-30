
package net.mcreator.animeoddysey.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.procedures.MainHUDDisplayOverlayIngameProcedure;
import net.mcreator.animeoddysey.procedures.ImageDisplayConditionProcedure;
import net.mcreator.animeoddysey.procedures.EnergyDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CurrentMoveDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CostDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CooldownCounterDisplayProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class MainHUDOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (MainHUDDisplayOverlayIngameProcedure.execute(entity)) {
			if (ImageDisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("animeoddysey:textures/screens/x.png"), 13, h - 66, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CurrentMoveDisplayProcedure.execute(entity), 13, h - 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					EnergyDisplayProcedure.execute(entity), 13, h - 46, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CostDisplayProcedure.execute(entity), 13, h - 18, -1, false);
			if (ImageDisplayConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						CooldownCounterDisplayProcedure.execute(entity), 17, h - 63, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
