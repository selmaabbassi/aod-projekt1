package algorithms;

import model.ScanPoint;
import model.ScanPointForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSorterTest {

        InsertionSorter<ScanPoint> sorter;

        @BeforeEach
        void setUp() {
                sorter = new InsertionSorter<>();
        }

        @AfterEach
        void tearDown() {
        }

        /**
         * Test method for sorting a list of @{@link ScanPoint}
         * in the order further ScanPoints to closer ScanPoints in the list.
         */
        @Test
        void testSortScanPoints() {
                List<ScanPoint> scanPoints = ScanPointForTesting.unsortedScanPoints();
                sorter.sort(scanPoints);

                List<ScanPoint> expected = ScanPointForTesting.sortedScanPoints();

                assertListsEquals(expected, scanPoints);
        }


        /**
         * Asserts that the y-coordinate of each @{@link ScanPoint} in two lists are equal
         * @param expected the expected list of ScanPoints
         * @param actual the actual list of ScanPoints after sorting
         */
        private void assertListsEquals(List<ScanPoint> expected, List<ScanPoint> actual) {
                for (int i = 0; i < actual.size(); i++) {
                        assertEquals(expected.get(i).getY(), (actual.get(i).getY()));
                }
        }
}