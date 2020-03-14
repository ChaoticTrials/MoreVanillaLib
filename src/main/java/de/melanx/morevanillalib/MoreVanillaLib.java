package de.melanx.morevanillalib;

import de.melanx.morevanillalib.util.AutoSmeltModifier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

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

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventHandlers {

        @SubscribeEvent
        public static void registerModifierSerializiers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
            event.getRegistry().register(new AutoSmeltModifier.Serializer().setRegistryName(new ResourceLocation(MODID, "auto_smelt")));
        }
    }
}
