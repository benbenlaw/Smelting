package com.benbenlaw.casting.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.Objects;

public class ModdedTags {

    // TODO - MOVE TO OPOLISUTILITIES

    //Type Tags

    public static TagKey<Item> gearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears")))));

    public static TagKey<Item> plateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates")))));

    public static TagKey<Item> rodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods")))));

    //Tin Tags
    public static TagKey<Item> tinNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/tin")))));
    public static TagKey<Item> tinIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/tin")))));
    public static TagKey<Item> tinBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/tin")))));
    public static TagKey<Item> tinOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/tin")))));
    public static TagKey<Item> tinRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/tin")))));

    //Osmium Tags

    public static TagKey<Item> osmiumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/osmium")))));

    public static TagKey<Item> osmiumIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/osmium")))));

    public static TagKey<Item> osmiumBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/osmium")))));

    public static TagKey<Item> osmiumOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/osmium")))));

    public static TagKey<Item> osmiumRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/osmium")))));


    //Uranium Tags

    public static TagKey<Item> uraniumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/uranium")))));

    public static TagKey<Item> uraniumIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/uranium")))));

    public static TagKey<Item> uraniumBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/uranium")))));

    public static TagKey<Item> uraniumOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/uranium")))));

    public static TagKey<Item> uraniumRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/uranium")))));


    //Lead Tags

    public static TagKey<Item> leadNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/lead")))));

    public static TagKey<Item> leadIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/lead")))));

    public static TagKey<Item> leadBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/lead")))));

    public static TagKey<Item> leadOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/lead")))));

    public static TagKey<Item> leadRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/lead")))));

    //Bronze Tags

    public static TagKey<Item> bronzeNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/bronze")))));

    public static TagKey<Item> bronzeIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/bronze")))));

    public static TagKey<Item> bronzeBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/bronze")))));

    public static TagKey<Item> bronzeOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/bronze")))));

    public static TagKey<Item> bronzeRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/bronze")))));

    //Steel Tags

    public static TagKey<Item> steelNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/steel")))));

    public static TagKey<Item> steelIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/steel")))));

    public static TagKey<Item> steelBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel")))));

    public static TagKey<Item> steelOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/steel")))));

    public static TagKey<Item> steelRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/steel")))));




}
