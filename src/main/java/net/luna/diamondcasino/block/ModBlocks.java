package net.luna.diamondcasino.block;

import net.minecraft.block.Block;
import net.luna.diamondcasino.DiamondCasino;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

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
    }
}
