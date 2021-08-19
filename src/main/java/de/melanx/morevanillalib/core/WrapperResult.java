package de.melanx.morevanillalib.core;

import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

public class WrapperResult implements FinishedRecipe {
    private final FinishedRecipe delegate;
    @Nullable
    private final RecipeSerializer<?> type;
    @Nullable
    private final Consumer<JsonObject> transform;

    /**
     * Transforms the resulting recipe json with the specified action, eg. adding NBT to an item result.
     */
    public static Consumer<FinishedRecipe> transformJson(Consumer<FinishedRecipe> parent, Consumer<JsonObject> transform) {
        return recipe -> parent.accept(new WrapperResult(recipe, null, transform));
    }

    public WrapperResult(FinishedRecipe delegate, @Nullable RecipeSerializer<?> type, @Nullable Consumer<JsonObject> transform) {
        this.delegate = delegate;
        this.type = type;
        this.transform = transform;
    }

    @Override
    public void serializeRecipeData(@Nonnull JsonObject json) {
        this.delegate.serializeRecipeData(json);
        if (this.transform != null) {
            this.transform.accept(json);
        }
    }

    @Nonnull
    @Override
    public ResourceLocation getId() {
        return this.delegate.getId();
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getType() {
        return this.type != null ? this.type : this.delegate.getType();
    }

    @Nullable
    @Override
    public JsonObject serializeAdvancement() {
        return this.delegate.serializeAdvancement();
    }

    @Nullable
    @Override
    public ResourceLocation getAdvancementId() {
        return this.delegate.getAdvancementId();
    }
}
