package de.melanx.morevanillalib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreVanillaLib.MODID)
public class MoreVanillaLib {

    public static final String MODID = "morevanillalib";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static MoreVanillaLib instance;

    public MoreVanillaLib() {
        instance = this;
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, LibConfigHandler.SERVER_CONFIG);
        LibConfigHandler.loadConfig(LibConfigHandler.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-server.toml"));
        MinecraftForge.EVENT_BUS.register(this);
    }
}
