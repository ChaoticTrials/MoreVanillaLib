package de.melanx.morevanillalib.config;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

import java.util.Random;

public class Chance {

    private final double chance;
    private final Random random = new Random();

    private Chance(double chance) {
        this.chance = chance;
    }

    public boolean test() {
        return this.test(0);
    }

    public boolean test(RandomSource random) {
        return this.test(random, 0);
    }

    public boolean test(double extraChance) {
        return this.chance > 0 && (this.random.nextDouble() + extraChance) <= this.chance;
    }

    public boolean test(RandomSource random, double extraChance) {
        return this.chance > 0 && (random.nextDouble() + extraChance) <= this.chance;
    }

    public double getChance() {
        return this.chance;
    }

    public boolean enabled() {
        return this.chance > 0;
    }

    public String format() {
        return String.format("%.2f", this.chance * 100);
    }

    public static Chance of(double chance) {
        chance = Mth.clamp(chance, 0, 1);
        return new Chance(chance);
    }
}
