
package net.mcreator.animeoddysey.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class DismantleProjectileHUEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public DismantleProjectileHUEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(AnimeoddyseyModEntities.DISMANTLE_PROJECTILE_HU.get(), world);
	}

	public DismantleProjectileHUEntity(EntityType<? extends DismantleProjectileHUEntity> type, Level world) {
		super(type, world);
	}

	public DismantleProjectileHUEntity(EntityType<? extends DismantleProjectileHUEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public DismantleProjectileHUEntity(EntityType<? extends DismantleProjectileHUEntity> type, LivingEntity entity, Level world) {
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
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		DismantleProjectileHUProjectileHitsLivingEntityProcedure.execute(this.level(), entity, this);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		DismantleProjectileHUProjectileHitsLivingEntityProcedure.execute(this.level(), entityHitResult.getEntity(), this);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		DismantleProjectileHUProjectileHitsLivingEntityProcedure.execute(this.level(), this.getOwner(), this);
	}

	@Override
	public void tick() {
		super.tick();
		DismantleProjectileHUWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		if (this.inGround)
			this.discard();
	}

	public static DismantleProjectileHUEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 2f, 5, 0);
	}

	public static DismantleProjectileHUEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		DismantleProjectileHUEntity entityarrow = new DismantleProjectileHUEntity(AnimeoddyseyModEntities.DISMANTLE_PROJECTILE_HU.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static DismantleProjectileHUEntity shoot(LivingEntity entity, LivingEntity target) {
		DismantleProjectileHUEntity entityarrow = new DismantleProjectileHUEntity(AnimeoddyseyModEntities.DISMANTLE_PROJECTILE_HU.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
