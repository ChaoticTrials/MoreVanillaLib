package de.melanx.morevanillalib;

import de.melanx.morevanillalib.config.ModValueMappers;
import de.melanx.morevanillalib.config.ToolValueConfig;
import de.melanx.morevanillalib.core.crafting.VanillaCondition;
import io.github.noeppi_noeppi.libx.config.ConfigManager;
import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

@Mod("morevanillalib")
public class MoreVanillaLib extends ModXRegistration {

    private static MoreVanillaLib instance;

    public MoreVanillaLib() {
        super("morevanillalib", new ItemGroup("morevanillalib") {
            @Nonnull
            @Override
            public ItemStack createIcon() {
                return new ItemStack(ModContent.obsidianShard);
            }
        });
        instance = this;
        ModValueMappers.registerValueMappers();
        ConfigManager.registerConfig(new ResourceLocation("morevanillalib", "tools"), ToolValueConfig.class, false);

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
}
