
package net.mcreator.animeoddysey.client.renderer;

public class KilluaZoldyckRenderer extends HumanoidMobRenderer<KilluaZoldyckEntity, HumanoidModel<KilluaZoldyckEntity>> {

	public KilluaZoldyckRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(KilluaZoldyckEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/killua_zoldyck.png");
	}

}
