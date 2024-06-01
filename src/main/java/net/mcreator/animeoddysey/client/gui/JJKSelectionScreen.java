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
	Button button_nanami;
	Button button_sukuna;

	public JJKSelectionScreen(JJKSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 204;
		this.imageHeight = 73;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/jjk_selection.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 11 && mouseX < leftPos + 35 && mouseY > topPos + 5 && mouseY < topPos + 29)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 38 && mouseX < leftPos + 62 && mouseY > topPos + 5 && mouseY < topPos + 29)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 65 && mouseX < leftPos + 89 && mouseY > topPos + 5 && mouseY < topPos + 29)
			guiGraphics.renderTooltip(font, Component.literal(TeenGojoSelectionValueProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 74 && mouseX < leftPos + 98 && mouseY > topPos + 32 && mouseY < topPos + 56)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.jjk_selection.tooltip_ss4sslsukuna_strongest_in_history"), mouseX, mouseY);
		if (mouseX > leftPos + 101 && mouseX < leftPos + 125 && mouseY > topPos + 32 && mouseY < topPos + 56)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.jjk_selection.tooltip_ss4sslsukuna_strongest_in_history1"), mouseX, mouseY);
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
		}).bounds(this.leftPos + 11, this.topPos + 5, 82, 20).build();
		guistate.put("button:button_gojo_teen", button_gojo_teen);
		this.addRenderableWidget(button_gojo_teen);
		button_itadori = Button.builder(Component.translatable("gui.animeoddysey.jjk_selection.button_itadori"), e -> {
		}).bounds(this.leftPos + 101, this.topPos + 5, 61, 20).build();
		guistate.put("button:button_itadori", button_itadori);
		this.addRenderableWidget(button_itadori);
		button_nanami = Button.builder(Component.translatable("gui.animeoddysey.jjk_selection.button_nanami"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new JJKSelectionButtonMessage(2, x, y, z));
				JJKSelectionButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 32, 56, 20).build();
		guistate.put("button:button_nanami", button_nanami);
		this.addRenderableWidget(button_nanami);
		button_sukuna = Button.builder(Component.translatable("gui.animeoddysey.jjk_selection.button_sukuna"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new JJKSelectionButtonMessage(3, x, y, z));
				JJKSelectionButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 74, this.topPos + 32, 56, 20).build();
		guistate.put("button:button_sukuna", button_sukuna);
		this.addRenderableWidget(button_sukuna);
	}
}
