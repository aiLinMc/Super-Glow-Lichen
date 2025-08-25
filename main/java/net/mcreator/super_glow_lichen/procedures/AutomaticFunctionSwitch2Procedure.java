package net.mcreator.super_glow_lichen.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.super_glow_lichen.network.SuperGlowLichenModVariables;
import net.mcreator.super_glow_lichen.init.SuperGlowLichenModItems;
import net.mcreator.super_glow_lichen.SuperGlowLichenMod;

import javax.annotation.Nullable;

@EventBusSubscriber(value = {Dist.CLIENT})
public class AutomaticFunctionSwitch2Procedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new AutomaticFunctionSwitch2Message());
		execute(event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record AutomaticFunctionSwitch2Message() implements CustomPacketPayload {
		public static final Type<AutomaticFunctionSwitch2Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SuperGlowLichenMod.MODID, "procedure_automatic_function_switch_2"));
		public static final StreamCodec<RegistryFriendlyByteBuf, AutomaticFunctionSwitch2Message> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AutomaticFunctionSwitch2Message message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new AutomaticFunctionSwitch2Message());

		@Override
		public Type<AutomaticFunctionSwitch2Message> type() {
			return TYPE;
		}

		public static void handleData(final AutomaticFunctionSwitch2Message message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			SuperGlowLichenMod.addNetworkMessage(AutomaticFunctionSwitch2Message.TYPE, AutomaticFunctionSwitch2Message.STREAM_CODEC, AutomaticFunctionSwitch2Message::handleData);
		}
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