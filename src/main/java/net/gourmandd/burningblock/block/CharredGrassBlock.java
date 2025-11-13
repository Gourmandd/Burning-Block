package net.gourmandd.burningblock.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CharredGrassBlock extends Block {

    final Block deadBlock;


     public CharredGrassBlock(Properties properties, Block deadBlock){
         super(properties);
         this.deadBlock = deadBlock;
     }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockState(pos.above()).canOcclude() && !level.getBlockState(pos.above()).canBeReplaced()){
            level.setBlockAndUpdate(pos, deadBlock.defaultBlockState());
        }
    }
}
