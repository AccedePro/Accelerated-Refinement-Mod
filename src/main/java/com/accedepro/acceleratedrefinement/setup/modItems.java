package com.accedepro.acceleratedrefinement.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class modItems {

    // Register adds new item to the item register
    // Make sure to identify an uppercase item name and an NBT tag in Minecraft character case: e.g minecraft:**enchanted_book**
    /*

    To mask the NBT tag, see the main -> resources -> assets -> accrefined -> lang -> en_us.json file and you can mask the item name there

     */

    public static final RegistryObject<Item> ENCHANTED_BOOK = itemReg.ITEMS.register("enchanted_book", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_TOOLS).stacksTo(1)));

    // Simply add more items by copying the above and changing stuff to your liking
    // Example provided below:
    //    public static final RegistryObject<Item> *** = itemReg.ITEMS.register("***", () ->
    //            new Item(new Item.Properties().tab(ItemGroup.***)));

    static void registerStuff() {}
}
