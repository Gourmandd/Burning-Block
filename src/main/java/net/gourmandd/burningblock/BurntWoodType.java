package net.gourmandd.burningblock;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BurntWoodType {
    public static final BlockSetType BURNT_BLOCK_SET = new BlockSetType(BurningBlock.MODID + ":burnt");
    public static final WoodType BURNT = new WoodType(BurningBlock.MODID + ":burnt", BURNT_BLOCK_SET);
}
