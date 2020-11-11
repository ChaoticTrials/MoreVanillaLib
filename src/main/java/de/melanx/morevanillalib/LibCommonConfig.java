package de.melanx.morevanillalib;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class LibCommonConfig {

    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(SERVER_BUILDER);
        COMMON_CONFIG = SERVER_BUILDER.build();
    }

    public static ForgeConfigSpec.BooleanValue vanilla;

    private static void init(ForgeConfigSpec.Builder builder) {
        vanilla = builder.comment("If set true, only hammers and excavators corresponding to the vanilla tool materials will be added.")
                .define("vanillaOnly", false);
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreVanillaLib.LOGGER.debug("Loading config file {}", path);
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}
