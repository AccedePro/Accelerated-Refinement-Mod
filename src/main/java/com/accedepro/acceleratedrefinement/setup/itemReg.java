package com.accedepro.acceleratedrefinement.setup;

import com.accedepro.acceleratedrefinement.acceleratedRefinement;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// This is the item register class
// This creates a new registry of items for the mod from the initialization function in the main class (acceleratedRefinement.java)

public class itemReg {
    // These variables parse in data to create lists of items and blocks that are added in this mod
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, acceleratedRefinement.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, acceleratedRefinement.MOD_ID);

    // This is the function referenced in the main class
    public static void registerStuff() {
        // The following 3 lines initialize the list
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        // These two lines run the registerStuff function in the two respective classes "modBlocks" and "modItems"
        // This in turn initializes the registryObjects lists for items and blocks and allows them to be added to the list of available blocks
        // This can be seen in Minecraft in-game
        modBlocks.registerStuff();
        modItems.registerStuff();
    }
}
