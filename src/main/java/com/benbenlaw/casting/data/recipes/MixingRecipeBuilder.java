package com.benbenlaw.casting.data.recipes;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.recipe.MixingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class MixingRecipeBuilder implements RecipeBuilder {

    protected String group;

    protected FluidStack fluid1;
    protected FluidStack fluid2;
    protected FluidStack fluid3;
    protected FluidStack fluid4;
    protected FluidStack fluid5;
    protected FluidStack fluid6;
    protected FluidStack outputFluid;
    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public MixingRecipeBuilder(FluidStack fluid1, FluidStack fluid2, FluidStack fluid3, FluidStack fluid4, FluidStack fluid5, FluidStack fluid6, FluidStack outputFluid) {
        this.fluid1 = fluid1 != null ? fluid1 : FluidStack.EMPTY;
        this.fluid2 = fluid2 != null ? fluid2 : FluidStack.EMPTY;
        this.fluid3 = fluid3 != null ? fluid3 : FluidStack.EMPTY;
        this.fluid4 = fluid4 != null ? fluid4 : FluidStack.EMPTY;
        this.fluid5 = fluid5 != null ? fluid5 : FluidStack.EMPTY;
        this.fluid6 = fluid6 != null ? fluid6 : FluidStack.EMPTY;
        this.outputFluid = outputFluid;
    }

    public static MixingRecipeBuilder MixingRecipesBuilder(FluidStack fluid1, FluidStack fluid2, FluidStack fluid3, FluidStack fluid4, FluidStack fluid5, FluidStack fluid6, FluidStack outputFluid) {
        return new MixingRecipeBuilder(fluid1, fluid2, fluid3, fluid4, fluid5, fluid6, outputFluid);
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }

    public void save(@NotNull RecipeOutput recipeOutput) {
        this.save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Casting.MOD_ID, "mixer/"));
    }

    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull ResourceLocation id) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        MixingRecipe mixingRecipe = new MixingRecipe(this.fluid1, this.fluid2, this.fluid3, this.fluid4, this.fluid5, this.fluid6, this.outputFluid);
        recipeOutput.accept(id, mixingRecipe, builder.build(id.withPrefix("recipes/mixer/")));

    }

}
