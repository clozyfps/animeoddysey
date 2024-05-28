
package net.mcreator.animeoddysey.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.animeoddysey.entity.AfterImageEntity;

public class AfterImageRenderer extends HumanoidMobRenderer<AfterImageEntity, HumanoidModel<AfterImageEntity>> {
	public AfterImageRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(AfterImageEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/whiteimage.png");
	}

	@Override
	protected boolean isBodyVisible(AfterImageEntity entity) {
		return false;
	}
}
