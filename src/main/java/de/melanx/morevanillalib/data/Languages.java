package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Languages {

    public static class English extends LanguageProvider {
        public English(DataGenerator generator) {
            super(generator, MoreVanillaLib.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("death.attack.paperCut", "%1$s was struck down by paper.");

            // default tool information
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
            add("jei." + MoreVanillaLib.MODID + ".extra_drop.desc", "If you use one of these tools, the corresponding repairing item will be dropped with a chance of %s%.");

            // extra drop information
            add("jei." + MoreVanillaLib.MODID + ".coal_drop.desc", "If you use this pickaxe, there is a %s% chance to get a piece of coal dropped if you mine a coal ore.");
            add("jei." + MoreVanillaLib.MODID + ".emerald_drop.desc", "If you use this pickaxe, there is a %s% chance to get a emerald gem dropped if you mine an emerald ore.");
            add("jei." + MoreVanillaLib.MODID + ".lapis_drop.desc", "If you use this pickaxe, there is a %s% chance to get a lapis gem dropped if you mine a lapis ore.");
            add("jei." + MoreVanillaLib.MODID + ".quartz_drop.desc", "If you use this pickaxe, there is a %s% chance to get a piece of quartz dropped if you mine a nether quartz ore.");
            add("jei." + MoreVanillaLib.MODID + ".redstone_drop.desc", "If you use this pickaxe, there is a %s% chance to get a redstone dust dropped if you mine a redstone ore.");

            // extra damage information
            add("jei." + MoreVanillaLib.MODID + ".bone_damage.desc", "If you kill a (wither) skeleton with these tools, you have a %s% chance to make up to 250% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".ender_damage.desc", "If you kill an enderman with these tools, you have a %s% chance to make up to 250% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".fiery_damage.desc", "If you kill a magma slime with these tools, you have a %s% chance to make up to 250% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".prismarine_damage.desc", "If you kill a (elder) guardian with these tools, you have a %s% chance to make up to 250% more damage.");
            add("jei." + MoreVanillaLib.MODID + ".slime_damage.desc", "If you kill a slime with these tools, you have a %s% chance to make up to 250% more damage.");

            // head drop information
            add("jei." + MoreVanillaLib.MODID + ".bone_heads.desc", "If you kill a (wither) skeleton, there is a %s% chance to get a head dropped.");

            // damage information
            add("jei." + MoreVanillaLib.MODID + ".paper_damage.desc", "If you use these tools, there is a %s% chance to get %s to %s hearts damage.");

            // auto smelt information
            add("jei." + MoreVanillaLib.MODID + ".fiery_smelt.desc", "If you break blocks which can be smelted with these tools, you get the drops as smelted items.");
        }
    }

    public static class German extends LanguageProvider {
        public German(DataGenerator generator) {
            super(generator, MoreVanillaLib.MODID, "de_de");
        }

        @Override
        protected void addTranslations() {
            add("death.attack.paperCut", "%1$s wurde durch Papier niedergestreckt.");
        }
    }

}
