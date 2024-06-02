
package net.mcreator.animeoddysey.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.entity.ElThorEntity;
import net.mcreator.animeoddysey.client.model.ModelElThor;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

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
