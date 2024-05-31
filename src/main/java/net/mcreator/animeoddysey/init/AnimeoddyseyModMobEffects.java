
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animeoddysey.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.animeoddysey.potion.ZoneMobEffect;
import net.mcreator.animeoddysey.potion.TalentCooldownMobEffect;
import net.mcreator.animeoddysey.potion.SpiritualAwarenessMobEffect;
import net.mcreator.animeoddysey.potion.SpeedEffectMobEffect;
import net.mcreator.animeoddysey.potion.SnakeAwakensMobEffect;
import net.mcreator.animeoddysey.potion.SmokescreenMobEffect;
import net.mcreator.animeoddysey.potion.SlamMobEffect;
import net.mcreator.animeoddysey.potion.ReversedCursedTechniqueMobEffect;
import net.mcreator.animeoddysey.potion.PsychicEnergyOutwardsEffectMobEffect;
import net.mcreator.animeoddysey.potion.OutwardsReversalRedMobEffect;
import net.mcreator.animeoddysey.potion.OutwardsPoofMobEffect;
import net.mcreator.animeoddysey.potion.OutwardsMobEffect;
import net.mcreator.animeoddysey.potion.NanamiHitEffectMobEffect;
import net.mcreator.animeoddysey.potion.LapseBluePoitonMobEffect;
import net.mcreator.animeoddysey.potion.LapseBlueMaximumMobEffect;
import net.mcreator.animeoddysey.potion.ImpactFrameMobEffect;
import net.mcreator.animeoddysey.potion.IframeMobEffect;
import net.mcreator.animeoddysey.potion.HonoredOneSkyMobEffect;
import net.mcreator.animeoddysey.potion.HollowPurpleActiveMobEffect;
import net.mcreator.animeoddysey.potion.GodspeedMobEffect;
import net.mcreator.animeoddysey.potion.GearshiftOverdriveMobEffect;
import net.mcreator.animeoddysey.potion.FullCowlingMobEffect;
import net.mcreator.animeoddysey.potion.FatigueMobEffect;
import net.mcreator.animeoddysey.potion.FaJinActiveMobEffect;
import net.mcreator.animeoddysey.potion.ExplosionOfEmotionsMobEffect;
import net.mcreator.animeoddysey.potion.ExplodingMobEffect;
import net.mcreator.animeoddysey.potion.EnMobEffect;
import net.mcreator.animeoddysey.potion.CooldownMobEffect;
import net.mcreator.animeoddysey.potion.BlackOutwardsMobEffect;
import net.mcreator.animeoddysey.potion.AuraControlMobEffect;
import net.mcreator.animeoddysey.AnimeoddyseyMod;

public class AnimeoddyseyModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AnimeoddyseyMod.MODID);
	public static final RegistryObject<MobEffect> SNAKE_AWAKENS = REGISTRY.register("snake_awakens", () -> new SnakeAwakensMobEffect());
	public static final RegistryObject<MobEffect> COOLDOWN = REGISTRY.register("cooldown", () -> new CooldownMobEffect());
	public static final RegistryObject<MobEffect> SPEED_EFFECT = REGISTRY.register("speed_effect", () -> new SpeedEffectMobEffect());
	public static final RegistryObject<MobEffect> OUTWARDS = REGISTRY.register("outwards", () -> new OutwardsMobEffect());
	public static final RegistryObject<MobEffect> GODSPEED = REGISTRY.register("godspeed", () -> new GodspeedMobEffect());
	public static final RegistryObject<MobEffect> EN = REGISTRY.register("en", () -> new EnMobEffect());
	public static final RegistryObject<MobEffect> LAPSE_BLUE_MAXIMUM = REGISTRY.register("lapse_blue_maximum", () -> new LapseBlueMaximumMobEffect());
	public static final RegistryObject<MobEffect> OUTWARDS_REVERSAL_RED = REGISTRY.register("outwards_reversal_red", () -> new OutwardsReversalRedMobEffect());
	public static final RegistryObject<MobEffect> HONORED_ONE_SKY = REGISTRY.register("honored_one_sky", () -> new HonoredOneSkyMobEffect());
	public static final RegistryObject<MobEffect> HOLLOW_PURPLE_ACTIVE = REGISTRY.register("hollow_purple_active", () -> new HollowPurpleActiveMobEffect());
	public static final RegistryObject<MobEffect> TALENT_COOLDOWN = REGISTRY.register("talent_cooldown", () -> new TalentCooldownMobEffect());
	public static final RegistryObject<MobEffect> REVERSED_CURSED_TECHNIQUE = REGISTRY.register("reversed_cursed_technique", () -> new ReversedCursedTechniqueMobEffect());
	public static final RegistryObject<MobEffect> ZONE = REGISTRY.register("zone", () -> new ZoneMobEffect());
	public static final RegistryObject<MobEffect> IMPACT_FRAME = REGISTRY.register("impact_frame", () -> new ImpactFrameMobEffect());
	public static final RegistryObject<MobEffect> BLACK_OUTWARDS = REGISTRY.register("black_outwards", () -> new BlackOutwardsMobEffect());
	public static final RegistryObject<MobEffect> EXPLODING = REGISTRY.register("exploding", () -> new ExplodingMobEffect());
	public static final RegistryObject<MobEffect> EXPLOSION_OF_EMOTIONS = REGISTRY.register("explosion_of_emotions", () -> new ExplosionOfEmotionsMobEffect());
	public static final RegistryObject<MobEffect> AURA_CONTROL = REGISTRY.register("aura_control", () -> new AuraControlMobEffect());
	public static final RegistryObject<MobEffect> SPIRITUAL_AWARENESS = REGISTRY.register("spiritual_awareness", () -> new SpiritualAwarenessMobEffect());
	public static final RegistryObject<MobEffect> SLAM = REGISTRY.register("slam", () -> new SlamMobEffect());
	public static final RegistryObject<MobEffect> IFRAME = REGISTRY.register("iframe", () -> new IframeMobEffect());
	public static final RegistryObject<MobEffect> FULL_COWLING = REGISTRY.register("full_cowling", () -> new FullCowlingMobEffect());
	public static final RegistryObject<MobEffect> FATIGUE = REGISTRY.register("fatigue", () -> new FatigueMobEffect());
	public static final RegistryObject<MobEffect> SMOKESCREEN = REGISTRY.register("smokescreen", () -> new SmokescreenMobEffect());
	public static final RegistryObject<MobEffect> GEARSHIFT_OVERDRIVE = REGISTRY.register("gearshift_overdrive", () -> new GearshiftOverdriveMobEffect());
	public static final RegistryObject<MobEffect> FA_JIN_ACTIVE = REGISTRY.register("fa_jin_active", () -> new FaJinActiveMobEffect());
	public static final RegistryObject<MobEffect> LAPSE_BLUE_POITON = REGISTRY.register("lapse_blue_poiton", () -> new LapseBluePoitonMobEffect());
	public static final RegistryObject<MobEffect> OUTWARDS_POOF = REGISTRY.register("outwards_poof", () -> new OutwardsPoofMobEffect());
	public static final RegistryObject<MobEffect> PSYCHIC_ENERGY_OUTWARDS_EFFECT = REGISTRY.register("psychic_energy_outwards_effect", () -> new PsychicEnergyOutwardsEffectMobEffect());
	public static final RegistryObject<MobEffect> NANAMI_HIT_EFFECT = REGISTRY.register("nanami_hit_effect", () -> new NanamiHitEffectMobEffect());
}
