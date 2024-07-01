package com.benbenlaw.smelting.data;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.smelting.Smelting;
import com.benbenlaw.smelting.item.ModItems;
import com.benbenlaw.smelting.util.SmeltingTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SmeltingItemTags extends ItemTagsProvider {

    SmeltingItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Smelting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(SmeltingTags.Items.MOLDS)
                .add(ModItems.BLOCK_MOLD.asItem())
                .add(ModItems.BLOCK_MOLD.asItem())
                .add(ModItems.DUST_MOLD.asItem())
                .add(ModItems.GEAR_MOLD.asItem())
                .add(ModItems.INGOT_MOLD.asItem())
                .add(ModItems.NUGGET_MOLD.asItem())
                .add(ModItems.PLATE_MOLD.asItem())
                .add(ModItems.GEM_MOLD.asItem())
        ;


    }
}
