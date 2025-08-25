/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.super_glow_lichen.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.super_glow_lichen.SuperGlowLichenMod;

public class SuperGlowLichenModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperGlowLichenMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SUPER_GLOW_LICHEN = REGISTRY.register("super_glow_lichen",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.super_glow_lichen.super_glow_lichen")).icon(() -> new ItemStack(Blocks.GLOW_LICHEN)).displayItems((parameters, tabData) -> {
				tabData.accept(SuperGlowLichenModItems.GLOW_LICHEN_HELMET.get());
				tabData.accept(SuperGlowLichenModItems.GLOW_LICHEN_CHESTPLATE.get());
				tabData.accept(SuperGlowLichenModItems.GLOW_LICHEN_LEGGINGS.get());
				tabData.accept(SuperGlowLichenModItems.GLOW_LICHEN_BOOTS.get());
				tabData.accept(SuperGlowLichenModItems.GLOW_LICHEN_PICKAXE.get());
			}).build());
}