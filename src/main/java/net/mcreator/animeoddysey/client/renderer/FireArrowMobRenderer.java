
package net.mcreator.animeoddysey.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.animeoddysey.entity.FireArrowMobEntity;
import net.mcreator.animeoddysey.client.model.Modelfirearrowexplosion;

import com.mojang.blaze3d.vertex.PoseStack;

public class FireArrowMobRenderer extends MobRenderer<FireArrowMobEntity, Modelfirearrowexplosion<FireArrowMobEntity>> {
	public FireArrowMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirearrowexplosion(context.bakeLayer(Modelfirearrowexplosion.LAYER_LOCATION)), 0f);
	}

	@Override
	protected void scale(FireArrowMobEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(5f, 5f, 5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FireArrowMobEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/firearrowexplosion.png");
	}

	@Override
	protected boolean isBodyVisible(FireArrowMobEntity entity) {
		return false;
	}
}
