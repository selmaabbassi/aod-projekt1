package algorithms;

import java.util.Collections;
import java.util.List;

/**
 * Insertion sorting algorithm
 * @param <T> Generic type that extends @{@link Comparable}
 * @author Selma Abbassi
 */
public class InsertionSorter<T extends Comparable<? super T>> implements Sorter<T> {

        /**
         * Sorts a @{@link List} using @{@link Comparable#compareTo(Object)}
         * @param list of generic types that extend @{@link Comparable}
         */
        @Override
        public void sort(List<T> list) {
                int high = list.size();
                int low = 0;

                for (int i = low + 1; i < high; i++) {
                        for (int k = i; k >= low + 1; k--) {
                                T current = list.get(k);
                                T previous = list.get(k - 1);
                                if(current.compareTo(previous) < 0) {
                                        Collections.swap(list, list.indexOf(current), list.indexOf(previous));
                                }
                        }
                }
        }

        @Override
        public String toString() {
                return getClass().toString();
        }
}
