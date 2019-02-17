package pl.sdacademy.ju4practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeaponValidator {

  private ListMerger listMerger;

  public WeaponValidator(final ListMerger listMerger) {
    this.listMerger = listMerger;
  }

  public void isValid(final Weapon weapon) {

    if (weapon.getDamage() <= 0.0) {
      throw new WeaponValidationFailedException("Weapon damage has to be positive");
    }

    final Element element = weapon.getElement();
    if (weapon.getNeutralElements().contains(element)
        || weapon.getStrongAgainstElements().contains(element)
        || weapon.getWeakAgainstElements().contains(element)) {
      throw new WeaponValidationFailedException("Weapon's element is also in one of three lists");
    }

    final List<Element> checkedElements = listMerger.merge(weapon.getStrongAgainstElements(),
        weapon.getWeakAgainstElements(), weapon.getNeutralElements());

//    final List<Element> checkedElements = new ArrayList<>();
//
//    weapon.getNeutralElements().forEach(el -> checkedElements.add(el));
//    weapon.getWeakAgainstElements().forEach(el -> checkedElements.add(el));
//    weapon.getStrongAgainstElements().forEach(el -> checkedElements.add(el));

    final List<Element> allElements = Arrays.asList(Element.values());

//    for (int index = 0; index < allElements.size(); index++) {
//      allElements.get(index);
//    }
//
//    for (final Element el : allElements) {
//      el
//    }

    for (final Element el : allElements) {
      if (el != element && !checkedElements.contains(el)) {
        throw new WeaponValidationFailedException("Unexpected element");
      }
    }

    final Set<Element> uniqueElements = new HashSet<>(checkedElements);
    if (uniqueElements.size() != checkedElements.size()) {
      throw new WeaponValidationFailedException("Unexpected element found");
    }
  }
}
