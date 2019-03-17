package pl.sdacademy.ju4practice;

import static java.util.Objects.isNull;

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
        validateBaseDamage(weapon);
        validateName(weapon);
        validateArmorTypes(weapon);
        return true;
    }

    private void validateBaseDamage(final Weapon weapon) {
        if (isNull(weapon.getBaseDamage())) {
            throw new InvalidWeaponException("Weapon base damage should not be null");
        }

        if (weapon.getBaseDamage() < 0) {
            throw new InvalidWeaponException("Base damage should be positive");
        }
    }

    private void validateName(final Weapon weapon) {
        if (weapon.getName().isEmpty() || weapon.getName().length() < 3) {
            throw new
                InvalidWeaponException("Weapon name should be longer than 3 chars");
        }
    }

    private List<ArmorType> getListOfAllArmorTypesInWeapon(final Weapon weapon) {
        final List<ArmorType> listOfAllArmorTypesInWeapon = new ArrayList<>();
        listOfAllArmorTypesInWeapon.addAll(weapon.getGoodAgainst());
        listOfAllArmorTypesInWeapon.addAll(weapon.getBadAgainst());
        listOfAllArmorTypesInWeapon.addAll(weapon.getNeutralAgainst());
        return listOfAllArmorTypesInWeapon;
    }

    private List<ArmorType> getAllArmorTypesList() {
        return Arrays.asList(ArmorType.values());
    }

    private void validateArmorTypes(final Weapon weapon) {
        final List<ArmorType> listOfAllArmorTypesInWeapon = getListOfAllArmorTypesInWeapon(weapon);
        final List<ArmorType> expectedArmorType = getAllArmorTypesList();

        final boolean allArmorTypesCorrect = listOfAllArmorTypesInWeapon.containsAll(expectedArmorType);

        if (!allArmorTypesCorrect) {
            throw new InvalidWeaponException("Armor type missing");
        }

        if (listOfAllArmorTypesInWeapon.size() != expectedArmorType.size()) {
            throw new InvalidWeaponException("Armor type duplicated");
        }
    }
}
