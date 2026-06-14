

package net.gourmandd.burningblock.datagen;

import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;


public final class DataEntryPoint
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        final PackOutput output = event.getGenerator().getPackOutput();

        final var lookup = add(event, new DatapackBuiltinEntriesProvider(
                event.getGenerator().getPackOutput(), event.getLookupProvider(),
                new RegistrySetBuilder()
                , Set.of(BurningBlock.MODID, "minecraft"))).getRegistryProvider();

        add(event, new DatagenBlockTags(event, lookup));
        add(event, new DatagenItemTags(event, lookup));
        add(event, new DatagenDataMapProvider(output, lookup));
        //add(event, new DatagenBlockStates(output, event.getExistingFileHelper()));
        //add(event, new DatagenItemModels(output, event.getExistingFileHelper()));
        //add(event, new DatagenLanguageProvider(output));

        //addLoot(lookup, output, event, DatagenBlockLootTables::new, LootContextParamSets.BLOCK);
    }

    private static <T extends DataProvider> T add(GatherDataEvent event, T provider)
    {
        return event.getGenerator().addProvider(true, provider);
    }

    private static void addLoot(CompletableFuture<HolderLookup.Provider> lookup, PackOutput output, GatherDataEvent event, Function<HolderLookup.Provider, LootTableSubProvider> provider, LootContextParamSet set )
    {
        add(event,
                new LootTableProvider(
                        output,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(provider, set)
                        ),
                        lookup
                )
        );
    }
}