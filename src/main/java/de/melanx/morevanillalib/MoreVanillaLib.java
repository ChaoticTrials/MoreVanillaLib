package de.melanx.morevanillalib;

import de.melanx.morevanillalib.data.DamageTypesProvider;
import de.melanx.morevanillalib.data.LootModifierProvider;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;

@Mod("morevanillalib")
public final class MoreVanillaLib extends ModXRegistration {

    private static MoreVanillaLib instance;

    public MoreVanillaLib() {
        instance = this;

        MinecraftForge.EVENT_BUS.register(new EventListener());
        DatagenSystem.create(this, system -> {
            system.addRegistryProvider(DamageTypesProvider::new);
            system.addDataProvider(LootModifierProvider::new);
            system.addDataProvider(ModTags::new);
        });
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {
        // NO-OP
    }

    public static MoreVanillaLib getInstance() {
        return instance;
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        // NO-OP
    }
}
