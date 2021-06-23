package de.melanx.morevanillalib.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;

public class LuckOfCheapRepairing extends Enchantment {

    public LuckOfCheapRepairing() {
        super(Enchantment.Rarity.RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.values());

        MinecraftForge.EVENT_BUS.addListener(this::onAnvilRepair);
    }

    private void onAnvilRepair(AnvilUpdateEvent event) {
        if (EnchantmentHelper.getEnchantmentLevel(this, event.getLeft()) > 0 && event.getRight() != ItemStack.EMPTY) {
            event.getLeft().setRepairCost(0);
        }
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 18;
    }
}
