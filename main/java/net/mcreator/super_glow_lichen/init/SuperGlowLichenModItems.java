/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.super_glow_lichen.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.super_glow_lichen.item.GlowLichenPickaxeItem;
import net.mcreator.super_glow_lichen.item.GlowLichenItem;
import net.mcreator.super_glow_lichen.SuperGlowLichenMod;

public class SuperGlowLichenModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SuperGlowLichenMod.MODID);
	public static final DeferredItem<Item> GLOW_LICHEN_HELMET = REGISTRY.register("glow_lichen_helmet", GlowLichenItem.Helmet::new);
	public static final DeferredItem<Item> GLOW_LICHEN_CHESTPLATE = REGISTRY.register("glow_lichen_chestplate", GlowLichenItem.Chestplate::new);
	public static final DeferredItem<Item> GLOW_LICHEN_LEGGINGS = REGISTRY.register("glow_lichen_leggings", GlowLichenItem.Leggings::new);
	public static final DeferredItem<Item> GLOW_LICHEN_BOOTS = REGISTRY.register("glow_lichen_boots", GlowLichenItem.Boots::new);
	public static final DeferredItem<Item> GLOW_LICHEN_PICKAXE = REGISTRY.register("glow_lichen_pickaxe", GlowLichenPickaxeItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}