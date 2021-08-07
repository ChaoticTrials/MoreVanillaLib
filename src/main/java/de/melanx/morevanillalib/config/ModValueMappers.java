package de.melanx.morevanillalib.config;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.api.IConfigurableTier;
import io.github.noeppi_noeppi.libx.config.ConfigManager;
import io.github.noeppi_noeppi.libx.config.ValueMapper;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

public class ModValueMappers {

    public static void registerValueMappers() {
        ConfigManager.registerValueMapper(new ResourceLocation("morevanillalib", "item_tier"), ITEM_TIER);
    }

    public static final ValueMapper<IConfigurableTier, JsonObject> ITEM_TIER = new ValueMapper<IConfigurableTier, JsonObject>() {
        @Override
        public Class<IConfigurableTier> type() {
            return IConfigurableTier.class;
        }

        @Override
        public Class<JsonObject> element() {
            return JsonObject.class;
        }

        @Override
        public IConfigurableTier fromJSON(JsonObject json, Class<?> elementType) {
            int durability = JSONUtils.getInt(json, "durability");
            float efficiency = JSONUtils.getFloat(json, "efficiency");
            float attackDamage = JSONUtils.getFloat(json, "attackDamage");
            float attackSpeed = JSONUtils.getFloat(json, "attackSpeed");
            int harvestLevel = JSONUtils.getInt(json, "harvestLevel");
            int enchantability = JSONUtils.getInt(json, "enchantability");
            return new IConfigurableTier() {
                @Override
                public int getMaxUses() {
                    return durability;
                }

                @Override
                public float getEfficiency() {
                    return efficiency;
                }

                @Override
                public float getAttackDamage() {
                    return attackDamage;
                }

                @Override
                public float getAttackSpeed() {
                    return attackSpeed;
                }

                @Override
                public int getHarvestLevel() {
                    return harvestLevel;
                }

                @Override
                public int getEnchantability() {
                    return enchantability;
                }
            };
        }

        @Override
        public JsonObject toJSON(IConfigurableTier tier, Class<?> elementType) {
            JsonObject json = new JsonObject();
            json.addProperty("durability", tier.getMaxUses());
            json.addProperty("efficiency", tier.getEfficiency());
            json.addProperty("attackDamage", tier.getAttackDamage());
            json.addProperty("attackSpeed", tier.getAttackSpeed());
            json.addProperty("harvestLevel", tier.getHarvestLevel());
            json.addProperty("enchantability", tier.getEnchantability());
            return json;
        }
    };
}
