package de.melanx.morevanillalib.data;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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

        private static Tag<Item> tag(String name) {
            return new net.minecraft.tags.ItemTags.Wrapper(new ResourceLocation("forge", name));
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

            copy(Blocks.BONE_BLOCK, ModTags.Items.BONE_BLOCK);
            copy(Blocks.STORAGE_BLOCKS_GLOWSTONE, Items.STORAGE_BLOCKS_GLOWSTONE);
            copy(Blocks.MAGMA_BLOCK, Items.MAGMA_BLOCK);
            copy(Blocks.NETHER_BRICKS, Items.NETHER_BRICKS);
            copy(Blocks.PRISMARINE, Items.PRISMARINE);
            copy(Blocks.SLIME_BLOCK, Items.SLIME_BLOCK);
        }
    }

}
