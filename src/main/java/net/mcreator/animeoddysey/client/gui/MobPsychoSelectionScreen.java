package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.MobPsychoSelectionMenu;
import net.mcreator.animeoddysey.network.MobPsychoSelectionButtonMessage;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MobPsychoSelectionScreen extends AbstractContainerScreen<MobPsychoSelectionMenu> {
	private final static HashMap<String, Object> guistate = MobPsychoSelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_mob;

	public MobPsychoSelectionScreen(MobPsychoSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 50;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/mob_psycho_selection.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 18 && mouseX < leftPos + 42 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.animeoddysey.mob_psycho_selection.tooltip_ssbsslkillua_zoldyck_assassin"), mouseX, mouseY);
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
		button_mob = Button.builder(Component.translatable("gui.animeoddysey.mob_psycho_selection.button_mob"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new MobPsychoSelectionButtonMessage(0, x, y, z));
				MobPsychoSelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 12, 40, 20).build();
		guistate.put("button:button_mob", button_mob);
		this.addRenderableWidget(button_mob);
	}
}
