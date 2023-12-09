package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge sorting algorithm
 *
 * @param <T> @param <T> Generic type that extends @{@link Comparable}
 * @author Selma Abbassi
 */
public class MergeSorter<T extends Comparable<? super T>> implements Sorter<T> {
        @Override
        public void sort(List<T> list) {
                //sort until sublist only has 1 element
                if (list.size() < 2) {
                        return;
                }

                int middle = list.size() / 2;

                // create sublists
                List<T> left = new ArrayList<>(list.subList(0, middle));
                List<T> right = new ArrayList<>(list.subList(middle, list.size()));

                sort(left);
                sort(right);
                //merge when dividing sublists is done
                merge(left, right, list);
        }

        private void merge(List<T> left, List<T> right, List<T> list) {
                int leftIndex = 0;
                int rightIndex = 0;
                int listIndex = 0;

                //compare elements from left and right and set right order in original list
                while (leftIndex < left.size() && rightIndex < right.size()) {
                        if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                                list.set(listIndex++, left.get(leftIndex++));
                        } else {
                                list.set(listIndex++, right.get(rightIndex++));
                        }
                }

                //Either of below while loop will execute
                while (leftIndex < left.size()) {
                        list.set(listIndex++, left.get(leftIndex++));
                }

                while (rightIndex < right.size()) {
                        list.set(listIndex++, right.get(rightIndex++));
                }
        }

        @Override
        public String toString() {
                return getClass().getName();
        }
}
