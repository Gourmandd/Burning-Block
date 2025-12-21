package net.gourmandd.burningblock.registry;

import net.gourmandd.burningblock.BurningBlock;
import net.gourmandd.burningblock.BurntWoodType;
import net.gourmandd.burningblock.block.BasicLogBlock;
import net.gourmandd.burningblock.block.CharredFallingLayeredBlock;
import net.gourmandd.burningblock.block.CharredGrassBlock;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BurningBlock.MODID);

    public static final DeferredBlock<Block> ASH = BLOCKS.register("ash", () -> new CharredFallingLayeredBlock(new ColorRGBA(14406560), Block.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops() ));

    public static final DeferredBlock<Block> CHARRED_LEAVES =  BLOCKS.register("charred_leaves", () -> new CharredFallingLayeredBlock(new ColorRGBA(14406560), Block.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_BLACK).noLootTable() ));

    public static final DeferredBlock<Block> BURNT_PLANKS = BLOCKS.registerSimpleBlock("burnt_planks", Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD));

    public static final DeferredBlock<Block> BURNT_LOG = BLOCKS.register("burnt_log", () -> new BasicLogBlock(Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );

    public static final DeferredBlock<Block> BURNT_STRIPPED_LOG = BLOCKS.register("stripped_burnt_log", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );

    public static final DeferredBlock<Block> BURNT_WOOD = BLOCKS.register("burnt_wood", () -> new BasicLogBlock(Block.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );

    public static final DeferredBlock<Block> BURNT_STRIPPED_WOOD = BLOCKS.register("stripped_burnt_wood", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD)) );


    public static final DeferredBlock<FenceBlock> BURNT_FENCE = BLOCKS.register("burnt_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<FenceGateBlock> BURNT_FENCE_GATE = BLOCKS.register("burnt_fence_gate", () -> new FenceGateBlock(BurntWoodType.BURNT, Block.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_BLACK)));


    public static final DeferredBlock<DoorBlock> BURNT_DOOR = BLOCKS.register("burnt_door", () -> new DoorBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<TrapDoorBlock> BURNT_TRAPDOOR = BLOCKS.register("burnt_trapdoor", () -> new TrapDoorBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_BLACK)));


    public static final DeferredBlock<StairBlock> BURNT_STAIRS = BLOCKS.register("burnt_stairs", () -> new StairBlock(BURNT_PLANKS.get().defaultBlockState(), Block.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<SlabBlock> BURNT_SLAB = BLOCKS.register("burnt_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_BLACK)));


    public static final DeferredBlock<ButtonBlock> BURNT_BUTTON = BLOCKS.register("burnt_button", () -> new ButtonBlock(BurntWoodType.BURNT_BLOCK_SET, 10, Block.Properties.ofFullCopy(Blocks.OAK_BUTTON).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<PressurePlateBlock> BURNT_PRESSURE_PLATE = BLOCKS.register("burnt_pressure_plate", () -> new PressurePlateBlock(BurntWoodType.BURNT_BLOCK_SET, Block.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_BLACK)));

    public static final DeferredBlock<Block> CHARRED_GRASS = BLOCKS.register("charred_grass", () -> new CharredGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_GRAY)));
}
