package net.mcreator.animeoddysey.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.Comparator;

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
