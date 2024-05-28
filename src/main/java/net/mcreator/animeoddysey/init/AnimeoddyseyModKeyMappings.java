
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.animeoddysey.network.UseSkillMessage;
import net.mcreator.animeoddysey.network.TalentMessage;
import net.mcreator.animeoddysey.network.SwitchSkillMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AnimeoddyseyModKeyMappings {
	public static final KeyMapping USE_SKILL = new KeyMapping("key.animeoddysey.use_skill", GLFW.GLFW_KEY_X, "key.categories.animeoddysey") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new UseSkillMessage(0, 0));
				UseSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_SKILL = new KeyMapping("key.animeoddysey.switch_skill", GLFW.GLFW_KEY_R, "key.categories.animeoddysey") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new SwitchSkillMessage(0, 0));
				SwitchSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TALENT = new KeyMapping("key.animeoddysey.talent", GLFW.GLFW_KEY_C, "key.categories.animeoddysey") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new TalentMessage(0, 0));
				TalentMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TALENT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TALENT_LASTPRESS);
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new TalentMessage(1, dt));
				TalentMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long TALENT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(USE_SKILL);
		event.register(SWITCH_SKILL);
		event.register(TALENT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				USE_SKILL.consumeClick();
				SWITCH_SKILL.consumeClick();
				TALENT.consumeClick();
			}
		}
	}
}
