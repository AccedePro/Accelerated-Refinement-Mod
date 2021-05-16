package com.accedepro.acceleratedrefinement;

import com.accedepro.acceleratedrefinement.setup.itemReg;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

/*
*           DISCLAIMER:
*           IF ANYTHING GOES WRONG, ALTER THE mods.toml FILE UNDER THE META-INF DIRECTORY
*           IT TENDS TO FIX A LOT OF PROBLEMS
*           THERE ARE REALLY ONLY A FEW KEY THINGS ON THIS PAGE:
*
*           1. MOD_ID VARIABLE AND NAME
*           2. THE INITIALIZING FUNCTION FOR THE MOD (references the item register)
*           3. THE PRIMARY EVENTBUSSUBSCRIBER, WHICH CAN BE IGNORED
*/

// MOD_ID for mod is listed as "accrefined" by linking variable below
// Classes are defined using camelcase title name "acceleratedRefinement"

@Mod(acceleratedRefinement.MOD_ID)
public class acceleratedRefinement {

    // Variable defining MOD_ID

    public static final String MOD_ID = "accrefined";



    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public acceleratedRefinement() {

        // Line below is the init for the block and item loader

        itemReg.registerStuff();

        /*
        *
        *
        *
        * From here on, I have no clue what 90% of this shit does
        *
        *
        *
        */

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // So apparently you can use the below EventBusSubscriber to register events, blocks, items, textures, GUIs, etc
    // I have instead opted to use seperate java classes

    //    You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    //    Event bus for receiving Registry Events)
    //    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    //    public static class RegistryEvents {
    //        @SubscribeEvent
    //        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    //            // register a new block here
    //            LOGGER.info("HELLO from Register Block");
    //        }
    //    }
}
