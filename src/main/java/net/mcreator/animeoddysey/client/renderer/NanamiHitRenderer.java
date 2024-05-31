
package net.mcreator.animeoddysey.client.renderer;

public class NanamiHitRenderer extends MobRenderer<NanamiHitEntity, ModelHitNanami<NanamiHitEntity>> {

	public NanamiHitRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelHitNanami(context.bakeLayer(ModelHitNanami.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(NanamiHitEntity entity) {
		return new ResourceLocation("animeoddysey:textures/entities/a2ie_layer_2.png");
	}

}
