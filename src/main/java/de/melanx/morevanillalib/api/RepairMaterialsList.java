package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

public class RepairMaterialsList {

    public static final Ingredient wood = getTagIngredient(ItemTags.PLANKS);
    public static final Ingredient stone = getTagIngredient(Tags.Items.COBBLESTONE);
    public static final Ingredient iron = getTagIngredient(Tags.Items.INGOTS_IRON);
    public static final Ingredient gold = getTagIngredient(Tags.Items.INGOTS_GOLD);
    public static final Ingredient diamond = getTagIngredient(Tags.Items.GEMS_DIAMOND);
    public static final Ingredient netherite = getTagIngredient(ModTags.Items.INGOTS_NETHERITE);

    public static final Ingredient bone = getTagIngredient(Tags.Items.BONES);
    public static final Ingredient coal = getTagIngredient(ModTags.Items.GEMS_COAL);
    public static final Ingredient emerald = getTagIngredient(Tags.Items.GEMS_EMERALD);
    public static final Ingredient ender = getTagIngredient(Tags.Items.ENDER_PEARLS);
    public static final Ingredient fiery = getTagIngredient(ModTags.Items.MAGMA_BLOCK);
    public static final Ingredient glowstone = getTagIngredient(Tags.Items.DUSTS_GLOWSTONE);
    public static final Ingredient lapis = getTagIngredient(Tags.Items.GEMS_LAPIS);
    public static final Ingredient nether = getTagIngredient(ModTags.Items.NETHER_BRICKS);
    public static final Ingredient obsidian = getTagIngredient(Tags.Items.OBSIDIAN);
    public static final Ingredient paper = getTagIngredient(ModTags.Items.PAPER);
    public static final Ingredient prismarine = getTagIngredient(Tags.Items.DUSTS_PRISMARINE);
    public static final Ingredient quartz = getTagIngredient(Tags.Items.GEMS_QUARTZ);
    public static final Ingredient redstone = getTagIngredient(Tags.Items.DUSTS_REDSTONE);
    public static final Ingredient slime = getTagIngredient(Tags.Items.SLIMEBALLS);

    private static Ingredient getTagIngredient(ITag.INamedTag<Item> tag) {
        return Ingredient.fromTag(tag);
    }

}
