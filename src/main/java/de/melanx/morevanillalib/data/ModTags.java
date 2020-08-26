package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Blocks {
        public static final ITag.INamedTag<Block> BONE_BLOCK = tag("bone_block");
        public static final ITag.INamedTag<Block> CLEAN_ENDSTONE = tag("clean_endstone");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_GLOWSTONE = tag("storage_blocks/glowstone");
        public static final ITag.INamedTag<Block> MAGMA_BLOCK = tag("magma_block");
        public static final ITag.INamedTag<Block> NETHER_BRICKS = tag("netherbricks");
        public static final ITag.INamedTag<Block> PRISMARINE = tag("prismarine");
        public static final ITag.INamedTag<Block> SLIME_BLOCK = tag("slime_block");

        private static ITag.INamedTag<Block> tag(String name) {
            return net.minecraft.tags.BlockTags.makeWrapperTag("forge:" + name);
        }
    }

    public static class Items {
        public static final ITag.INamedTag<Item> BONE_BLOCK = tag("bone_block");
        public static final ITag.INamedTag<Item> CLEAN_ENDSTONE = tag("clean_endstone");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_GLOWSTONE = tag("storage_blocks/glowstone");
        public static final ITag.INamedTag<Item> MAGMA_BLOCK = tag("magma_block");
        public static final ITag.INamedTag<Item> NETHER_BRICKS = tag("netherbricks");
        public static final ITag.INamedTag<Item> PRISMARINE = tag("prismarine");
        public static final ITag.INamedTag<Item> SLIME_BLOCK = tag("slime_block");

        public static final ITag.INamedTag<Item> DUSTS_OBSIDIAN = tag("dusts/obsidian");
        public static final ITag.INamedTag<Item> GEMS_COAL = tag("gems/coal");
        public static final ITag.INamedTag<Item> PAPER = tag("paper");
        public static final ITag.INamedTag<Item> PAPER_BUNDLE = tag("paper_bundle");

        public static final ITag.INamedTag<Item> CREEPER_HEAD = tag("heads/creeper_head");
        public static final ITag.INamedTag<Item> DRAGON_HEAD = tag("heads/dragon_head");
        public static final ITag.INamedTag<Item> PLAYER_HEAD = tag("heads/player_head");
        public static final ITag.INamedTag<Item> ZOMBIE_HEAD = tag("heads/zombie_head");
        public static final ITag.INamedTag<Item> MAGMA_CREAM = tag("magma_cream");

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
            return net.minecraft.tags.ItemTags.makeWrapperTag(MoreVanillaLib.MODID + ":" + name);
        }
    }

    public static class BlockTags extends BlockTagsProvider {
        public BlockTags(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected void registerTags() {
            getOrCreateBuilder(Blocks.BONE_BLOCK).add(net.minecraft.block.Blocks.BONE_BLOCK);
            getOrCreateBuilder(Blocks.CLEAN_ENDSTONE).add(Registration.clean_endstone.get());
            getOrCreateBuilder(Blocks.STORAGE_BLOCKS_GLOWSTONE).add(net.minecraft.block.Blocks.GLOWSTONE);
            getOrCreateBuilder(Blocks.MAGMA_BLOCK).add(net.minecraft.block.Blocks.MAGMA_BLOCK);
            getOrCreateBuilder(Blocks.NETHER_BRICKS).add(net.minecraft.block.Blocks.NETHER_BRICKS);
            getOrCreateBuilder(Blocks.PRISMARINE).add(net.minecraft.block.Blocks.PRISMARINE_BRICKS);
            getOrCreateBuilder(Blocks.SLIME_BLOCK).add(net.minecraft.block.Blocks.SLIME_BLOCK);

            getOrCreateBuilder(Tags.Blocks.END_STONES).addTags(Blocks.CLEAN_ENDSTONE);
        }
    }

    public static class ItemTags extends ItemTagsProvider {
        public ItemTags(DataGenerator generator, BlockTagsProvider blockTags) {
            super(generator, blockTags);
        }

        @Override
        protected void registerTags() {
            getOrCreateBuilder(Items.DUSTS_OBSIDIAN).add(Registration.obsidian_shard.get());
            getOrCreateBuilder(Items.GEMS_COAL).add(net.minecraft.item.Items.COAL);
            getOrCreateBuilder(Items.PAPER).add(net.minecraft.item.Items.PAPER);
            getOrCreateBuilder(Items.PAPER_BUNDLE).add(Registration.paper_bundle.get());
            getOrCreateBuilder(Tags.Items.HEADS).addTags(Items.CREEPER_HEAD, Items.DRAGON_HEAD, Items.PLAYER_HEAD, Items.ZOMBIE_HEAD);
            getOrCreateBuilder(Items.CREEPER_HEAD).add(net.minecraft.item.Items.CREEPER_HEAD);
            getOrCreateBuilder(Items.DRAGON_HEAD).add(net.minecraft.item.Items.DRAGON_HEAD);
            getOrCreateBuilder(Items.PLAYER_HEAD).add(net.minecraft.item.Items.PLAYER_HEAD);
            getOrCreateBuilder(Items.ZOMBIE_HEAD).add(net.minecraft.item.Items.ZOMBIE_HEAD);
            getOrCreateBuilder(Items.MAGMA_CREAM).add(net.minecraft.item.Items.MAGMA_CREAM);

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
            getOrCreateBuilder(Items.ALL_TOOLS).addTags(Items.WOOD_TOOLS, Items.STONE_TOOLS, Items.IRON_TOOLS, Items.GOLD_TOOLS, Items.DIAMOND_TOOLS, Items.BONE_TOOLS, Items.COAL_TOOLS, Items.EMERALD_TOOLS, Items.ENDER_TOOLS, Items.FIERY_TOOLS, Items.GLOWSTONE_TOOLS, Items.LAPIS_TOOLS, Items.NETHER_TOOLS, Items.NETHERITE_TOOLS, Items.OBSIDIAN_TOOLS, Items.PRISMARINE_TOOLS, Items.QUARTZ_TOOLS, Items.REDSTONE_TOOLS, Items.SLIME_TOOLS);

            copy(Blocks.BONE_BLOCK, Items.BONE_BLOCK);
            copy(Blocks.CLEAN_ENDSTONE, Items.CLEAN_ENDSTONE);
            copy(Blocks.STORAGE_BLOCKS_GLOWSTONE, Items.STORAGE_BLOCKS_GLOWSTONE);
            copy(Blocks.MAGMA_BLOCK, Items.MAGMA_BLOCK);
            copy(Blocks.NETHER_BRICKS, Items.NETHER_BRICKS);
            copy(Blocks.PRISMARINE, Items.PRISMARINE);
            copy(Blocks.SLIME_BLOCK, Items.SLIME_BLOCK);
        }
    }

}
