
package net.mcreator.animeoddysey.command;

@Mod.EventBusSubscriber
public class AnimeOddyseySetCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("animeoddyseyset").requires(s -> s.hasPermission(1))
				.then(Commands.literal("stat").then(Commands.argument("name", EntityArgument.player()).then(Commands.literal("energy").then(Commands.argument("amountstat", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();

					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();

					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);

					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetEnergyProcedure.execute(arguments);
					return 0;
				}))))).then(Commands.literal("prestigecharacter").then(Commands.argument("name", EntityArgument.player()).then(Commands.literal("AwakenedYuji").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();

					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();

					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);

					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AwakenedItadoriSetProcedure.execute(arguments);
					return 0;
				})))));
	}

}
