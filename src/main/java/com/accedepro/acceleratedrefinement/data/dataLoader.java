package com.accedepro.acceleratedrefinement.data;

import com.accedepro.acceleratedrefinement.acceleratedRefinement;
import com.accedepro.acceleratedrefinement.data.client.modBlockStateProvider;
import com.accedepro.acceleratedrefinement.data.client.modTextureProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = acceleratedRefinement.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class dataLoader {

    @SubscribeEvent
    public static void aquireData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new modTextureProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(new modBlockStateProvider(generator, event.getExistingFileHelper()));
    }

}
