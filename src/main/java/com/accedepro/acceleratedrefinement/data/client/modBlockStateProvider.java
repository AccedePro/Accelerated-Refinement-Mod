package com.accedepro.acceleratedrefinement.data.client;

import com.accedepro.acceleratedrefinement.acceleratedRefinement;
import com.accedepro.acceleratedrefinement.setup.modBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class modBlockStateProvider extends BlockStateProvider {
    public modBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, acceleratedRefinement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(modBlocks.KILN.get());
    }
}
