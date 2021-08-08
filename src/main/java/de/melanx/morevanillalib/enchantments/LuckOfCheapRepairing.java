package de.melanx.morevanillalib.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;

public class LuckOfCheapRepairing extends DeactivatableEnchantment {

    public LuckOfCheapRepairing() {
        super(Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlot.values());

        MinecraftForge.EVENT_BUS.addListener(this::onAnvilRepair);
    }

    private void onAnvilRepair(AnvilUpdateEvent event) {
        if (EnchantmentHelper.getItemEnchantmentLevel(this, event.getLeft()) > 0 && event.getRight() != ItemStack.EMPTY) {
            event.getLeft().setRepairCost(0);
        }
    }

    @Override
    public int getMinCost(int level) {
        return 18;
    }
}
