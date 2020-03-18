package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Blocks {
        public static final Tag<Block> BONE_BLOCK = tag("bone_block");
        public static final Tag<Block> STORAGE_BLOCKS_GLOWSTONE = tag("storage_blocks/glowstone");
        public static final Tag<Block> MAGMA_BLOCK = tag("magma_block");
        public static final Tag<Block> NETHER_BRICKS = tag("netherbricks");
        public static final Tag<Block> PRISMARINE = tag("prismarine");
        public static final Tag<Block> SLIME_BLOCK = tag("slime_block");

        private static Tag<Block> tag(String name) {
            return new net.minecraft.tags.BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final Tag<Item> BONE_BLOCK = tag("bone_block");
        public static final Tag<Item> STORAGE_BLOCKS_GLOWSTONE = tag("storage_blocks/glowstone");
        public static final Tag<Item> MAGMA_BLOCK = tag("magma_block");
        public static final Tag<Item> NETHER_BRICKS = tag("netherbricks");
        public static final Tag<Item> PRISMARINE = tag("prismarine");
        public static final Tag<Item> SLIME_BLOCK = tag("slime_block");

        public static final Tag<Item> PAPER = tag("paper");

        public static final Tag<Item> HEADS = tag("heads");

        public static final Tag<Item> CREEPER_HEAD = tag("heads/creeper_head");
        public static final Tag<Item> DRAGON_HEAD = tag("heads/dragon_head");
        public static final Tag<Item> PLAYER_HEAD = tag("heads/player_head");
        public static final Tag<Item> ZOMBIE_HEAD = tag("heads/zombie_head");
        public static final Tag<Item> MAGMA_CREAM = tag("magma_cream");

        public static final Tag<Item> BONE_TOOLS = modTag("tools/bone");
        public static final Tag<Item> COAL_TOOLS = modTag("tools/coal");
        public static final Tag<Item> EMERALD_TOOLS = modTag("tools/emerald");
        public static final Tag<Item> ENDER_TOOLS = modTag("tools/ender");
        public static final Tag<Item> FIERY_TOOLS = modTag("tools/fiery");
        public static final Tag<Item> GLOWSTONE_TOOLS = modTag("tools/glowstone");
        public static final Tag<Item> LAPIS_TOOLS = modTag("tools/lapis");
        public static final Tag<Item> NETHER_TOOLS = modTag("tools/nether");
        public static final Tag<Item> OBSIDIAN_TOOLS = modTag("tools/obsidian");
        public static final Tag<Item> PAPER_TOOLS = modTag("tools/paper");
        public static final Tag<Item> PRISMARINE_TOOLS = modTag("tools/prismarine");
        public static final Tag<Item> QUARTZ_TOOLS = modTag("tools/quartz");
        public static final Tag<Item> REDSTONE_TOOLS = modTag("tools/redstone");
        public static final Tag<Item> SLIME_TOOLS = modTag("tools/slime");
        public static final Tag<Item> ALL_TOOLS = modTag("tools");

        private static Tag<Item> tag(String name) {
            return new net.minecraft.tags.ItemTags.Wrapper(new ResourceLocation("forge", name));
        }

        private static Tag<Item> modTag(String name) {
            return new net.minecraft.tags.ItemTags.Wrapper(new ResourceLocation(MoreVanillaLib.MODID, name));
        }
    }

    public static class BlockTags extends BlockTagsProvider {
        public BlockTags(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected void registerTags() {
            getBuilder(Blocks.BONE_BLOCK).add(net.minecraft.block.Blocks.BONE_BLOCK);
            getBuilder(Blocks.STORAGE_BLOCKS_GLOWSTONE).add(net.minecraft.block.Blocks.GLOWSTONE);
            getBuilder(Blocks.MAGMA_BLOCK).add(net.minecraft.block.Blocks.MAGMA_BLOCK);
            getBuilder(Blocks.NETHER_BRICKS).add(net.minecraft.block.Blocks.NETHER_BRICKS);
            getBuilder(Blocks.PRISMARINE).add(net.minecraft.block.Blocks.PRISMARINE);
            getBuilder(Blocks.SLIME_BLOCK).add(net.minecraft.block.Blocks.SLIME_BLOCK);
        }
    }

    public static class ItemTags extends ItemTagsProvider {
        public ItemTags(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected void registerTags() {
            getBuilder(Items.PAPER).add(net.minecraft.item.Items.PAPER);
            getBuilder(Items.HEADS).add(Items.CREEPER_HEAD, Items.DRAGON_HEAD, Items.PLAYER_HEAD, Items.ZOMBIE_HEAD);
            getBuilder(Items.CREEPER_HEAD).add(net.minecraft.item.Items.CREEPER_HEAD);
            getBuilder(Items.DRAGON_HEAD).add(net.minecraft.item.Items.DRAGON_HEAD);
            getBuilder(Items.PLAYER_HEAD).add(net.minecraft.item.Items.PLAYER_HEAD);
            getBuilder(Items.ZOMBIE_HEAD).add(net.minecraft.item.Items.ZOMBIE_HEAD);
            getBuilder(Items.MAGMA_CREAM).add(net.minecraft.item.Items.MAGMA_CREAM);

            getBuilder(Items.BONE_TOOLS);
            getBuilder(Items.COAL_TOOLS);
            getBuilder(Items.EMERALD_TOOLS);
            getBuilder(Items.ENDER_TOOLS);
            getBuilder(Items.FIERY_TOOLS);
            getBuilder(Items.GLOWSTONE_TOOLS);
            getBuilder(Items.LAPIS_TOOLS);
            getBuilder(Items.NETHER_TOOLS);
            getBuilder(Items.OBSIDIAN_TOOLS);
            getBuilder(Items.PAPER_TOOLS);
            getBuilder(Items.PRISMARINE_TOOLS);
            getBuilder(Items.QUARTZ_TOOLS);
            getBuilder(Items.REDSTONE_TOOLS);
            getBuilder(Items.SLIME_TOOLS);
            getBuilder(Items.ALL_TOOLS).add(Items.BONE_TOOLS).add(Items.COAL_TOOLS).add(Items.EMERALD_TOOLS).add(Items.ENDER_TOOLS).add(Items.FIERY_TOOLS).add(Items.GLOWSTONE_TOOLS).add(Items.LAPIS_TOOLS).add(Items.NETHER_TOOLS).add(Items.OBSIDIAN_TOOLS).add(Items.PRISMARINE_TOOLS).add(Items.QUARTZ_TOOLS).add(Items.REDSTONE_TOOLS).add(Items.SLIME_TOOLS);

            copy(Blocks.BONE_BLOCK, ModTags.Items.BONE_BLOCK);
            copy(Blocks.STORAGE_BLOCKS_GLOWSTONE, Items.STORAGE_BLOCKS_GLOWSTONE);
            copy(Blocks.MAGMA_BLOCK, Items.MAGMA_BLOCK);
            copy(Blocks.NETHER_BRICKS, Items.NETHER_BRICKS);
            copy(Blocks.PRISMARINE, Items.PRISMARINE);
            copy(Blocks.SLIME_BLOCK, Items.SLIME_BLOCK);
        }
    }

}
