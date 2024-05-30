
package net.mcreator.animeoddysey.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.animeoddysey.entity.ShigeoKageyamaEntity;

public class ShigeoKageyamaRenderer extends HumanoidMobRenderer<ShigeoKageyamaEntity, HumanoidModel<ShigeoKageyamaEntity>> {
	public ShigeoKageyamaRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(ShigeoKageyamaEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/shigeo_kageyama.png");
	}
}
