package net.luna.diamondcasino.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class ChipExchangerBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ChipExchangerBlock(Settings settings) {
        super(settings);
        // Set the default state of the block to face north
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        // Retrieve the player's yaw (rotation in degrees)
        float yaw = context.getPlayerYaw();

        // Convert yaw to a cardinal direction (NORTH, EAST, SOUTH, WEST)
        Direction placementDirection = getDirectionFromYaw(yaw);

        // Set the block's facing directly based on the computed direction
        return this.getDefaultState().with(FACING, placementDirection);
    }

    private Direction getDirectionFromYaw(float yaw) {
        // Normalize yaw to range 0–360 degrees
        yaw = yaw % 360;
        if (yaw < 0) {
            yaw += 360;
        }

        // Determine the rightmost cardinal direction based on yaw
        if (yaw >= 45 && yaw < 135) {
            return Direction.EAST;  // Right of NORTH
        } else if (yaw >= 135 && yaw < 225) {
            return Direction.SOUTH; // Right of EAST
        } else if (yaw >= 225 && yaw < 315) {
            return Direction.WEST;  // Right of SOUTH
        } else {
            return Direction.NORTH; // Right of WEST
        }
    }

    // Handle rotation (e.g., when applying a block rotation tool or piston)
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    // Handle block mirroring (e.g., mirrored in structures)
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    // Register the FACING property so it works with BlockState
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}