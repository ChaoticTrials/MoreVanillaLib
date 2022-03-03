package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.CommonTagsProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

@Datagen
public class ModTags extends CommonTagsProviderBase {

    public ModTags(ModX mod, DataGenerator generator, ExistingFileHelper helper) {
        super(mod, generator, helper);
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
        public static final TagKey<Block> CLEAN_ENDSTONE = tag("clean_endstone");
        public static final TagKey<Block> MINEABLE_WITH_AIOT = tag("mineable/aiot");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CLEAN_ENDSTONE = tag("clean_endstone");

        public static final TagKey<Item> DUSTS_OBSIDIAN = tag("dusts/obsidian");
        public static final TagKey<Item> PAPER_BUNDLE = tag("paper_bundle");

        public static final TagKey<Item> WOOD_TOOLS = modTag("tools/wood");
        public static final TagKey<Item> STONE_TOOLS = modTag("tools/stone");
        public static final TagKey<Item> IRON_TOOLS = modTag("tools/iron");
        public static final TagKey<Item> GOLD_TOOLS = modTag("tools/gold");
        public static final TagKey<Item> DIAMOND_TOOLS = modTag("tools/diamond");
        public static final TagKey<Item> BONE_TOOLS = modTag("tools/bone");
        public static final TagKey<Item> COAL_TOOLS = modTag("tools/coal");
        public static final TagKey<Item> EMERALD_TOOLS = modTag("tools/emerald");
        public static final TagKey<Item> ENDER_TOOLS = modTag("tools/ender");
        public static final TagKey<Item> FIERY_TOOLS = modTag("tools/fiery");
        public static final TagKey<Item> GLOWSTONE_TOOLS = modTag("tools/glowstone");
        public static final TagKey<Item> LAPIS_TOOLS = modTag("tools/lapis");
        public static final TagKey<Item> NETHER_TOOLS = modTag("tools/nether");
        public static final TagKey<Item> NETHERITE_TOOLS = modTag("tools/netherite");
        public static final TagKey<Item> OBSIDIAN_TOOLS = modTag("tools/obsidian");
        public static final TagKey<Item> PAPER_TOOLS = modTag("tools/paper");
        public static final TagKey<Item> PRISMARINE_TOOLS = modTag("tools/prismarine");
        public static final TagKey<Item> QUARTZ_TOOLS = modTag("tools/quartz");
        public static final TagKey<Item> REDSTONE_TOOLS = modTag("tools/redstone");
        public static final TagKey<Item> SLIME_TOOLS = modTag("tools/slime");
        public static final TagKey<Item> ALL_TOOLS = modTag("tools");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        private static TagKey<Item> modTag(String name) {
            return ItemTags.create(MoreVanillaLib.getInstance().resource(name));
        }
    }
}
