
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AnimeoddyseyMod.MODID);
	public static final RegistryObject<SoundEvent> BLOODY = REGISTRY.register("bloody", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "bloody")));
	public static final RegistryObject<SoundEvent> HEARTBEAT = REGISTRY.register("heartbeat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "heartbeat")));
	public static final RegistryObject<SoundEvent> ELECTRICITY = REGISTRY.register("electricity", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "electricity")));
	public static final RegistryObject<SoundEvent> HONOREDONE = REGISTRY.register("honoredone", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "honoredone")));
	public static final RegistryObject<SoundEvent> BLACKFLASH = REGISTRY.register("blackflash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "blackflash")));
	public static final RegistryObject<SoundEvent> STRESSPERCENTAGE = REGISTRY.register("stresspercentage", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "stresspercentage")));
	public static final RegistryObject<SoundEvent> BEEP = REGISTRY.register("beep", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "beep")));
	public static final RegistryObject<SoundEvent> MOBRAGE = REGISTRY.register("mobrage", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "mobrage")));
	public static final RegistryObject<SoundEvent> PSYCHICENERGY = REGISTRY.register("psychicenergy", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "psychicenergy")));
	public static final RegistryObject<SoundEvent> SPIRITUALAWARENESS = REGISTRY.register("spiritualawareness", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "spiritualawareness")));
	public static final RegistryObject<SoundEvent> EXPLOSIVEPUNCH = REGISTRY.register("explosivepunch", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "explosivepunch")));
	public static final RegistryObject<SoundEvent> OFACHARGE = REGISTRY.register("ofacharge", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "ofacharge")));
	public static final RegistryObject<SoundEvent> DELAWARESMASH = REGISTRY.register("delawaresmash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animeoddysey", "delawaresmash")));
}
