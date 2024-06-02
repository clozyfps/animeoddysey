
package net.mcreator.animeoddysey.client.particle;

import com.mojang.math.Axis;

@OnlyIn(Dist.CLIENT)
public class Slice2SmallParticle extends TextureSheetParticle {
	public static Slice2SmallParticleProvider provider(SpriteSet spriteSet) {
		return new Slice2SmallParticleProvider(spriteSet);
	}

	public static class Slice2SmallParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public Slice2SmallParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			Slice2SmallParticle particle = new Slice2SmallParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			return particle;
		}
	}

	private final SpriteSet spriteSet;

	protected Slice2SmallParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.05f, 0.2f);
		this.quadSize *= 5f;
		this.lifetime = 1;
		this.gravity = 0f;
		this.hasPhysics = false;
		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
	}
}