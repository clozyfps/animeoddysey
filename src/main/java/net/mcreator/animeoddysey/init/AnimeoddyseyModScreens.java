
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.animeoddysey.client.gui.MobPsychoSelectionScreen;
import net.mcreator.animeoddysey.client.gui.MainMenuScreen;
import net.mcreator.animeoddysey.client.gui.MHASelectionScreen;
import net.mcreator.animeoddysey.client.gui.JJKSelectionScreen;
import net.mcreator.animeoddysey.client.gui.JJBASelectionScreen;
import net.mcreator.animeoddysey.client.gui.HxHSelectionScreen;
import net.mcreator.animeoddysey.client.gui.CharacterSelectMainScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeoddyseyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AnimeoddyseyModMenus.HX_H_SELECTION.get(), HxHSelectionScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.CHARACTER_SELECT_MAIN.get(), CharacterSelectMainScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.JJK_SELECTION.get(), JJKSelectionScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.MOB_PSYCHO_SELECTION.get(), MobPsychoSelectionScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.MAIN_MENU.get(), MainMenuScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.MHA_SELECTION.get(), MHASelectionScreen::new);
			MenuScreens.register(AnimeoddyseyModMenus.JJBA_SELECTION.get(), JJBASelectionScreen::new);
		});
	}
}
