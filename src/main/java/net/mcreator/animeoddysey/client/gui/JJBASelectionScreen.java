package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.JJBASelectionMenu;
import net.mcreator.animeoddysey.network.JJBASelectionButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JJBASelectionScreen extends AbstractContainerScreen<JJBASelectionMenu> {
	private final static HashMap<String, Object> guistate = JJBASelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_gojo_teen;
	Button button_dio_vampire;

	public JJBASelectionScreen(JJBASelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 50;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/jjba_selection.png");

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
		button_gojo_teen = Button.builder(Component.translatable("gui.animeoddysey.jjba_selection.button_gojo_teen"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new JJBASelectionButtonMessage(0, x, y, z));
				JJBASelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 12, 82, 20).build();
		guistate.put("button:button_gojo_teen", button_gojo_teen);
		this.addRenderableWidget(button_gojo_teen);
		button_dio_vampire = Button.builder(Component.translatable("gui.animeoddysey.jjba_selection.button_dio_vampire"), e -> {
		}).bounds(this.leftPos + 99, this.topPos + 12, 93, 20).build();
		guistate.put("button:button_dio_vampire", button_dio_vampire);
		this.addRenderableWidget(button_dio_vampire);
	}
}
