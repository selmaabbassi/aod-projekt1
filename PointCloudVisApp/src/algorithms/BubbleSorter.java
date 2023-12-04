package algorithms;

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
                                        swap(list, i, i + 1);
                                        changed = true;
                                }
                        }
                        step++;
                } while (changed);
        }

        private void swap(List<T> list, int i, int k) {
                T elementToSwap = list.get(i);
                T elementToSwapWith = list.get(k);

                list.set(i, elementToSwapWith);
                list.set(k, elementToSwap);
        }

        @Override
        public String toString() {
                return getClass().toString();
        }
}
