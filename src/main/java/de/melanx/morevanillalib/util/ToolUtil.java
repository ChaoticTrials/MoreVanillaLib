package de.melanx.morevanillalib.util;

import com.google.common.collect.Sets;
import de.melanx.morevanillalib.LibConfigHandler;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;
import java.util.Set;

public class ToolUtil {

    public static final Set<Material> PICKAXE_MATERIALS = Sets.newHashSet(Material.ROCK, Material.ANVIL, Material.IRON);
    public static final Set<Material> AXE_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANTS, Material.TALL_PLANTS, Material.BAMBOO, Material.GOURD);

    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            Random rand = event.getEntityLiving().world.rand;

            double chance = LibConfigHandler.extraDamageChance.get();
            if (rand.nextDouble() < chance && LibConfigHandler.extraDamage.get()) {
                float multiplier = (float) rand.nextInt(26) / 10 + 1;
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    public static void headDrop(LivingDropsEvent event, IItemProvider head) {
        ItemStack weapon = ((PlayerEntity) event.getSource().getTrueSource()).getHeldItemMainhand();
        if (!weapon.isEmpty()) {
            Random rand = event.getEntityLiving().world.rand;
            int looting = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, weapon);

            double chance = LibConfigHandler.headDropChance.get();
            if (LibConfigHandler.headDrop.get() && rand.nextDouble() < chance + looting) {
                addDrop(event, new ItemStack(head));
            }
        }
    }

    private static void addDrop(LivingDropsEvent event, ItemStack drop) {
        ItemEntity entityitem = new ItemEntity(event.getEntityLiving().world, event.getEntityLiving().lastTickPosX, event.getEntityLiving().lastTickPosY, event.getEntityLiving().lastTickPosZ, drop);
        entityitem.setPickupDelay(10);
        event.getDrops().add(entityitem);
    }

    public static void extraDrop(World world, BlockPos pos, IItemTier mat) {
        double chance = LibConfigHandler.extraDropChance.get();
        if (world.rand.nextDouble() < chance && LibConfigHandler.extraDrop.get()) {
            Ingredient ingredient = mat.getRepairMaterial();
            ItemStack stack = ingredient.acceptedItems[0].getStacks().iterator().next();
            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }

    public static boolean isPlayerKill(LivingDropsEvent event) {
        return event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof PlayerEntity;
    }

}
