package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.core.Registration;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        compress(Items.OBSIDIAN, ModTags.Items.DUSTS_OBSIDIAN).build(consumer);
        compress(Registration.paper_bundle.get(), ModTags.Items.PAPER).build(consumer);
        decompress(Registration.obsidian_shard.get(), Tags.Items.OBSIDIAN).build(consumer);
        decompress(Items.PAPER, ModTags.Items.PAPER_BUNDLE).build(consumer);
        registerSmeltingRecipes(consumer, "_smelting", IRecipeSerializer.SMELTING, 0.1F, 200);
        registerSmeltingRecipes(consumer, "_blasting", IRecipeSerializer.BLASTING, 0.1F, 100);
    }

    private ShapedRecipeBuilder compress(Item result, Tag<Item> ingredient) {
        return ShapedRecipeBuilder.shapedRecipe(result)
                .key('X', ingredient)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("XXX")
                .addCriterion("has_material", hasItem(ingredient));
    }

    private ShapelessRecipeBuilder decompress(Item result, Tag<Item> ingredient) {
        return ShapelessRecipeBuilder.shapelessRecipe(result, 9)
                .addIngredient(ingredient)
                .addCriterion("has_material", hasItem(ingredient));
    }

    private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer, String method, CookingRecipeSerializer<?> serializer, float xp, int time) {
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Items.END_STONE), Registration.clean_endstone.get(), xp, time, serializer).addCriterion("has_material", hasItem(Items.END_STONE)).build(consumer, Registration.clean_endstone.get().getRegistryName() + method);
    }
}
