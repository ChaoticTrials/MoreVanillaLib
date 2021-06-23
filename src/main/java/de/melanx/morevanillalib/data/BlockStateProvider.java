package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.BlockStateProviderBase;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateProvider extends BlockStateProviderBase {

    public BlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(MoreVanillaLib.getInstance(), generator, helper);
    }

    @Override
    protected void setup() {
        // No, u
    }
}
