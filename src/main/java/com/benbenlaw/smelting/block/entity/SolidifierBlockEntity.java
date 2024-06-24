package com.benbenlaw.smelting.block.entity;

import com.benbenlaw.opolisutilities.block.entity.custom.BlockPlacerBlockEntity;
import com.benbenlaw.opolisutilities.block.entity.custom.handler.InputOutputItemHandler;
import com.benbenlaw.opolisutilities.util.inventory.IInventoryHandlingBlockEntity;
import com.benbenlaw.smelting.block.screen.SolidifierMenu;
import com.benbenlaw.smelting.recipe.SolidifierRecipe;
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
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class SolidifierBlockEntity extends BlockEntity implements MenuProvider, IInventoryHandlingBlockEntity {

    private final ItemStackHandler itemHandler = new ItemStackHandler(8) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            sync();
        }
    };

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

    private final IFluidHandler fluidHandler = new IFluidHandler() {
        @Override
        public int getTanks() {
            return 4;
        }

        @Override
        public FluidStack getFluidInTank(int tank) {

            if (tank == 0)
                return TANK_1.getFluid();
            if (tank == 1)
                return TANK_2.getFluid();
            if (tank == 2)
                return TANK_3.getFluid();
            if (tank == 3)
                return TANK_4.getFluid();
            return null;
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
            return 0;
        }

        @Override
        public boolean isFluidValid(int tank, FluidStack stack) {
            return switch (tank) {
                case 0 -> TANK_1.isFluidValid(stack);
                case 1 -> TANK_2.isFluidValid(stack);
                case 2 -> TANK_3.isFluidValid(stack);
                case 3 -> TANK_4.isFluidValid(stack);
                default -> false;
            };
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
            return 0;
        }

        @Override
        public FluidStack drain(FluidStack resource, FluidAction action) {
            return null;
        }

        @Override
        public FluidStack drain(int maxDrain, FluidAction action) {
            return null;
        }
    };

    public boolean onPlayerUse(Player player, InteractionHand hand) {
        // Assuming TANK_1, TANK_2, TANK_3, TANK_4 are your tanks or references to them.
        FluidTank[] tanks = { TANK_1, TANK_2, TANK_3, TANK_4 };

        for (FluidTank tank : tanks) {
            if (!tank.isEmpty() || tank.getCapacity() != tank.getFluidAmount()) {
                boolean interacted = FluidUtil.interactWithFluidHandler(player, hand, tank);
                if (interacted) {
                    return true;
                }
            }
        }
        return false;
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
    private final IItemHandler solidifierItemHandler = new InputOutputItemHandler(itemHandler,
            (i, stack) -> true,
            i -> false //
    );

    public @Nullable IItemHandler getItemHandlerCapability(@Nullable Direction side) {
        return solidifierItemHandler;
    }

    public void setHandler(ItemStackHandler handler) {
        for (int i = 0; i < handler.getSlots(); i++) {
            this.itemHandler.setStackInSlot(i, handler.getStackInSlot(i));
        }
    }

    public ItemStackHandler getItemStackHandler() {
        return this.itemHandler;
    }

    public SolidifierBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOLIDIFIER_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> SolidifierBlockEntity.this.progress;
                    case 1 -> SolidifierBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SolidifierBlockEntity.this.progress = value;
                    case 1 -> SolidifierBlockEntity.this.maxProgress = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.smelting.solidifier");
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int container, @NotNull Inventory inventory, @NotNull Player player) {
        return new SolidifierMenu(container, inventory, this.getBlockPos(), data);
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
        compoundTag.put("inventory", this.itemHandler.serializeNBT(provider));
        compoundTag.putInt("progress", progress);
        compoundTag.putInt("maxProgress", maxProgress);
        compoundTag.put("tank1", TANK_1.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank2", TANK_2.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank3", TANK_3.writeToNBT(provider, new CompoundTag()));
        compoundTag.put("tank4", TANK_4.writeToNBT(provider, new CompoundTag()));


    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.@NotNull Provider provider) {
        this.itemHandler.deserializeNBT(provider, compoundTag.getCompound("inventory"));

        progress = compoundTag.getInt("progress");
        maxProgress = compoundTag.getInt("maxProgress");

        TANK_1.readFromNBT(provider, compoundTag.getCompound("tank1"));
        TANK_2.readFromNBT(provider, compoundTag.getCompound("tank2"));
        TANK_3.readFromNBT(provider, compoundTag.getCompound("tank3"));
        TANK_4.readFromNBT(provider, compoundTag.getCompound("tank4"));

        super.loadAdditional(compoundTag, provider);
    }


    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick() {
        assert level != null;
        if (!level.isClientSide()) {
            RecipeInput inventory = new RecipeInput() {
                @Override
                public ItemStack getItem(int index) {
                    if (index == 0 || index == 2 || index == 4 || index == 6) {
                        return itemHandler.getStackInSlot(index);
                    }
                    return ItemStack.EMPTY;
                }

                @Override
                public int size() {
                    return 4;
                }
            };

            sync();

            Optional<RecipeHolder<SolidifierRecipe>> selectedRecipe = Optional.empty();

            for (RecipeHolder<SolidifierRecipe> recipeHolder : level.getRecipeManager().getRecipesFor(SolidifierRecipe.Type.INSTANCE, inventory, level)) {
                SolidifierRecipe recipe = recipeHolder.value();

                boolean isValidRecipe = false;
                for (int i = 0; i <= 6; i += 2) {
                    if (recipe.mold().test(itemHandler.getStackInSlot(i)) && hasEnoughFluid(recipe.fluid(), i) && isRecipeSlotsValidForTanks(recipe)) {
                        isValidRecipe = true;
                        break;
                    }
                }

                if (isValidRecipe) {
                    selectedRecipe = Optional.of(recipeHolder);
                    break;
                }
            }

            if (selectedRecipe.isPresent()) {
                RecipeHolder<SolidifierRecipe> match = selectedRecipe.get();
                SolidifierRecipe recipe = match.value();

                progress++;

                if (progress >= maxProgress) {
                    int inputSlotIndex = -1;
                    int outputSlotIndex = -1;

                    for (int i = 0; i <= 6; i += 2) {
                        if (recipe.mold().test(itemHandler.getStackInSlot(i)) && isRecipeSlotsValidForTanks(recipe)) {
                            inputSlotIndex = i;
                            outputSlotIndex = i + 1;
                            break;
                        }
                    }

                    if (inputSlotIndex != -1 && outputSlotIndex != -1) {
                        itemHandler.getStackInSlot(inputSlotIndex).shrink(1);

                        ItemStack outputStack = itemHandler.getStackInSlot(outputSlotIndex);
                        if (outputStack.isEmpty()) {
                            itemHandler.setStackInSlot(outputSlotIndex, new ItemStack(recipe.output().getItem(), 1));
                        } else {
                            outputStack.grow(1);
                            itemHandler.setStackInSlot(outputSlotIndex, outputStack);
                        }

                        extractFluid(recipe.fluid(), recipe.fluid().getAmount(), inputSlotIndex);

                        System.out.println("Recipe Matched");
                        resetProgress();
                    }
                }
            }
        }
    }



    private void resetProgress() {
        progress = 0;
    }

    private void extractFluid(FluidStack output, int amount, int slot) {
        switch (slot) {
            case 0:
            case 1:
                if (TANK_1.getFluidAmount() >= amount && TANK_1.getFluid().getFluid() == output.getFluid()) {
                    TANK_1.drain(amount, IFluidHandler.FluidAction.EXECUTE);
                }
                break;
            case 2:
            case 3:
                if (TANK_2.getFluidAmount() >= amount && TANK_2.getFluid().getFluid() == output.getFluid()) {
                    TANK_2.drain(amount, IFluidHandler.FluidAction.EXECUTE);
                }
                break;
            case 4:
            case 5:
                if (TANK_3.getFluidAmount() >= amount && TANK_3.getFluid().getFluid() == output.getFluid()) {
                    TANK_3.drain(amount, IFluidHandler.FluidAction.EXECUTE);
                }
                break;
            case 6:
            case 7:
                if (TANK_4.getFluidAmount() >= amount && TANK_4.getFluid().getFluid() == output.getFluid()) {
                    TANK_4.drain(amount, IFluidHandler.FluidAction.EXECUTE);
                }
                break;
        }
    }


    private boolean hasEnoughFluid(FluidStack output, int slot) {
        switch (slot) {
            case 0:
            case 1:
                return TANK_1.getFluidAmount() >= output.getAmount() && TANK_1.getFluid().getFluid() == output.getFluid();
            case 2:
            case 3:
                return TANK_2.getFluidAmount() >= output.getAmount() && TANK_2.getFluid().getFluid() == output.getFluid();
            case 4:
            case 5:
                return TANK_3.getFluidAmount() >= output.getAmount() && TANK_3.getFluid().getFluid() == output.getFluid();
            case 6:
            case 7:
                return TANK_4.getFluidAmount() >= output.getAmount() && TANK_4.getFluid().getFluid() == output.getFluid();
            default:
                return false;
        }
    }


    private boolean isRecipeSlotsValidForTanks(SolidifierRecipe recipe) {
        FluidStack recipeFluid = recipe.fluid();

        boolean tank1Valid = TANK_1.getFluid().is(recipeFluid.getFluidType()) && (tankIsValidForSlot(recipeFluid, 0) || tankIsValidForSlot(recipeFluid, 1));
        boolean tank2Valid = TANK_2.getFluid().is(recipeFluid.getFluidType()) && (tankIsValidForSlot(recipeFluid, 2) || tankIsValidForSlot(recipeFluid, 3));
        boolean tank3Valid = TANK_3.getFluid().is(recipeFluid.getFluidType()) && (tankIsValidForSlot(recipeFluid, 4) || tankIsValidForSlot(recipeFluid, 5));
        boolean tank4Valid = TANK_4.getFluid().is(recipeFluid.getFluidType()) && (tankIsValidForSlot(recipeFluid, 6) || tankIsValidForSlot(recipeFluid, 7));

        return tank1Valid || tank2Valid || tank3Valid || tank4Valid;
    }

    private boolean tankIsValidForSlot(FluidStack stack, int slot) {
        switch (slot) {
            case 0:
            case 1:
                return stack.getFluid() == TANK_1.getFluid().getFluid();
            case 2:
            case 3:
                return stack.getFluid() == TANK_2.getFluid().getFluid();
            case 4:
            case 5:
                return stack.getFluid() == TANK_3.getFluid().getFluid();
            case 6:
            case 7:
                return stack.getFluid() == TANK_4.getFluid().getFluid();
            default:
                return false;
        }
    }

}
