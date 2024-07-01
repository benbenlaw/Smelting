package com.benbenlaw.smelting.util;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.smelting.Smelting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SmeltingTags {

    public static class Blocks {

        //Smelting Tags
       // public static final TagKey<Block> BANNED_IN_BLOCK_PLACER = tag("banned_in_block_placer");


        //Common Tags
     //   public static final TagKey<Block> ENDER_ORE = commonTags("ores/ender_ore");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, name));
        }

        private static TagKey<Block> commonTags(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

    }

    public static class Items {

        //Smelting Item Tags
        public static final TagKey<Item> MOLDS = tag("molds");


        //Common Tags
     //   public static final TagKey<Item> ENDER_ORE = commonTags("ores/ender_ore");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Smelting.MOD_ID, name));
        }

        private static TagKey<Item> commonTags(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

    }
}
