package net.mcreator.super_glow_lichen.procedures;

import net.minecraft.network.chat.Component;

public class GlowLichenPickaxeDescriptionProcedure {
	public static String execute() {
		return ("\u00A7e" + Component.translatable("item.super_glow_lichen.glow_lichen_pickaxe.description_0").getString()) + "\n" + ("\u00A7r" + Component.translatable("item.super_glow_lichen.on_off2").getString());
	}
}