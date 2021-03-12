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

    public static ForgeConfigSpec.DoubleValue extraDropChance;
    public static ForgeConfigSpec.DoubleValue extraDamageChance;
    public static ForgeConfigSpec.DoubleValue headDropChance;
    public static ForgeConfigSpec.DoubleValue damageByPaperToolsChance;

    public static ForgeConfigSpec.DoubleValue diamondDoubleDropChance;
    public static ForgeConfigSpec.DoubleValue coalDoubleDropChance;
    public static ForgeConfigSpec.DoubleValue emeraldDoubleDropChance;
    public static ForgeConfigSpec.DoubleValue lapisDoubleDropChance;
    public static ForgeConfigSpec.DoubleValue quartzDoubleDropChance;
    public static ForgeConfigSpec.DoubleValue redstoneDoubleDropChance;

    public static ForgeConfigSpec.BooleanValue extraDrop;
    public static ForgeConfigSpec.BooleanValue doubleDrop;
    public static ForgeConfigSpec.BooleanValue extraDamage;
    public static ForgeConfigSpec.BooleanValue headDrop;
    public static ForgeConfigSpec.BooleanValue damageByPaperTools;
    public static ForgeConfigSpec.BooleanValue autoSmelt;
    public static ForgeConfigSpec.BooleanValue glowstoneDrops;

    public static ForgeConfigSpec.BooleanValue diamondDoubleDrop;
    public static ForgeConfigSpec.BooleanValue coalDoubleDrop;
    public static ForgeConfigSpec.BooleanValue emeraldDoubleDrop;
    public static ForgeConfigSpec.BooleanValue lapisDoubleDrop;
    public static ForgeConfigSpec.BooleanValue quartzDoubleDrop;
    public static ForgeConfigSpec.BooleanValue redstoneDoubleDrop;

    public static ForgeConfigSpec.IntValue minPaperDamage;
    public static ForgeConfigSpec.IntValue maxPaperDamage;

    public static ForgeConfigSpec.IntValue boneDurability;
    public static ForgeConfigSpec.IntValue coalDurability;
    public static ForgeConfigSpec.IntValue emeraldDurability;
    public static ForgeConfigSpec.IntValue enderDurability;
    public static ForgeConfigSpec.IntValue fieryDurability;
    public static ForgeConfigSpec.IntValue glowstoneDurability;
    public static ForgeConfigSpec.IntValue lapisDurability;
    public static ForgeConfigSpec.IntValue netherDurability;
    public static ForgeConfigSpec.IntValue obsidianDurability;
    public static ForgeConfigSpec.IntValue paperDurability;
    public static ForgeConfigSpec.IntValue prismarineDurability;
    public static ForgeConfigSpec.IntValue quartzDurability;
    public static ForgeConfigSpec.IntValue redstoneDurability;
    public static ForgeConfigSpec.IntValue slimeDurability;
    public static ForgeConfigSpec.IntValue durabilityMulitplier;

    public static ForgeConfigSpec.IntValue woodHarvestlevel;
    public static ForgeConfigSpec.IntValue stoneHarvestlevel;
    public static ForgeConfigSpec.IntValue ironHarvestlevel;
    public static ForgeConfigSpec.IntValue goldHarvestlevel;
    public static ForgeConfigSpec.IntValue diamondHarvestlevel;
    public static ForgeConfigSpec.IntValue netheriteHarvestlevel;
    public static ForgeConfigSpec.IntValue boneHarvestlevel;
    public static ForgeConfigSpec.IntValue coalHarvestlevel;
    public static ForgeConfigSpec.IntValue emeraldHarvestlevel;
    public static ForgeConfigSpec.IntValue enderHarvestlevel;
    public static ForgeConfigSpec.IntValue fieryHarvestlevel;
    public static ForgeConfigSpec.IntValue glowstoneHarvestlevel;
    public static ForgeConfigSpec.IntValue lapisHarvestlevel;
    public static ForgeConfigSpec.IntValue netherHarvestlevel;
    public static ForgeConfigSpec.IntValue obsidianHarvestlevel;
    public static ForgeConfigSpec.IntValue paperHarvestlevel;
    public static ForgeConfigSpec.IntValue prismarineHarvestlevel;
    public static ForgeConfigSpec.IntValue quartzHarvestlevel;
    public static ForgeConfigSpec.IntValue redstoneHarvestlevel;
    public static ForgeConfigSpec.IntValue slimeHarvestlevel;

    public static ForgeConfigSpec.DoubleValue woodMiningSpeed;
    public static ForgeConfigSpec.DoubleValue stoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue ironMiningSpeed;
    public static ForgeConfigSpec.DoubleValue goldMiningSpeed;
    public static ForgeConfigSpec.DoubleValue diamondMiningSpeed;
    public static ForgeConfigSpec.DoubleValue netheriteMiningSpeed;
    public static ForgeConfigSpec.DoubleValue boneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue coalMiningSpeed;
    public static ForgeConfigSpec.DoubleValue emeraldMiningSpeed;
    public static ForgeConfigSpec.DoubleValue enderMiningSpeed;
    public static ForgeConfigSpec.DoubleValue fieryMiningSpeed;
    public static ForgeConfigSpec.DoubleValue glowstoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue lapisMiningSpeed;
    public static ForgeConfigSpec.DoubleValue netherMiningSpeed;
    public static ForgeConfigSpec.DoubleValue obsidianMiningSpeed;
    public static ForgeConfigSpec.DoubleValue paperMiningSpeed;
    public static ForgeConfigSpec.DoubleValue prismarineMiningSpeed;
    public static ForgeConfigSpec.DoubleValue quartzMiningSpeed;
    public static ForgeConfigSpec.DoubleValue redstoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue slimeMiningSpeed;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("features");
        extraDrop = builder.comment("If set true, tools may drop an item when they'll be used.")
                .define("extraDrop", true);
        doubleDrop = builder.comment("If set to true the corresponding ore of the tool drops an additional resource.")
                .define("doubleDrop", true);
        extraDamage = builder.comment("If set true, bone axe and sword make extra damage against special mobs.")
                .define("extraDamage", true);
        headDrop = builder.comment("If set true, (wither) skeletons will drop their head with a defined chance if killed with bone axe or sword.")
                .define("headDrop", true);
        damageByPaperTools = builder.comment("If set to true paper tools may hurt you.")
                .define("damageByPaperTools", true);
        autoSmelt = builder.comment("If set true, using Fiery tools to mine blocks will smelt them.")
                .define("autoSmelt", true);
        glowstoneDrops = builder.comment("If set true, glowstone tools will always drop 4 glowstone dust when breaking glowstone blocks.")
                .define("glowstoneDrops", true);

        builder.push("doubleDropBool");
        diamondDoubleDrop = builder.comment("Diamond available for hammers/excavators").define("diamond", true);
        coalDoubleDrop = builder.define("coal", true);
        emeraldDoubleDrop = builder.define("emerald", true);
        lapisDoubleDrop = builder.define("lapis", true);
        quartzDoubleDrop = builder.define("quartz", true);
        redstoneDoubleDrop = builder.define("redstone", true);
        builder.pop();

        builder.pop();

        builder.push("chances");
        builder.push("extraDropValue");
        extraDropChance = builder.comment("Sets the chance of an extra drop when using a tool. [Default 0.0005 = 0.05%]")
                .defineInRange("extraDrop", 0.0005, 0, 1);
        extraDamageChance = builder.comment("Sets the chance of extra damage when using bone axe or sword on a (wither) skeleton. [Default 0.2 = 20%]")
                .defineInRange("extraDamage", 0.2, 0, 1);
        headDropChance = builder.comment("Sets the chance of an head drop when using bone axe or sword. [Default 0.05 = 5%]")
                .defineInRange("headDrop", 0.05, 0, 1);
        damageByPaperToolsChance = builder.comment("Sets the chance to take an half heart damage if using paper tools. [Default 0.1 = 10%]")
                .defineInRange("damageByPaperTools", 0.1, 0, 1);
        builder.pop();

        builder.push("doubleDropValue").comment("The chance for dropping an additional resource of their corresponding ore. [Default 0.2 = 20%]");
        diamondDoubleDropChance = builder.comment("Default 1 = 0.1%").defineInRange("diamond", 0.001, 0, 1);
        coalDoubleDropChance = builder.defineInRange("coal", 0.2, 0, 1);
        emeraldDoubleDropChance = builder.comment("Default 1 = 0.1%").defineInRange("emerald", 0.001, 0, 1);
        lapisDoubleDropChance = builder.defineInRange("lapis", 0.2, 0, 1);
        quartzDoubleDropChance = builder.defineInRange("quartz", 0.2, 0, 1);
        redstoneDoubleDropChance = builder.defineInRange("redstone", 0.2, 0, 1);
        builder.pop();
        builder.pop();

        builder.push("amounts");
        minPaperDamage = builder.comment("The minimum amount of damage. Default: 1 = 0.5 hearts")
                .defineInRange("minPaperDamage", 1, 0, Integer.MAX_VALUE);
        maxPaperDamage = builder.comment("The maximum amount of damage. Default: 5 = 2.5 hearts")
                .defineInRange("maxPaperDamage", 5, 0, Integer.MAX_VALUE);

        builder.push("harvestlevels").comment("The harvestlevel of the tools (0 = wood; 1 = stone; 2 = iron; 3 = diamond; 4 = netherite, 5-10 = higher)");
        woodHarvestlevel = builder.defineInRange("wood", 0, 0, 10);
        stoneHarvestlevel = builder.defineInRange("stone", 1, 0, 10);
        ironHarvestlevel = builder.defineInRange("iron", 2, 0, 10);
        goldHarvestlevel = builder.defineInRange("gold", 0, 0, 10);
        diamondHarvestlevel = builder.defineInRange("diamond", 3, 0, 10);
        netheriteHarvestlevel = builder.defineInRange("netherite", 4, 0, 10);
        boneHarvestlevel = builder.defineInRange("bone", 0, 0, 10);
        coalHarvestlevel = builder.defineInRange("coal", 0, 0, 10);
        emeraldHarvestlevel = builder.defineInRange("emerald", 3, 0, 10);
        enderHarvestlevel = builder.defineInRange("ender", 2, 0, 10);
        fieryHarvestlevel = builder.defineInRange("fiery", 1, 0, 10);
        glowstoneHarvestlevel = builder.defineInRange("glowstone", 1, 0, 10);
        lapisHarvestlevel = builder.defineInRange("lapis", 2, 0, 10);
        netherHarvestlevel = builder.defineInRange("nether", 1, 0, 10);
        obsidianHarvestlevel = builder.defineInRange("obsidian", 3, 0, 10);
        paperHarvestlevel = builder.defineInRange("paper", 0, 0, 10);
        prismarineHarvestlevel = builder.defineInRange("prismarine", 2, 0, 10);
        quartzHarvestlevel = builder.defineInRange("quartz", 1, 0, 10);
        redstoneHarvestlevel = builder.defineInRange("redstone", 2, 0, 10);
        slimeHarvestlevel = builder.defineInRange("slime", 1, 0, 10);
        builder.pop();

        builder.push("durabilities").comment("The durability of the tools");
        boneDurability = builder.defineInRange("bone", 176, 1, Integer.MAX_VALUE);
        coalDurability = builder.defineInRange("coal", 145, 1, Integer.MAX_VALUE);
        emeraldDurability = builder.defineInRange("emerald", 1859, 1, Integer.MAX_VALUE);
        enderDurability = builder.defineInRange("ender", 666, 1, Integer.MAX_VALUE);
        fieryDurability = builder.defineInRange("fiery", 127, 1, Integer.MAX_VALUE);
        glowstoneDurability = builder.defineInRange("glowstone", 123, 1, Integer.MAX_VALUE);
        lapisDurability = builder.defineInRange("lapis", 173, 1, Integer.MAX_VALUE);
        netherDurability = builder.defineInRange("nether", 188, 1, Integer.MAX_VALUE);
        obsidianDurability = builder.defineInRange("obsidian", 1337, 1, Integer.MAX_VALUE);
        paperDurability = builder.defineInRange("paper", 13, 1, Integer.MAX_VALUE);
        prismarineDurability = builder.defineInRange("prismarine", 225, 1, Integer.MAX_VALUE);
        quartzDurability = builder.defineInRange("quartz", 117, 1, Integer.MAX_VALUE);
        redstoneDurability = builder.defineInRange("redstone", 173, 1, Integer.MAX_VALUE);
        slimeDurability = builder.defineInRange("slime", 123, 1, Integer.MAX_VALUE);
        durabilityMulitplier = builder.comment("The multiplier for Hammers and Excavators")
                .defineInRange("multiplier", 7, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.push("miningspeed").comment("The mining speed of the tools. Will be devided by 3.5 for hammers/excavators.");
        woodMiningSpeed = builder.defineInRange("wood", 2.0, 0, Integer.MAX_VALUE);
        stoneMiningSpeed = builder.defineInRange("stone", 4.0, 0, Integer.MAX_VALUE);
        ironMiningSpeed = builder.defineInRange("iron", 6.0, 0, Integer.MAX_VALUE);
        goldMiningSpeed = builder.defineInRange("gold", 12.0, 0, Integer.MAX_VALUE);
        diamondMiningSpeed = builder.defineInRange("diamond", 8.0, 0, Integer.MAX_VALUE);
        netheriteMiningSpeed = builder.defineInRange("netherite", 9.0, 0, Integer.MAX_VALUE);
        boneMiningSpeed = builder.defineInRange("bone", 3.9, 0, Integer.MAX_VALUE);
        coalMiningSpeed = builder.defineInRange("coal", 3.9, 0, Integer.MAX_VALUE);
        emeraldMiningSpeed = builder.defineInRange("emerald", 8.2, 0, Integer.MAX_VALUE);
        enderMiningSpeed = builder.defineInRange("ender", 3.7, 0, Integer.MAX_VALUE);
        fieryMiningSpeed = builder.defineInRange("fiery", 4.0, 0, Integer.MAX_VALUE);
        glowstoneMiningSpeed = builder.defineInRange("glowstone", 3.0, 0, Integer.MAX_VALUE);
        lapisMiningSpeed = builder.defineInRange("lapis", 6.2, 0, Integer.MAX_VALUE);
        netherMiningSpeed = builder.defineInRange("nether", 3.9, 0, Integer.MAX_VALUE);
        obsidianMiningSpeed = builder.defineInRange("obsidian", 4.7, 0, Integer.MAX_VALUE);
        paperMiningSpeed = builder.defineInRange("paper", 1.8, 0, Integer.MAX_VALUE);
        prismarineMiningSpeed = builder.defineInRange("prismarine", 6.0, 0, Integer.MAX_VALUE);
        quartzMiningSpeed = builder.defineInRange("quartz", 3.9, 0, Integer.MAX_VALUE);
        redstoneMiningSpeed = builder.defineInRange("redstone", 6.2, 0, Integer.MAX_VALUE);
        slimeMiningSpeed = builder.defineInRange("slime", 5.2, 0, Integer.MAX_VALUE);
        builder.pop();

        builder.pop();

    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreVanillaLib.LOGGER.debug("Loading config file {}", path);
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }
}
