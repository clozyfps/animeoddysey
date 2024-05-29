
package net.mcreator.animeoddysey.client.particle;

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
			return new StoneParticlePreParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
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
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
	}
}