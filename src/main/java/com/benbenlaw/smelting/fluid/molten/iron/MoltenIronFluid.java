package com.benbenlaw.smelting.fluid.molten.iron;

import com.benbenlaw.smelting.fluid.ModFluids;
import com.benbenlaw.smelting.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import org.jetbrains.annotations.NotNull;

public class MoltenIronFluid extends BaseFlowingFluid {

    public static final Properties PROPERTIES = new Properties(
            ModFluids.MOLTEN_IRON_TYPE,
            ModFluids.MOLTEN_IRON_FLOWING,
            ModFluids.MOLTEN_IRON_SOURCE).bucket(ModItems.MOLTEN_IRON_BUCKET).block(ModFluids.MOLTEN_IRON_BLOCK)


    ;

    protected MoltenIronFluid(Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.MOLTEN_IRON_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return ModFluids.MOLTEN_IRON_SOURCE.get();
    }

    @Override
    public Item getBucket() {
        return ModItems.MOLTEN_IRON_BUCKET.get();
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    protected boolean canConvertToSource(Level pLevel) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }

    public static class Flowing extends MoltenIronFluid {
        public Flowing() {
            super(PROPERTIES);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
            super.createFluidStateDefinition(pBuilder);
            pBuilder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState pState) {
            return pState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState pState) {
            return false;
        }


    }

    public static class Source extends MoltenIronFluid {
        public Source() {
            super(PROPERTIES);
        }

        @Override
        public int getAmount(FluidState pState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState pState) {
            return true;
        }
    }
}
