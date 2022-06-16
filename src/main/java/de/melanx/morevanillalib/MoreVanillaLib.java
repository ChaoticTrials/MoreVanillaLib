package de.melanx.morevanillalib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;

@Mod("morevanillalib")
public final class MoreVanillaLib extends ModXRegistration {

    private static MoreVanillaLib instance;

    public MoreVanillaLib() {
        instance = this;

        MinecraftForge.EVENT_BUS.register(new EventListener());
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }

    public static MoreVanillaLib getInstance() {
        return instance;
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.build();
    }
}
