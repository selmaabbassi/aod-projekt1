package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter2<T extends Comparable<? super T>> implements Sorter<T> {

        @Override
        public void sort(List<T> list) {
                ArrayList<T> tmp = new ArrayList<>(list);
                mergeSortWorker(list, tmp, 0, list.size() - 1);
        }

        private void mergeSortWorker(List<T> data, ArrayList<T> tmp,
                                     int low, int high) {
                int middle, indexLow, indexHigh;
                if (high - low >= 1) {
                        middle = (low + high) / 2;
                        mergeSortWorker(data, tmp, low, middle);
                        mergeSortWorker(data, tmp, middle + 1, high);
                        for (int i = middle; i >= low; i--) {
                                tmp.set(i, data.get(i));
                        }
                        for (int i = middle + 1; i <= high; i++) {
                                tmp.set(middle + 1 + high - i, data.get(i));
                        }
                        indexLow = low;
                        indexHigh = high;

                        for (int i = low; i <= high; i++) {
                                if (tmp.get(indexLow).compareTo(tmp.get(indexHigh)) > 0) {
                                        data.set(i, tmp.get(indexHigh));
                                        indexHigh--;
                                } else {
                                        data.set(i, tmp.get(indexLow));
                                        indexLow++;
                                }
                        }
                }
        }

        @Override
        public String toString() {
                return getClass().getName();
        }
}
