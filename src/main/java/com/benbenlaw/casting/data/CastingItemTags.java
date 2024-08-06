package com.benbenlaw.casting.data;

import com.benbenlaw.casting.Casting;
import com.benbenlaw.casting.item.ModItems;
import com.benbenlaw.casting.util.CastingTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CastingItemTags extends ItemTagsProvider {

    CastingItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Casting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(CastingTags.Items.MOLDS)
                .add(ModItems.BLOCK_MOLD.asItem())
                .add(ModItems.BLOCK_MOLD.asItem())
                .add(ModItems.DUST_MOLD.asItem())
                .add(ModItems.GEAR_MOLD.asItem())
                .add(ModItems.INGOT_MOLD.asItem())
                .add(ModItems.NUGGET_MOLD.asItem())
                .add(ModItems.PLATE_MOLD.asItem())
                .add(ModItems.GEM_MOLD.asItem())
                .add(ModItems.ROD_MOLD.asItem())
        ;


    }
}
