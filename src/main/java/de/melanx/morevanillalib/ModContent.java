package de.melanx.morevanillalib;

import de.melanx.morevanillalib.core.modifier.AutoSmeltModifier;
import de.melanx.morevanillalib.core.modifier.GlowstoneToolModifier;
import de.melanx.morevanillalib.enchantments.LuckOfCheapRepairing;
import io.github.noeppi_noeppi.libx.annotation.RegisterClass;
import io.github.noeppi_noeppi.libx.mod.registration.BlockBase;
import io.github.noeppi_noeppi.libx.mod.registration.ItemBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

@RegisterClass
public class ModContent {

    public static final Block cleanEndStone = new BlockBase(MoreVanillaLib.getInstance(), AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4.0F, 11.0F));

    public static final Item obsidianShard = new ItemBase(MoreVanillaLib.getInstance(), new Item.Properties());
    public static final Item paperBundle = new ItemBase(MoreVanillaLib.getInstance(), new Item.Properties());

    public static final Enchantment repairingLuck = new LuckOfCheapRepairing();

    public static final GlobalLootModifierSerializer<AutoSmeltModifier> autoSmelt = new AutoSmeltModifier.Serializer();
    public static final GlobalLootModifierSerializer<GlowstoneToolModifier> glowstoneDrops = new GlowstoneToolModifier.Serializer();
}
