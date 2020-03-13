package de.melanx.morevanillalib;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class LibConfigHandler {

    public static final ForgeConfigSpec SERVER_CONFIG;
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(SERVER_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    public static ForgeConfigSpec.IntValue extraDropChance;
    public static ForgeConfigSpec.IntValue extraDamageChance;
    public static ForgeConfigSpec.IntValue headDropChance;
    public static ForgeConfigSpec.IntValue damageByPaperToolsChance;

    public static ForgeConfigSpec.IntValue coalDoubleDropChance;
    public static ForgeConfigSpec.IntValue emeraldDoubleDropChance;
    public static ForgeConfigSpec.IntValue lapisDoubleDropChance;
    public static ForgeConfigSpec.IntValue quartzDoubleDropChance;
    public static ForgeConfigSpec.IntValue redstoneDoubleDropChance;

    public static ForgeConfigSpec.BooleanValue extraDrop;
    public static ForgeConfigSpec.BooleanValue extraDamage;
    public static ForgeConfigSpec.BooleanValue headDrop;
    public static ForgeConfigSpec.BooleanValue damageByPaperTools;

    public static ForgeConfigSpec.BooleanValue coalDoubleDrop;
    public static ForgeConfigSpec.BooleanValue emeraldDoubleDrop;
    public static ForgeConfigSpec.BooleanValue lapisDoubleDrop;
    public static ForgeConfigSpec.BooleanValue quartzDoubleDrop;
    public static ForgeConfigSpec.BooleanValue redstoneDoubleDrop;

    public static ForgeConfigSpec.IntValue minPaperDamage;
    public static ForgeConfigSpec.IntValue maxPaperDamage;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("features");
        extraDrop = builder.comment("If set true, tools may drop an item when they'll be used.")
                .define("features.extraDrop", true);
        extraDamage = builder.comment("If set true, bone axe and sword make extra damage against skeletons.")
                .define("features.extraDamage", true);
        headDrop = builder.comment("If set true, (wither) skeletons will drop their head with a defined chance if killed with bone axe or sword.")
                .define("features.headDrop", true);
        damageByPaperTools = builder.comment("If set to true paper tools may hurt you.")
                .define("features.damageByPaperTools", true);
        builder.pop();

        builder.push("features.extraDrop").comment("If set to true the corresponding ore  of the tool drops an additional resource.");
        coalDoubleDrop = builder.define("features.extraDrop.coal", true);
        emeraldDoubleDrop = builder.define("features.extraDrop.emerald", true);
        lapisDoubleDrop = builder.define("features.extraDrop.lapis", true);
        quartzDoubleDrop = builder.define("features.extraDrop.quartz", true);
        redstoneDoubleDrop = builder.define("features.extraDrop.redstone", true);
        builder.pop();

        builder.push("features.chances");
        extraDropChance = builder.comment("Sets the chance of an extra drop when using a tool. [Default 5 = 0.5%]")
                .defineInRange("features.chances.extraDrop", 5, 0, 1000);
        extraDamageChance = builder.comment("Sets the chance of extra damage when using bone axe or sword on a (wither) skeleton. [Default 200 = 20%]")
                .defineInRange("features.chances.extraDamage", 200, 0, 1000);
        headDropChance = builder.comment("Sets the chance of an head drop when using bone axe or sword. [Default 50 = 5%]")
                .defineInRange("features.chances.headDrop", 50, 0, 1000);
        damageByPaperToolsChance = builder.comment("Sets the chance to take an half heart damage if using paper tools. [Default 100 = 10%]")
                .defineInRange("features.chances.damageByPaperTools", 100, 0, Integer.MAX_VALUE);
        builder.pop();

        builder.push("features.chances.extraDrops").comment("The chance for dropping an additional resource of their corresponding ore. [Default 500 = 50%]");
        coalDoubleDropChance = builder.defineInRange("features.chances.extraDrops.coal", 500, 0, 1000);
        emeraldDoubleDropChance = builder.comment("Default 1 = 0.1%").defineInRange("features.chances.extraDrops.emerald", 1, 0, 1000);
        lapisDoubleDropChance = builder.defineInRange("features.chances.extraDrops.lapis", 500, 0, 1000);
        quartzDoubleDropChance = builder.defineInRange("features.chances.extraDrops.quartz", 500, 0, 1000);
        redstoneDoubleDropChance = builder.defineInRange("features.chances.extraDrops.redstone", 500, 0, 1000);
        builder.pop();

        builder.push("amounts");
        minPaperDamage = builder.comment("The minimum amount of damage. Default: 1 = 0.5 hearts")
                .defineInRange("minPaperDamage", 1, 0, Integer.MAX_VALUE);
        maxPaperDamage = builder.comment("The maximum amount of damage. Default: 5 = 2.5 hearts")
                .defineInRange("maxPaperDamage", 5, 0, Integer.MAX_VALUE);
        builder.pop();

    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreVanillaLib.LOGGER.debug("Loading config file {}", path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }

}
