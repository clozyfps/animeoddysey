package net.mcreator.animeoddysey.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.animeoddysey.world.inventory.MainMenuMenu;
import net.mcreator.animeoddysey.procedures.StrengthDisplayProcedure;
import net.mcreator.animeoddysey.procedures.SPValueProcedure;
import net.mcreator.animeoddysey.procedures.RankValueProcedure;
import net.mcreator.animeoddysey.procedures.LevelValueProcedure;
import net.mcreator.animeoddysey.procedures.EnergyValueProcedure;
import net.mcreator.animeoddysey.procedures.DefenseDisplayProcedure;
import net.mcreator.animeoddysey.procedures.AgilityDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MainMenuScreen extends AbstractContainerScreen<MainMenuMenu> {
	private final static HashMap<String, Object> guistate = MainMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

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
	}
}
