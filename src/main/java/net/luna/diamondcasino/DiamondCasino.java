package net.luna.diamondcasino;

import net.fabricmc.api.ModInitializer;

import net.luna.diamondcasino.block.ModBlocks;
import net.luna.diamondcasino.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiamondCasino implements ModInitializer {
	public static final String MOD_ID = "diamondcasino";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}