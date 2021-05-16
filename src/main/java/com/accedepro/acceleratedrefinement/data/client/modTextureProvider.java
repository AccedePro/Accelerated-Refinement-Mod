package com.accedepro.acceleratedrefinement.data.client;

import com.accedepro.acceleratedrefinement.acceleratedRefinement;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class modTextureProvider extends ItemModelProvider {

    //https://shadowfacts.net/tutorials/forge-modding-1102/

    public modTextureProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, acceleratedRefinement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("kiln", modLoc("kiln"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "enchanted_book");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
