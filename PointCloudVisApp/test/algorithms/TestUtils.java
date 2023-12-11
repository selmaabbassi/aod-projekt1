package algorithms;

import model.ScanPoint;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {

        /**
         * Asserts that each @{@link ScanPoint} in a list is equal to the ScanPoint in the same position of another list
         *
         * @param expected the expected list of ScanPoints
         * @param actual   the actual list of ScanPoints after sorting
         */
        public static void assertEquals(List<ScanPoint> expected, List<ScanPoint> actual) {
                for (int i = 0; i < actual.size(); i++) {
                        Assertions.assertTrue(expected.get(i).compareTo(actual.get(i)) == 0);
                }
        }

        /**
         * Generates an unsorted List of @{@link Integer}
         *
         * @param minValue min value
         * @param maxValue max value
         * @return unsorted list with @{@link Integer}
         */
        public static List<Integer> generateUnsortedList(int minValue, int maxValue) {
                List<Integer> randomList = generateSortedList(minValue, maxValue);
                Collections.shuffle(randomList);
                return randomList;
        }

        /**
         * Generates a sorted List of @{@link Integer}
         *
         * @param minValue min value
         * @param maxValue max value
         * @return sorted list with @{@link Integer}
         */
        public static List<Integer> generateSortedList(int minValue, int maxValue) {
                List<Integer> sortedList = new ArrayList<>();
                for (int i = minValue; i <= maxValue; i++) {
                        sortedList.add(i);
                }
                return sortedList;
        }
}
