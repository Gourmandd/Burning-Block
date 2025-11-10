package net.gourmandd.burningblock;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class Tags {

    private static TagKey<Block> createBlockTag(String name){
    return TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(BurningBlock.MODID, name)
            );
    };

    public static final TagKey<Block> BURNS_FULLY = createBlockTag( "burns_fully");
    public static final TagKey<Block> BURNS_INTO_ASH = createBlockTag( "burns_into/ash");
    public static final TagKey<Block> BURNS_INTO_PLANKS = createBlockTag( "burns_into/burnt/planks");
    public static final TagKey<Block> BURNS_INTO_STAIRS = createBlockTag( "burns_into/burnt/stairs");
    public static final TagKey<Block> BURNS_INTO_SLAB = createBlockTag( "burns_into/burnt/slab");
    //public static final TagKey<Block> BURNS_INTO_CHEST = createBlockTag( "burns_into/burnt/chest");
    public static final TagKey<Block> BURNS_INTO_LEAVES = createBlockTag( "burns_into/burnt/leaves");
    public static final TagKey<Block> BURNS_INTO_FENCE = createBlockTag( "burns_into/burnt/fence");
    public static final TagKey<Block> BURNS_INTO_FENCE_GATE = createBlockTag( "burns_into/burnt/fence_gate");
    public static final TagKey<Block> BURNS_INTO_DOOR = createBlockTag( "burns_into/burnt/door");
    public static final TagKey<Block> BURNS_INTO_TRAPDOOR = createBlockTag( "burns_into/burnt/trapdoor");
    public static final TagKey<Block> BURNS_INTO_BUTTON = createBlockTag( "burns_into/burnt/button");
    public static final TagKey<Block> BURNS_INTO_PRESSURE_PLATE = createBlockTag( "burns_into/burnt/pressure_plate");
    public static final TagKey<Block> BURNS_INTO_LOG = createBlockTag( "burns_into/burnt/log");
    public static final TagKey<Block> BURNS_INTO_STRIPPED_LOG = createBlockTag( "burns_into/burnt/stripped_log");
    public static final TagKey<Block> BURNS_INTO_WOOD = createBlockTag( "burns_into/burnt/wood");
    public static final TagKey<Block> BURNS_INTO_STRIPPED_WOOD = createBlockTag( "burns_into/burnt/stripped_wood");
}
