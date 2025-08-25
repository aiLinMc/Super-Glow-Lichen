package net.mcreator.super_glow_lichen.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.super_glow_lichen.network.SuperGlowLichenModVariables;

public class GlowLichenBootsEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (entity.getData(SuperGlowLichenModVariables.PLAYER_VARIABLES).AutoTorch).equals("on")) {
			if (world.getBlockState(BlockPos.containing(x, Math.round(y) - 1, z)).isFaceSturdy(world, BlockPos.containing(x, Math.round(y) - 1, z), Direction.UP)
					&& ((world.getBlockState(BlockPos.containing(x, Math.round(y), z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, Math.round(y), z))).getBlock() == Blocks.CAVE_AIR)) {
				world.setBlock(BlockPos.containing(x, Math.round(y), z), Blocks.TORCH.defaultBlockState(), 3);
			}
		}
	}
}