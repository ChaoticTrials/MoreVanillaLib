package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.recipe.RecipeProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

@Datagen
public class RecipeProvider extends RecipeProviderBase {

    public RecipeProvider(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.compress(Items.OBSIDIAN, ModTags.Items.DUSTS_OBSIDIAN, this.consumer());
        this.compress(ModContent.paperBundle, Items.PAPER, this.consumer());
        this.decompress(ModContent.obsidianShard, Tags.Items.OBSIDIAN, this.consumer());
        this.decompress(Items.PAPER, ModTags.Items.PAPER_BUNDLE, this.consumer());
        this.registerSmeltingRecipes(this.consumer(), "smelting", RecipeSerializer.SMELTING_RECIPE, 0.1F, 200);
        this.registerSmeltingRecipes(this.consumer(), "blasting", RecipeSerializer.BLASTING_RECIPE, 0.1F, 100);
    }

    @SuppressWarnings("SameParameterValue")
    private void compress(Item result, TagKey<Item> ingredient, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "compress"));
    }

    @SuppressWarnings("SameParameterValue")
    private void compress(Item result, ItemLike ingredient, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "compress"));
    }

    private void decompress(Item result, TagKey<Item> ingredient, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, 9)
                .requires(ingredient)
                .unlockedBy("has_material", has(ingredient))
                .save(consumer, this.loc(result, "decompress"));
    }

    private void registerSmeltingRecipes(Consumer<FinishedRecipe> consumer, String method, SimpleCookingSerializer<?> serializer, float xp, int time) {
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.END_STONE), ModContent.cleanEndStone, xp, time, serializer).unlockedBy("has_material", has(Items.END_STONE)).save(consumer, this.loc(ModContent.cleanEndStone, method));
    }
}
