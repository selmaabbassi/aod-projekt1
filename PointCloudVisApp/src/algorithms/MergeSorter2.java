package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge sorting algorithm with different implementation than @{@link MergeSorter}
 *
 * @param <T> @param <T> Generic type that extends @{@link Comparable}
 * @author Selma Abbassi
 * @implNote creates a new sorted list during merge and sets the original list to the sorted list's values after merge
 */
public class MergeSorter2<T extends Comparable<? super T>> implements Sorter<T> {

        @Override
        public void sort(List<T> list) {
                mergeSortWorker(list, 0, list.size() - 1);
        }

        private void mergeSortWorker(List<T> data, int low, int high) {
                if (high - low >= 1) {
                        int middle = (low + high) / 2;
                        mergeSortWorker(data, low, middle);
                        mergeSortWorker(data, middle + 1, high);

                        List<T> sorted = merge(data, low, middle, high);

                        for (int i = low; i <= high; i++) {
                                data.set(i, sorted.get(i - low));
                        }
                }
        }

        private List<T> merge(List<T> data, int low, int middle, int high) {
                int leftSize = middle - low + 1;
                int rightSize = high - middle;

                List<T> left = new ArrayList<>(data.subList(low, low + leftSize));
                List<T> right = new ArrayList<>(data.subList(middle + 1, middle + 1 + rightSize));

                int indexLow = 0, indexHigh = 0;
                List<T> sorted = new ArrayList<>(leftSize + rightSize);

                while (indexLow < leftSize && indexHigh < rightSize) {
                        if (left.get(indexLow).compareTo(right.get(indexHigh)) <= 0) {
                                sorted.add(left.get(indexLow));
                                indexLow++;
                        } else {
                                sorted.add(right.get(indexHigh));
                                indexHigh++;
                        }
                }

                while (indexLow < leftSize) {
                        sorted.add(left.get(indexLow));
                        indexLow++;
                }

                while (indexHigh < rightSize) {
                        sorted.add(right.get(indexHigh));
                        indexHigh++;
                }

                return sorted;
        }

        @Override
        public String toString() {
                return getClass().getName();
        }
}
