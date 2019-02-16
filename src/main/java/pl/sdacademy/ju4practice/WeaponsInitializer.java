package pl.sdacademy.ju4practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WeaponsInitializer {

    private Set<Weapon> gameWeapons;

    public void initialize() {
        gameWeapons = new HashSet<>();
        gameWeapons.add(Weapon.builder()
                .code("AK47")
                .damage(88D)
                .name("Kalashnikov")
                .element(Element.NEUTRAL)
                .shortsPerSecond(3)
                .version(47L)
                .strongAgainstElements(Arrays.asList(Element.WATER, Element.NEUTRAL))
                .weakAgainstElements(Collections.singletonList(Element.AIR))
                .neutralElements(Arrays.asList(Element.FIRE, Element.EARTH, Element.ELECTICITY))
                .build());

        gameWeapons.add(Weapon.builder()
                .code("LG")
                .damage(7.5D)
                .name("Lighting Gun")
                .element(Element.ELECTICITY)
                .shortsPerSecond(100)
                .version(1L)
                .strongAgainstElements(Arrays.asList(Element.WATER, Element.NEUTRAL))
                .weakAgainstElements(Arrays.asList(Element.AIR, Element.FIRE, Element.EARTH))
                .build());
    }
}
