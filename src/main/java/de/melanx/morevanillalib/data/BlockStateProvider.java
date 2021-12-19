package de.melanx.morevanillalib.data;

import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.BlockStateProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

@Datagen
public class BlockStateProvider extends BlockStateProviderBase {

    public BlockStateProvider(ModX mod, DataGenerator generator, ExistingFileHelper helper) {
        super(mod, generator, helper);
    }

    @Override
    protected void setup() {
        // No, u
    }
}
