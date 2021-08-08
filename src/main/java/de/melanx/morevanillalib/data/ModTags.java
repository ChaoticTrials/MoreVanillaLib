package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.CommonTagsProviderBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTags extends CommonTagsProviderBase {

    public ModTags(DataGenerator generator, ExistingFileHelper helper) {
        super(MoreVanillaLib.getInstance(), generator, helper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setup() {
        this.block(BlockTags.MINEABLE_WITH_PICKAXE).add(ModContent.cleanEndStone);

        this.block(Tags.Blocks.END_STONES).addTags(Blocks.CLEAN_ENDSTONE);
        this.block(Blocks.MINEABLE_WITH_AIOT).addTags(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_HOE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL);

        this.item(Items.WOOD_TOOLS);
        this.item(Items.STONE_TOOLS);
        this.item(Items.IRON_TOOLS);
        this.item(Items.GOLD_TOOLS);
        this.item(Items.DIAMOND_TOOLS);
        this.item(Items.NETHERITE_TOOLS);
        this.item(Items.BONE_TOOLS);
        this.item(Items.COAL_TOOLS);
        this.item(Items.EMERALD_TOOLS);
        this.item(Items.ENDER_TOOLS);
        this.item(Items.FIERY_TOOLS);
        this.item(Items.GLOWSTONE_TOOLS);
        this.item(Items.LAPIS_TOOLS);
        this.item(Items.NETHER_TOOLS);
        this.item(Items.OBSIDIAN_TOOLS);
        this.item(Items.PAPER_TOOLS);
        this.item(Items.PRISMARINE_TOOLS);
        this.item(Items.QUARTZ_TOOLS);
        this.item(Items.REDSTONE_TOOLS);
        this.item(Items.SLIME_TOOLS);
        //noinspection unchecked
        this.item(Items.ALL_TOOLS).addTags(
            Items.WOOD_TOOLS,
            Items.STONE_TOOLS,
            Items.IRON_TOOLS,
            Items.GOLD_TOOLS,
            Items.DIAMOND_TOOLS,
            Items.NETHERITE_TOOLS,
            Items.BONE_TOOLS,
            Items.COAL_TOOLS,
            Items.EMERALD_TOOLS,
            Items.ENDER_TOOLS,
            Items.FIERY_TOOLS,
            Items.GLOWSTONE_TOOLS,
            Items.LAPIS_TOOLS,
            Items.NETHER_TOOLS,
            Items.OBSIDIAN_TOOLS,
            Items.PRISMARINE_TOOLS,
            Items.QUARTZ_TOOLS,
            Items.REDSTONE_TOOLS,
            Items.SLIME_TOOLS
        );

        this.copyBlock(Blocks.CLEAN_ENDSTONE, Items.CLEAN_ENDSTONE);
    }

    @Override
    public void defaultBlockTags(Block block) {
        if (block == ModContent.cleanEndStone) {
            this.block(Blocks.CLEAN_ENDSTONE).add(ModContent.cleanEndStone);
        }
    }

    @Override
    public void defaultItemTags(Item item) {
        if (item == ModContent.obsidianShard) {
            this.item(Items.DUSTS_OBSIDIAN).add(item);
        } else if (item == ModContent.paperBundle) {
            this.item(Items.PAPER_BUNDLE).add(item);
        }
    }

    public static class Blocks {
        public static final Tag.Named<Block> CLEAN_ENDSTONE = tag("clean_endstone");
        public static final Tag.Named<Block> MINEABLE_WITH_AIOT = tag("mineable/aiot");

        private static Tag.Named<Block> tag(String name) {
            return BlockTags.bind("forge:" + name);
        }
    }

    public static class Items {
        public static final Tag.Named<Item> CLEAN_ENDSTONE = tag("clean_endstone");

        public static final Tag.Named<Item> DUSTS_OBSIDIAN = tag("dusts/obsidian");
        public static final Tag.Named<Item> PAPER_BUNDLE = tag("paper_bundle");

        public static final Tag.Named<Item> WOOD_TOOLS = modTag("tools/wood");
        public static final Tag.Named<Item> STONE_TOOLS = modTag("tools/stone");
        public static final Tag.Named<Item> IRON_TOOLS = modTag("tools/iron");
        public static final Tag.Named<Item> GOLD_TOOLS = modTag("tools/gold");
        public static final Tag.Named<Item> DIAMOND_TOOLS = modTag("tools/diamond");
        public static final Tag.Named<Item> BONE_TOOLS = modTag("tools/bone");
        public static final Tag.Named<Item> COAL_TOOLS = modTag("tools/coal");
        public static final Tag.Named<Item> EMERALD_TOOLS = modTag("tools/emerald");
        public static final Tag.Named<Item> ENDER_TOOLS = modTag("tools/ender");
        public static final Tag.Named<Item> FIERY_TOOLS = modTag("tools/fiery");
        public static final Tag.Named<Item> GLOWSTONE_TOOLS = modTag("tools/glowstone");
        public static final Tag.Named<Item> LAPIS_TOOLS = modTag("tools/lapis");
        public static final Tag.Named<Item> NETHER_TOOLS = modTag("tools/nether");
        public static final Tag.Named<Item> NETHERITE_TOOLS = modTag("tools/netherite");
        public static final Tag.Named<Item> OBSIDIAN_TOOLS = modTag("tools/obsidian");
        public static final Tag.Named<Item> PAPER_TOOLS = modTag("tools/paper");
        public static final Tag.Named<Item> PRISMARINE_TOOLS = modTag("tools/prismarine");
        public static final Tag.Named<Item> QUARTZ_TOOLS = modTag("tools/quartz");
        public static final Tag.Named<Item> REDSTONE_TOOLS = modTag("tools/redstone");
        public static final Tag.Named<Item> SLIME_TOOLS = modTag("tools/slime");
        public static final Tag.Named<Item> ALL_TOOLS = modTag("tools");

        private static Tag.Named<Item> tag(String name) {
            return ItemTags.bind("forge:" + name);
        }

        private static Tag.Named<Item> modTag(String name) {
            return ItemTags.bind(MoreVanillaLib.getInstance().modid + ":" + name);
        }
    }
}
