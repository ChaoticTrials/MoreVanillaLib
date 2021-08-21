package de.melanx.morevanillalib;

import de.melanx.morevanillalib.core.modifier.*;
import de.melanx.morevanillalib.enchantments.LuckOfCheapRepairing;
import de.melanx.morevanillalib.enchantments.PowerOfTheDepth;
import io.github.noeppi_noeppi.libx.annotation.registration.RegisterClass;
import io.github.noeppi_noeppi.libx.base.BlockBase;
import io.github.noeppi_noeppi.libx.base.ItemBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

@RegisterClass
public class ModContent {

    public static final Block cleanEndStone = new BlockBase(MoreVanillaLib.getInstance(), BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 11.0F));

    public static final Item obsidianShard = new ItemBase(MoreVanillaLib.getInstance(), new Item.Properties());
    public static final Item paperBundle = new ItemBase(MoreVanillaLib.getInstance(), new Item.Properties());

    public static final Enchantment repairingLuck = new LuckOfCheapRepairing();
    public static final Enchantment powerOfTheDepth = new PowerOfTheDepth();

    public static final GlobalLootModifierSerializer<AutoSmeltModifier> autoSmelt = new AutoSmeltModifier.Serializer();
    public static final GlobalLootModifierSerializer<GlowstoneToolModifier> glowstoneDrops = new GlowstoneToolModifier.Serializer();
    public static final GlobalLootModifierSerializer<DoubleDropModifier> doubleDrops = new DoubleDropModifier.Serializer();
    public static final GlobalLootModifierSerializer<ExtraDropsModifier> extraDrops = new ExtraDropsModifier.Serializer();
    public static final GlobalLootModifierSerializer<HeadDropModifier> headDrops = new HeadDropModifier.Serializer();
}
