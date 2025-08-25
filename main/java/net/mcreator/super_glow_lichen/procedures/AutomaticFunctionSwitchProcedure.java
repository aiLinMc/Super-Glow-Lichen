package net.mcreator.super_glow_lichen.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.super_glow_lichen.network.SuperGlowLichenModVariables;
import net.mcreator.super_glow_lichen.init.SuperGlowLichenModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AutomaticFunctionSwitchProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SuperGlowLichenModItems.GLOW_LICHEN_BOOTS.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if ((entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES).AutoTorch).equals("on")) {
				{
					SuperGlowLichenModVariables.PlayerVariables _vars = entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES);
					_vars.AutoTorch = "off";
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SuperGlowLichenModVariables.PlayerVariables _vars = entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES);
					_vars.AutoTorch = "on";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}