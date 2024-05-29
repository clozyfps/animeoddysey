package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShadersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean YourCondition = false;
		if (world.isClientSide() && entity instanceof Player) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(AnimeoddyseyModMobEffects.IFRAME.get())) {
				if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("animeoddysey:shaders/post/black_and_white.json"));
				}
			} else {
				if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				}
			}
		}
	}
}
