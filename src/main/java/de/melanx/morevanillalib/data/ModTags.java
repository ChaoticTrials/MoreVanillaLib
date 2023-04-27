package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.tags.CommonTagsProviderBase;

public class ModTags extends CommonTagsProviderBase {

    public ModTags(DatagenContext context) {
        super(context);
    }

    @Override
    public void setup() {
        this.item(Items.WOOD_TOOLS);
        this.item(Items.STONE_TOOLS);
        this.item(Items.IRON_TOOLS);
        this.item(Items.GOLD_TOOLS);
        this.item(Items.DIAMOND_TOOLS);
        this.item(Items.NETHERITE_TOOLS);
        this.item(Items.BONE_TOOLS);
        this.item(Items.COAL_TOOLS);
        this.item(Items.COPPER_TOOLS);
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
                Items.COPPER_TOOLS,
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
    }

    public static class Items {
        public static final TagKey<Item> WOOD_TOOLS = modTag("tools/wood");
        public static final TagKey<Item> STONE_TOOLS = modTag("tools/stone");
        public static final TagKey<Item> IRON_TOOLS = modTag("tools/iron");
        public static final TagKey<Item> GOLD_TOOLS = modTag("tools/gold");
        public static final TagKey<Item> DIAMOND_TOOLS = modTag("tools/diamond");
        public static final TagKey<Item> BONE_TOOLS = modTag("tools/bone");
        public static final TagKey<Item> COAL_TOOLS = modTag("tools/coal");
        public static final TagKey<Item> COPPER_TOOLS = modTag("tools/copper");
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
