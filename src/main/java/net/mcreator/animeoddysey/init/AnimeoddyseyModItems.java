
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.animeoddysey.item.TestItem;
import net.mcreator.animeoddysey.item.CharacterSelectorItem;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AnimeoddyseyMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> CHARACTER_SELECTOR = REGISTRY.register("character_selector", () -> new CharacterSelectorItem());
}
