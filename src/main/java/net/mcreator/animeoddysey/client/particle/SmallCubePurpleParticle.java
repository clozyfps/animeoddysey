
package net.mcreator.animeoddysey.client.particle;

import com.mojang.math.Axis;

@OnlyIn(Dist.CLIENT)
public class SmallCubePurpleParticle extends TextureSheetParticle {
	public static SmallCubePurpleParticleProvider provider(SpriteSet spriteSet) {
		return new SmallCubePurpleParticleProvider(spriteSet);
	}

	public static class SmallCubePurpleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public SmallCubePurpleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			SmallCubePurpleParticle particle = new SmallCubePurpleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			return particle;
		}
	}

	private final SpriteSet spriteSet;

	protected SmallCubePurpleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(1f, 1f);
		this.quadSize *= 3f;
		this.lifetime = 17;
		this.gravity = 0f;
		this.hasPhysics = true;
		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;
		this.pickSprite(spriteSet);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
	}
}