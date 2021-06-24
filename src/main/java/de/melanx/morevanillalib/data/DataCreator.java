package de.melanx.morevanillalib.data;

import io.github.noeppi_noeppi.libx.data.provider.BlockTagProviderBase;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = "morevanillalib", bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagProviderBase blockTags = new ModTags.BlockTags(generator, helper);
            generator.addProvider(blockTags);
            generator.addProvider(new ModTags.ItemTags(generator, blockTags, helper));
            generator.addProvider(new LootModifierProvider(generator));
            generator.addProvider(new LootTableProvider(generator));
            generator.addProvider(new RecipeProvider(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new BlockStateProvider(generator, helper));
            generator.addProvider(new ItemModelProvider(generator, helper));
        }
    }

}
