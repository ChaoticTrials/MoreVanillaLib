package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoreVanillaLib.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagsProvider blockTags = new ModTags.BlockTags(generator);
            generator.addProvider(blockTags);
            generator.addProvider(new ModTags.ItemTags(generator, blockTags));
            generator.addProvider(new LootTables(generator));
            generator.addProvider(new Recipes(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new BlockStates(generator, helper));
            generator.addProvider(new ItemModels(generator, helper));
            generator.addProvider(new Languages.English(generator));
            generator.addProvider(new Languages.German(generator));
        }
    }

}
