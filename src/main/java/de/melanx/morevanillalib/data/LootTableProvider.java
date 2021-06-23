package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.BlockLootProviderBase;
import net.minecraft.data.DataGenerator;

public class LootTableProvider extends BlockLootProviderBase {
    public LootTableProvider(DataGenerator generator) {
        super(MoreVanillaLib.getInstance(), generator);
    }

    @Override
    protected void setup() {
        this.drops(ModContent.cleanEndStone, this.item());
    }
}
