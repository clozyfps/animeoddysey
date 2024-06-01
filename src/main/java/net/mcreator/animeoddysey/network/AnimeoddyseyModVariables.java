package net.mcreator.animeoddysey.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimeoddyseyModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		AnimeoddyseyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Character = original.Character;
			clone.Talent = original.Talent;
			clone.Passives = original.Passives;
			clone.Moves = original.Moves;
			clone.SelectedMove = original.SelectedMove;
			clone.Cost = original.Cost;
			clone.Energy = original.Energy;
			clone.ColorCode = original.ColorCode;
			clone.EnergyMax = original.EnergyMax;
			clone.MoveNumber = original.MoveNumber;
			clone.ActiveMove = original.ActiveMove;
			clone.EnergyStat = original.EnergyStat;
			clone.StrengthStat = original.StrengthStat;
			clone.SpeedStat = original.SpeedStat;
			clone.EnergyBase = original.EnergyBase;
			clone.Application = original.Application;
			clone.StrengthMod = original.StrengthMod;
			clone.SpeedMod = original.SpeedMod;
			clone.DefenseStat = original.DefenseStat;
			clone.DefenseMod = original.DefenseMod;
			clone.ZoneMod = original.ZoneMod;
			clone.Rank = original.Rank;
			clone.Level = original.Level;
			clone.Exp = original.Exp;
			clone.ExpMax = original.ExpMax;
			clone.SP = original.SP;
			clone.RedAnim = original.RedAnim;
			clone.OFAPercentage = original.OFAPercentage;
			clone.FaJin = original.FaJin;
			clone.JoinedWorld = original.JoinedWorld;
			clone.LapseBlueID = original.LapseBlueID;
			clone.HitNanamiVaribleClientSide = original.HitNanamiVaribleClientSide;
			clone.HitNanamiPlayer = original.HitNanamiPlayer;
			clone.Tomoe = original.Tomoe;
			clone.CurseMarkLevel = original.CurseMarkLevel;
			if (!event.isWasDeath()) {
				clone.Percentage = original.Percentage;
				clone.HelmetSlotSave = original.HelmetSlotSave;
				clone.ChestSlotSave = original.ChestSlotSave;
				clone.LeggingsSlotSave = original.LeggingsSlotSave;
				clone.BootsSlotSave = original.BootsSlotSave;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("animeoddysey", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Character = "";
		public String Talent = "";
		public String Passives = "";
		public double Moves = 0;
		public String SelectedMove = "";
		public double Cost = 0;
		public double Energy = 0.0;
		public String ColorCode = "";
		public double EnergyMax = 50.0;
		public double MoveNumber = 0.0;
		public String ActiveMove = "";
		public double EnergyStat = 0.0;
		public double StrengthStat = 0;
		public double SpeedStat = 0;
		public double EnergyBase = 0;
		public String Application = "";
		public double StrengthMod = 0;
		public double SpeedMod = 0;
		public double DefenseStat = 0;
		public double DefenseMod = 0;
		public double ZoneMod = 0;
		public double Percentage = 0;
		public String Rank = "";
		public double Level = 1.0;
		public double Exp = 0;
		public double ExpMax = 20.0;
		public double SP = 0;
		public boolean RedAnim = false;
		public double OFAPercentage = 0;
		public ItemStack HelmetSlotSave = ItemStack.EMPTY;
		public ItemStack ChestSlotSave = ItemStack.EMPTY;
		public ItemStack LeggingsSlotSave = ItemStack.EMPTY;
		public ItemStack BootsSlotSave = ItemStack.EMPTY;
		public double FaJin = 0;
		public boolean JoinedWorld = false;
		public double LapseBlueID = 0;
		public boolean HitNanamiVaribleClientSide = false;
		public boolean HitNanamiPlayer = false;
		public double Tomoe = 1.0;
		public double CurseMarkLevel = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AnimeoddyseyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Character", Character);
			nbt.putString("Talent", Talent);
			nbt.putString("Passives", Passives);
			nbt.putDouble("Moves", Moves);
			nbt.putString("SelectedMove", SelectedMove);
			nbt.putDouble("Cost", Cost);
			nbt.putDouble("Energy", Energy);
			nbt.putString("ColorCode", ColorCode);
			nbt.putDouble("EnergyMax", EnergyMax);
			nbt.putDouble("MoveNumber", MoveNumber);
			nbt.putString("ActiveMove", ActiveMove);
			nbt.putDouble("EnergyStat", EnergyStat);
			nbt.putDouble("StrengthStat", StrengthStat);
			nbt.putDouble("SpeedStat", SpeedStat);
			nbt.putDouble("EnergyBase", EnergyBase);
			nbt.putString("Application", Application);
			nbt.putDouble("StrengthMod", StrengthMod);
			nbt.putDouble("SpeedMod", SpeedMod);
			nbt.putDouble("DefenseStat", DefenseStat);
			nbt.putDouble("DefenseMod", DefenseMod);
			nbt.putDouble("ZoneMod", ZoneMod);
			nbt.putDouble("Percentage", Percentage);
			nbt.putString("Rank", Rank);
			nbt.putDouble("Level", Level);
			nbt.putDouble("Exp", Exp);
			nbt.putDouble("ExpMax", ExpMax);
			nbt.putDouble("SP", SP);
			nbt.putBoolean("RedAnim", RedAnim);
			nbt.putDouble("OFAPercentage", OFAPercentage);
			nbt.put("HelmetSlotSave", HelmetSlotSave.save(new CompoundTag()));
			nbt.put("ChestSlotSave", ChestSlotSave.save(new CompoundTag()));
			nbt.put("LeggingsSlotSave", LeggingsSlotSave.save(new CompoundTag()));
			nbt.put("BootsSlotSave", BootsSlotSave.save(new CompoundTag()));
			nbt.putDouble("FaJin", FaJin);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putDouble("LapseBlueID", LapseBlueID);
			nbt.putBoolean("HitNanamiVaribleClientSide", HitNanamiVaribleClientSide);
			nbt.putBoolean("HitNanamiPlayer", HitNanamiPlayer);
			nbt.putDouble("Tomoe", Tomoe);
			nbt.putDouble("CurseMarkLevel", CurseMarkLevel);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Character = nbt.getString("Character");
			Talent = nbt.getString("Talent");
			Passives = nbt.getString("Passives");
			Moves = nbt.getDouble("Moves");
			SelectedMove = nbt.getString("SelectedMove");
			Cost = nbt.getDouble("Cost");
			Energy = nbt.getDouble("Energy");
			ColorCode = nbt.getString("ColorCode");
			EnergyMax = nbt.getDouble("EnergyMax");
			MoveNumber = nbt.getDouble("MoveNumber");
			ActiveMove = nbt.getString("ActiveMove");
			EnergyStat = nbt.getDouble("EnergyStat");
			StrengthStat = nbt.getDouble("StrengthStat");
			SpeedStat = nbt.getDouble("SpeedStat");
			EnergyBase = nbt.getDouble("EnergyBase");
			Application = nbt.getString("Application");
			StrengthMod = nbt.getDouble("StrengthMod");
			SpeedMod = nbt.getDouble("SpeedMod");
			DefenseStat = nbt.getDouble("DefenseStat");
			DefenseMod = nbt.getDouble("DefenseMod");
			ZoneMod = nbt.getDouble("ZoneMod");
			Percentage = nbt.getDouble("Percentage");
			Rank = nbt.getString("Rank");
			Level = nbt.getDouble("Level");
			Exp = nbt.getDouble("Exp");
			ExpMax = nbt.getDouble("ExpMax");
			SP = nbt.getDouble("SP");
			RedAnim = nbt.getBoolean("RedAnim");
			OFAPercentage = nbt.getDouble("OFAPercentage");
			HelmetSlotSave = ItemStack.of(nbt.getCompound("HelmetSlotSave"));
			ChestSlotSave = ItemStack.of(nbt.getCompound("ChestSlotSave"));
			LeggingsSlotSave = ItemStack.of(nbt.getCompound("LeggingsSlotSave"));
			BootsSlotSave = ItemStack.of(nbt.getCompound("BootsSlotSave"));
			FaJin = nbt.getDouble("FaJin");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			LapseBlueID = nbt.getDouble("LapseBlueID");
			HitNanamiVaribleClientSide = nbt.getBoolean("HitNanamiVaribleClientSide");
			HitNanamiPlayer = nbt.getBoolean("HitNanamiPlayer");
			Tomoe = nbt.getDouble("Tomoe");
			CurseMarkLevel = nbt.getDouble("CurseMarkLevel");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Character = message.data.Character;
					variables.Talent = message.data.Talent;
					variables.Passives = message.data.Passives;
					variables.Moves = message.data.Moves;
					variables.SelectedMove = message.data.SelectedMove;
					variables.Cost = message.data.Cost;
					variables.Energy = message.data.Energy;
					variables.ColorCode = message.data.ColorCode;
					variables.EnergyMax = message.data.EnergyMax;
					variables.MoveNumber = message.data.MoveNumber;
					variables.ActiveMove = message.data.ActiveMove;
					variables.EnergyStat = message.data.EnergyStat;
					variables.StrengthStat = message.data.StrengthStat;
					variables.SpeedStat = message.data.SpeedStat;
					variables.EnergyBase = message.data.EnergyBase;
					variables.Application = message.data.Application;
					variables.StrengthMod = message.data.StrengthMod;
					variables.SpeedMod = message.data.SpeedMod;
					variables.DefenseStat = message.data.DefenseStat;
					variables.DefenseMod = message.data.DefenseMod;
					variables.ZoneMod = message.data.ZoneMod;
					variables.Percentage = message.data.Percentage;
					variables.Rank = message.data.Rank;
					variables.Level = message.data.Level;
					variables.Exp = message.data.Exp;
					variables.ExpMax = message.data.ExpMax;
					variables.SP = message.data.SP;
					variables.RedAnim = message.data.RedAnim;
					variables.OFAPercentage = message.data.OFAPercentage;
					variables.HelmetSlotSave = message.data.HelmetSlotSave;
					variables.ChestSlotSave = message.data.ChestSlotSave;
					variables.LeggingsSlotSave = message.data.LeggingsSlotSave;
					variables.BootsSlotSave = message.data.BootsSlotSave;
					variables.FaJin = message.data.FaJin;
					variables.JoinedWorld = message.data.JoinedWorld;
					variables.LapseBlueID = message.data.LapseBlueID;
					variables.HitNanamiVaribleClientSide = message.data.HitNanamiVaribleClientSide;
					variables.HitNanamiPlayer = message.data.HitNanamiPlayer;
					variables.Tomoe = message.data.Tomoe;
					variables.CurseMarkLevel = message.data.CurseMarkLevel;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
