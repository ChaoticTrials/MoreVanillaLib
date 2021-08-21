package de.melanx.morevanillalib.enchantments;

import de.melanx.morevanillalib.api.ranged.RangeItem;
import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.ModList;

public class PowerOfTheDepth extends DeactivatableEnchantment {

    public PowerOfTheDepth() {
        super(Rarity.RARE,
                EnchantmentCategory.create("ranged", item -> item instanceof RangeItem),
                new EquipmentSlot[]{EquipmentSlot.MAINHAND},
                FeatureConfig.enchantments
                        && ModList.get().isLoaded("vanillahammers") || ModList.get().isLoaded("vanillaexcavators"));
    }

    @Override
    public int getMinCost(int level) {
        return 13;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
