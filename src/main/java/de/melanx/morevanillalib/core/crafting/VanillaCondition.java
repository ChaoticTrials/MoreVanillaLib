package de.melanx.morevanillalib.core.crafting;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaCondition implements ICondition {

    public static final ResourceLocation KEY = new ResourceLocation(MoreVanillaLib.MODID, "vanilla_only");

    @Override
    public ResourceLocation getID() {
        return KEY;
    }

    @Override
    public boolean test() {
        return !FeatureConfig.vanillaOnly;
    }

    public static final IConditionSerializer<VanillaCondition> SERIALIZER = new IConditionSerializer<VanillaCondition>() {
        @Override
        public void write(JsonObject json, VanillaCondition value) {
            // nothing
        }

        @Override
        public VanillaCondition read(JsonObject json) {
            return new VanillaCondition();
        }

        @Override
        public ResourceLocation getID() {
            return KEY;
        }
    };
}
