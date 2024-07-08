package com.benbenlaw.casting.data;

import com.benbenlaw.casting.block.ModBlocks;
import com.benbenlaw.casting.data.recipes.FuelRecipeBuilder;
import com.benbenlaw.casting.data.recipes.MeltingRecipeBuilder;
import com.benbenlaw.casting.data.recipes.MixingRecipeBuilder;
import com.benbenlaw.casting.data.recipes.SolidifierRecipeBuilder;
import com.benbenlaw.casting.fluid.ModFluids;
import com.benbenlaw.casting.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);

        // Coal
        FuelRecipeBuilder.FuelRecipesBuilder(new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 8), 1200)
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);
        
        // Uranium
        FuelRecipeBuilder.FuelRecipesBuilder(new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 25), 1600)
                .unlockedBy("has_bucket", has(Items.BUCKET))
                .save(consumer);

        // ********** Processing ********** //

        // Iron Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_IRON), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.INGOTS_IRON))
                .save(consumer, "casting:melting/iron/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_IRON), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_IRON))
                .save(consumer, "casting:melting/iron/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_IRON), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_IRON))
                .save(consumer, "casting:melting/iron/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_INGOT), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(Items.IRON_NUGGET), 1),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 10))
                .unlockedBy("has_bucket", has(Items.IRON_INGOT)).save(consumer, "casting:solidifier/iron_nugget");

        //Gold Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.INGOTS_GOLD))
                .save(consumer, "casting:melting/gold/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_GOLD), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_GOLD))
                .save(consumer, "casting:melting/gold/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_GOLD), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_GOLD)).save(consumer, "casting:melting/gold/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.GOLD_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD),new SizedIngredient(Ingredient.of(Items.GOLD_INGOT), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(Items.GOLD_NUGGET), 1),
                        new FluidStack(ModFluids.MOLTEN_GOLD_SOURCE, 10))
                .unlockedBy("has_bucket", has(Items.GOLD_INGOT)).save(consumer, "casting:solidifier/gold_nugget");

        //Copper Processing

MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.INGOTS_COPPER), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.INGOTS_COPPER))
                .save(consumer, "casting:melting/copper/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_COPPER), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_COPPER))
                .save(consumer, "casting:melting/copper/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.RAW_MATERIALS_COPPER), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_COPPER)).save(consumer, "casting:melting/copper/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD),new SizedIngredient(Ingredient.of(Items.COPPER_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(Items.COPPER_INGOT), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(com.benbenlaw.opolisutilities.item.ModItems.COPPER_NUGGET), 1),
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 10))
                .unlockedBy("has_bucket", has(Items.COPPER_INGOT)).save(consumer, "casting:solidifier/copper_nugget");

        //Tin Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(tinIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinIngotTag))), "casting:melting/tin/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(ModdedTags.tinOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(ModdedTags.tinOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinOreTag))), "casting:melting/tin/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(ModdedTags.tinRawOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(ModdedTags.tinRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinRawOreTag))), "casting:melting/tin/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(tinBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 810))
                .unlockedBy("has_bucket", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinBlockTag))), "casting:solidifier/tin_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(tinIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 90))
                .unlockedBy("has_bucket", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinIngotTag))), "casting:solidifier/tin_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(ModdedTags.tinNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 10))
                .unlockedBy("has_bucket", has(tinIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(tinNuggetTag))), "casting:solidifier/tin_nugget");

        //Osmium Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumIngotTag))), "casting:melting/osmium/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(osmiumOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumOreTag))), "casting:melting/osmium/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(osmiumRawOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(osmiumRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumRawOreTag))), "casting:melting/osmium/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(osmiumBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 810))
                .unlockedBy("has_bucket", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumBlockTag))), "casting:solidifier/osmium_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(osmiumIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 90))
                .unlockedBy("has_bucket", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumIngotTag))), "casting:solidifier/osmium_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(osmiumNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_OSMIUM_SOURCE, 10))
                .unlockedBy("has_bucket", has(osmiumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumNuggetTag))), "casting:solidifier/osmium_nugget");

        //Uranium Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumIngotTag))), "casting:melting/uranium/from_ingot");


        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(uraniumOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumOreTag))), "casting:melting/uranium/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(uraniumRawOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(uraniumRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumRawOreTag))), "casting:melting/uranium/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(uraniumBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 810))
                .unlockedBy("has_bucket", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumBlockTag))), "casting:solidifier/uranium_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(uraniumIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 90))
                .unlockedBy("has_bucket", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumIngotTag))), "casting:solidifier/uranium_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(uraniumNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_URANIUM_SOURCE, 10))
                .unlockedBy("has_bucket", has(uraniumIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumNuggetTag))), "casting:solidifier/uranium_nugget");

        //Lead Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadIngotTag))), "casting:melting/lead/from_ingot");


        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(leadOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadOreTag))), "casting:melting/lead/from_ore");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(leadRawOreTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(leadRawOreTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadRawOreTag))), "casting:melting/lead/from_raw_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(leadBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 810))
                .unlockedBy("has_bucket", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadBlockTag))), "casting:solidifier/lead_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(leadIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 90))
                .unlockedBy("has_bucket", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadIngotTag))), "casting:solidifier/lead_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(leadNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_LEAD_SOURCE, 10))
                .unlockedBy("has_bucket", has(leadIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(leadNuggetTag))), "casting:solidifier/lead_nugget");


        // Coal Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Items.COAL), 1),
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 80), 1000)
                .unlockedBy("has_bucket", has(Items.COAL))
                .save(consumer, "casting:melting/coal/from_item");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_COAL), 1),
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_COAL))
                .save(consumer, "casting:melting/coal/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.COAL_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 720))
                .unlockedBy("has_bucket", has(Items.COAL)).save(consumer, "casting:solidifier/coal_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.COAL), 1),
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 80))
                .unlockedBy("has_bucket", has(Items.COAL)).save(consumer, "casting:solidifier/coal");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(com.benbenlaw.opolisutilities.item.ModItems.MINI_COAL), 1),
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 10))
                .unlockedBy("has_bucket", has(Items.COAL)).save(consumer, "casting:solidifier/mini_coal");

        // Emerald Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_EMERALD), 1),
                        new FluidStack(ModFluids.MOLTEN_EMERALD_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.GEMS_EMERALD))
                .save(consumer, "casting:melting/emerald/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_EMERALD), 1),
                        new FluidStack(ModFluids.MOLTEN_EMERALD_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_EMERALD))
                .save(consumer, "casting:melting/emerald/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.EMERALD_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_EMERALD_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.EMERALD)).save(consumer, "casting:solidifier/emerald_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.EMERALD), 1),
                        new FluidStack(ModFluids.MOLTEN_EMERALD_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.EMERALD)).save(consumer,"casting:solidifier/emerald");

        //Diamond Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND), 1),
                        new FluidStack(ModFluids.MOLTEN_DIAMOND_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.GEMS_DIAMOND))
                .save(consumer, "casting:melting/diamond/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_DIAMOND), 1),
                        new FluidStack(ModFluids.MOLTEN_DIAMOND_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_DIAMOND))
                .save(consumer, "casting:melting/diamond/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.DIAMOND_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_DIAMOND_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.DIAMOND)).save(consumer, "casting:solidifier/diamond_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.DIAMOND), 1),
                        new FluidStack(ModFluids.MOLTEN_DIAMOND_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.DIAMOND)).save(consumer, "casting:solidifier/diamond");

        //Redstone Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE), 1),
                        new FluidStack(ModFluids.MOLTEN_REDSTONE_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.DUSTS_REDSTONE))
                .save(consumer, "casting:melting/redstone/from_dust");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_REDSTONE), 1),
                        new FluidStack(ModFluids.MOLTEN_REDSTONE_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_REDSTONE))
                .save(consumer, "casting:melting/redstone/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.REDSTONE_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_REDSTONE_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.REDSTONE)).save(consumer, "casting:solidifier/redstone_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.DUST_MOLD), new SizedIngredient(Ingredient.of(Items.REDSTONE), 1),
                        new FluidStack(ModFluids.MOLTEN_REDSTONE_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.REDSTONE)).save(consumer, "casting:solidifier/redstone");


        //Lapis Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS), 1),
                        new FluidStack(ModFluids.MOLTEN_LAPIS_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.GEMS_LAPIS))
                .save(consumer, "casting:melting/lapis/from_gem");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.ORES_LAPIS), 1),
                        new FluidStack(ModFluids.MOLTEN_LAPIS_SOURCE, 100), 1000)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_LAPIS))
                .save(consumer, "casting:melting/lapis/from_ore");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD),new SizedIngredient(Ingredient.of(Items.LAPIS_BLOCK), 1),
                        new FluidStack(ModFluids.MOLTEN_LAPIS_SOURCE, 810))
                .unlockedBy("has_bucket", has(Items.LAPIS_LAZULI)).save(consumer, "casting:solidifier/lapis_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.GEM_MOLD), new SizedIngredient(Ingredient.of(Items.LAPIS_LAZULI), 1),
                        new FluidStack(ModFluids.MOLTEN_LAPIS_SOURCE, 90))
                .unlockedBy("has_bucket", has(Items.LAPIS_LAZULI)).save(consumer, "casting:solidifier/lapis");


        //Obsidian Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(Tags.Items.OBSIDIANS), 1),
                        new FluidStack(ModFluids.MOLTEN_OBSIDIAN_SOURCE, 1000), 1200)
                .unlockedBy("has_bucket", has(Tags.Items.ORES_LAPIS))
                .save(consumer, "casting:melting/obsidian/from_block");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(Fluids.WATER, 1000),
                        new FluidStack(Fluids.LAVA, 1000),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(ModFluids.MOLTEN_OBSIDIAN_SOURCE, 1000))
                .unlockedBy("has_bucket", has(Items.WATER_BUCKET))
                .save(consumer, "casting:mixing/obsidian");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(Items.OBSIDIAN), 1),
                        new FluidStack(ModFluids.MOLTEN_OBSIDIAN_SOURCE, 1000))
                .unlockedBy("has_bucket", has(Items.OBSIDIAN)).save(consumer, "casting:solidifier/obsidian_block");

        //Bronze Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 810), 1000)
                .unlockedBy("has_bucket", has(bronzeBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeBlockTag))), "casting:melting/bronze/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))), "casting:melting/bronze/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(bronzeNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 10), 1000)
                .unlockedBy("has_bucket", has(bronzeNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeNuggetTag))), "casting:melting/bronze/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(ModFluids.MOLTEN_COPPER_SOURCE, 270),
                        new FluidStack(ModFluids.MOLTEN_TIN_SOURCE, 90),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 360))
                .unlockedBy("has_bucket", has(bronzeIngotTag))
                .save(consumer, "casting:mixing/bronze");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(bronzeBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 810))
                .unlockedBy("has_bucket", has(bronzeBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeBlockTag))), "casting:solidifier/bronze_block");


        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(bronzeIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 90))
                .unlockedBy("has_bucket", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))), "casting:solidifier/bronze_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(bronzeNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_BRONZE_SOURCE, 10))
                .unlockedBy("has_bucket", has(bronzeIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeNuggetTag))), "casting:solidifier/bronze_nugget");

        //Steel Processing

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 810), 1000)
                .unlockedBy("has_bucket", has(steelBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelBlockTag))), "casting:melting/steel/from_block");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 90), 1000)
                .unlockedBy("has_bucket", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelIngotTag))), "casting:melting/steel/from_ingot");

        MeltingRecipeBuilder.MeltingRecipesBuilder(new SizedIngredient(Ingredient.of(steelNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 10), 1000)
                .unlockedBy("has_bucket", has(steelNuggetTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelNuggetTag))), "casting:melting/steel/from_nugget");

        MixingRecipeBuilder.MixingRecipesBuilder(
                        new FluidStack(ModFluids.MOLTEN_COAL_SOURCE, 160),
                        new FluidStack(ModFluids.MOLTEN_IRON_SOURCE, 90),
                        null,
                        null,
                        null,
                        null,
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 90))
                .unlockedBy("has_bucket", has(steelIngotTag))
                .save(consumer, "casting:mixing/steel");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.BLOCK_MOLD), new SizedIngredient(Ingredient.of(steelBlockTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 810))
                .unlockedBy("has_bucket", has(steelBlockTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelBlockTag))), "casting:solidifier/steel_block");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.INGOT_MOLD), new SizedIngredient(Ingredient.of(steelIngotTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 90))
                .unlockedBy("has_bucket", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelIngotTag))), "casting:solidifier/steel_ingot");

        SolidifierRecipeBuilder.SolidifierRecipesBuilder(Ingredient.of(ModItems.NUGGET_MOLD), new SizedIngredient(Ingredient.of(steelNuggetTag), 1),
                        new FluidStack(ModFluids.MOLTEN_STEEL_SOURCE, 10))
                .unlockedBy("has_bucket", has(steelIngotTag)).save(consumer.withConditions(new NotCondition(new TagEmptyCondition(steelNuggetTag))), "casting:solidifier/steel_nugget");

    }
}
