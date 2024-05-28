
package net.mcreator.animeoddysey.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.world.inventory.MainMenuMenu;
import net.mcreator.animeoddysey.procedures.UpgradeStrengthProcedure;
import net.mcreator.animeoddysey.procedures.UpgradeEnergyProcedure;
import net.mcreator.animeoddysey.procedures.UpgradeDefenseProcedure;
import net.mcreator.animeoddysey.procedures.UpgradeAgilityProcedure;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainMenuButtonMessage {
	private final int buttonID, x, y, z;

	public MainMenuButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MainMenuButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MainMenuButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MainMenuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MainMenuMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			UpgradeStrengthProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			UpgradeDefenseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			UpgradeAgilityProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			UpgradeEnergyProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnimeoddyseyMod.addNetworkMessage(MainMenuButtonMessage.class, MainMenuButtonMessage::buffer, MainMenuButtonMessage::new, MainMenuButtonMessage::handler);
	}
}
