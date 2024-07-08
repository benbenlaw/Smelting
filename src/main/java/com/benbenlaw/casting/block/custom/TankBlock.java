package com.benbenlaw.casting.block.custom;

import com.benbenlaw.casting.block.entity.ModBlockEntities;
import com.benbenlaw.casting.block.entity.TankBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TankBlock extends BaseEntityBlock {

    public static final MapCodec<TankBlock> CODEC = simpleCodec(TankBlock::new);

    public TankBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        // Retrieve the block entity at the position
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (!(blockEntity instanceof TankBlockEntity)) {
            return InteractionResult.FAIL;
        }

        TankBlockEntity entity = (TankBlockEntity) blockEntity;

        //FILL BUCKET//
        TankBlockEntity tankBlockEntity = (TankBlockEntity) level.getBlockEntity(blockPos);
        if (tankBlockEntity != null && tankBlockEntity.onPlayerUse(player, InteractionHand.MAIN_HAND)) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    //BLOCK ENTITY


    @SuppressWarnings("deprecation")
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, BlockState newBlockState, boolean isMoving) {
        blockState.getBlock();
        newBlockState.getBlock();
        super.onRemove(blockState, level, blockPos, newBlockState, isMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new TankBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.TANK_BLOCK_ENTITY.get(),
                (world, blockPos, thisBlockState, blockEntity) -> blockEntity.tick());
    }
}
