package pl.sdacademy.ju4practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponValidatorTest {

  // damage, jest nieujmeny
  // name jest niepusta, dluzsza niz 3 znaki
  // baseDamage nie jest nullem
  // wszystkie 4 typy ArmorType są w którejs z 3 list
  // żaden z nich nie jest zduplikowany
  // każdu jest użyty tylko raz

  private WeaponValidator weaponValidator;
  private Weapon weapon;

  @BeforeEach
  void setUp() {
    weaponValidator = new WeaponValidator();
    weapon = createCorrectWeapon();
  }

  @Test
  void shouldValidateCorrectWeapon() {
    final boolean isValid = weaponValidator.isValid(weapon);

    assertThat(isValid).isTrue();
  }

  @Test
  void shouldThrowExceptionWhenDamageIsNegative() {
    weapon.setBaseDamage(-2);

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage()).isEqualTo("Base damage should be positive");
  }

  @Test
  void shouldThrowWhenNameLessThatThreeChars() {
    weapon.setName("as");

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage())
        .isEqualTo("Weapon name should be longer than 3 chars");
  }

  @Test
  void shouldThrowWhenBaseDamageIsNull() {
    weapon.setBaseDamage(null);

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage())
        .isEqualTo("Weapon base damage should not be null");
  }

  @Test
  void shouldThrowWhenArmorTypeMissing() {
    weapon.setBadAgainst(new ArrayList<>());

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage())
        .isEqualTo("Armor type missing");
  }

  @Test
  void shouldThrowWhenArmorTypeDuplicatedInList() {
    final List<ArmorType> armorTypes = new ArrayList<>();
    armorTypes.add(ArmorType.GOLD);
    armorTypes.add(ArmorType.GOLD);
    weapon.setBadAgainst(armorTypes);

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage())
        .isEqualTo("Armor type duplicated");
  }

  @Test
  void shouldThrowWhenArmorTypeDuplicatedInSeparateLists() {
    final List<ArmorType> armorTypes = new ArrayList<>();
    armorTypes.add(ArmorType.GOLD);
    armorTypes.add(ArmorType.BLUE);
    weapon.setBadAgainst(armorTypes);

    final Throwable exp = assertInvalidWeaponExceptionThrownDuringValidation();

    assertThat(exp.getMessage())
        .isEqualTo("Armor type duplicated");
  }

  private Throwable assertInvalidWeaponExceptionThrownDuringValidation() {
    return assertThrows(InvalidWeaponException.class,
        () -> weaponValidator.isValid(weapon));
  }

  private Weapon createCorrectWeapon() {
    weapon = new Weapon();
    weapon.setBaseDamage(12);
    weapon.setName("Spitfire");
    weapon.setAmmoType(AmmoType.HEAVY);

    final List<ArmorType> badAgainst = new ArrayList<>();
    badAgainst.add(ArmorType.GOLD);
    weapon.setBadAgainst(badAgainst);

    final List<ArmorType> goodAgainst = new ArrayList<>();
    goodAgainst.add(ArmorType.WHITE);
    weapon.setGoodAgainst(goodAgainst);

    final List<ArmorType> neutralAgainst = new ArrayList<>();
    neutralAgainst.add(ArmorType.PURPLE);
    neutralAgainst.add(ArmorType.BLUE);
    weapon.setNeutralAgainst(neutralAgainst);

    return weapon;
  }
}