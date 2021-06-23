package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.ItemModelProviderBase;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends ItemModelProviderBase {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(MoreVanillaLib.getInstance(), generator, helper);
    }

    @Override
    protected void setup() {
        // No, u
    }
}
