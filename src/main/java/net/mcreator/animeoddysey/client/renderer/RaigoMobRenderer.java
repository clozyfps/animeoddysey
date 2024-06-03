
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

import net.mcreator.animeoddysey.entity.RaigoMobEntity;
import net.mcreator.animeoddysey.client.model.ModelRaigo;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class RaigoMobRenderer extends MobRenderer<RaigoMobEntity, ModelRaigo<RaigoMobEntity>> {
	public RaigoMobRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRaigo(context.bakeLayer(ModelRaigo.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<RaigoMobEntity, ModelRaigo<RaigoMobEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("animeoddysey:textures/entities/raigo.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, RaigoMobEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new ModelRaigo(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRaigo.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, 15728640, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(RaigoMobEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(3f, 3f, 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(RaigoMobEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/raigo.png");
	}
}
