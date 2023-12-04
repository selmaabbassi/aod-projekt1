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
                List<T> temp = new ArrayList<>();
                mergeSortWorker(list, temp, 0, list.size() - 1);
        }

        private void mergeSortWorker(List<T> list, List<T> temp, int low, int high) {
                int middle, indexLow, indexHigh;

                if (high - low >= 1) {
                        //find middle point to split to subarrays
                        middle = (low + high) / 2;

                        //merge first and second halves
                        mergeSortWorker(list, temp, low, middle);
                        mergeSortWorker(list, temp, middle + 1, high);

                        //insert left elements of middle to temp
                        for (int i = middle; i >= low; i--)
                                temp.add(i, list.get(i));

                        //insert right elements of middle to temp
                        for (int i = middle + 1; i <= high; i++)
                                temp.add(middle + 1 + high - i, list.get(i));

                        indexLow = low;
                        indexHigh = high;

                        //sort data in temp subarrays and swap
                        for (int i = low; i <= high; i++) {
                                if (temp.get(indexLow).compareTo(temp.get(indexHigh)) > 0) {
                                        list.add(i, temp.get(indexHigh));
                                        indexHigh--;
                                } else {
                                        list.add(i, temp.get(indexLow));
                                        indexLow++;
                                }
                        }
                }
        }
}
