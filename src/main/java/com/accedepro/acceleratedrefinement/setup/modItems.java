package com.accedepro.acceleratedrefinement.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class modItems {
    public static final RegistryObject<Item> ENCHANTED_BOOK = itemReg.ITEMS.register("enchanted_book", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_TOOLS).stacksTo(1)));

    static void registerStuff() {}
}
