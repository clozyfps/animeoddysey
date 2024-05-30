
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnimeoddyseyMod.MODID);
	public static final RegistryObject<CreativeModeTab> ANIME_ODDYSEY_MOBS = REGISTRY.register("anime_oddysey_mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.animeoddysey.anime_oddysey_mobs")).icon(() -> new ItemStack(AnimeoddyseyModItems.CHARACTER_SELECTOR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AnimeoddyseyModItems.KILLUA_ZOLDYCK_SPAWN_EGG.get());
			}).withSearchBar().build());
}
