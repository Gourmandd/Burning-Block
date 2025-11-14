package net.gourmandd.burningblock.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CharredGrassBlock extends Block {

     public CharredGrassBlock(Properties properties){
         super(properties);
     }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        if (level.getBlockState(pos.above()).canOcclude() && !level.getBlockState(pos.above()).canBeReplaced()){

            Holder<Block> holder = state.getBlockHolder();
            BurningDataMap.GrassDyingData data = holder.getData(BurningDataMap.GRASS_DYING_DATA);

            Block block = Blocks.DIRT;

            if (data != null){
                block = data.block();
            }

            level.setBlockAndUpdate(pos, block.defaultBlockState());
        }

    }
}
