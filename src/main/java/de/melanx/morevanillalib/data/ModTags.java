package de.melanx.morevanillalib.data;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Blocks {
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
        public static final Tag<Item> STORAGE_BLOCKS_GLOWSTONE = tag("storage_blocks/glowstone");
        public static final Tag<Item> MAGMA_BLOCK = tag("magma_block");
        public static final Tag<Item> NETHER_BRICKS = tag("netherbricks");
        public static final Tag<Item> PRISMARINE = tag("prismarine");
        public static final Tag<Item> SLIME_BLOCK = tag("slime_block");

        public static final Tag<Item> PAPER = tag("paper");

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

            copy(Blocks.STORAGE_BLOCKS_GLOWSTONE, Items.STORAGE_BLOCKS_GLOWSTONE);
            copy(Blocks.MAGMA_BLOCK, Items.MAGMA_BLOCK);
            copy(Blocks.NETHER_BRICKS, Items.NETHER_BRICKS);
            copy(Blocks.PRISMARINE, Items.PRISMARINE);
            copy(Blocks.SLIME_BLOCK, Items.SLIME_BLOCK);
        }
    }

}
