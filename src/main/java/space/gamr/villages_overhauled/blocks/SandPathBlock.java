package space.gamr.villages_overhauled.blocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SandPathBlock extends GrassPathBlock {
    public SandPathBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        turnToSand(state, worldIn, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), Blocks.SAND.getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState upBlockState = worldIn.getBlockState(pos.up());
        BlockState downBlockState = worldIn.getBlockState(pos.down());
        return downBlockState.getMaterial().isSolid() && (!upBlockState.getMaterial().isSolid() || upBlockState.getBlock() instanceof FenceGateBlock || upBlockState.getBlock() instanceof MovingPistonBlock);
    }

    public static void turnToSand(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, Blocks.SAND.getDefaultState(), worldIn, pos));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!isValidPosition(stateIn, worldIn, currentPos)) {
            return Blocks.SAND.getDefaultState();
        }
        else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }
}
