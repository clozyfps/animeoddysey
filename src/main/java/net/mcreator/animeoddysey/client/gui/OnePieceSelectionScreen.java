package net.mcreator.animeoddysey.client.gui;

public class OnePieceSelectionScreen extends AbstractContainerScreen<OnePieceSelectionMenu> {

	private final static HashMap<String, Object> guistate = OnePieceSelectionMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_gojo_teen;

	public OnePieceSelectionScreen(OnePieceSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 50;
	}

	private static final ResourceLocation texture = new ResourceLocation("animeoddysey:textures/screens/one_piece_selection.png");

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

		button_gojo_teen = Button.builder(Component.translatable("gui.animeoddysey.one_piece_selection.button_gojo_teen"), e -> {
			if (true) {
				AnimeoddyseyMod.PACKET_HANDLER.sendToServer(new OnePieceSelectionButtonMessage(0, x, y, z));
				OnePieceSelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 12, 36, 20).build();

		guistate.put("button:button_gojo_teen", button_gojo_teen);
		this.addRenderableWidget(button_gojo_teen);

	}

}
