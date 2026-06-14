package net.gourmandd.burningblock.datagen;

import net.gourmandd.burningblock.block.BurningDataMap;
import net.gourmandd.burningblock.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class DatagenDataMapProvider extends DataMapProvider {

    protected DatagenDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {

        // burning
        DataMapProvider.Builder<BurningDataMap.BurningData, Block> burningMap = this.builder(BurningDataMap.BURNING_DATA);

        burningMap.add(ModBlocks.CHARRED_GRASS.getKey(), new BurningDataMap.BurningData(Blocks.COARSE_DIRT), false);


        // adjacent burning
        DataMapProvider.Builder<BurningDataMap.AdjacentBurningData, Block> adjacentBurningMap = this.builder(BurningDataMap.ADJACENT_BURNING_DATA);

        adjacentBurningMap.add(getKey(Blocks.GRASS_BLOCK), new BurningDataMap.AdjacentBurningData(ModBlocks.CHARRED_GRASS.get()), false);
        adjacentBurningMap.add(getKey(Blocks.PODZOL), new BurningDataMap.AdjacentBurningData(ModBlocks.CHARRED_GRASS.get()), false);
        adjacentBurningMap.add(getKey(Blocks.MYCELIUM), new BurningDataMap.AdjacentBurningData(ModBlocks.CHARRED_GRASS.get()), false);

        adjacentBurningMap.add(getKey(Blocks.ROOTED_DIRT), new BurningDataMap.AdjacentBurningData(Blocks.COARSE_DIRT), false);
        adjacentBurningMap.add(getKey(Blocks.DIRT_PATH), new BurningDataMap.AdjacentBurningData(Blocks.COARSE_DIRT), false);

        adjacentBurningMap.add(getKey(Blocks.CRIMSON_NYLIUM), new BurningDataMap.AdjacentBurningData(Blocks.NETHERRACK), false);
        adjacentBurningMap.add(getKey(Blocks.WARPED_NYLIUM), new BurningDataMap.AdjacentBurningData(Blocks.NETHERRACK), false);

        adjacentBurningMap.add(BlockTags.ICE, new BurningDataMap.AdjacentBurningData(Blocks.WATER), false);

        adjacentBurningMap.add(getKey(Blocks.CLAY), new BurningDataMap.AdjacentBurningData(Blocks.TERRACOTTA), false);
        adjacentBurningMap.add(getKey(Blocks.SANDSTONE), new BurningDataMap.AdjacentBurningData(Blocks.SAND), false);
        adjacentBurningMap.add(getKey(Blocks.RED_SANDSTONE), new BurningDataMap.AdjacentBurningData(Blocks.RED_SAND), false);
        adjacentBurningMap.add(getKey(Blocks.STONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_STONE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_STONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.INFESTED_CRACKED_STONE_BRICKS), false);

        adjacentBurningMap.add(getKey(Blocks.INFESTED_CRACKED_STONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_STONE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_MOSSY_STONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.MOSSY_STONE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_STONE), new BurningDataMap.AdjacentBurningData(Blocks.STONE), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_COBBLESTONE), new BurningDataMap.AdjacentBurningData(Blocks.COBBLESTONE), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_CHISELED_STONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CHISELED_STONE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.INFESTED_DEEPSLATE), new BurningDataMap.AdjacentBurningData(Blocks.DEEPSLATE), false);

        adjacentBurningMap.add(getKey(Blocks.DEEPSLATE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_DEEPSLATE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.DEEPSLATE_TILES), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_DEEPSLATE_TILES), false);
        adjacentBurningMap.add(getKey(Blocks.POLISHED_BLACKSTONE_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS), false);
        adjacentBurningMap.add(getKey(Blocks.NETHER_BRICKS), new BurningDataMap.AdjacentBurningData(Blocks.CRACKED_NETHER_BRICKS), false);

        adjacentBurningMap.add(Tags.Blocks.GLASS_PANES, new BurningDataMap.AdjacentBurningData(Blocks.AIR), false);
        adjacentBurningMap.add(Tags.Blocks.GLASS_BLOCKS, new BurningDataMap.AdjacentBurningData(Blocks.AIR), false);

        // grass dying
        DataMapProvider.Builder<BurningDataMap.GrassDyingData, Block> grassDying = this.builder(BurningDataMap.GRASS_DYING_DATA);

        grassDying.add(ModBlocks.CHARRED_GRASS, new BurningDataMap.GrassDyingData(Blocks.COARSE_DIRT), false);
    }

    private ResourceKey<Block> getKey (Block block){
        return block.builtInRegistryHolder().getKey();
    }
}

