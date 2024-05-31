
package net.mcreator.animeoddysey.client.particle;

import com.mojang.math.Axis;

@OnlyIn(Dist.CLIENT)
public class StarPurpleBigParticle extends TextureSheetParticle {
	public static StarPurpleBigParticleProvider provider(SpriteSet spriteSet) {
		return new StarPurpleBigParticleProvider(spriteSet);
	}

	public static class StarPurpleBigParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public StarPurpleBigParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			StarPurpleBigParticle particle = new StarPurpleBigParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			return particle;
		}
	}

	private final SpriteSet spriteSet;

	protected StarPurpleBigParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(4f, 4f);
		this.quadSize *= 80f;
		this.lifetime = 11;
		this.gravity = 0f;
		this.hasPhysics = true;
		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;
		this.setSpriteFromAge(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 1) % 4 + 1, 4));
		}
	}
}