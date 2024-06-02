
package net.mcreator.animeoddysey.client.renderer;

public class ElThorRenderer extends MobRenderer<ElThorEntity, ModelElThor<ElThorEntity>> {

	public ElThorRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelElThor(context.bakeLayer(ModelElThor.LAYER_LOCATION)), 0.5f);

		this.addLayer(new RenderLayer<ElThorEntity, ModelElThor<ElThorEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("animeoddysey:textures/entities/elthor.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ElThorEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new ModelElThor(Minecraft.getInstance().getEntityModels().bakeLayer(ModelElThor.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, 15728640, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ElThorEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/elthor.png");
	}

}
