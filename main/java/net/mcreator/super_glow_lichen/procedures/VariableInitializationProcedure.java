package net.mcreator.super_glow_lichen.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.super_glow_lichen.network.SuperGlowLichenModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VariableInitializationProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES).AutoTorch).isEmpty()) {
			{
				SuperGlowLichenModVariables.PlayerVariables _vars = entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES);
				_vars.AutoTorch = "on";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}