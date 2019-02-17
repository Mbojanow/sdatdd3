package pl.sdacademy.ju4practice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListMergerTest {

  private ListMerger listMerger;

  @Before
  public void setUp() {
    listMerger = new ListMerger();
  }

  @Test
  public void shouldMergeThreeListsIntoOne() {
    final List<Element> listA = Arrays.asList(Element.AIR, Element.WATER);
    final List<Element> listB = Arrays.asList(Element.NEUTRAL, Element.ELECTRICITY);
    final List<Element> listC = Arrays.asList(Element.EARTH, Element.FIRE);
    final List<Element> expectedList = Arrays.asList(Element.values());

    final List<Element> actualList = listMerger.merge(listA, listB, listC);

    assertThat(actualList).containsAll(expectedList);
  }
}