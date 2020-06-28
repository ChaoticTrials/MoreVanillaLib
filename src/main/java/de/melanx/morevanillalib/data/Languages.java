package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Languages {

    public static class English extends LanguageProvider {
        public English(DataGenerator generator) {
            super(generator, MoreVanillaLib.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup." + MoreVanillaLib.MODID, "MoreVanillaLib");
            add("death.attack.paperCut", "%1$s was cut to death with paper");
            add("enchantment." + MoreVanillaLib.MODID + ".repairing_luck", "Luck of Cheap Repairing");
            add("enchantment." + MoreVanillaLib.MODID + ".repairing_luck.desc", "Reduces the repair costs in the anvil to a minimum.");

            // items
            add(Registration.clean_endstone.get(), "Clean Endstone");
            add(Registration.obsidian_shard.get(), "Obsidian Shard");
            add(Registration.paper_bundle.get(), "Bundle of Paper");

            // default tool information
            add("jei." + MoreVanillaLib.MODID + ".wood_tools.desc", "Wood Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".stone_tools.desc", "Stone Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".iron_tools.desc", "Iron Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".gold_tools.desc", "Gold Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".diamond_tools.desc", "Diamond Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".netherite_tools.desc", "Netherite Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");

            add("jei." + MoreVanillaLib.MODID + ".bone_tools.desc", "Bone Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".coal_tools.desc", "Coal Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".emerald_tools.desc", "Emerald Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".ender_tools.desc", "Ender Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".fiery_tools.desc", "Fiery Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".glowstone_tools.desc", "Glowstone Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".lapis_tools.desc", "Lapis Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".nether_tools.desc", "Nether Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".obsidian_tools.desc", "Obsidian Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".paper_tools.desc", "Paper Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".prismarine_tools.desc", "Prismarine Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".quartz_tools.desc", "Quartz Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".redstone_tools.desc", "Redstone Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".slime_tools.desc", "Slime Tools\nDurability: %s (Hammer/Excavator: %s)\nHarvest Level: %s\nRepairing Item: %s");
            add("jei." + MoreVanillaLib.MODID + ".extra_drop.desc", "If you use one of these tools, the corresponding repairing item will be dropped with a chance of %d%%.");

            // double drop information
            add("jei." + MoreVanillaLib.MODID + ".diamond_double_drop.desc", "If you use this tool, there is a %d%% chance to get a diamond dropped if you mine a diamond ore.");
            add("jei." + MoreVanillaLib.MODID + ".coal_double_drop.desc", "If you use this tool, there is a %d%% chance to get a piece of coal dropped if you mine a coal ore.");
            add("jei." + MoreVanillaLib.MODID + ".emerald_double_drop.desc", "If you use this tool, there is a %d%% chance to get an emerald gem dropped if you mine an emerald ore.");
            add("jei." + MoreVanillaLib.MODID + ".lapis_double_drop.desc", "If you use this tool, there is a %d%% chance to get up to 3 lapis gem dropped if you mine a lapis ore.");
            add("jei." + MoreVanillaLib.MODID + ".quartz_double_drop.desc", "If you use this tool, there is a %d%% chance to get a piece of quartz dropped if you mine a nether quartz ore.");
            add("jei." + MoreVanillaLib.MODID + ".redstone_double_drop.desc", "If you use this tool, there is a %d%% chance to get up to 3 redstone dust dropped if you mine a redstone ore.");

            // extra damage information
            add("jei." + MoreVanillaLib.MODID + ".bone_damage.desc", "If you kill a (wither) skeleton with these tools, you have a %d%% chance to make up to 250%% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".ender_damage.desc", "If you kill an enderman with these tools, you have a %d%% chance to make up to 250%% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".fiery_damage.desc", "If you kill a magma slime with these tools, you have a %d%% chance to make up to 250%% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".prismarine_damage.desc", "If you kill a (elder) guardian with these tools, you have a %d%% chance to make up to 250%% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".slime_damage.desc", "If you kill a slime with these tools, you have a %d%% chance to make up to 250%% more damage.");

            // head drop information
            add("jei." + MoreVanillaLib.MODID + ".bone_heads.desc", "If you kill a (wither) skeleton, there is a %d%% chance to get a head dropped.");

            // damage information
            add("jei." + MoreVanillaLib.MODID + ".paper_damage.desc", "If you use these tools, there is a %d%% chance to get %d to %d hearts damage.");

            // auto smelt information
            add("jei." + MoreVanillaLib.MODID + ".fiery_smelt.desc", "If you break blocks which can be smelted with these tools, you get the drops as smelted items.");
            add("jei." + MoreVanillaLib.MODID + ".glowstone_drops.desc", "If you break glowstone with these tools, you always get 4 glowstone dust.");
        }
    }

    public static class German extends LanguageProvider {
        public German(DataGenerator generator) {
            super(generator, MoreVanillaLib.MODID, "de_de");
        }

        @Override
        protected void addTranslations() {
            add("death.attack.paperCut", "%1$s wurde durch Papier niedergestreckt.");
            add("enchantment." + MoreVanillaLib.MODID + ".repairing_luck", "Gl\u00FCck der billigen Reparatur");
            add("enchantment." + MoreVanillaLib.MODID + ".repairing_luck.desc", "Verringert die Reperaturkosten im Amboss auf ein Minimum.");

            // items
            add(Registration.clean_endstone.get(), "Reiner Endstein");
            add(Registration.obsidian_shard.get(), "Obsidianscherbe");
            add(Registration.paper_bundle.get(), "Papierb\u00FCndel");

            // default tool information
            add("jei." + MoreVanillaLib.MODID + ".wood_tools.desc", "Holzwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".stone_tools.desc", "Steinwerkezuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".iron_tools.desc", "Eisenwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".gold_tools.desc", "Goldwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".diamond_tools.desc", "Diamantwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".netherite_tools.desc", "Netheritwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");

            add("jei." + MoreVanillaLib.MODID + ".bone_tools.desc", "Knochenwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".coal_tools.desc", "Kohlewerkezuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".emerald_tools.desc", "Smaragdwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".ender_tools.desc", "Enderwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".fiery_tools.desc", "Feuerwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".glowstone_tools.desc", "Glowstonewerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".lapis_tools.desc", "Lapiswerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".nether_tools.desc", "Netherwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".obsidian_tools.desc", "Obsidianwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".paper_tools.desc", "Papierwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".prismarine_tools.desc", "Prismarinwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".quartz_tools.desc", "Quartzwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".redstone_tools.desc", "Redstonewerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".slime_tools.desc", "Schleimwerkzeuge\nHaltbarkeit: %s (Hammer/Ausgraber: %s)\nAbbaulevel: %s\nReparaturitem: %s");
            add("jei." + MoreVanillaLib.MODID + ".extra_drop.desc", "Wenn du eins dieser Werkzeuge benutzt, wird zu einer %d%%igen Chance ein Reparaturitem fallengelassen.");

            // extra drop information
            add("jei." + MoreVanillaLib.MODID + ".diamond_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst zu zu einer %d%%igen Chance einen Diamanten extra, wenn du Diamanterz abbaust.");
            add("jei." + MoreVanillaLib.MODID + ".coal_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst du zu einer %d%%igen Chance ein St\u00FCck Kohle extra, wenn du Kohleerz abbaust.");
            add("jei." + MoreVanillaLib.MODID + ".emerald_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst du zu einer %d%%igen Chance einen Smaragd extra, wenn du Smaragderz abbaust.");
            add("jei." + MoreVanillaLib.MODID + ".lapis_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst du zu einer %d%%igen Chance bis zu 3 St\u00FCck Lapis extra, wenn du Lapiserz abbaust.");
            add("jei." + MoreVanillaLib.MODID + ".quartz_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst du zu einer %d%%igen Chance ein St\u00FCck Netherquartz extra, wenn du Netherquartzerz abbaust.");
            add("jei." + MoreVanillaLib.MODID + ".redstone_double_drop.desc", "Wenn du dieses Werkzeug benutzt, bekommst du zu einer %d%%igen Chance bis zu 3 St\u00FCck Redstonestaub extra, wenn du Redstoneerz abbaust.");

            // extra damage information
            add("jei." + MoreVanillaLib.MODID + ".bone_damage.desc", "Wenn du ein (Wither-)Skelett mit einem dieser Werkzeuge t\u00F6test, machst du zu einer %d%%igen Chance bis zu 250%% mehr Schaden.");
            add("jei." + MoreVanillaLib.MODID + ".ender_damage.desc", "Wenn du einen Enderman mit einem dieser Werkzeuge t\u00F6test, machst du zu einer %d%%igen Chance bis zu 250%% mehr Schaden.");
            add("jei." + MoreVanillaLib.MODID + ".fiery_damage.desc", "Wenn du einen Magmaschleim mit einem dieser Werkzeuge t\u00F6test, machst du zu einer %d%%igen Chance bis zu 250%% mehr Schaden.");
            add("jei." + MoreVanillaLib.MODID + ".prismarine_damage.desc", "Wenn du einen (Gro\u00DFen) W\u00FCchter mit einem dieser Werkzeuge t\u00F6test, machst du zu einer %d%%igen Chance bis zu 250%% mehr Schaden.");
            add("jei." + MoreVanillaLib.MODID + ".slime_damage.desc", "Wenn du einen Schleim mit einem dieser Werkzeuge t\u00F6test, machst du zu einer %d%%igen Chance bis zu 250%% mehr Schaden.");

            // head drop information
            add("jei." + MoreVanillaLib.MODID + ".bone_heads.desc", "Wenn du ein (Wither-)Skelett mit einem dieser Werkzeuge t\u00F6test, hast du eien %d%%ige Chance, einen Kopf zu bekommen.");

            // damage information
            add("jei." + MoreVanillaLib.MODID + ".paper_damage.desc", "Wenn du diese Werkzeuge benutzt, besteht eine %d%%ige Chance, dass du %d bis %d Herzen Schaden bekommst.");

            // auto smelt information
            add("jei." + MoreVanillaLib.MODID + ".fiery_smelt.desc", "Wenn du mit einem dieser Werkzeuge einen Block abbaust, werden die fallengelassenen Items direkt geschmolzen.");
            add("jei." + MoreVanillaLib.MODID + ".glowstone_drops.desc", "Wenn du mit einem dieser Werkzeuge Glowstone abbaust, werden immer 4 Glowstonestaub fallengelassen.");
        }
    }

}
