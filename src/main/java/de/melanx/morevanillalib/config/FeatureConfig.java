package de.melanx.morevanillalib.config;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;
import org.moddingx.libx.config.validate.DoubleRange;
import org.moddingx.libx.config.validate.FloatRange;

@RegisterConfig(value = "features")
public class FeatureConfig {

    @Config("Should fiery tools automatically smelt blocks while mining?")
    public static boolean autoSmelt = true;

    @Config("Should glowstone tools always drop 4 glowstone dust when breaking glowstone blocks? (excluded by silk touch)")
    public static boolean glowstoneDrops = true;

    @Config("The chance for tools to drop corresponding materials when being used")
    public static Chance extraDrop = Chance.of(0.0005);

    @Config("The chance for (wither) skeletons to drop their head if killed with bone axe or sword")
    public static Chance headDrop = Chance.of(0.05);

    @Group
    public static class ExtraDamage {

        @Config({"The chance for some tools to deal extra damage against some mobs",
                "Bone tools -> (Wither) Skeletons",
                "Ender tools -> Enderman and Endermite",
                "Fiery tools -> Magma Cubes",
                "Prismarine tools -> Guardians",
                "Slime tools -> Slime Cubes"})
        public static Chance chance = Chance.of(0.2);

        @Config("Value to multiply with dealt damage.")
        @DoubleRange(min = 0, max = 10.0)
        public static double maxMultiplier = 2.5;
    }

    @Group
    public static class PaperDamage {

        @Config("Should paper tools hurt you when using? (Chance: 0 = 0%, 1 = 100%)")
        public static Chance chance = Chance.of(0.1);

        @Config("Minimum damage amount. 1 = 0.5 hearts")
        @FloatRange(min = 0)
        public static float minDamage = 0.5F;

        @Config("Maximum damage amount. 5 = 2.5 hearts")
        @FloatRange(min = 0)
        public static float maxDamage = 2.5F;
    }

    @Group({"Should ores drop more materials when mined with corresponding tool?",
            "This is to disable all values. If enabled, you can toggle each resource at you wish.",
            "Example: Coal Ore mined with Coal Pickaxe drops more than 1 coal."})
    public static class DoubleDrop {

        @Config
        public static boolean enabledAll = true;

        @Config
        public static Chance diamond = Chance.of(0.001);

        @Config
        public static Chance coal = Chance.of(0.2);

        @Config
        public static Chance emerald = Chance.of(0.001);

        @Config
        public static Chance lapis = Chance.of(0.2);

        @Config
        public static Chance quartz = Chance.of(0.2);

        @Config
        public static Chance redstone = Chance.of(0.2);
    }
}
