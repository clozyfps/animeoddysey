
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.animeoddysey.world.inventory.NarutoSelectionMenu;
import net.mcreator.animeoddysey.world.inventory.MobPsychoSelectionMenu;
import net.mcreator.animeoddysey.world.inventory.MainMenuMenu;
import net.mcreator.animeoddysey.world.inventory.MHASelectionMenu;
import net.mcreator.animeoddysey.world.inventory.JJKSelectionMenu;
import net.mcreator.animeoddysey.world.inventory.JJBASelectionMenu;
import net.mcreator.animeoddysey.world.inventory.HxHSelectionMenu;
import net.mcreator.animeoddysey.world.inventory.CharacterSelectMainMenu;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AnimeoddyseyMod.MODID);
	public static final RegistryObject<MenuType<HxHSelectionMenu>> HX_H_SELECTION = REGISTRY.register("hx_h_selection", () -> IForgeMenuType.create(HxHSelectionMenu::new));
	public static final RegistryObject<MenuType<CharacterSelectMainMenu>> CHARACTER_SELECT_MAIN = REGISTRY.register("character_select_main", () -> IForgeMenuType.create(CharacterSelectMainMenu::new));
	public static final RegistryObject<MenuType<JJKSelectionMenu>> JJK_SELECTION = REGISTRY.register("jjk_selection", () -> IForgeMenuType.create(JJKSelectionMenu::new));
	public static final RegistryObject<MenuType<MobPsychoSelectionMenu>> MOB_PSYCHO_SELECTION = REGISTRY.register("mob_psycho_selection", () -> IForgeMenuType.create(MobPsychoSelectionMenu::new));
	public static final RegistryObject<MenuType<MainMenuMenu>> MAIN_MENU = REGISTRY.register("main_menu", () -> IForgeMenuType.create(MainMenuMenu::new));
	public static final RegistryObject<MenuType<MHASelectionMenu>> MHA_SELECTION = REGISTRY.register("mha_selection", () -> IForgeMenuType.create(MHASelectionMenu::new));
	public static final RegistryObject<MenuType<JJBASelectionMenu>> JJBA_SELECTION = REGISTRY.register("jjba_selection", () -> IForgeMenuType.create(JJBASelectionMenu::new));
	public static final RegistryObject<MenuType<NarutoSelectionMenu>> NARUTO_SELECTION = REGISTRY.register("naruto_selection", () -> IForgeMenuType.create(NarutoSelectionMenu::new));
}
