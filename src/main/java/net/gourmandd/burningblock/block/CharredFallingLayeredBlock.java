package net.gourmandd.burningblock.block;

import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static net.gourmandd.burningblock.BlockBurningMechanic.adjacentBurning;

// The length of this class name makes me think that there could be a better way to name it, it is what it says its is to be fair.
public class CharredFallingLayeredBlock extends FallingLayeredBlock{

    public CharredFallingLayeredBlock(ColorRGBA color, Properties properties){
        super(color, properties);
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        BlockState block = level.getBlockState(pos);
        boolean isSameBlock = block.is(fallingBlock.getBlockState().getBlock());

        Holder<Block> holder = level.getBlockState(pos.below()).getBlockHolder();
        BurningDataMap.AdjacentBurningData data = holder.getData(BurningDataMap.ADJACENT_BURNING_DATA);

        if (data != null){
            BurningBlock.LOGGER.info("not null");
            adjacentBurning(level, pos.below(), 0.75f);
            level.setBlock(pos.below(), data.block().withPropertiesOf(level.getBlockState(pos.below())), 3 );
        }

        if (block.hasProperty(LAYERS) && isSameBlock) {
            int i = fallingBlock.getBlockState().getValue(LAYERS);
            int layers = block.getValue(LAYERS);
            block = block.setValue(LAYERS, Math.min(MAX_LAYERS, layers + i));
            level.setBlock(pos, block, 3);
            return;
        }

        if (!isSameBlock && !block.isAir()){
            return;
        }

        if (canSurvive(fallingBlock.getBlockState(), level, pos)){
            level.setBlock(pos, fallingBlock.getBlockState(), 3);
        }
    }
}
