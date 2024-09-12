package com.benbenlaw.casting.block.custom;

import com.benbenlaw.casting.block.entity.ControllerBlockEntity;
import com.benbenlaw.casting.block.entity.MixerBlockEntity;
import com.benbenlaw.casting.block.entity.ModBlockEntities;
import com.benbenlaw.casting.item.CastingDataComponents;
import com.benbenlaw.casting.screen.SmelterMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ControllerBlock extends BaseEntityBlock {

    public static final MapCodec<ControllerBlock> CODEC = simpleCodec(ControllerBlock::new);

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    /* FACING */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public ControllerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ControllerBlockEntity) {
                ((ControllerBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult hit) {

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        if (!level.isClientSide()) {

            ControllerBlockEntity controllerBlockEntity = (ControllerBlockEntity) level.getBlockEntity(blockPos);


            //MENU OPEN//

            if (controllerBlockEntity instanceof ControllerBlockEntity) {
                ContainerData data = controllerBlockEntity.data;
                player.openMenu(new SimpleMenuProvider(
                        (windowId, playerInventory, playerEntity) -> new SmelterMenu(windowId, playerInventory, blockPos, data),
                        Component.translatable("block.casting.controller")), (buf -> buf.writeBlockPos(blockPos)));

            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }


    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity entity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, entity, itemStack);

        if (level.getBlockEntity(blockPos) instanceof ControllerBlockEntity controllerBlockEntity) {

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_1) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_1)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_1);
                Fluid outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString));
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_1);
                controllerBlockEntity.setOutputFluid1(new FluidStack(outputFluid, outputFluidAmount));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_2) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_2)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_2);
                Fluid outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString));
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_2);
                controllerBlockEntity.setOutputFluid2(new FluidStack(outputFluid, outputFluidAmount));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_3) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_3)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_3);
                Fluid outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString));
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_3);
                controllerBlockEntity.setOutputFluid3(new FluidStack(outputFluid, outputFluidAmount));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_4) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_4)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_4);
                Fluid outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString));
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_4);
                controllerBlockEntity.setOutputFluid4(new FluidStack(outputFluid, outputFluidAmount));
            }
        }
    }



    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity entity, ItemStack stack) {
        if (entity instanceof ControllerBlockEntity controllerBlockEntity) {

            ItemStack itemStackWithFluids = new ItemStack(this);

            if (controllerBlockEntity.getOutputFluid1().getFluid() != Fluids.EMPTY && controllerBlockEntity.getOutputFluid1().getAmount() > 0) {
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_1, controllerBlockEntity.getOutputFluid1().getFluid().getFluidType().toString());
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_AMOUNT_1, controllerBlockEntity.getOutputFluid1().getAmount());
            }

            if (controllerBlockEntity.getOutputFluid2().getFluid() != Fluids.EMPTY && controllerBlockEntity.getOutputFluid2().getAmount() > 0) {
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_2, controllerBlockEntity.getOutputFluid2().getFluid().getFluidType().toString());
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_AMOUNT_2, controllerBlockEntity.getOutputFluid2().getAmount());
            }

            if (controllerBlockEntity.getOutputFluid3().getFluid() != Fluids.EMPTY && controllerBlockEntity.getOutputFluid3().getAmount() > 0) {
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_3, controllerBlockEntity.getOutputFluid3().getFluid().getFluidType().toString());
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_AMOUNT_3, controllerBlockEntity.getOutputFluid3().getAmount());
            }

            if (controllerBlockEntity.getOutputFluid4().getFluid() != Fluids.EMPTY && controllerBlockEntity.getOutputFluid4().getAmount() > 0) {
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_4, controllerBlockEntity.getOutputFluid4().getFluid().getFluidType().toString());
                itemStackWithFluids.set(CastingDataComponents.OUTPUT_FLUID_AMOUNT_4, controllerBlockEntity.getOutputFluid4().getAmount());
            }
            popResource(level, pos, itemStackWithFluids);

        } else {
            popResource(level, pos, this.asItem().getDefaultInstance());
        }

        super.playerDestroy(level, player, pos, state, entity, stack);
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @NotNull Item.TooltipContext context, @NotNull List<Component> components, @NotNull TooltipFlag flag) {

        if (Screen.hasShiftDown()) {

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_1) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_1)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_1);
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_1);
                FluidType outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString)).getFluidType();
                components.add(Component.literal("Tank 1 Contains: ").append(outputFluidAmount + "mb ").append(Component.translatable(outputFluid.getDescriptionId())).withStyle(ChatFormatting.GREEN));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_2) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_2)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_2);
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_2);
                FluidType outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString)).getFluidType();
                components.add(Component.literal("Tank 2 Contains: ").append(outputFluidAmount + "mb ").append(Component.translatable(outputFluid.getDescriptionId())).withStyle(ChatFormatting.GREEN));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_3) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_3)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_3);
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_3);
                FluidType outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString)).getFluidType();
                components.add(Component.literal("Tank 3 Contains: ").append(outputFluidAmount + "mb ").append(Component.translatable(outputFluid.getDescriptionId())).withStyle(ChatFormatting.GREEN));
            }

            if (itemStack.has(CastingDataComponents.OUTPUT_FLUID_4) && itemStack.has(CastingDataComponents.OUTPUT_FLUID_AMOUNT_4)) {
                String outputFluidAsString = itemStack.get(CastingDataComponents.OUTPUT_FLUID_4);
                int outputFluidAmount = itemStack.get(CastingDataComponents.OUTPUT_FLUID_AMOUNT_4);
                FluidType outputFluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(outputFluidAsString)).getFluidType();
                components.add(Component.literal("Tank 4 Contains: ").append(outputFluidAmount + "mb ").append(Component.translatable(outputFluid.getDescriptionId())).withStyle(ChatFormatting.GREEN));
            }
        } else {
            components.add(Component.translatable("tooltips.blocks.with_fluid.shift").withStyle(ChatFormatting.GREEN));
        }

        super.appendHoverText(itemStack, context, components, flag);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ControllerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.CONTROLLER_BLOCK_ENTITY.get(),
                (world, blockPos, thisBlockState, blockEntity) -> blockEntity.tick());
    }
}

