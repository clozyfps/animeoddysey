package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.MainMenuMenu;
import net.mcreator.animeoddysey.procedures.StrengthDisplayProcedure;
import net.mcreator.animeoddysey.procedures.SPValueProcedure;
import net.mcreator.animeoddysey.procedures.RankValueProcedure;
import net.mcreator.animeoddysey.procedures.LevelValueProcedure;
import net.mcreator.animeoddysey.procedures.EnergyValueProcedure;
import net.mcreator.animeoddysey.procedures.DefenseDisplayProcedure;
import net.mcreator.animeoddysey.procedures.AgilityDisplayProcedure;
import net.mcreator.animeoddysey.network.MainMenuButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MainMenuScreen extends AbstractContainerScreen<MainMenuMenu> {
	private final static HashMap<String, Object> guistate = MainMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssl;
	Button button_ssl1;
	Button button_ssl2;
	Button button_ssl3;

	public MainMenuScreen(MainMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/main_menu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				StrengthDisplayProcedure.execute(entity), -208, 25, -1, false);
		guiGraphics.drawString(this.font,

				DefenseDisplayProcedure.execute(entity), -208, 43, -1, false);
		guiGraphics.drawString(this.font,

				AgilityDisplayProcedure.execute(entity), -208, 61, -1, false);
		guiGraphics.drawString(this.font,

				EnergyValueProcedure.execute(entity), -208, 79, -1, false);
		guiGraphics.drawString(this.font,

				RankValueProcedure.execute(entity), -208, 106, -1, false);
		guiGraphics.drawString(this.font,

				LevelValueProcedure.execute(entity), -208, -11, -1, false);
		guiGraphics.drawString(this.font,

				SPValueProcedure.execute(entity), -208, 7, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_ssl = new PlainTextButton(this.leftPos + -118, this.topPos + 25, 40, 20, Component.translatable("gui.animeoddysey.main_menu.button_ssl"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MainMenuButtonMessage(0, x, y, z));
				MainMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssl", button_ssl);
		this.addRenderableWidget(button_ssl);
		button_ssl1 = new PlainTextButton(this.leftPos + -118, this.topPos + 43, 40, 20, Component.translatable("gui.animeoddysey.main_menu.button_ssl1"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MainMenuButtonMessage(1, x, y, z));
				MainMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssl1", button_ssl1);
		this.addRenderableWidget(button_ssl1);
		button_ssl2 = new PlainTextButton(this.leftPos + -118, this.topPos + 61, 40, 20, Component.translatable("gui.animeoddysey.main_menu.button_ssl2"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MainMenuButtonMessage(2, x, y, z));
				MainMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssl2", button_ssl2);
		this.addRenderableWidget(button_ssl2);
		button_ssl3 = new PlainTextButton(this.leftPos + -118, this.topPos + 79, 40, 20, Component.translatable("gui.animeoddysey.main_menu.button_ssl3"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MainMenuButtonMessage(3, x, y, z));
				MainMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssl3", button_ssl3);
		this.addRenderableWidget(button_ssl3);
	}
}
