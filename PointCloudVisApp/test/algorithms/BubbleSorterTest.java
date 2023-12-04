package algorithms;

import model.ScanPoint;
import model.ScanPointForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BubbleSorterTest {

        BubbleSorter<ScanPoint> sorter;
        List<ScanPoint> scanPoints;

        @BeforeEach
        void setUp() {
                sorter = new BubbleSorter<>();
                scanPoints = ScanPointForTesting.unsortedScanPoints();
        }

        @AfterEach
        void tearDown() {
                scanPoints = null;
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint} using Bubble Sort
         * from further ScanPoints to closer ScanPoints in the list.
         */
        @Test
        void testBubbleSortOnScanPoints() {
                sorter.sort(scanPoints);

                List<ScanPoint> expected = ScanPointForTesting.sortedScanPoints();

                ScanPointTestUtils.assertListsEqual(expected, scanPoints);
        }
}