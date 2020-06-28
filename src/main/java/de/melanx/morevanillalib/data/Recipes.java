package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.Registration;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        compress(Items.OBSIDIAN, ModTags.Items.DUSTS_OBSIDIAN, consumer);
        compress(Registration.paper_bundle.get(), ModTags.Items.PAPER, consumer);
        decompress(Registration.obsidian_shard.get(), Tags.Items.OBSIDIAN, consumer);
        decompress(Items.PAPER, ModTags.Items.PAPER_BUNDLE, consumer);
        registerSmeltingRecipes(consumer, "_smelting", IRecipeSerializer.SMELTING, 0.1F, 200);
        registerSmeltingRecipes(consumer, "_blasting", IRecipeSerializer.BLASTING, 0.1F, 100);
    }

    private void compress(Item result, ITag.INamedTag<Item> ingredient, Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('X', ingredient)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("XXX")
                .addCriterion("has_material", hasItem(ingredient))
                .build(consumer, new ResourceLocation(MoreVanillaLib.MODID, result.getRegistryName().getPath()));
    }

    private void decompress(Item result, ITag.INamedTag<Item> ingredient, Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(result, 9)
                .addIngredient(ingredient)
                .addCriterion("has_material", hasItem(ingredient))
                .build(consumer, new ResourceLocation(MoreVanillaLib.MODID, result.getRegistryName().getPath()));
    }

    private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer, String method, CookingRecipeSerializer<?> serializer, float xp, int time) {
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Items.END_STONE), Registration.clean_endstone.get(), xp, time, serializer).addCriterion("has_material", hasItem(Items.END_STONE)).build(consumer, Registration.clean_endstone.get().getRegistryName() + method);
    }
}
