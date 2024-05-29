
package net.mcreator.animeoddysey.client.particle;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.client.model.Modelstone;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;

@OnlyIn(Dist.CLIENT)
public class StoneParticlePreParticle extends TextureSheetParticle {
	public static StoneParticlePreParticleProvider provider(SpriteSet spriteSet) {
		return new StoneParticlePreParticleProvider(spriteSet);
	}

	public static class StoneParticlePreParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public StoneParticlePreParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			StoneParticlePreParticle particle = new StoneParticlePreParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			class StoneParticlePreRenderSequence {
				private ClientLevel world;

				private class StoneParticlePreRenderer {
					public EntityModel model = new Modelstone(Minecraft.getInstance().getEntityModels().bakeLayer(Modelstone.LAYER_LOCATION));

					public StoneParticlePreRenderer() {
						MinecraftForge.EVENT_BUS.register(this);
					}

					private float scale = (float) 1;
					private int rotX = (int) 0;
					private int rotY = (int) 0;
					private int rotZ = (int) 0;

					@SubscribeEvent
					public void render(RenderLevelStageEvent event) {
						if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
							VertexConsumer consumer = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation("animeoddysey:textures/particle/stone_particle_pre.png")));
							Vec3 camPos = event.getCamera().getPosition();
							double x = Mth.lerp(event.getPartialTick(), particle.xo, particle.x) - camPos.x();
							double y = Mth.lerp(event.getPartialTick(), particle.yo, particle.y) - camPos.y();
							double z = Mth.lerp(event.getPartialTick(), particle.zo, particle.z) - camPos.z();
							event.getPoseStack().pushPose();
							event.getPoseStack().translate(x, y, z);
							event.getPoseStack().mulPose(Axis.XP.rotationDegrees(180));
							event.getPoseStack().scale(scale, scale, scale);
							event.getPoseStack().mulPose(Axis.XP.rotationDegrees(rotX));
							event.getPoseStack().mulPose(Axis.YP.rotationDegrees(rotY));
							event.getPoseStack().mulPose(Axis.ZP.rotationDegrees(rotZ));
							model.renderToBuffer(event.getPoseStack(), consumer, particle.getLightColor(event.getPartialTick()), OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
							event.getPoseStack().popPose();
						}
					}
				}

				private StoneParticlePreRenderer renderer;

				public void start(ClientLevel world) {
					this.renderer = new StoneParticlePreRenderer();
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ClientTickEvent event) {
					if (!particle.isAlive())
						end();
				}

				private void end() {
					MinecraftForge.EVENT_BUS.unregister(renderer);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}
			StoneParticlePreRenderSequence sequence = new StoneParticlePreRenderSequence();
			sequence.start(worldIn);
			return particle;
		}
	}

	private final SpriteSet spriteSet;

	protected StoneParticlePreParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(2f, 2f);
		this.quadSize *= 3f;
		this.lifetime = 60;
		this.gravity = 1f;
		this.hasPhysics = true;
		this.xd = vx * 1;
		this.yd = vy * 1;
		this.zd = vz * 1;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.NO_RENDER;
	}

	@Override
	public void tick() {
		super.tick();
	}
}
