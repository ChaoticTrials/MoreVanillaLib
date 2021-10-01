package de.melanx.morevanillalib.config;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.api.IConfigurableTier;
import io.github.noeppi_noeppi.libx.annotation.config.RegisterMapper;
import io.github.noeppi_noeppi.libx.config.ValidatorInfo;
import io.github.noeppi_noeppi.libx.config.ValueMapper;
import io.github.noeppi_noeppi.libx.config.gui.ConfigEditor;
import net.minecraft.util.GsonHelper;

@RegisterMapper
public class ItemTier implements ValueMapper<IConfigurableTier, JsonObject> {

    @Override
    public Class<IConfigurableTier> type() {
        return IConfigurableTier.class;
    }

    @Override
    public Class<JsonObject> element() {
        return JsonObject.class;
    }

    @Override
    public IConfigurableTier fromJson(JsonObject json) {
        int durability = GsonHelper.getAsInt(json, "durability");
        float speed = GsonHelper.getAsFloat(json, "speed");
        float attackDamageBonus = GsonHelper.getAsFloat(json, "attackDamageBonus");
        float attackSpeed = GsonHelper.getAsFloat(json, "attackSpeed");
        int harvestLevel = GsonHelper.getAsInt(json, "harvestLevel");
        int enchantmentValue = GsonHelper.getAsInt(json, "enchantmentValue");
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
    public JsonObject toJson(IConfigurableTier tier) {
        JsonObject json = new JsonObject();
        json.addProperty("durability", tier.getUses());
        json.addProperty("speed", tier.getSpeed());
        json.addProperty("attackDamageBonus", tier.getAttackDamageBonus());
        json.addProperty("attackSpeed", tier.getAttackSpeed());
        json.addProperty("harvestLevel", tier.getLevel());
        json.addProperty("enchantmentValue", tier.getEnchantmentValue());
        return json;
    }

    @Override
    public ConfigEditor<IConfigurableTier> createEditor(ValidatorInfo<?> validator) {
        return ConfigEditor.unsupported(
                new IConfigurableTier() {
                    @Override
                    public int getUses() {
                        return 0;
                    }

                    @Override
                    public float getSpeed() {
                        return 0;
                    }

                    @Override
                    public float getAttackDamageBonus() {
                        return 0;
                    }

                    @Override
                    public int getLevel() {
                        return 0;
                    }

                    @Override
                    public int getEnchantmentValue() {
                        return 0;
                    }
                }
        );
    }
}
