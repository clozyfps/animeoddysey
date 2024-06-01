
package net.mcreator.animeoddysey.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.animeoddysey.entity.FireArrowMobEntity;
import net.mcreator.animeoddysey.client.model.Modelfirearrowexplosion;

public class FireArrowMobRenderer extends MobRenderer<FireArrowMobEntity, Modelfirearrowexplosion<FireArrowMobEntity>> {
	public FireArrowMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirearrowexplosion(context.bakeLayer(Modelfirearrowexplosion.LAYER_LOCATION)), 0f);
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
