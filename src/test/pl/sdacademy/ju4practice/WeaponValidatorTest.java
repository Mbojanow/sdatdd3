package pl.sdacademy.ju4practice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WeaponValidatorTest {

  private WeaponValidator weaponValidator;
  private ListMerger listMerger;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() {
    listMerger = new ListMerger();
    weaponValidator = new WeaponValidator(listMerger);
  }

  @Test(/*expected = WeaponValidationFailedException.class*/)
  public void shouldThrowExceptionWhenWeaponDamageInNegative() {
    expectedException.expect(WeaponValidationFailedException.class);
    expectedException.expectMessage("Weapon damage has to be positive");
    final Weapon weapon = Weapon.builder()
        .element(Element.NEUTRAL)
        .damage(-2.0)
        .build();

    weaponValidator.isValid(weapon);
  }

  @Test
  public void shouldThrowExceptionWhenWeaponsElementInOneOfThreeLists() {
    expectedException.expect(WeaponValidationFailedException.class);
    expectedException.expectMessage("Weapon's element is also in one of three lists");
    final Weapon weapon = Weapon.builder()
        .element(Element.NEUTRAL)
        .damage(2.0)
        .strongAgainstElements(Arrays.asList(Element.AIR, Element.ELECTRICITY))
        .weakAgainstElements(Arrays.asList(Element.EARTH, Element.WATER))
        .neutralElements(Collections.singletonList(Element.NEUTRAL))
        .build();

    weaponValidator.isValid(weapon);
  }

  @Test
  public void shouldValidateCorrectWeaponWithoutThrowingAnyException() {
    final Weapon weapon = Weapon.builder()
        .element(Element.NEUTRAL)
        .damage(100.0)
        .strongAgainstElements(Arrays.asList(Element.EARTH, Element.ELECTRICITY))
        .weakAgainstElements(Arrays.asList(Element.WATER, Element.FIRE))
        .neutralElements(Collections.singletonList(Element.AIR))
        .build();

    weaponValidator.isValid(weapon);
  }
}