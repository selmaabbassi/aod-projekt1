package algorithms;

import model.DataForTesting;
import model.ScanPoint;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorterTest {

        Sorter<Integer> integerSorter;
        Sorter<ScanPoint> scanPointSorter;

        /**
         * Test method for sorting a list of @{@link Integer} sorting from min to max
         * using one of the algorithms that implements @{@link Sorter}
         */
        @Test
        void testSortIntegerList() {
                List<Integer> integerList = DataForTesting.unsortedIntegers();
                List<Integer> expected = DataForTesting.sortedIntegers();

                System.out.println("Before sorting: " + Arrays.toString(integerList.toArray()));
                integerSorter.sort(integerList);
                System.out.println("After sorting: " + Arrays.toString(integerList.toArray()));

                assertEquals(expected, integerList);
        }

        /**
         * Test method for sorting a list of @{@link Integer} with duplicates, sorting from min to max
         * using one of the algorithms that implements @{@link Sorter}
         */
        @Test
        void testSortIntegerListWithDuplicates() {
                List<Integer> integerList = DataForTesting.unsortedIntegersWithDuplicates();
                List<Integer> expected = DataForTesting.sortedIntegersWithDuplicates();

                System.out.println("Before sorting: " + Arrays.toString(integerList.toArray()));
                integerSorter.sort(integerList);
                System.out.println("After sorting: " + Arrays.toString(integerList.toArray()));

                assertEquals(expected, integerList);
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint}
         * sorting from further ScanPoints to closer ScanPoints in the list
         * using one of the algorithms that implements @{@link Sorter}
         */
        @Test
        void testSortScanPointList() {
                List<ScanPoint> scanPoints = DataForTesting.unsortedScanPoints();
                List<ScanPoint> expected = DataForTesting.sortedScanPoints();

                System.out.println("Before sorting: " + Arrays.toString(scanPoints.toArray()));
                scanPointSorter.sort(scanPoints);
                System.out.println("After sorting: " + Arrays.toString(scanPoints.toArray()));

                TestUtils.assertEquals(expected, scanPoints);
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint} with duplicates
         * sorting from further ScanPoints to closer ScanPoints in the list
         * using one of the algorithms that implements @{@link Sorter}
         */
        @Test
        void testSortScanPointListWithDuplicates() {
                List<ScanPoint> scanPoints = DataForTesting.unsortedScanPointsWithDuplicates();
                List<ScanPoint> expected = DataForTesting.sortedScanPointsWithDuplicates();

                System.out.println("Before sorting: " + Arrays.toString(scanPoints.toArray()));
                scanPointSorter.sort(scanPoints);
                System.out.println("After sorting: " + Arrays.toString(scanPoints.toArray()));

                TestUtils.assertEquals(expected, scanPoints);
        }
}
