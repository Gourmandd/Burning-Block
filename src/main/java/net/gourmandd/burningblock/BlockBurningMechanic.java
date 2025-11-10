package net.gourmandd.burningblock;

import net.gourmandd.burningblock.block.BurningDataMap;
import net.gourmandd.burningblock.block.FallingLayeredBlock;
import net.gourmandd.burningblock.block.ModBlocks;
import net.mehvahdjukaar.moonlight.api.events.IFireConsumeBlockEvent;
import net.mehvahdjukaar.moonlight.api.misc.EventCalled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class BlockBurningMechanic {

    private static final double ALT_RESULT_CHANCE = 0.1;
    private static final double MAX_RANDOM_LAYER = 3;

    private static int getRandomLayerInt(){
        return (int) Math.clamp(Math.floor((Math.random() / MAX_RANDOM_LAYER) * 10 ) , 1, MAX_RANDOM_LAYER);
    }

    private static BlockPos[] getAdjacentBlocks(BlockPos origin){

        BlockPos[] positions = new BlockPos[6];

        positions[0] = origin.east(); //+x
        positions[1] = origin.west(); //-x
        positions[2] = origin.above(); //+y
        positions[3] = origin.below(); //-y
        positions[4] = origin.south(); //+z
        positions[5] = origin.north(); //-z

        return positions;
    }

    private static void doAdjacentBurning(IFireConsumeBlockEvent event){
        adjacentBurning(event.getLevel(), event.getPos(), 1f);
    }

    public static void adjacentBurning(Level level, BlockPos pos, Float chance){

        BlockPos[] adjacent_blocks = getAdjacentBlocks(pos);

        for (int i = 0; i < adjacent_blocks.length; i++){

            if (Math.random() >= chance){
                return;
            }

            BlockState state = level.getBlockState(adjacent_blocks[i]);

            Holder<Block> holder = state.getBlockHolder();
            BurningDataMap.AdjacentBurningData data = holder.getData(BurningDataMap.ADJACENT_BURNING_DATA);

            if (data != null){

                BurningBlock.LOGGER.info(data.block().toString());
                level.setBlock(adjacent_blocks[i], data.block().withPropertiesOf(state), 3 );
            }
        }
    }


    public static void adjacentBurning(LevelAccessor level, BlockPos pos, Float chance){

        BlockPos[] adjacent_blocks = getAdjacentBlocks(pos);

        for (int i = 0; i < adjacent_blocks.length; i++){

            if (Math.random() >= chance){
                return;
            }

            BlockState state = level.getBlockState(adjacent_blocks[i]);

            Holder<Block> holder = state.getBlockHolder();
            BurningDataMap.AdjacentBurningData data = holder.getData(BurningDataMap.ADJACENT_BURNING_DATA);

            if (data != null){

                BurningBlock.LOGGER.info(data.block().toString());
                level.setBlock(adjacent_blocks[i], data.block().withPropertiesOf(state), 3 );
            }
        }
    }



    private static void burnBlock(IFireConsumeBlockEvent event, BlockState block_state, int alt_result_multiplier) {

        BlockState state = event.getState();
        double random_num = Math.random();

        if (state.is(Tags.BURNS_INTO_ASH) || (random_num < (ALT_RESULT_CHANCE * alt_result_multiplier) && alt_result_multiplier != 0)) {
            if (random_num >= 0.25d){
                event.setFinalState(Blocks.AIR.defaultBlockState());
            } else {
                event.setFinalState(ModBlocks.ASH.get().defaultBlockState().setValue(FallingLayeredBlock.LAYERS, getRandomLayerInt()));
            }
            return;
        }

        doAdjacentBurning(event);

        event.setFinalState(block_state);
    }

    @EventCalled
    public static void onFireConsume(IFireConsumeBlockEvent event){

        BlockState state = event.getState();


        if (state.is(Tags.BURNS_FULLY)) {
            doAdjacentBurning(event);
            event.setFinalState(Blocks.AIR.defaultBlockState());
            return;
        }

        if (state.is(Tags.BURNS_INTO_LEAVES)) {
            burnBlock(event, ModBlocks.CHARRED_LEAVES.get().defaultBlockState().setValue(FallingLayeredBlock.LAYERS, getRandomLayerInt()), 3);
            return;
        }

        if (state.is(Tags.BURNS_INTO_PLANKS)) {
            burnBlock(event, ModBlocks.BURNT_PLANKS.get().defaultBlockState(), 2);
            return;
        }

        if (state.is(Tags.BURNS_INTO_LOG)) {
            burnBlock(event, ModBlocks.BURNT_LOG.get().withPropertiesOf(state), 0);
            return;
        }

        if (state.is(Tags.BURNS_INTO_STRIPPED_LOG)) {
            burnBlock(event, ModBlocks.BURNT_STRIPPED_LOG.get().withPropertiesOf(state), 0);
            return;
        }

        if (state.is(Tags.BURNS_INTO_WOOD)) {
            burnBlock(event, ModBlocks.BURNT_WOOD.get().withPropertiesOf(state), 0);
            return;
        }

        if (state.is(Tags.BURNS_INTO_STRIPPED_WOOD)) {
            burnBlock(event, ModBlocks.BURNT_STRIPPED_WOOD.get().withPropertiesOf(state), 0);
            return;
        }

        if (state.is(Tags.BURNS_INTO_STAIRS)) {
            burnBlock(event, ModBlocks.BURNT_STAIRS.get().withPropertiesOf(state), 2);
            return;
        }

        if (state.is(Tags.BURNS_INTO_SLAB)) {
            burnBlock(event, ModBlocks.BURNT_SLAB.get().withPropertiesOf(state), 2);
            return;
        }

        if (state.is(Tags.BURNS_INTO_FENCE)) {
            burnBlock(event, ModBlocks.BURNT_FENCE.get().withPropertiesOf(state), 2);
            return;
        }

        if (state.is(Tags.BURNS_INTO_FENCE_GATE)) {
            burnBlock(event, ModBlocks.BURNT_FENCE_GATE.get().withPropertiesOf(state), 2);
            return;
        }


        Holder<Block> holder = state.getBlockHolder();
        BurningDataMap.BurningData data = holder.getData(BurningDataMap.BURNING_DATA);

        if (data != null){
            doAdjacentBurning(event);
            event.setFinalState(data.block().withPropertiesOf(state));
        }
        //turns out these arnt flammable
        /*
        if (state.is(Tags.BURNS_INTO_DOOR)) {
            event.setFinalState(ModBlocks.BURNT_DOOR.get().defaultBlockState());
            return;
        }

        if (state.is(Tags.BURNS_INTO_TRAPDOOR)) {
            event.setFinalState(ModBlocks.BURNT_TRAPDOOR.get().defaultBlockState());
            return;
        }

        if (state.is(Tags.BURNS_INTO_BUTTON)) {
            event.setFinalState(ModBlocks.BURNT_BUTTON.get().defaultBlockState());
            return;
        }

        if (state.is(Tags.BURNS_INTO_PRESSURE_PLATE)) {
            event.setFinalState(ModBlocks.BURNT_PRESSURE_PLATE.get().defaultBlockState());
            return;
        }*/

    }
}
