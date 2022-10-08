package CustomListIterator09;

import java.util.Collections;
import java.util.List;

public class Sorter extends CustomList {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        Collections.sort(list);
    }
}
