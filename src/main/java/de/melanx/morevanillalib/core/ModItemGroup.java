package de.melanx.morevanillalib.core;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup {

    public ModItemGroup() {
        super(MoreVanillaLib.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registration.obsidian_shard.get());
    }
}
