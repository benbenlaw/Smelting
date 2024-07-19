package com.benbenlaw.casting.data;

import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.data.recipes.FuelRecipeBuilder;
import com.benbenlaw.casting.data.recipes.MeltingRecipeBuilder;
import com.benbenlaw.casting.data.recipes.MixingRecipeBuilder;
import com.benbenlaw.casting.data.recipes.SolidifierRecipeBuilder;
import com.benbenlaw.casting.fluid.CastingFluids;
import com.benbenlaw.casting.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.concurrent.CompletableFuture;

import static com.benbenlaw.casting.data.ModdedTags.*;

public class CastingRecipes extends RecipeProvider {

    public CastingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        //Black Brick

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BRICK), RecipeCategory.MISC, new ItemStack(ModItems.BLACK_BRICK.get()), 0.5f, 100)
                .unlockedBy("has_brick", has(Items.BRICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_BRICKS.get(), 1)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BLACK_BRICK.get())
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Tank
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TANK.get(), 1)
                .pattern("BBB")
                .pattern("BGB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('G', Tags.Items.GLASS_BLOCKS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Controller
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CONTROLLER.get(), 1)
                .pattern("BBB")
                .pattern("B B")
                .pattern("BBB")
                .define('B', ModBlocks.BLACK_BRICKS.get())
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Solidifier
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOLIDIFIER.get(), 1)
                .pattern("BBB")
                .pattern("K K")
                .pattern("BBB")
                .define('B', ModBlocks.BLACK_BRICKS.get())
                .define('K', ModItems.BLACK_BRICK.get())
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Gear Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEAR_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BGB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('G', gearTag)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(gearTag))));

        // Ingot Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INGOT_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', Tags.Items.INGOTS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Nugget Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NUGGET_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', Tags.Items.NUGGETS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Plate Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATE_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', plateTag)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(plateTag))));

        // Rod Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROD_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', rodTag)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(rodTag))));

        // Block Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLOCK_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', Tags.Items.STORAGE_BLOCKS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Gem Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEM_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', Tags.Items.GEMS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // Dust Mold
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DUST_MOLD.get(), 1)
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.BLACK_BRICK.get())
                .define('I', Tags.Items.DUSTS)
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK.get()))
                .save(consumer);

        // ********** Fuels ********** //

        // Lava
        FuelRecipeBuilder.FuelRecipesBuilder(new FluidStack(Fluids.LAVA, 10), 1000)
                .unlockedBy("has_item", has(Items.BUCKET))
                .save(consumer);

        // Coal
        FuelRecipeBuilder.FuelRecipesBuilder(new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 8), 1200)
                .unlockedBy("has_item", has(Items.BUCKET))
                .save(consumer);
        
        // Uranium
        FuelRecipeBuilder.FuelRecipesBuilder(new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 25), 1600)
                .unlockedBy("has_item", has(Items.BUCKET))
                .save(consumer);

        // ********** Processing ********** //

        // Iron Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_IRON), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(consumer, "casting:melting/iron/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_IRON), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_IRON))
                .save(consumer, "casting:melting/iron/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_IRON), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_IRON))
                .save(consumer, "casting:melting/iron/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 810))
                .unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_INGOT), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 90))
                .unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_NUGGET), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 10))
                .unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(ironGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 360))
                .unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_gear");



        //Gold Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.INGOTS_GOLD))
                .save(consumer, "casting:melting/gold/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_GOLD), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_GOLD))
                .save(consumer, "casting:melting/gold/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_GOLD), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_GOLD)).save(consumer, "casting:melting/gold/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.GOLD_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 810))
                .unlockedBy("has_item", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD),new SizedIngredient(Ingredient.of(Items.GOLD_INGOT), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 90))
                .unlockedBy("has_item", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(Items.GOLD_NUGGET), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 10))
                .unlockedBy("has_item", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(goldGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 360))
                .unlockedBy("has_item", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_gear");

        //Copper Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_COPPER), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.INGOTS_COPPER))
                .save(consumer, "casting:melting/copper/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_COPPER), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_COPPER))
                .save(consumer, "casting:melting/copper/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_COPPER), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_COPPER)).save(consumer, "casting:melting/copper/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD),new SizedIngredient(Ingredient.of(Items.COPPER_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 810))
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(Items.COPPER_INGOT), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 90))
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(com.benbenlaw.opolisutilities.item.ModItems.COPPER_NUGGET), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 10))
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(copperGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 360))
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_gear");

        //Tin Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(tinIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinIngotTag))), "casting:melting/tin/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(ModdedTags.tinOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(ModdedTags.tinOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinOreTag))), "casting:melting/tin/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(ModdedTags.tinRawOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(ModdedTags.tinRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinRawOreTag))), "casting:melting/tin/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(tinBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 810))
                .unlockedBy("has_item", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinBlockTag))), "casting:solidifier/tin_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(tinIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 90))
                .unlockedBy("has_item", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinIngotTag))), "casting:solidifier/tin_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(ModdedTags.tinNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 10))
                .unlockedBy("has_item", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinNuggetTag))), "casting:solidifier/tin_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(tinGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 360))
                .unlockedBy("has_item", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinGearTag))), "casting:solidifier/tin_gear");

        //Osmium Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumIngotTag))), "casting:melting/osmium/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(osmiumOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumOreTag))), "casting:melting/osmium/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumRawOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(osmiumRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumRawOreTag))), "casting:melting/osmium/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(osmiumBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 810))
                .unlockedBy("has_item", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumBlockTag))), "casting:solidifier/osmium_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(osmiumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 90))
                .unlockedBy("has_item", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumIngotTag))), "casting:solidifier/osmium_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(osmiumNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 10))
                .unlockedBy("has_item", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumNuggetTag))), "casting:solidifier/osmium_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(osmiumGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_OSMIUM.getFluid(), 360))
                .unlockedBy("has_item", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumGearTag))), "casting:solidifier/osmium_gear");

        //Uranium Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumIngotTag))), "casting:melting/uranium/from_ingot");


        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(uraniumOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumOreTag))), "casting:melting/uranium/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumRawOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(uraniumRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumRawOreTag))), "casting:melting/uranium/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(uraniumBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 810))
                .unlockedBy("has_item", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumBlockTag))), "casting:solidifier/uranium_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(uraniumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 90))
                .unlockedBy("has_item", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumIngotTag))), "casting:solidifier/uranium_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(uraniumNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 10))
                .unlockedBy("has_item", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumNuggetTag))), "casting:solidifier/uranium_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(uraniumGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_URANIUM.getFluid(), 360))
                .unlockedBy("has_item", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumGearTag))), "casting:solidifier/uranium_gear");

        //Lead Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadIngotTag))), "casting:melting/lead/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(leadOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadOreTag))), "casting:melting/lead/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadRawOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(leadRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadRawOreTag))), "casting:melting/lead/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(leadBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 810))
                .unlockedBy("has_item", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadBlockTag))), "casting:solidifier/lead_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(leadIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 90))
                .unlockedBy("has_item", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadIngotTag))), "casting:solidifier/lead_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(leadNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 10))
                .unlockedBy("has_item", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadNuggetTag))), "casting:solidifier/lead_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(leadGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LEAD.getFluid(), 360))
                .unlockedBy("has_item", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadGearTag))), "casting:solidifier/lead_gear");

        //Silver Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(silverIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(silverIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverIngotTag))), "casting:melting/silver/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(silverOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(silverOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverOreTag))), "casting:melting/silver/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(silverRawOreTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(silverRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverRawOreTag))), "casting:melting/silver/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(silverBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 810))
                .unlockedBy("has_item", has(silverIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverBlockTag))), "casting:solidifier/silver_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(silverIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 90))
                .unlockedBy("has_item", has(silverIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverIngotTag))), "casting:solidifier/silver_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(silverNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 10))
                .unlockedBy("has_item", has(silverIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverNuggetTag))), "casting:solidifier/silver_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(silverGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 360))
                .unlockedBy("has_item", has(silverIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverGearTag))), "casting:solidifier/silver_gear");

        // Coal Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Items.COAL), 1),
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 80), 1000)
                .unlockedBy("has_item", has(Items.COAL))
                .save(consumer, "casting:melting/coal/from_item");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_COAL), 1),
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_COAL))
                .save(consumer, "casting:melting/coal/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.COAL_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 720))
                .unlockedBy("has_item", has(Items.COAL)).save(consumer, "casting:solidifier/coal_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.COAL), 1),
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 80))
                .unlockedBy("has_item", has(Items.COAL)).save(consumer, "casting:solidifier/coal");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(com.benbenlaw.opolisutilities.item.ModItems.MINI_COAL), 1),
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 10))
                .unlockedBy("has_item", has(Items.COAL)).save(consumer, "casting:solidifier/mini_coal");

        // Emerald Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_EMERALD), 1),
                        new FluidStack(CastingFluids.MOLTEN_EMERALD.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.GEMS_EMERALD))
                .save(consumer, "casting:melting/emerald/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_EMERALD), 1),
                        new FluidStack(CastingFluids.MOLTEN_EMERALD.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_EMERALD))
                .save(consumer, "casting:melting/emerald/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.EMERALD_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_EMERALD.getFluid(), 810))
                .unlockedBy("has_item", has(Items.EMERALD)).save(consumer, "casting:solidifier/emerald_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.EMERALD), 1),
                        new FluidStack(CastingFluids.MOLTEN_EMERALD.getFluid(), 90))
                .unlockedBy("has_item", has(Items.EMERALD)).save(consumer,"casting:solidifier/emerald");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(emeraldGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_EMERALD.getFluid(), 360))
                .unlockedBy("has_item", has(emeraldGearTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(emeraldGearTag))), "casting:solidifier/emerald_gear");

        //Diamond Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND), 1),
                        new FluidStack(CastingFluids.MOLTEN_DIAMOND.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.GEMS_DIAMOND))
                .save(consumer, "casting:melting/diamond/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_DIAMOND), 1),
                        new FluidStack(CastingFluids.MOLTEN_DIAMOND.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_DIAMOND))
                .save(consumer, "casting:melting/diamond/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.DIAMOND_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_DIAMOND.getFluid(), 810))
                .unlockedBy("has_item", has(Items.DIAMOND)).save(consumer, "casting:solidifier/diamond_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.DIAMOND), 1),
                        new FluidStack(CastingFluids.MOLTEN_DIAMOND.getFluid(), 90))
                .unlockedBy("has_item", has(Items.DIAMOND)).save(consumer, "casting:solidifier/diamond");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(diamondGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_DIAMOND.getFluid(), 360))
                .unlockedBy("has_item", has(diamondGearTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(diamondGearTag))), "casting:solidifier/diamond_gear");

        //Redstone Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE), 1),
                        new FluidStack(CastingFluids.MOLTEN_REDSTONE.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.DUSTS_REDSTONE))
                .save(consumer, "casting:melting/redstone/from_dust");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_REDSTONE), 1),
                        new FluidStack(CastingFluids.MOLTEN_REDSTONE.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_REDSTONE))
                .save(consumer, "casting:melting/redstone/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.REDSTONE_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_REDSTONE.getFluid(), 810))
                .unlockedBy("has_item", has(Items.REDSTONE)).save(consumer, "casting:solidifier/redstone_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.DUST_MOLD), new SizedIngredient(Ingredient.of(Items.REDSTONE), 1),
                        new FluidStack(CastingFluids.MOLTEN_REDSTONE.getFluid(), 90))
                .unlockedBy("has_item", has(Items.REDSTONE)).save(consumer, "casting:solidifier/redstone");


        //Lapis Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS), 1),
                        new FluidStack(CastingFluids.MOLTEN_LAPIS.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.GEMS_LAPIS))
                .save(consumer, "casting:melting/lapis/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_LAPIS), 1),
                        new FluidStack(CastingFluids.MOLTEN_LAPIS.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_LAPIS))
                .save(consumer, "casting:melting/lapis/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD),new SizedIngredient(Ingredient.of(Items.LAPIS_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_LAPIS.getFluid(), 810))
                .unlockedBy("has_item", has(Items.LAPIS_LAZULI)).save(consumer, "casting:solidifier/lapis_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.LAPIS_LAZULI), 1),
                        new FluidStack(CastingFluids.MOLTEN_LAPIS.getFluid(), 90))
                .unlockedBy("has_item", has(Items.LAPIS_LAZULI)).save(consumer, "casting:solidifier/lapis");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(lapisGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_LAPIS.getFluid(), 360))
                .unlockedBy("has_item", has(lapisGearTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(lapisGearTag))), "casting:solidifier/lapis_gear");


        //Obsidian Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.OBSIDIANS), 1),
                        new FluidStack(CastingFluids.MOLTEN_OBSIDIAN.getFluid(), 1000), 1200)
                .unlockedBy("has_item", has(Tags.Items.ORES_LAPIS))
                .save(consumer, "casting:melting/obsidian/from_block");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(Fluids.WATER, 1000),
                        new FluidStack(Fluids.LAVA, 1000),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(CastingFluids.MOLTEN_OBSIDIAN.getFluid(), 1000))
                .unlockedBy("has_item", has(Items.WATER_BUCKET))
                .save(consumer, "casting:mixing/obsidian");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.OBSIDIAN), 1),
                        new FluidStack(CastingFluids.MOLTEN_OBSIDIAN.getFluid(), 1000))
                .unlockedBy("has_item", has(Items.OBSIDIAN)).save(consumer, "casting:solidifier/obsidian_block");

        //Bronze Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 810), 1000)
                .unlockedBy("has_item", has(bronzeBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeBlockTag))), "casting:melting/bronze/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))), "casting:melting/bronze/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 10), 1000)
                .unlockedBy("has_item", has(bronzeNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeNuggetTag))), "casting:melting/bronze/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(CastingFluids.MOLTEN_COPPER.getFluid(), 270),
                        new FluidStack(CastingFluids.MOLTEN_TIN.getFluid(), 90),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 360))
                .unlockedBy("has_item", has(bronzeIngotTag))
                .save(consumer, "casting:mixing/bronze");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(bronzeBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 810))
                .unlockedBy("has_item", has(bronzeBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeBlockTag))), "casting:solidifier/bronze_block");


        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(bronzeIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 90))
                .unlockedBy("has_item", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))), "casting:solidifier/bronze_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(bronzeNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 10))
                .unlockedBy("has_item", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeNuggetTag))), "casting:solidifier/bronze_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(bronzeGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_BRONZE.getFluid(), 360))
                .unlockedBy("has_item", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeGearTag))), "casting:solidifier/bronze_gear");

        //Steel Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 810), 1000)
                .unlockedBy("has_item", has(steelBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelBlockTag))), "casting:melting/steel/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelIngotTag))), "casting:melting/steel/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 10), 1000)
                .unlockedBy("has_item", has(steelNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelNuggetTag))), "casting:melting/steel/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(CastingFluids.MOLTEN_COAL.getFluid(), 160),
                        new FluidStack(CastingFluids.MOLTEN_IRON.getFluid(), 90),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 90))
                .unlockedBy("has_item", has(steelIngotTag))
                .save(consumer, "casting:mixing/steel");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(steelBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 810))
                .unlockedBy("has_item", has(steelBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelBlockTag))), "casting:solidifier/steel_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(steelIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 90))
                .unlockedBy("has_item", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelIngotTag))), "casting:solidifier/steel_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(steelNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 10))
                .unlockedBy("has_item", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelNuggetTag))), "casting:solidifier/steel_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(steelGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STEEL.getFluid(), 360))
                .unlockedBy("has_item", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelGearTag))), "casting:solidifier/steel_gear");


        //Netherite Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Blocks.NETHERITE_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 810), 1250)
                .unlockedBy("has_item", has(Blocks.NETHERITE_BLOCK)).save(consumer, "casting:melting/netherite/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_NETHERITE), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 90), 1250)
                .unlockedBy("has_item", has(Tags.Items.INGOTS_NETHERITE)).save(consumer, "casting:melting/netherite/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(netheriteNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 10), 1250)
                .unlockedBy("has_item", has(netheriteNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(netheriteNuggetTag))), "casting:melting/netherite/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 360),
                        new FluidStack(CastingFluids.MOLTEN_DEBRIS.getFluid(), 360),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 90))
                .unlockedBy("has_item", has(steelIngotTag))
                .save(consumer, "casting:mixing/netherite");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Blocks.NETHERITE_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 810))
                    .unlockedBy("has_item", has(Blocks.NETHERITE_BLOCK)).save(consumer, "casting:solidifier/netherite_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_NETHERITE), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 90))
                    .unlockedBy("has_item", has(Tags.Items.INGOTS_NETHERITE)).save(consumer, "casting:solidifier/netherite_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(netheriteNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 10))
                    .unlockedBy("has_item", has(netheriteNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(netheriteNuggetTag))), "casting:solidifier/netherite_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(netheriteGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_NETHERITE.getFluid(), 360))
                    .unlockedBy("has_item", has(netheriteGearTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(netheriteGearTag))), "casting:solidifier/netherite_gear");



        //Debris Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Blocks.ANCIENT_DEBRIS), 1),
                        new FluidStack(CastingFluids.MOLTEN_DEBRIS.getFluid(), 100), 1250)
                .unlockedBy("has_item", has(Blocks.ANCIENT_DEBRIS)).save(consumer, "casting:melting/debris/from_ore");


        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Items.NETHERITE_SCRAP), 1),
                        new FluidStack(CastingFluids.MOLTEN_DEBRIS.getFluid(), 90), 1250)
                .unlockedBy("has_item", has(Blocks.ANCIENT_DEBRIS)).save(consumer, "casting:melting/debris/from_scrap");

        //Quartz Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ), 1),
                        new FluidStack(CastingFluids.MOLTEN_QUARTZ.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(Tags.Items.GEMS_QUARTZ))
                .save(consumer, "casting:melting/quartz/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_QUARTZ), 1),
                        new FluidStack(CastingFluids.MOLTEN_QUARTZ.getFluid(), 100), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_QUARTZ))
                .save(consumer, "casting:melting/quartz/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Items.QUARTZ_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_QUARTZ.getFluid(), 360), 1000)
                .unlockedBy("has_item", has(Tags.Items.ORES_QUARTZ))
                .save(consumer, "casting:melting/quartz/from_block");



        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.QUARTZ_BLOCK), 1),
                        new FluidStack(CastingFluids.MOLTEN_QUARTZ.getFluid(), 360))
                .unlockedBy("has_item", has(Items.QUARTZ)).save(consumer, "casting:solidifier/quartz_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.QUARTZ), 1),
                        new FluidStack(CastingFluids.MOLTEN_QUARTZ.getFluid(), 90))
                .unlockedBy("has_item", has(Items.QUARTZ)).save(consumer, "casting:solidifier/quartz");

        //Glass Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Items.GLASS), 1),
                        new FluidStack(CastingFluids.MOLTEN_GLASS.getFluid(), 1000), 250)
                .unlockedBy("has_item", has(Items.GLASS))
                .save(consumer, "casting:melting/glass/from_item");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.SANDS), 1),
                        new FluidStack(CastingFluids.MOLTEN_GLASS.getFluid(), 1000), 250)
                .unlockedBy("has_item", has(Tags.Items.SANDS))
                .save(consumer, "casting:melting/glass/from_sand");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.GLASS), 1),
                        new FluidStack(CastingFluids.MOLTEN_GLASS.getFluid(), 1000))
                .unlockedBy("has_item", has(Items.GLASS)).save(consumer, "casting:solidifier/glass_block");

        //Stone Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.STONES), 1),
                        new FluidStack(CastingFluids.MOLTEN_STONE.getFluid(), 1000), 900)
                .unlockedBy("has_item", has(Tags.Items.STONES))
                .save(consumer, "casting:melting/stone/from_stone");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.COBBLESTONES), 1),
                        new FluidStack(CastingFluids.MOLTEN_STONE.getFluid(), 1000), 900)
                .unlockedBy("has_item", has(Tags.Items.COBBLESTONES))
                .save(consumer, "casting:melting/stone/from_cobblestone");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.STONE), 1),
                        new FluidStack(CastingFluids.MOLTEN_STONE.getFluid(), 1000))
                .unlockedBy("has_item", has(Tags.Items.STONES)).save(consumer, "casting:solidifier/stone_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(stoneGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_STONE.getFluid(), 360))
                .unlockedBy("has_item", has(stoneGearTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(stoneGearTag))), "casting:solidifier/stone_gear");

        //Electrum Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(electrumBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 810), 1000)
                .unlockedBy("has_item", has(electrumBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumBlockTag))), "casting:melting/electrum/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(electrumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 90), 1000)
                .unlockedBy("has_item", has(electrumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumIngotTag))), "casting:melting/electrum/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(electrumNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 10), 1000)
                .unlockedBy("has_item", has(electrumNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumNuggetTag))), "casting:melting/electrum/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(CastingFluids.MOLTEN_GOLD.getFluid(), 90),
                        new FluidStack(CastingFluids.MOLTEN_SILVER.getFluid(), 90),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 180))
                .unlockedBy("has_item", has(electrumIngotTag))
                .save(consumer, "casting:mixing/electrum");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(electrumBlockTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 810))
                .unlockedBy("has_item", has(electrumBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumBlockTag))), "casting:solidifier/electrum_block");


        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(electrumIngotTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 90))
                .unlockedBy("has_item", has(electrumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumIngotTag))), "casting:solidifier/electrum_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(electrumNuggetTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 10))
                .unlockedBy("has_item", has(electrumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumNuggetTag))), "casting:solidifier/electrum_nugget");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEAR_MOLD), new SizedIngredient(Ingredient.of(electrumGearTag), 1),
                        new FluidStack(CastingFluids.MOLTEN_ELECTRUM.getFluid(), 360))
                .unlockedBy("has_item", has(electrumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(electrumGearTag))), "casting:solidifier/electrum_gear");






    }
}
