package Library;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static <T> void sortByAscending(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    public static <T> void sortByDescending(List<T> list, Comparator<T> comparator) {
        list.sort(comparator.reversed());
    }
}
