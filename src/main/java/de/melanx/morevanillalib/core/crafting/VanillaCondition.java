package de.melanx.morevanillalib.core.crafting;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.LibCommonConfig;
import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaCondition implements ICondition {
    public static final ResourceLocation KEY = new ResourceLocation(MoreVanillaLib.MODID, "vanilla_only");
    private final boolean value;

    public VanillaCondition(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return KEY;
    }

    @Override
    public boolean test() {
        return !LibCommonConfig.vanilla.get();
    }

    public static final IConditionSerializer<VanillaCondition> SERIALIZER = new IConditionSerializer<VanillaCondition>() {
        @Override
        public void write(JsonObject json, VanillaCondition value) {
            json.addProperty("value", value.value);
        }

        @Override
        public VanillaCondition read(JsonObject json) {
            return new VanillaCondition(json.get("value").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return KEY;
        }
    };
}
