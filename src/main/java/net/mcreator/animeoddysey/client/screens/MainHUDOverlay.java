
package net.mcreator.animeoddysey.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.procedures.StoredCharacterDisplayProcedure;
import net.mcreator.animeoddysey.procedures.MainHUDDisplayOverlayIngameProcedure;
import net.mcreator.animeoddysey.procedures.ImageDisplayConditionProcedure;
import net.mcreator.animeoddysey.procedures.EnergyDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CurrentMoveDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CostDisplayProcedure;
import net.mcreator.animeoddysey.procedures.CooldownCounterDisplayProcedure;

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
		if (MainHUDDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CurrentMoveDisplayProcedure.execute(entity), 13, h - 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					EnergyDisplayProcedure.execute(entity), 13, h - 46, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CostDisplayProcedure.execute(entity), 13, h - 18, -1, false);
			if (ImageDisplayConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						CooldownCounterDisplayProcedure.execute(entity), 14, h - 63, -65536, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					StoredCharacterDisplayProcedure.execute(entity), w / 2 + 92, h - 12, -1, false);
		}
	}
}
