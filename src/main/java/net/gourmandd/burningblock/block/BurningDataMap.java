package net.gourmandd.burningblock.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class BurningDataMap {

    public record BurningData(Block block) {
        public static final Codec<BurningData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                BuiltInRegistries.BLOCK.byNameCodec().fieldOf("result").forGetter(BurningData::block)
        ).apply(instance, BurningData::new));
    }

    public static final DataMapType<Block, BurningData> BURNING_DATA = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(BurningBlock.MODID, "burning"),
            Registries.BLOCK,
            BurningData.CODEC
    ).build();

    public record AdjacentBurningData(Block block) {
        public static final Codec<AdjacentBurningData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                BuiltInRegistries.BLOCK.byNameCodec().fieldOf("result").forGetter(AdjacentBurningData::block)
        ).apply(instance, AdjacentBurningData::new));
    }

    public static final DataMapType<Block, AdjacentBurningData> ADJACENT_BURNING_DATA = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(BurningBlock.MODID, "adjacent_burning"),
            Registries.BLOCK,
            AdjacentBurningData.CODEC
    ).build();

    @SubscribeEvent // on the mod event bus
    public static void registerDataMapTypes(RegisterDataMapTypesEvent event) {
        event.register(BurningDataMap.BURNING_DATA);
        event.register(BurningDataMap.ADJACENT_BURNING_DATA);
    }
}
