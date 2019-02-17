package pl.sdacademy.ju4practice;

import java.util.ArrayList;
import java.util.List;

public class ListMerger {

  List<Element> merge(final List<Element> elementList1,
                      final List<Element> elementList2,
                      final List<Element> elementList3) {
    final List<Element> mergedElements = new ArrayList<>();
    mergedElements.addAll(elementList1);
    mergedElements.addAll(elementList2);
    mergedElements.addAll(elementList3);
    return mergedElements;
  }
}
