package net.gourmandd.burningblock.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class BasicLogBlock extends RotatedPillarBlock {

    public BasicLogBlock(Properties properties){
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        boolean canStrip = context.getItemInHand().canPerformAction(ItemAbilities.AXE_STRIP);

        if (canStrip){
            Level level = context.getLevel();

            if (state.is(ModBlocks.BURNT_LOG.get())){
                return ModBlocks.BURNT_STRIPPED_LOG.get().withPropertiesOf(state);
            }

            if (state.is(ModBlocks.BURNT_WOOD.get())){
                return ModBlocks.BURNT_STRIPPED_WOOD.get().withPropertiesOf(state);
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
