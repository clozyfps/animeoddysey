
package net.mcreator.animeoddysey.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.animeoddysey.world.inventory.CharacterSelectMainMenu;
import net.mcreator.animeoddysey.procedures.OpenMHAProcedure;
import net.mcreator.animeoddysey.procedures.OpenJJBAProcedure;
import net.mcreator.animeoddysey.procedures.OpenHxHProcedure;
import net.mcreator.animeoddysey.procedures.JJKPressedProcedure;
import net.mcreator.animeoddysey.procedures.ClickMP100Procedure;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CharacterSelectMainButtonMessage {
	private final int buttonID, x, y, z;

	public CharacterSelectMainButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CharacterSelectMainButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CharacterSelectMainButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CharacterSelectMainButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CharacterSelectMainMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenHxHProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenMHAProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			JJKPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ClickMP100Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenJJBAProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnimeoddyseyMod.addNetworkMessage(CharacterSelectMainButtonMessage.class, CharacterSelectMainButtonMessage::buffer, CharacterSelectMainButtonMessage::new, CharacterSelectMainButtonMessage::handler);
	}
}
