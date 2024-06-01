package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.MHASelectionMenu;
import net.mcreator.animeoddysey.network.MHASelectionButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MHASelectionScreen extends AbstractContainerScreen<MHASelectionMenu> {
	private final static HashMap<String, Object> guistate = MHASelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_deku;
	Button button_neito;

	public MHASelectionScreen(MHASelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 50;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/mha_selection.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 9 && mouseX < leftPos + 33 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.mha_selection.tooltip_ssassldeku_successor_strength"), mouseX, mouseY);
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.mha_selection.tooltip_ssassldeku_successor_strength1"), mouseX, mouseY);
		if (mouseX > leftPos + 61 && mouseX < leftPos + 85 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.mha_selection.tooltip_special_energy_kit"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 110 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.mha_selection.tooltip_ss6sslneito_special_energy_kit"), mouseX, mouseY);
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
		button_deku = Button.builder(Component.translatable("gui.animeoddysey.mha_selection.button_deku"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MHASelectionButtonMessage(0, x, y, z));
				MHASelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 12, 46, 20).build();
		guistate.put("button:button_deku", button_deku);
		this.addRenderableWidget(button_deku);
		button_neito = Button.builder(Component.translatable("gui.animeoddysey.mha_selection.button_neito"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MHASelectionButtonMessage(1, x, y, z));
				MHASelectionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 12, 51, 20).build();
		guistate.put("button:button_neito", button_neito);
		this.addRenderableWidget(button_neito);
	}
}
