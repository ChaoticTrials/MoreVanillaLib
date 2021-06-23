package de.melanx.morevanillalib.util;

import com.google.common.collect.Sets;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.core.LibDamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
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

    // TODO 1.17 replace with tags
    public static final Set<Material> PICKAXE_MATERIALS = Sets.newHashSet(Material.ROCK, Material.ANVIL, Material.IRON);
    public static final Set<Material> AXE_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANTS, Material.TALL_PLANTS, Material.BAMBOO, Material.GOURD);

    // TODO use loot modifier
    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            Random rand = event.getEntityLiving().world.rand;

            if (FeatureConfig.ExtraDamage.enabled && rand.nextDouble() < FeatureConfig.ExtraDamage.chance) {
                float multiplier = (float) (rand.nextFloat() * FeatureConfig.ExtraDamage.maxMultiplier);
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    // TODO use loot modifier
    public static void headDrop(LivingDropsEvent event, IItemProvider head) {
        ItemStack weapon = ((PlayerEntity) event.getSource().getTrueSource()).getHeldItemMainhand();
        if (!weapon.isEmpty()) {
            Random rand = event.getEntityLiving().world.rand;
            int looting = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, weapon);

            if (FeatureConfig.HeadDrop.enabled && rand.nextDouble() < FeatureConfig.HeadDrop.chance + looting) {
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
        if (FeatureConfig.ExtraDrop.enabled && world.rand.nextDouble() < FeatureConfig.ExtraDrop.chance) {
            Ingredient ingredient = mat.getRepairMaterial();
            ItemStack stack = ingredient.getMatchingStacks()[0];
            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }

    public static boolean isPlayerKill(LivingDropsEvent event) {
        return event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof PlayerEntity;
    }

    public static void paperDamage(LivingEntity entity) {
        entity.attackEntityFrom(LibDamageSource.PAPER_CUT, Math.max(FeatureConfig.PaperDamage.minDamage, entity.world.rand.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
    }
}
