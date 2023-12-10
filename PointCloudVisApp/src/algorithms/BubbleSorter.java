package algorithms;

import java.util.Collections;
import java.util.List;

/**
 * Bubble sorting algorithm
 *
 * @param <T> @param <T> Generic type that extends @{@link Comparable}
 * @author Selma Abbassi
 */
public class BubbleSorter<T extends Comparable<? super T>> implements Sorter<T> {

        @Override
        public void sort(List<T> list) {
                boolean changed = true;
                int step = 0;

                do {
                        changed = false;
                        for (int i = 0; i < list.size() - 1; i++) {
                                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                                        Collections.swap(list, i, i + 1);
                                        changed = true;
                                }
                        }
                        step++;
                } while (changed);
        }

        @Override
        public String toString() {
                return getClass().getName();
        }
}
