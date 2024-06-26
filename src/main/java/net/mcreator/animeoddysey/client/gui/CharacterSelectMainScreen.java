package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.CharacterSelectMainMenu;
import net.mcreator.animeoddysey.network.CharacterSelectMainButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CharacterSelectMainScreen extends AbstractContainerScreen<CharacterSelectMainMenu> {
	private final static HashMap<String, Object> guistate = CharacterSelectMainMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hxh;
	Button button_hxh1;
	Button button_hxh2;
	Button button_hxh3;
	Button button_jjba;
	Button button_op;
	Button button_na;

	public CharacterSelectMainScreen(CharacterSelectMainMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 204;
		this.imageHeight = 75;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/character_select_main.png");

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_hxh = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_hxh"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(0, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 6, 40, 20).build();
		guistate.put("button:button_hxh", button_hxh);
		this.addRenderableWidget(button_hxh);
		button_hxh1 = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_hxh1"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(1, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 56, this.topPos + 6, 40, 20).build();
		guistate.put("button:button_hxh1", button_hxh1);
		this.addRenderableWidget(button_hxh1);
		button_hxh2 = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_hxh2"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(2, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 6, 40, 20).build();
		guistate.put("button:button_hxh2", button_hxh2);
		this.addRenderableWidget(button_hxh2);
		button_hxh3 = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_hxh3"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(3, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 146, this.topPos + 6, 40, 20).build();
		guistate.put("button:button_hxh3", button_hxh3);
		this.addRenderableWidget(button_hxh3);
		button_jjba = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_jjba"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(4, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 30, 40, 20).build();
		guistate.put("button:button_jjba", button_jjba);
		this.addRenderableWidget(button_jjba);
		button_op = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_op"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(5, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 56, this.topPos + 30, 40, 20).build();
		guistate.put("button:button_op", button_op);
		this.addRenderableWidget(button_op);
		button_na = Button.builder(Component.translatable("gui.animeoddysey.character_select_main.button_na"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new CharacterSelectMainButtonMessage(6, x, y, z));
				CharacterSelectMainButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 102, this.topPos + 30, 39, 20).build();
		guistate.put("button:button_na", button_na);
		this.addRenderableWidget(button_na);
	}
}
