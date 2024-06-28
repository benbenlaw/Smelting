package com.benbenlaw.smelting.integration.jei;

import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.block.ModBlocks;
import com.benbenlaw.smelting.recipe.FuelRecipe;
import com.benbenlaw.smelting.recipe.MeltingRecipe;
import com.benbenlaw.smelting.recipe.ModRecipes;
import com.benbenlaw.smelting.recipe.SolidifierRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import org.jetbrains.annotations.NotNull;


@JeiPlugin
public class JEISmeltingPlugin implements IModPlugin {

    public static IDrawableStatic slotDrawable;



    public static RecipeType<MeltingRecipe> MELTING_RECIPE =
            new RecipeType<>(MeltingRecipeCatagory.UID, MeltingRecipe.class);


    public static RecipeType<SolidifierRecipe> SOLIDIFIER_RECIPE =
            new RecipeType<>(SolidifierRecipeCatagory.UID, SolidifierRecipe.class);



    public static RecipeType<FuelRecipe> FUEL_RECIPE =
            new RecipeType<>(FuelRecipeCategory.UID, FuelRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TANK.get()), FuelRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SOLIDIFIER.get()), SolidifierRecipeCatagory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CONTROLLER.get()), MeltingRecipeCatagory.RECIPE_TYPE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new
                FuelRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                SolidifierRecipeCatagory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                MeltingRecipeCatagory(registration.getJeiHelpers().getGuiHelper()));




        slotDrawable = guiHelper.getSlotDrawable();
    }



    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        final var recipeManager = Minecraft.getInstance().level.getRecipeManager();

        registration.addRecipes(FuelRecipeCategory.RECIPE_TYPE,
                recipeManager.getAllRecipesFor(ModRecipes.FUEL_TYPE.get()).stream().map(RecipeHolder::value).toList());


        registration.addRecipes(MeltingRecipeCatagory.RECIPE_TYPE,
                recipeManager.getAllRecipesFor(ModRecipes.MELTING_TYPE.get()).stream().map(RecipeHolder::value).toList());

        registration.addRecipes(SolidifierRecipeCatagory.RECIPE_TYPE,
                recipeManager.getAllRecipesFor(ModRecipes.SOLIDIFIER_TYPE.get()).stream().map(RecipeHolder::value).toList());


    }

}


