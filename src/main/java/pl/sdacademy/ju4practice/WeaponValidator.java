package pl.sdacademy.ju4practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponValidator {

    // damage, jest nieujmeny
    // name jest niepusta, dluzsza niz 3 znaki
    // baseDamage nie jest nullem
    // wszystkie 4 typy ArmorType są w którejsc z 3 list
    // żaden z nich nie jest zduplikowany
    // każdu jest użyty tylko raz

    public boolean isValid(final Weapon weapon) {

        if (weapon.getBaseDamage() == null) {
            throw new InvalidWeaponException("Weapon base damage should not be null");
        }

        if (weapon.getBaseDamage() < 0) {
            throw new InvalidWeaponException("Base damage should be positive");
        }

        if (weapon.getName().isEmpty() || weapon.getName().length() < 3) {
            throw new
                InvalidWeaponException("Weapon name should be longer than 3 chars");
        }

        final List<ArmorType> listOfAllArmorTypesInWeapon = new ArrayList<>();
        listOfAllArmorTypesInWeapon.addAll(weapon.getGoodAgainst());
        listOfAllArmorTypesInWeapon.addAll(weapon.getBadAgainst());
        listOfAllArmorTypesInWeapon.addAll(weapon.getNeutralAgainst());

        final List<ArmorType> expectedArmorType = Arrays.asList(ArmorType.values());

        final boolean allArmorTypesCorrect = expectedArmorType.stream()
            .allMatch(type -> listOfAllArmorTypesInWeapon.contains(type));

        if (!allArmorTypesCorrect) {
            throw new InvalidWeaponException("Armor type missing");
        }

        if (listOfAllArmorTypesInWeapon.size() != expectedArmorType.size()) {
            throw new InvalidWeaponException("Armor type duplicated");
        }

        return true;
    }
}
