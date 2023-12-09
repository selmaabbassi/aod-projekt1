package algorithms;

import model.DataForTesting;
import model.ScanPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSorterTest {

        InsertionSorter<ScanPoint> scanPointSorter;
        InsertionSorter<Integer> integerSorter;

        @BeforeEach
        void setUp() {
                scanPointSorter = new InsertionSorter<>();
                integerSorter = new InsertionSorter<>();
        }

        /**
         * Test method for sorting a list of @{@link Integer} from min to max
         * using Insertion Sort
         */
        @Test
        void testInsertionSortOnIntegerList() {
                List<Integer> integerList = DataForTesting.unsortedIntegers();
                List<Integer> expected = DataForTesting.sortedIntegers();

                integerSorter.sort(integerList);

                assertEquals(expected, integerList);
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint}
         * from further ScanPoints to closer ScanPoints in the list
         * using Insertion Sort
         */
        @Test
        void testInsertionSortOnScanPoints() {
                List<ScanPoint> scanPointList = DataForTesting.unsortedScanPoints();
                List<ScanPoint> expected = DataForTesting.sortedScanPoints();

                scanPointSorter.sort(scanPointList);

                TestUtils.assertEquals(expected, scanPointList);
        }
}