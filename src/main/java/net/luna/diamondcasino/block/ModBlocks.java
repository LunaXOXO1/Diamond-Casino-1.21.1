package net.luna.diamondcasino.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luna.diamondcasino.DiamondCasino;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Create Chip Exchanger Block
    public static final Block CHIP_EXCHANGER = registerBlock("chip_exchanger",
            new ChipExchangerBlock(AbstractBlock.Settings.create()
                    .strength(4f) // TODO
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    // registerBlock helper method
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DiamondCasino.MOD_ID, name), block);
    }

    // Helper method
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DiamondCasino.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DiamondCasino.LOGGER.info("Registering Mod Blocks for " + DiamondCasino.MOD_ID);

        // Add ModBlocks to ItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CHIP_EXCHANGER);
        });
    }
}