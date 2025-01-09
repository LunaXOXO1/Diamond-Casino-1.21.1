package net.luna.diamondcasino.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luna.diamondcasino.DiamondCasino;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Register Items
    public static final Item BLACK_CASINO_CHIP = registerItem("black_casino_chip", new Item(new Item.Settings()));
    public static final Item WHITE_CASINO_CHIP = registerItem("white_casino_chip", new Item(new Item.Settings()));
    public static final Item GOLD_CASINO_CHIP = registerItem("gold_casino_chip", new Item(new Item.Settings()));
    public static final Item BLUE_CASINO_CHIP = registerItem("blue_casino_chip", new Item(new Item.Settings()));
    public static final Item RED_CASINO_CHIP = registerItem("red_casino_chip", new Item(new Item.Settings()));
    public static final Item DIAMOND_CASINO_CHIP = registerItem("diamond_casino_chip", new Item(new Item.Settings()));
    public static final Item GREEN_CASINO_CHIP = registerItem("green_casino_chip", new Item(new Item.Settings()));

    // registerItem Helper Method
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DiamondCasino.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DiamondCasino.LOGGER.info("Registering Mod Items for " + DiamondCasino.MOD_ID);
        // Add new items to the Functional Blocks ItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLACK_CASINO_CHIP);
            entries.add(WHITE_CASINO_CHIP);
            entries.add(GOLD_CASINO_CHIP);
            entries.add(BLUE_CASINO_CHIP);
            entries.add(RED_CASINO_CHIP);
            entries.add(DIAMOND_CASINO_CHIP);
            entries.add(GREEN_CASINO_CHIP);
        });
    }
}
