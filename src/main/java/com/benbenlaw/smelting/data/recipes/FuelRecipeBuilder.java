package com.benbenlaw.smelting.data.recipes;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.recipe.CatalogueRecipe;
import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.recipe.FuelRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
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

public class FuelRecipeBuilder implements RecipeBuilder {

    protected String group;
    protected FluidStack fluid;
    protected int temp;
    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public FuelRecipeBuilder(FluidStack fluid, int temp) {
        this.fluid = fluid;
        this.temp = temp;
    }

    public static FuelRecipeBuilder FuelRecipesBuilder(FluidStack fluid, int temp) {
        return new FuelRecipeBuilder(fluid, temp);
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
        this.save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "fuel/" +
                BuiltInRegistries.FLUID.getKey(this.fluid.getFluid()).getPath()));
    }

    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull ResourceLocation id) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        FuelRecipe fuelRecipe = new FuelRecipe(this.fluid, this.temp);
        recipeOutput.accept(id, fuelRecipe, builder.build(id.withPrefix("recipes/fuel/")));

    }

}
