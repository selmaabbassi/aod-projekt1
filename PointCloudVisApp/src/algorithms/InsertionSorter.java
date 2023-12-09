package algorithms;

import java.util.Collections;
import java.util.List;

/**
 * Insertion sorting algorithm
 *
 * @param <T> Generic type that extends @{@link Comparable}
 * @author Selma Abbassi
 */
public class InsertionSorter<T extends Comparable<? super T>> implements Sorter<T> {

        @Override
        public void sort(List<T> list) {
                int high = list.size();
                int low = 0;

                for (int i = low + 1; i < high; i++) {
                        for (int k = i; k >= low + 1; k--) {
                                if (list.get(k).compareTo(list.get(k - 1)) < 0) {
                                        Collections.swap(list, k, k - 1);
                                }
                        }
                }
        }

        @Override
        public String toString() {
                return getClass().getName();
        }
}
