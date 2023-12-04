package algorithms;

import model.ScanPoint;
import model.ScanPointForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

                assertListsEqual(expected, scanPoints);
        }

        /**
         * Asserts that each @{@link ScanPoint} in a list is equal to the ScanPoint in the same position of another list
         *
         * @param expected the expected list of ScanPoints
         * @param actual   the actual list of ScanPoints after sorting
         */
        private void assertListsEqual(List<ScanPoint> expected, List<ScanPoint> actual) {
                for (int i = 0; i < actual.size(); i++) {
                        assertEquals(expected.get(i).getY(), (actual.get(i).getY()));
                }
        }
}