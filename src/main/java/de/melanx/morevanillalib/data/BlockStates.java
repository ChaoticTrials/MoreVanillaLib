package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MoreVanillaLib.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        Block block = Registration.clean_endstone.get();

        ModelFile model = models().cubeAll(block.getRegistryName().getPath(), modLoc("block/" + block.getRegistryName().getPath()));
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
    }
}
