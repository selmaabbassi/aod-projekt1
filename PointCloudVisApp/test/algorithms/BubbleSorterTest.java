package algorithms;

import model.DataForTesting;
import model.ScanPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSorterTest {

        BubbleSorter<ScanPoint> scanPointSorter;
        BubbleSorter<Integer> integerSorter;

        @BeforeEach
        void setUp() {
                scanPointSorter = new BubbleSorter<>();
                integerSorter = new BubbleSorter<>();
        }

        /**
         * Test method for sorting a list of @{@link Integer} from min to max
         * using Bubble Sort
         */
        @Test
        void testBubbleSortOnIntegerList() {
                List<Integer> integerList = DataForTesting.unsortedIntegers();
                List<Integer> expected = DataForTesting.sortedIntegers();

                System.out.println("Before sorting: " + Arrays.toString(integerList.toArray()));
                integerSorter.sort(integerList);
                System.out.println("After sorting: " + Arrays.toString(integerList.toArray()));

                assertEquals(expected, integerList);
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint}
         * from further ScanPoints to closer ScanPoints in the list
         * using Bubble Sort
         */
        @Test
        void testBubbleSortOnScanPoints() {
                List<ScanPoint> scanPoints = DataForTesting.unsortedScanPoints();
                List<ScanPoint> expected = DataForTesting.sortedScanPoints();

                System.out.println("Before sorting: " + Arrays.toString(scanPoints.toArray()));
                scanPointSorter.sort(scanPoints);
                System.out.println("After sorting: " + Arrays.toString(scanPoints.toArray()));

                TestUtils.assertEquals(expected, scanPoints);
        }
}