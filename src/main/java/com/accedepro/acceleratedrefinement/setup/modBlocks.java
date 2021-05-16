package com.accedepro.acceleratedrefinement.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class modBlocks {

    // Register adds new block to the block register
    // Make sure to identify an uppercase item block name and an NBT tag in Minecraft character case: e.g minecraft:**enchanted_book**
    /*

    To mask the NBT tag, see the main -> resources -> assets -> accrefined -> lang -> en_us.json file and you can mask the item name there

     */

    public static final RegistryObject<Block> CLAY_OVEN = register("clay_oven", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(3).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.ANCIENT_DEBRIS)));

    // Simply add more blocks by copying the above and changing stuff to your liking
    // Example provided below:
    // public static final RegistryObject<Block> *** = register("***", () ->
    //             new Block(AbstractBlock.Properties.of(Material.***).strength(*(, *.*F - Not required but here anyway)).harvestLevel(2).harvestTool(ToolType.***).sound(SoundType.***)));

    static void registerStuff() {}

    // AFAIK, this is the register for the block itself
    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return itemReg.BLOCKS.register(name, block);
    }

    // AFAIK, this is the register for the "BLOCK ITEM" and only block items that remain in the decoration itemgroup tab
    // Block items that require storage under alternate itemgroups need a separate function
    // They are however still listed alongside the other item registers in this class
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> returnValue = registerNoItem(name, block);
        itemReg.ITEMS.register(name, () -> new BlockItem(returnValue.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
        return returnValue;
    }
}
