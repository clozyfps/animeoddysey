
package net.mcreator.animeoddysey.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PsychicBlastEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public PsychicBlastEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(AnimeoddyseyModEntities.PSYCHIC_BLAST.get(), world);
	}

	public PsychicBlastEntity(EntityType<? extends PsychicBlastEntity> type, Level world) {
		super(type, world);
	}

	public PsychicBlastEntity(EntityType<? extends PsychicBlastEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PsychicBlastEntity(EntityType<? extends PsychicBlastEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		PsychicBlastWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this.getOwner(), this);
		if (this.inGround)
			this.discard();
	}

	public static PsychicBlastEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 2f, 5, 5);
	}

	public static PsychicBlastEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PsychicBlastEntity entityarrow = new PsychicBlastEntity(AnimeoddyseyModEntities.PSYCHIC_BLAST.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static PsychicBlastEntity shoot(LivingEntity entity, LivingEntity target) {
		PsychicBlastEntity entityarrow = new PsychicBlastEntity(AnimeoddyseyModEntities.PSYCHIC_BLAST.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
