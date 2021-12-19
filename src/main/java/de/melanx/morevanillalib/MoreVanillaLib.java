package de.melanx.morevanillalib;

import de.melanx.morevanillalib.core.crafting.VanillaCondition;
import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import io.github.noeppi_noeppi.libx.mod.registration.RegistrationBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

@Mod("morevanillalib")
public final class MoreVanillaLib extends ModXRegistration {

    private static MoreVanillaLib instance;

    public MoreVanillaLib() {
        super(new CreativeModeTab("morevanillalib") {
            @Nonnull
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ModContent.obsidianShard);
            }
        });
        instance = this;

        MinecraftForge.EVENT_BUS.register(new EventListener());
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        CraftingHelper.register(VanillaCondition.SERIALIZER);
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }

    public static MoreVanillaLib getInstance() {
        return instance;
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.setVersion(1);
    }
}
