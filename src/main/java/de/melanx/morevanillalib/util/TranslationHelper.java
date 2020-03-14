package de.melanx.morevanillalib.util;

public class TranslationHelper {

    public static String getGermanMaterial(String path) {
        String material = path.split("_")[0];
        switch (material) {
            case "bone":
                return "Knochen";
            case "coal":
                return "Kohle";
            case "emerald":
                return "Smaragd";
            case "ender":
                return "Ender";
            case "fiery":
                return "Feuer";
            case "glowstone":
                return "Glowstone";
            case "lapis":
                return "Lapis";
            case "nether":
                return "Nether";
            case "obsidian":
                return "Obsidian";
            case "paper":
                return "Papier";
            case "prismarine":
                return "Prismarin";
            case "quartz":
                return "Netherquartz";
            case "redstone":
                return "Redstone";
            case "slime":
                return "Schleim";
            default:
                return null;
        }
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

}
