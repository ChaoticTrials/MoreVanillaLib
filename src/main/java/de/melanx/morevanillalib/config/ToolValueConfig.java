package de.melanx.morevanillalib.config;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.api.ItemTier;
import de.melanx.morevanillalib.data.ModTags;
import io.github.noeppi_noeppi.libx.config.Config;
import io.github.noeppi_noeppi.libx.config.Group;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class ToolValueConfig {

    @Group("This is be used by MoreVanillaTools")
    public static class NormalTools {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().build();
    }

    @Group("This is used by Vanilla AIOTs")
    public static class AIOTs {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().aiot().build();
    }

    @Group("This is used by Vanilla Hammers and Vanilla Excavators")
    public static class RangedTools {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().big().build();
    }

    private static class RawToolMaterials {

        private static final ItemTier.Builder WOOD = ItemTier.builder()
                .durability(59)
                .efficiency(2F)
                .attackDamage(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(0)
                .enchantability(15)
                .name("wood")
                .repairMaterial(() -> Ingredient.fromItems(Items.AIR))
                .craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder STONE = ItemTier.builder()
                .durability(131)
                .efficiency(4F)
                .attackDamage(4F)
                .attackSpeed(-2.6F)
                .harvestLevel(1)
                .enchantability(5)
                .name("stone")
                .repairMaterial(() -> Ingredient.fromItems(Items.AIR))
                .craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder IRON = ItemTier.builder()
                .durability(250)
                .efficiency(6F)
                .attackDamage(5F)
                .attackSpeed(-2.8F)
                .harvestLevel(2)
                .enchantability(14)
                .name("iron")
                .repairMaterial(() -> Ingredient.fromItems(Items.AIR))
                .craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder GOLD = ItemTier.builder()
                .durability(32)
                .efficiency(12F)
                .attackDamage(5F)
                .attackSpeed(-2.5F)
                .harvestLevel(0)
                .enchantability(22)
                .name("gold")
                .repairMaterial(() -> Ingredient.fromItems(Items.AIR))
                .craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder DIAMOND = ItemTier.builder()
                .durability(1561)
                .efficiency(8F)
                .attackDamage(10F)
                .attackSpeed(-3F)
                .harvestLevel(3)
                .enchantability(10)
                .name("diamond")
                .repairMaterial(() -> Ingredient.fromItems(Items.AIR))
                .craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder NETHERITE = ItemTier.builder()
                .durability(2031)
                .efficiency(9F)
                .attackDamage(11F)
                .attackSpeed(-3.5F)
                .harvestLevel(4)
                .enchantability(15).name("netherite").repairMaterial(() -> Ingredient.fromItems(Items.AIR)).craftingIngredient(() -> Ingredient.fromItems(Items.AIR));

        private static final ItemTier.Builder BONE = ItemTier.builder()
                .durability(176)
                .efficiency(3.9F)
                .attackDamage(4F)
                .attackSpeed(-2F)
                .harvestLevel(0)
                .enchantability(17)
                .name("bone")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.BONES))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.BONES));

        private static final ItemTier.Builder COAL = ItemTier.builder()
                .durability(145)
                .efficiency(3.9F)
                .attackDamage(2F)
                .attackSpeed(-2.6F)
                .harvestLevel(0)
                .enchantability(17)
                .name("coal")
                .repairMaterial(() -> Ingredient.fromItems(Items.COAL))
                .craftingIngredient(() -> Ingredient.fromItems(Items.COAL));

        private static final ItemTier.Builder EMERALD = ItemTier.builder()
                .durability(1171)
                .efficiency(8.2F)
                .attackDamage(11F)
                .attackSpeed(-3F)
                .harvestLevel(2)
                .enchantability(35)
                .name("emerald")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD));

        private static final ItemTier.Builder ENDER = ItemTier.builder()
                .durability(666)
                .efficiency(3.7F)
                .attackDamage(10F)
                .attackSpeed(-3.3F)
                .harvestLevel(2)
                .enchantability(10)
                .name("ender")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.END_STONES));

        private static final ItemTier.Builder FIERY = ItemTier.builder()
                .durability(127)
                .efficiency(4F)
                .attackDamage(6F)
                .attackSpeed(-2.3F)
                .harvestLevel(1)
                .enchantability(15)
                .name("fiery")
                .repairMaterial(() -> Ingredient.fromItems(Items.MAGMA_BLOCK))
                .craftingIngredient(() -> Ingredient.fromItems(Items.MAGMA_CREAM));

        private static final ItemTier.Builder GLOWSTONE = ItemTier.builder()
                .durability(123)
                .efficiency(3F)
                .attackDamage(5F)
                .attackSpeed(-2.3F)
                .harvestLevel(1)
                .enchantability(35)
                .name("glowstone")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE));

        private static final ItemTier.Builder LAPIS = ItemTier.builder()
                .durability(173)
                .efficiency(6.2F)
                .attackDamage(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(2)
                .enchantability(20)
                .name("lapis")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS));

        private static final ItemTier.Builder NETHER = ItemTier.builder()
                .durability(188)
                .efficiency(3.9F)
                .attackDamage(4F)
                .attackSpeed(-2.1F)
                .harvestLevel(1)
                .enchantability(66)
                .name("nether")
                .repairMaterial(() -> Ingredient.fromItems(Items.NETHER_BRICKS))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.NETHERRACK));

        private static final ItemTier.Builder OBSIDIAN = ItemTier.builder()
                .durability(1337)
                .efficiency(4.7F)
                .attackDamage(7F)
                .attackSpeed(-3.5F)
                .harvestLevel(3)
                .enchantability(15)
                .name("obsidian")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.OBSIDIAN))
                .craftingIngredient(() -> Ingredient.fromTag(ModTags.Items.DUSTS_OBSIDIAN));

        private static final ItemTier.Builder PAPER = ItemTier.builder()
                .durability(13)
                .efficiency(1.8F)
                .attackDamage(0F)
                .attackSpeed(-3F)
                .harvestLevel(0)
                .enchantability(17)
                .name("paper")
                .repairMaterial(() -> Ingredient.fromItems(Items.PAPER))
                .craftingIngredient(() -> Ingredient.fromItems(Items.PAPER));

        private static final ItemTier.Builder PRISMARINE = ItemTier.builder()
                .durability(225)
                .efficiency(6F)
                .attackDamage(6F)
                .attackSpeed(-2.3F)
                .harvestLevel(2)
                .enchantability(20)
                .name("prismarine")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE));

        private static final ItemTier.Builder QUARTZ = ItemTier.builder()
                .durability(117)
                .efficiency(3.9F)
                .attackDamage(5F)
                .attackSpeed(-2F)
                .harvestLevel(1)
                .enchantability(18)
                .name("quartz")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ));

        private static final ItemTier.Builder REDSTONE = ItemTier.builder()
                .durability(173)
                .efficiency(6.2F)
                .attackDamage(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(2)
                .enchantability(20)
                .name("redstone")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE));

        private static final ItemTier.Builder SLIME = ItemTier.builder()
                .durability(123)
                .efficiency(5.2F)
                .attackDamage(7F)
                .attackSpeed(-3F)
                .harvestLevel(1)
                .enchantability(20)
                .name("slime")
                .repairMaterial(() -> Ingredient.fromTag(Tags.Items.SLIMEBALLS))
                .craftingIngredient(() -> Ingredient.fromTag(Tags.Items.SLIMEBALLS));
    }
}
