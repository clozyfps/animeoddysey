package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NanamiHitOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					{
						Entity _ent = entity;
						_ent.teleportTo((entityiterator.getX() + entity.getPersistentData().getDouble("NanamiHitX")), (entityiterator.getY() + entity.getPersistentData().getDouble("NanamiHitY")),
								(entityiterator.getZ() + entity.getPersistentData().getDouble("NanamiHitZ")));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entityiterator.getX() + entity.getPersistentData().getDouble("NanamiHitX")), (entityiterator.getY() + entity.getPersistentData().getDouble("NanamiHitY")),
									(entityiterator.getZ() + entity.getPersistentData().getDouble("NanamiHitZ")), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
