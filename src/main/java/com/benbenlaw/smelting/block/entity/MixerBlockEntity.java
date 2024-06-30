package com.benbenlaw.smelting.block.entity;

import com.benbenlaw.opolisutilities.block.entity.custom.handler.InputOutputItemHandler;
import com.benbenlaw.opolisutilities.recipe.NoInventoryRecipe;
import com.benbenlaw.opolisutilities.util.inventory.IInventoryHandlingBlockEntity;
import com.benbenlaw.smelting.recipe.MixingRecipe;
import com.benbenlaw.smelting.recipe.SolidifierRecipe;
import com.benbenlaw.smelting.screen.MixerMenu;
import com.benbenlaw.smelting.screen.SolidifierMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MixerBlockEntity extends BlockEntity implements MenuProvider {

    public final FluidTank TANK_1 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank TANK_2 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank TANK_3 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank TANK_4 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank TANK_5 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank TANK_6 = new FluidTank(16000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };

    public final FluidTank OUTPUT_TANK = new FluidTank(64000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            sync();
        }
    };



    private final IFluidHandler fluidHandler = new IFluidHandler() {
        @Override
        public int getTanks() {
            return 7;
        }

        @Override
        public FluidStack getFluidInTank(int tank) {
            switch (tank) {
                case 0:
                    return TANK_1.getFluid();
                case 1:
                    return TANK_2.getFluid();
                case 2:
                    return TANK_3.getFluid();
                case 3:
                    return TANK_4.getFluid();
                case 4:
                    return TANK_5.getFluid();
                case 5:
                    return TANK_6.getFluid();
                case 6:
                    return OUTPUT_TANK.getFluid();
                default:
                    return FluidStack.EMPTY;
            }
        }

        @Override
        public int getTankCapacity(int tank) {
            if (tank == 0)
                return TANK_1.getCapacity();
            if (tank == 1)
                return TANK_2.getCapacity();
            if (tank == 2)
                return TANK_3.getCapacity();
            if (tank == 3)
                return TANK_4.getCapacity();
            if (tank == 4)
                return TANK_5.getCapacity();
            if (tank == 5)
                return TANK_6.getCapacity();
            if (tank == 6)
                return OUTPUT_TANK.getCapacity();
            return 0;
        }

        @Override
        public boolean isFluidValid(int tank, FluidStack stack) {
            if (tank == 0)
                return TANK_1.isFluidValid(stack);
            if (tank == 1)
                return TANK_2.isFluidValid(stack);
            if (tank == 2)
                return TANK_3.isFluidValid(stack);
            if (tank == 3)
                return TANK_4.isFluidValid(stack);
            if (tank == 4)
                return TANK_5.isFluidValid(stack);
            if (tank == 5)
                return TANK_6.isFluidValid(stack);
            if (tank == 6)
                return OUTPUT_TANK.isFluidValid(stack);
            return false;
        }
        @Override
        public int fill(FluidStack resource, FluidAction action) {
            if (resource.getFluid() == TANK_1.getFluid().getFluid()) {
                return TANK_1.fill(resource, action);
            }
            if (resource.getFluid() == TANK_2.getFluid().getFluid()) {
                return TANK_2.fill(resource, action);
            }
            if (resource.getFluid() == TANK_3.getFluid().getFluid()) {
                return TANK_3.fill(resource, action);
            }
            if (resource.getFluid() == TANK_4.getFluid().getFluid()) {
                return TANK_4.fill(resource, action);
            }
            if (resource.getFluid() == TANK_5.getFluid().getFluid()) {
                return TANK_5.fill(resource, action);
            }
            if (resource.getFluid() == TANK_6.getFluid().getFluid()) {
                return TANK_6.fill(resource, action);
            }
            return 0;
        }

        @Override
        public FluidStack drain(FluidStack resource, FluidAction action) {

            if (resource.getFluid() == OUTPUT_TANK.getFluid().getFluid()) {
                return OUTPUT_TANK.drain(resource.getAmount(), action);
            }
            return FluidStack.EMPTY;
        }

        @Override
        public FluidStack drain(int maxDrain, FluidAction action) {
            if (OUTPUT_TANK.getFluidAmount() > 0) {
                return OUTPUT_TANK.drain(maxDrain, action);
            }
            return FluidStack.EMPTY;
        }
    };

    public boolean onPlayerUse(Player player, InteractionHand hand) {
        return FluidUtil.interactWithFluidHandler(player, hand, TANK_1);
    }

    public IFluidHandler getFluidHandlerCapability(Direction side) {
        return fluidHandler;
    }
    public void sync() {
        if (level instanceof ServerLevel serverLevel) {
            LevelChunk chunk = serverLevel.getChunkAt(getBlockPos());
            if (Objects.requireNonNull(chunk.getLevel()).getChunkSource() instanceof ServerChunkCache chunkCache) {
                chunkCache.chunkMap.getPlayers(chunk.getPos(), false).forEach(this::syncContents);
            }
        }
    }

    public void syncContents(ServerPlayer player) {
        player.connection.send(Objects.requireNonNull(getUpdatePacket()));
    }

    public final ContainerData data;
    public int progress = 0;
    public int maxProgress = 20;

    public MixerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MIXER_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> MixerBlockEntity.this.progress;
                    case 1 -> MixerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MixerBlockEntity.this.progress = value;
                    case 1 -> MixerBlockEntity.this.maxProgress = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.smelting.mixer");
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int container, @NotNull Inventory inventory, @NotNull Player player) {
        return new MixerMenu(container, inventory, this.getBlockPos(), data);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.setChanged();
    }

    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag compoundTag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(compoundTag, provider);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        saveAdditional(compoundTag, provider);
        return compoundTag;
    }

    @Override
    public void onDataPacket(@NotNull Connection connection, @NotNull ClientboundBlockEntityDataPacket clientboundBlockEntityDataPacket,
                             HolderLookup.@NotNull Provider provider) {
        super.onDataPacket(connection, clientboundBlockEntityDataPacket, provider);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("progress", progress);
        compoundTag.putInt("maxProgress", maxProgress);
        compoundTag.put("tank1", TANK_1.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank2", TANK_2.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank3", TANK_3.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank4", TANK_4.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank5", TANK_5.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank6", TANK_6.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("output_tank", OUTPUT_TANK.writeToNBT(provider, new CompoundTag()));


    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.@NotNull Provider provider) {
        progress = compoundTag.getInt("progress");
        maxProgress = compoundTag.getInt("maxProgress");
        TANK_1.readFromNBT(provider, compoundTag.getCompound("tank1"));
        TANK_2.readFromNBT(provider, compoundTag.getCompound("tank2"));
        TANK_3.readFromNBT(provider, compoundTag.getCompound("tank3"));
        TANK_4.readFromNBT(provider, compoundTag.getCompound("tank4"));
        TANK_5.readFromNBT(provider, compoundTag.getCompound("tank5"));
        TANK_6.readFromNBT(provider, compoundTag.getCompound("tank6"));
        OUTPUT_TANK.readFromNBT(provider, compoundTag.getCompound("output_tank"));
        super.loadAdditional(compoundTag, provider);
    }


    public void drops() {
    }

    public void tick() {
        assert level != null;
        if (!level.isClientSide()) {

            boolean foundMatch = false;


            for (RecipeHolder<MixingRecipe> recipeHolder : level.getRecipeManager().getRecipesFor(MixingRecipe.Type.INSTANCE, NoInventoryRecipe.INSTANCE, level)) {
                MixingRecipe recipe = recipeHolder.value();
                FluidStack fluid1 = recipe.fluid1();
                FluidStack fluid2 = recipe.fluid2();
                FluidStack fluid3 = recipe.fluid3();
                FluidStack fluid4 = recipe.fluid4();
                FluidStack fluid5 = recipe.fluid5();
                FluidStack fluid6 = recipe.fluid6();

                /*
                System.out.println("Fluid 1: " + fluid1.getFluid());
                System.out.println("Fluid 2: " + fluid2.getFluid());
                System.out.println("Fluid 3: " + fluid3.getFluid());
                System.out.println("Fluid 4: " + fluid4.getFluid());
                System.out.println("Fluid 5: " + fluid5.getFluid());
                System.out.println("Fluid 6: " + fluid6.getFluid());

                 */
            }




            /*
            for (RecipeHolder<SolidifierRecipe> recipeHolder : level.getRecipeManager().getRecipesFor(SolidifierRecipe.Type.INSTANCE, inventory, level)) {
                SolidifierRecipe recipe = recipeHolder.value();
                if (recipe.mold().test(itemHandler.getStackInSlot(0)) && hasEnoughFluid(recipe.fluid())) {
                    FluidStack output = recipe.fluid();

                    if (hasOutputSpaceMaking(this, recipe)) {
                        progress++;

                        if (progress >= maxProgress) {
                            extractFluid(output, output.getAmount());
                            itemHandler.setStackInSlot(1, new ItemStack(recipe.output().getItems()[0].getItem(), recipe.output().count() + itemHandler.getStackInSlot(1).getCount()));
                            setChanged();
                            resetProgress();
                            sync();
                        }
           foundMatch = true;
                        break;
                    }
                }
            }

             */

            if (!foundMatch) {
                resetProgress();
            }
        }
    }


    private void resetProgress() {
        progress = 0;
    }
}