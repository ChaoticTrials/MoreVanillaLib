package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import io.github.noeppi_noeppi.libx.data.provider.recipe.RecipeProviderBase;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class RecipeProvider extends RecipeProviderBase {

    public RecipeProvider(DataGenerator generator) {
        super(MoreVanillaLib.getInstance(), generator);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        compress(Items.OBSIDIAN, ModTags.Items.DUSTS_OBSIDIAN, consumer);
        compress(ModContent.paperBundle, Items.PAPER, consumer);
        decompress(ModContent.obsidianShard, Tags.Items.OBSIDIAN, consumer);
        decompress(Items.PAPER, ModTags.Items.PAPER_BUNDLE, consumer);
        registerSmeltingRecipes(consumer, "smelting", IRecipeSerializer.SMELTING_RECIPE, 0.1F, 200);
        registerSmeltingRecipes(consumer, "blasting", IRecipeSerializer.BLASTING_RECIPE, 0.1F, 100);
    }

    @SuppressWarnings("SameParameterValue")
    private void compress(Item result, ITag.INamedTag<Item> ingredient, Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "compress"));
    }

    @SuppressWarnings("SameParameterValue")
    private void compress(Item result, IItemProvider ingredient, Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "compress"));
    }

    private void decompress(Item result, ITag.INamedTag<Item> ingredient, Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, 9)
                .requires(ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "decompress"));
    }

    private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer, String method, CookingRecipeSerializer<?> serializer, float xp, int time) {
        CookingRecipeBuilder.cooking(Ingredient.of(Items.END_STONE), ModContent.cleanEndStone, xp, time, serializer).unlockedBy("has_material", has(Items.END_STONE)).save(consumer, this.loc(ModContent.cleanEndStone, method));
    }
}
