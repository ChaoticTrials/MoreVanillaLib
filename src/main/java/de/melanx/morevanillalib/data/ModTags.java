package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.BlockTagProviderBase;
import io.github.noeppi_noeppi.libx.data.provider.ItemTagProviderBase;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTags {

    public static class Blocks {
        public static final ITag.INamedTag<Block> CLEAN_ENDSTONE = tag("clean_endstone");

        private static ITag.INamedTag<Block> tag(@SuppressWarnings("SameParameterValue") String name) {
            return net.minecraft.tags.BlockTags.makeWrapperTag("forge:" + name);
        }
    }

    public static class Items {
        public static final ITag.INamedTag<Item> CLEAN_ENDSTONE = tag("clean_endstone");

        public static final ITag.INamedTag<Item> DUSTS_OBSIDIAN = tag("dusts/obsidian");
        public static final ITag.INamedTag<Item> PAPER_BUNDLE = tag("paper_bundle");

        public static final ITag.INamedTag<Item> WOOD_TOOLS = modTag("tools/wood");
        public static final ITag.INamedTag<Item> STONE_TOOLS = modTag("tools/stone");
        public static final ITag.INamedTag<Item> IRON_TOOLS = modTag("tools/iron");
        public static final ITag.INamedTag<Item> GOLD_TOOLS = modTag("tools/gold");
        public static final ITag.INamedTag<Item> DIAMOND_TOOLS = modTag("tools/diamond");
        public static final ITag.INamedTag<Item> BONE_TOOLS = modTag("tools/bone");
        public static final ITag.INamedTag<Item> COAL_TOOLS = modTag("tools/coal");
        public static final ITag.INamedTag<Item> EMERALD_TOOLS = modTag("tools/emerald");
        public static final ITag.INamedTag<Item> ENDER_TOOLS = modTag("tools/ender");
        public static final ITag.INamedTag<Item> FIERY_TOOLS = modTag("tools/fiery");
        public static final ITag.INamedTag<Item> GLOWSTONE_TOOLS = modTag("tools/glowstone");
        public static final ITag.INamedTag<Item> LAPIS_TOOLS = modTag("tools/lapis");
        public static final ITag.INamedTag<Item> NETHER_TOOLS = modTag("tools/nether");
        public static final ITag.INamedTag<Item> NETHERITE_TOOLS = modTag("tools/netherite");
        public static final ITag.INamedTag<Item> OBSIDIAN_TOOLS = modTag("tools/obsidian");
        public static final ITag.INamedTag<Item> PAPER_TOOLS = modTag("tools/paper");
        public static final ITag.INamedTag<Item> PRISMARINE_TOOLS = modTag("tools/prismarine");
        public static final ITag.INamedTag<Item> QUARTZ_TOOLS = modTag("tools/quartz");
        public static final ITag.INamedTag<Item> REDSTONE_TOOLS = modTag("tools/redstone");
        public static final ITag.INamedTag<Item> SLIME_TOOLS = modTag("tools/slime");
        public static final ITag.INamedTag<Item> ALL_TOOLS = modTag("tools");

        private static ITag.INamedTag<Item> tag(String name) {
            return net.minecraft.tags.ItemTags.makeWrapperTag("forge:" + name);
        }

        private static ITag.INamedTag<Item> modTag(String name) {
            return net.minecraft.tags.ItemTags.makeWrapperTag(MoreVanillaLib.getInstance().modid + ":" + name);
        }
    }

    public static class BlockTags extends BlockTagProviderBase {
        public BlockTags(DataGenerator generator, ExistingFileHelper helper) {
            super(MoreVanillaLib.getInstance(), generator, helper);
        }

        @Override
        protected void setup() {
            getOrCreateBuilder(Blocks.CLEAN_ENDSTONE).add(ModContent.cleanEndStone);

            //noinspection unchecked
            getOrCreateBuilder(Tags.Blocks.END_STONES).addTags(Blocks.CLEAN_ENDSTONE);
        }
    }

    public static class ItemTags extends ItemTagProviderBase {
        public ItemTags(DataGenerator generator, BlockTagProviderBase blockTags, ExistingFileHelper helper) {
            super(MoreVanillaLib.getInstance(), generator, helper, blockTags);
        }

        @Override
        protected void setup() {
            getOrCreateBuilder(Items.DUSTS_OBSIDIAN).add(ModContent.obsidianShard);
            getOrCreateBuilder(Items.PAPER_BUNDLE).add(ModContent.paperBundle);

            getOrCreateBuilder(Items.WOOD_TOOLS);
            getOrCreateBuilder(Items.STONE_TOOLS);
            getOrCreateBuilder(Items.IRON_TOOLS);
            getOrCreateBuilder(Items.GOLD_TOOLS);
            getOrCreateBuilder(Items.DIAMOND_TOOLS);
            getOrCreateBuilder(Items.BONE_TOOLS);
            getOrCreateBuilder(Items.COAL_TOOLS);
            getOrCreateBuilder(Items.EMERALD_TOOLS);
            getOrCreateBuilder(Items.ENDER_TOOLS);
            getOrCreateBuilder(Items.FIERY_TOOLS);
            getOrCreateBuilder(Items.GLOWSTONE_TOOLS);
            getOrCreateBuilder(Items.LAPIS_TOOLS);
            getOrCreateBuilder(Items.NETHER_TOOLS);
            getOrCreateBuilder(Items.NETHERITE_TOOLS);
            getOrCreateBuilder(Items.OBSIDIAN_TOOLS);
            getOrCreateBuilder(Items.PAPER_TOOLS);
            getOrCreateBuilder(Items.PRISMARINE_TOOLS);
            getOrCreateBuilder(Items.QUARTZ_TOOLS);
            getOrCreateBuilder(Items.REDSTONE_TOOLS);
            getOrCreateBuilder(Items.SLIME_TOOLS);
            //noinspection unchecked
            getOrCreateBuilder(Items.ALL_TOOLS).addTags(Items.WOOD_TOOLS, Items.STONE_TOOLS, Items.IRON_TOOLS, Items.GOLD_TOOLS, Items.DIAMOND_TOOLS, Items.BONE_TOOLS, Items.COAL_TOOLS, Items.EMERALD_TOOLS, Items.ENDER_TOOLS, Items.FIERY_TOOLS, Items.GLOWSTONE_TOOLS, Items.LAPIS_TOOLS, Items.NETHER_TOOLS, Items.NETHERITE_TOOLS, Items.OBSIDIAN_TOOLS, Items.PRISMARINE_TOOLS, Items.QUARTZ_TOOLS, Items.REDSTONE_TOOLS, Items.SLIME_TOOLS);

            copy(Blocks.CLEAN_ENDSTONE, Items.CLEAN_ENDSTONE);
        }
    }

}
