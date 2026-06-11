package net.gourmandd.burningblock.datagen;


import net.gourmandd.burningblock.BBTags;
import net.gourmandd.burningblock.BurningBlock;
import net.gourmandd.burningblock.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class DatagenItemTags extends TagsProvider<Item>
{
    private final ExistingFileHelper.IResourceType resourceType;

    public DatagenItemTags(GatherDataEvent event, CompletableFuture<HolderLookup.Provider> lookup)
    {
        super(event.getGenerator().getPackOutput(), Registries.ITEM, lookup, BurningBlock.MODID, event.getExistingFileHelper());
        this.resourceType = new ExistingFileHelper.ResourceType(PackType.SERVER_DATA, ".json", Registries.tagsDirPath(registryKey));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BBTags.BURNT_LOGS).add(
                ModItems.BURNT_LOG_ITEM.getKey(),
                ModItems.BURNT_WOOD_ITEM.getKey(),
                ModItems.BURNT_STRIPPED_LOG_ITEM.getKey(),
                ModItems.BURNT_STRIPPED_WOOD_ITEM.getKey()
        );

        this.tag(BBTags.createItemTag("c", "ash")).add(ModItems.ASH_ITEM.getKey());

        this.tag(Tags.Items.FENCE_GATES).add(ModItems.BURNT_FENCE_GATE_ITEM.getKey());
        this.tag(ItemTags.FENCE_GATES).add(ModItems.BURNT_FENCE_GATE_ITEM.getKey());

        this.tag(ItemTags.LOGS).add(
                ModItems.BURNT_LOG_ITEM.getKey(),
                ModItems.BURNT_STRIPPED_LOG_ITEM.getKey()
        );
        this.tag(ItemTags.LOGS_THAT_BURN).add(
                ModItems.BURNT_LOG_ITEM.getKey(),
                ModItems.BURNT_STRIPPED_LOG_ITEM.getKey()
        );

        this.tag(ItemTags.PLANKS).add(ModItems.BURNT_PLANKS_ITEM.getKey());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModItems.BURNT_PRESSURE_PLATE_ITEM.getKey());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ModItems.BURNT_BUTTON_ITEM.getKey());
        this.tag(ItemTags.WOODEN_DOORS).add(ModItems.BURNT_DOOR_ITEM.getKey());
        this.tag(ItemTags.WOODEN_FENCES).add(ModItems.BURNT_FENCE_ITEM.getKey());
        this.tag(ItemTags.WOODEN_SLABS).add(ModItems.BURNT_SLAB_ITEM.getKey());
        this.tag(ItemTags.WOODEN_STAIRS).add(ModItems.BURNT_STAIRS_ITEM.getKey());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ModItems.BURNT_TRAPDOOR_ITEM.getKey());
    }

    private ResourceKey<Block> getKey(Block block){
        return block.builtInRegistryHolder().key();
    }
}
