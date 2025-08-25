package net.mcreator.super_glow_lichen.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.super_glow_lichen.network.SuperGlowLichenModVariables;

public class GlowLichenBootsDescriptionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("\u00A7e" + Component.translatable("item.super_glow_lichen.glow_lichen_boots.description_0").getString()) + "\n" + ("\u00A7r" + Component.translatable("item.super_glow_lichen.on_off1").getString()) + "\n" + "\n"
				+ (Component.translatable("item.super_glow_lichen.function").getString() + "\u00A75\u00A7l" + Component.translatable(("item.super_glow_lichen." + entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES).AutoTorch)).getString());
	}
}