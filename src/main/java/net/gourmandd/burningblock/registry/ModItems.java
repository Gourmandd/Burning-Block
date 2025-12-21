package net.gourmandd.burningblock.registry;

import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BurningBlock.MODID);
    public static final DeferredItem<BlockItem> CHARRED_GRASS_BLOCK = ITEMS.registerSimpleBlockItem("charred_grass", ModBlocks.CHARRED_GRASS);
    public static final DeferredItem<BlockItem> BURNT_PRESSURE_PLATE_ITEM = ITEMS.registerSimpleBlockItem("burnt_pressure_plate", ModBlocks.BURNT_PRESSURE_PLATE);
    public static final DeferredItem<BlockItem> BURNT_BUTTON_ITEM = ITEMS.registerSimpleBlockItem("burnt_button", ModBlocks.BURNT_BUTTON);
    public static final DeferredItem<BlockItem> BURNT_SLAB_ITEM = ITEMS.registerSimpleBlockItem("burnt_slab", ModBlocks.BURNT_SLAB);
    public static final DeferredItem<BlockItem> BURNT_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("burnt_stairs", ModBlocks.BURNT_STAIRS);
    public static final DeferredItem<BlockItem> BURNT_TRAPDOOR_ITEM = ITEMS.registerSimpleBlockItem("burnt_trapdoor", ModBlocks.BURNT_TRAPDOOR);
    public static final DeferredItem<BlockItem> BURNT_DOOR_ITEM = ITEMS.registerSimpleBlockItem("burnt_door", ModBlocks.BURNT_DOOR);
    public static final DeferredItem<BlockItem> BURNT_FENCE_GATE_ITEM = ITEMS.registerSimpleBlockItem("burnt_fence_gate", ModBlocks.BURNT_FENCE_GATE);
    public static final DeferredItem<BlockItem> BURNT_FENCE_ITEM = ITEMS.registerSimpleBlockItem("burnt_fence", ModBlocks.BURNT_FENCE);
    public static final DeferredItem<BlockItem> BURNT_STRIPPED_WOOD_ITEM = ITEMS.registerSimpleBlockItem("stripped_burnt_wood", ModBlocks.BURNT_STRIPPED_WOOD);
    public static final DeferredItem<BlockItem> BURNT_WOOD_ITEM = ITEMS.registerSimpleBlockItem("burnt_wood", ModBlocks.BURNT_WOOD);
    public static final DeferredItem<BlockItem> BURNT_STRIPPED_LOG_ITEM = ITEMS.registerSimpleBlockItem("stripped_burnt_log", ModBlocks.BURNT_STRIPPED_LOG);
    public static final DeferredItem<BlockItem> BURNT_LOG_ITEM = ITEMS.registerSimpleBlockItem("burnt_log", ModBlocks.BURNT_LOG);
    public static final DeferredItem<BlockItem> BURNT_PLANKS_ITEM = ITEMS.registerSimpleBlockItem("burnt_planks", ModBlocks.BURNT_PLANKS);
    public static final DeferredItem<BlockItem> CHARRED_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("charred_leaves", ModBlocks.CHARRED_LEAVES);
    public static final DeferredItem<BlockItem> ASH_ITEM = ITEMS.registerSimpleBlockItem("ash", ModBlocks.ASH);
}
