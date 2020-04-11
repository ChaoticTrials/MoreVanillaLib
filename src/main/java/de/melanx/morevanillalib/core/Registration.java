package de.melanx.morevanillalib.core;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoreVanillaLib.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreVanillaLib.MODID);

    public static final Block.Properties blockProps = Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0F, 11.0F);
    public static final Item.Properties itemProps = new Item.Properties().group(MoreVanillaLib.modGroup);

    public static final RegistryObject<Block> clean_endstone = BLOCKS.register("clean_end_stone", () -> new Block(blockProps));
    public static final RegistryObject<Item> clean_endstone_item = ITEMS.register("clean_end_stone", () -> new BlockItem(clean_endstone.get(), itemProps));
    public static final RegistryObject<Item> obsidian_shard = ITEMS.register("obsidian_shard", () -> new Item(itemProps));
    public static final RegistryObject<Item> paper_bundle = ITEMS.register("paper_bundle", () -> new Item(itemProps));

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        MoreVanillaLib.LOGGER.debug("Items registered.");
        BLOCKS.register(bus);
        MoreVanillaLib.LOGGER.debug("Blocks registered.");
    }
}
