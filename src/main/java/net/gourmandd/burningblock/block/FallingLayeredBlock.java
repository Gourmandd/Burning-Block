package net.gourmandd.burningblock.block;

import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import static net.gourmandd.burningblock.BlockBurningMechanic.adjacentBurning;

public class FallingLayeredBlock extends ColoredFallingBlock {

    public static final int MAX_LAYERS = 8;
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;
    public static final VoxelShape[] SHAPE_BY_LAYER = new VoxelShape[] {
            Shapes.empty(),
            box(0, 0, 0, 16, 2, 16),
            box(0, 0, 0, 16, 4, 16),
            box(0, 0, 0, 16, 6, 16),
            box(0, 0, 0, 16, 8, 16),
            box(0, 0, 0, 16, 10, 16),
            box(0, 0, 0, 16, 12, 16),
            box(0, 0, 0, 16, 14, 16),
            Shapes.block()
    };

    public FallingLayeredBlock(ColorRGBA color, Properties properties){
        super(color, properties);
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return type == PathComputationType.LAND && state.getValue(LAYERS) < 5;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        BlockState blockstate = level.getBlockState(pos.below());
        return blockstate.isAir() || Block.isFaceFull(blockstate.getCollisionShape(level, pos.below()), Direction.UP) || (blockstate.getBlock() == this && blockstate.getValue(LAYERS) == 8);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {

        int i = state.getValue(LAYERS);
        if (useContext.getItemInHand().is(this.asItem()) && i < MAX_LAYERS) {
            return useContext.replacingClickedOnBlock() ? useContext.getClickedFace() == Direction.UP : true;
        } else {
            return false;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            int i = blockstate.getValue(LAYERS);
            return blockstate.setValue(LAYERS, Math.min(MAX_LAYERS, i + 1));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, pos, state);
            fallingblockentity.disableDrop();
            this.falling(fallingblockentity);
        }

    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        BlockState block = level.getBlockState(pos);
        boolean isSameBlock = block.is(fallingBlock.getBlockState().getBlock());

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

    @NotNull
    @Override
    protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }


    @NotNull
    @Override
    protected VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE_BY_LAYER[state.getValue(LAYERS)];
    }

    @NotNull
    @Override
    protected VoxelShape getBlockSupportShape(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
        return SHAPE_BY_LAYER[state.getValue(LAYERS)];
    }

    @NotNull
    @Override
    protected VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE_BY_LAYER[state.getValue(LAYERS) - 1];
    }

    @NotNull
    @Override
    protected VoxelShape getVisualShape(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE_BY_LAYER[state.getValue(LAYERS)];
    }

    @NotNull
    @Override
    protected BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        return !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder.add(LAYERS));
    }
}
