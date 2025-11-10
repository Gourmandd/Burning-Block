package net.gourmandd.burningblock.block;

import net.gourmandd.burningblock.BurningBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BurningBlock.MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    /*
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.examplemod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
     */

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + BurningBlock.MODID)) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModBlocks.BURNT_PLANKS_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.ASH_ITEM);
                output.accept(ModBlocks.CHARRED_LEAVES_ITEM);
                output.accept(ModBlocks.BURNT_PLANKS_ITEM);
                output.accept(ModBlocks.BURNT_LOG_ITEM);
                output.accept(ModBlocks.BURNT_STRIPPED_LOG_ITEM);
                output.accept(ModBlocks.BURNT_WOOD_ITEM);
                output.accept(ModBlocks.BURNT_STRIPPED_WOOD_ITEM);
                output.accept(ModBlocks.BURNT_FENCE_ITEM);
                output.accept(ModBlocks.BURNT_FENCE_GATE_ITEM);
                output.accept(ModBlocks.BURNT_DOOR_ITEM);
                output.accept(ModBlocks.BURNT_TRAPDOOR_ITEM);
                output.accept(ModBlocks.BURNT_STAIRS_ITEM);
                output.accept(ModBlocks.BURNT_SLAB_ITEM);
                output.accept(ModBlocks.BURNT_BUTTON_ITEM);
                output.accept(ModBlocks.BURNT_PRESSURE_PLATE_ITEM);
            }).build());
}
