
package net.mcreator.animeoddysey.client.screens;

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

		if (

		MainHUDDisplayOverlayIngameProcedure.execute(entity)

		) {

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CurrentMoveDisplayProcedure.execute(entity), 13, h - 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					EnergyDisplayProcedure.execute(entity), 13, h - 46, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					CostDisplayProcedure.execute(entity), 13, h - 18, -1, false);

		}

	}

}
