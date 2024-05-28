
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
}
