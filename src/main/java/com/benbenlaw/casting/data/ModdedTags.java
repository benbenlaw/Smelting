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
    
    public static TagKey<Item> stoneRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/stone")))));


    //Gear Tags

    public static TagKey<Item> ironGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/iron")))));

    public static TagKey<Item> goldGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/gold")))));

    public static TagKey<Item> copperGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/copper")))));

    public static TagKey<Item> diamondGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/diamond")))));

    public static TagKey<Item> emeraldGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/emerald")))));

    public static TagKey<Item> stoneGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/stone")))));
    public static TagKey<Item> lapisGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/lapis")))));

    //Rod Tags

    public static TagKey<Item> ironRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/iron")))));

    public static TagKey<Item> goldRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/gold")))));

    public static TagKey<Item> copperRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/copper")))));

    //Plate Tags

    public static TagKey<Item> ironPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/iron")))));

    public static TagKey<Item> goldPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/gold")))));

    public static TagKey<Item> copperPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/copper")))));

    public static TagKey<Item> stonePlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/stone")))));


    //Netherite Tags

    public static TagKey<Item> netheriteNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/netherite")))));
    public static TagKey<Item> netheriteGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/netherite")))));
    public static TagKey<Item> netheriteRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/netherite")))));

    public static TagKey<Item> netheritePlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/netherite")))));




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
    public static TagKey<Item> tinGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/tin")))));

    public static TagKey<Item> tinRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/tin")))));

    public static TagKey<Item> tinPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/tin")))));


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
    public static TagKey<Item> osmiumGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/osmium")))));

    public static TagKey<Item> osmiumRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/osmium")))));

    public static TagKey<Item> osmiumPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/osmium")))));




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

    public static TagKey<Item> uraniumGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/uranium")))));

    public static TagKey<Item> uraniumRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/uranium")))));

    public static TagKey<Item> uraniumPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/uranium")))));


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

    public static TagKey<Item> leadGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/lead")))));

    public static TagKey<Item> leadRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/lead")))));

    public static TagKey<Item> leadPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/lead")))));


    //Silver Tags

    public static TagKey<Item> silverNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/silver")))));

    public static TagKey<Item> silverIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/silver")))));

    public static TagKey<Item> silverBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/silver")))));

    public static TagKey<Item> silverOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/silver")))));

    public static TagKey<Item> silverRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/silver")))));

    public static TagKey<Item> silverGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/silver")))));

    public static TagKey<Item> silverRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/silver")))));

    public static TagKey<Item> silverPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/silver")))));


    //Bronze Tags

    public static TagKey<Item> bronzeNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/bronze")))));

    public static TagKey<Item> bronzeIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/bronze")))));

    public static TagKey<Item> bronzeBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/bronze")))));
    public static TagKey<Item> bronzeGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/bronze")))));

    public static TagKey<Item> bronzeRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/bronze")))));

    public static TagKey<Item> bronzePlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/bronze")))));

    //Steel Tags

    public static TagKey<Item> steelNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/steel")))));

    public static TagKey<Item> steelIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/steel")))));

    public static TagKey<Item> steelBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel")))));

    public static TagKey<Item> steelGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/steel")))));

    public static TagKey<Item> steelRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/steel")))));

    public static TagKey<Item> steelPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/steel")))));


    //Electrum Tags

    public static TagKey<Item> electrumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/electrum")))));

    public static TagKey<Item> electrumIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/electrum")))));

    public static TagKey<Item> electrumBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/electrum")))));

    public static TagKey<Item> electrumGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/electrum")))));

    public static TagKey<Item> electrumRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/electrum")))));

    public static TagKey<Item> electrumPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/electrum")))));

    //Nickel Tags

    public static TagKey<Item> nickelOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ores/nickel")))));

    public static TagKey<Item> nickelRawOreTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/nickel")))));

    public static TagKey<Item> nickelNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/nickel")))));

    public static TagKey<Item> nickelIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/nickel")))));

    public static TagKey<Item> nickelBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/nickel")))));
        public static TagKey<Item> nickelGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/nickel")))));
    public static TagKey<Item> nickelRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/nickel")))));

    public static TagKey<Item> nickelPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/nickel")))));



    //Invar Tags

    public static TagKey<Item> invarNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/invar")))));

    public static TagKey<Item> invarIngotTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/invar")))));

    public static TagKey<Item> invarBlockTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/invar")))));

    public static TagKey<Item> invarGearTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "gears/invar")))));

    public static TagKey<Item> invarRodTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "rods/invar")))));
    public static TagKey<Item> invarPlateTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "plates/invar")))));





}
