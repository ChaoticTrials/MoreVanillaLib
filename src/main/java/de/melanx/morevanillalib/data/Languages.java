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
