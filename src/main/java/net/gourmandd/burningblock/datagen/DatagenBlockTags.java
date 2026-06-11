package net.gourmandd.burningblock.datagen;

import net.gourmandd.burningblock.BBTags;
import net.gourmandd.burningblock.BurningBlock;
import net.gourmandd.burningblock.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DatagenBlockTags extends TagsProvider<Block>
{
    private final ExistingFileHelper.IResourceType resourceType;

    public DatagenBlockTags(GatherDataEvent event, CompletableFuture<HolderLookup.Provider> lookup)
    {
        super(event.getGenerator().getPackOutput(), Registries.BLOCK, lookup, BurningBlock.MODID, event.getExistingFileHelper());
        this.resourceType = new ExistingFileHelper.ResourceType(PackType.SERVER_DATA, ".json", Registries.tagsDirPath(registryKey));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BBTags.BURNS_INTO_ASH).addTag(BlockTags.FLOWERS);
        this.tag(BBTags.BURNS_INTO_BUTTON).addTag(BlockTags.WOODEN_BUTTONS);
        this.tag(BBTags.BURNS_INTO_CHEST).addTag(Tags.Blocks.CHESTS_WOODEN);
        this.tag(BBTags.BURNS_INTO_DOOR).addTag(BlockTags.WOODEN_DOORS);
        this.tag(BBTags.BURNS_INTO_FENCE).addTag(Tags.Blocks.FENCES_WOODEN);
        this.tag(BBTags.BURNS_INTO_FENCE_GATE).addTag(Tags.Blocks.FENCE_GATES_WOODEN);
        this.tag(BBTags.BURNS_INTO_LEAVES).addTag(BlockTags.LEAVES);
        this.tag(BBTags.BURNS_INTO_STAIRS).addTag(BlockTags.WOODEN_STAIRS);
        this.tag(BBTags.BURNS_INTO_SLAB).addTag(BlockTags.WOODEN_SLABS);
        this.tag(BBTags.BURNS_INTO_PLANKS).addTag(BlockTags.PLANKS);
        this.tag(BBTags.BURNS_INTO_LOG).addTag(BlockTags.OVERWORLD_NATURAL_LOGS);
        this.tag(BBTags.BURNS_INTO_PRESSURE_PLATE).addTag(BlockTags.WOODEN_PRESSURE_PLATES);
        this.tag(BBTags.BURNS_INTO_TRAPDOOR).addTag(BlockTags.WOODEN_TRAPDOORS);

        this.tag(BBTags.BURNS_INTO_STRIPPED_LOG).addTag(Tags.Blocks.STRIPPED_LOGS);
        this.tag(BBTags.BURNS_INTO_WOOD).add(
                getKey(Blocks.OAK_WOOD),
                getKey(Blocks.BIRCH_WOOD),
                getKey(Blocks.SPRUCE_WOOD),
                getKey(Blocks.JUNGLE_WOOD),
                getKey(Blocks.ACACIA_WOOD),
                getKey(Blocks.DARK_OAK_WOOD),
                getKey(Blocks.MANGROVE_WOOD),
                getKey(Blocks.CHERRY_WOOD)
        );
        this.tag(BBTags.BURNS_INTO_STRIPPED_WOOD).add(
                getKey(Blocks.STRIPPED_OAK_WOOD),
                getKey(Blocks.STRIPPED_BIRCH_WOOD),
                getKey(Blocks.STRIPPED_SPRUCE_WOOD),
                getKey(Blocks.STRIPPED_JUNGLE_WOOD),
                getKey(Blocks.STRIPPED_ACACIA_WOOD),
                getKey(Blocks.STRIPPED_DARK_OAK_WOOD),
                getKey(Blocks.STRIPPED_MANGROVE_WOOD),
                getKey(Blocks.STRIPPED_CHERRY_WOOD)
        );

        this.tag(Tags.Blocks.FENCE_GATES).add(ModBlocks.BURNT_FENCE_GATE.getKey());
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.BURNT_FENCE_GATE.getKey());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.BURNT_FENCE_GATE.getKey());

        this.tag(BlockTags.LOGS).add(ModBlocks.BURNT_LOG.getKey(), ModBlocks.BURNT_STRIPPED_LOG.getKey());
        this.tag(BlockTags.LOGS_THAT_BURN).add(ModBlocks.BURNT_LOG.getKey(), ModBlocks.BURNT_STRIPPED_LOG.getKey());

        this.tag(BlockTags.PLANKS).add(ModBlocks.BURNT_PLANKS.getKey());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.BURNT_PRESSURE_PLATE.getKey());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.BURNT_BUTTON.getKey());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.BURNT_DOOR.getKey());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.BURNT_FENCE.getKey());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.BURNT_SLAB.getKey());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.BURNT_STAIRS.getKey());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.BURNT_TRAPDOOR.getKey());

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.BURNT_LOG.getKey(),
                ModBlocks.BURNT_STRIPPED_LOG.getKey(),
                ModBlocks.BURNT_WOOD.getKey(),
                ModBlocks.BURNT_STRIPPED_WOOD.getKey(),
                ModBlocks.BURNT_PLANKS.getKey(),
                ModBlocks.BURNT_BUTTON.getKey(),
                ModBlocks.BURNT_PRESSURE_PLATE.getKey(),
                ModBlocks.BURNT_STAIRS.getKey(),
                ModBlocks.BURNT_SLAB.getKey(),
                ModBlocks.BURNT_DOOR.getKey(),
                ModBlocks.BURNT_TRAPDOOR.getKey(),
                ModBlocks.BURNT_FENCE.getKey(),
                ModBlocks.BURNT_FENCE_GATE.getKey()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.CHARRED_LEAVES.getKey());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.ASH.getKey(),
                ModBlocks.CHARRED_LEAVES.getKey(),
                ModBlocks.CHARRED_GRASS.getKey()
        );
    }

    private ResourceKey<Block> getKey(Block block){
        return block.builtInRegistryHolder().key();
    }

    protected void add(Map<?, DeferredHolder<Block, Block>> map, List<TagKey<Block>> tags ){
        for (DeferredHolder<Block, Block> block : map.values()){
            for (TagKey<Block> tag : tags){
                this.tag(tag).add(block.getKey());
            }
        }
    }
}
