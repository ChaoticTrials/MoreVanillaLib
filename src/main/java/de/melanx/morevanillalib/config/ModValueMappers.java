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
            int durability = JSONUtils.getAsInt(json, "durability");
            float speed = JSONUtils.getAsFloat(json, "speed");
            float attackDamageBonus = JSONUtils.getAsFloat(json, "attackDamageBonus");
            float attackSpeed = JSONUtils.getAsFloat(json, "attackSpeed");
            int harvestLevel = JSONUtils.getAsInt(json, "harvestLevel");
            int enchantmentValue = JSONUtils.getAsInt(json, "enchantmentValue");
            return new IConfigurableTier() {
                @Override
                public int getUses() {
                    return durability;
                }

                @Override
                public float getSpeed() {
                    return speed;
                }

                @Override
                public float getAttackDamageBonus() {
                    return attackDamageBonus;
                }

                @Override
                public float getAttackSpeed() {
                    return attackSpeed;
                }

                @Override
                public int getLevel() {
                    return harvestLevel;
                }

                @Override
                public int getEnchantmentValue() {
                    return enchantmentValue;
                }
            };
        }

        @Override
        public JsonObject toJSON(IConfigurableTier tier, Class<?> elementType) {
            JsonObject json = new JsonObject();
            json.addProperty("durability", tier.getUses());
            json.addProperty("speed", tier.getSpeed());
            json.addProperty("attackDamageBonus", tier.getAttackDamageBonus());
            json.addProperty("attackSpeed", tier.getAttackSpeed());
            json.addProperty("harvestLevel", tier.getLevel());
            json.addProperty("enchantmentValue", tier.getEnchantmentValue());
            return json;
        }
    };
}
