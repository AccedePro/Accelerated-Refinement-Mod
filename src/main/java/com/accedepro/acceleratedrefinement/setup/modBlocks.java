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
    public static final RegistryObject<Block> CLAY_OVEN = register("clay_oven", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(3).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.ANCIENT_DEBRIS)));

    // Simply add more blocks by copying the above and changing stuff to your liking

    // public static final RegistryObject<Block> *** = register("***", () ->
    //             new Block(AbstractBlock.Properties.of(Material.***).strength(*(, *.*F - Not required but here anyway)).harvestLevel(2).harvestTool(ToolType.***).sound(SoundType.***)));

    static void registerStuff() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return itemReg.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> returnValue = registerNoItem(name, block);
        itemReg.ITEMS.register(name, () -> new BlockItem(returnValue.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
        return returnValue;
    }
}
