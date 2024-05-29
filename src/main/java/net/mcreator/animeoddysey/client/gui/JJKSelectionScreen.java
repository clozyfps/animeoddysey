package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.JJKSelectionMenu;
import net.mcreator.animeoddysey.procedures.TeenGojoSelectionValueProcedure;
import net.mcreator.animeoddysey.network.JJKSelectionButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JJKSelectionScreen extends AbstractContainerScreen<JJKSelectionMenu> {
	private final static HashMap<String, Object> guistate = JJKSelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_gojo_teen;
	Button button_itadori;

	public JJKSelectionScreen(JJKSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 50;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/jjk_selection.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 9 && mouseX < leftPos + 33 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 36 && mouseX < leftPos + 60 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 63 && mouseX < leftPos + 87 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
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
		button_gojo_teen = Button.builder(Component.translatable("gui.animeoddysey.jjk_selection.button_gojo_teen"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new JJKSelectionButtonMessage(0, x, y, z));
				JJKSelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 12, 82, 20).build();
		guistate.put("button:button_gojo_teen", button_gojo_teen);
		this.addRenderableWidget(button_gojo_teen);
		button_itadori = Button.builder(Component.translatable("gui.animeoddysey.jjk_selection.button_itadori"), e -> {
		}).bounds(this.leftPos + 99, this.topPos + 12, 61, 20).build();
		guistate.put("button:button_itadori", button_itadori);
		this.addRenderableWidget(button_itadori);
	}
}
