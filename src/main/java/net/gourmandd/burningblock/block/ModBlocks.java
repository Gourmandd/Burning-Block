package net.gourmandd.burningblock.block;

import net.gourmandd.burningblock.BurningBlock;
import net.gourmandd.burningblock.BurntWoodType;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BurningBlock.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BurningBlock.MODID);

    public static final DeferredBlock<Block> ASH = BLOCKS.register("ash", () -> new CharredFallingLayeredBlock(new ColorRGBA(14406560), Block.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops() ));
    public static final DeferredItem<BlockItem> ASH_ITEM = ITEMS.registerSimpleBlockItem("ash", ASH);

    public static final DeferredBlock<Block> CHARRED_LEAVES =  BLOCKS.register("charred_leaves", () -> new CharredFallingLayeredBlock(new ColorRGBA(14406560), Block.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_BLACK).noLootTable() ));
    public static final DeferredItem<BlockItem> CHARRED_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("charred_leaves", CHARRED_LEAVES);

    public static final DeferredBlock<Block> BURNT_PLANKS = BLOCKS.registerSimpleBlock("burnt_planks", Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD));
    public static final DeferredItem<BlockItem> BURNT_PLANKS_ITEM = ITEMS.registerSimpleBlockItem("burnt_planks", BURNT_PLANKS);

    public static final DeferredBlock<Block> BURNT_LOG = BLOCKS.register("burnt_log", () -> new BasicLogBlock(Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );
    public static final DeferredItem<BlockItem> BURNT_LOG_ITEM = ITEMS.registerSimpleBlockItem("burnt_log", BURNT_LOG);

    public static final DeferredBlock<Block> BURNT_STRIPPED_LOG = BLOCKS.register("stripped_burnt_log", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );
    public static final DeferredItem<BlockItem> BURNT_STRIPPED_LOG_ITEM = ITEMS.registerSimpleBlockItem("stripped_burnt_log", BURNT_STRIPPED_LOG);

    public static final DeferredBlock<Block> BURNT_WOOD = BLOCKS.register("burnt_wood", () -> new BasicLogBlock(Block.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );
    public static final DeferredItem<BlockItem> BURNT_WOOD_ITEM = ITEMS.registerSimpleBlockItem("burnt_wood", BURNT_WOOD);

    public static final DeferredBlock<Block> BURNT_STRIPPED_WOOD = BLOCKS.register("stripped_burnt_wood", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );
    public static final DeferredItem<BlockItem> BURNT_STRIPPED_WOOD_ITEM = ITEMS.registerSimpleBlockItem("stripped_burnt_wood", BURNT_STRIPPED_WOOD);


    public static final DeferredBlock<FenceBlock> BURNT_FENCE = BLOCKS.register("burnt_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_FENCE_ITEM = ITEMS.registerSimpleBlockItem("burnt_fence", BURNT_FENCE);

    public static final DeferredBlock<FenceGateBlock> BURNT_FENCE_GATE = BLOCKS.register("burnt_fence_gate", () -> new FenceGateBlock(BurntWoodType.BURNT, Block.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_FENCE_GATE_ITEM = ITEMS.registerSimpleBlockItem("burnt_fence_gate", BURNT_FENCE_GATE);


    public static final DeferredBlock<DoorBlock> BURNT_DOOR = BLOCKS.register("burnt_door", () -> new DoorBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_DOOR_ITEM = ITEMS.registerSimpleBlockItem("burnt_door", BURNT_DOOR);

    public static final DeferredBlock<TrapDoorBlock> BURNT_TRAPDOOR = BLOCKS.register("burnt_trapdoor", () -> new TrapDoorBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_TRAPDOOR_ITEM = ITEMS.registerSimpleBlockItem("burnt_trapdoor", BURNT_TRAPDOOR);


    public static final DeferredBlock<StairBlock> BURNT_STAIRS = BLOCKS.register("burnt_stairs", () -> new StairBlock(BURNT_PLANKS.get().defaultBlockState(), Block.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("burnt_stairs", BURNT_STAIRS);

    public static final DeferredBlock<SlabBlock> BURNT_SLAB = BLOCKS.register("burnt_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_SLAB_ITEM = ITEMS.registerSimpleBlockItem("burnt_slab", BURNT_SLAB);


    public static final DeferredBlock<ButtonBlock> BURNT_BUTTON = BLOCKS.register("burnt_button", () -> new ButtonBlock(BurntWoodType.BURNT_BLOCK_SET, 10, Block.Properties.ofFullCopy(Blocks.OAK_BUTTON).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_BUTTON_ITEM = ITEMS.registerSimpleBlockItem("burnt_button", BURNT_BUTTON);

    public static final DeferredBlock<PressurePlateBlock> BURNT_PRESSURE_PLATE = BLOCKS.register("burnt_pressure_plate", () -> new PressurePlateBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredItem<BlockItem> BURNT_PRESSURE_PLATE_ITEM = ITEMS.registerSimpleBlockItem("burnt_pressure_plate", BURNT_PRESSURE_PLATE);

    public static final DeferredBlock<Block> CHARRED_GRASS = BLOCKS.register("charred_grass", () -> new CharredGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_GRAY), Blocks.DIRT));
    public static final DeferredItem<BlockItem> CHARRED_GRASS_BLOCK = ITEMS.registerSimpleBlockItem("charred_grass", CHARRED_GRASS);

    // I don't think this is worth it.
    //public static final DeferredBlock<ChestBlock> BURNT_CHEST = BLOCKS.register("burnt_chest", () -> new ChestBlock(Block.Properties.ofFullCopy(Blocks.CHEST).mapColor(MapColor.COLOR_BLACK),  () -> BlockEntityType.CHEST));
    //public static final DeferredItem<BlockItem> BURNT_CHEST_ITEM = ITEMS.registerSimpleBlockItem("burnt_chest", BURNT_CHEST);
}
