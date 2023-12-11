package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSorter2Test extends SorterTest {

        /**
         * Initialize @{@link MergeSorter2} to execute tests in @{@link SorterTest}
         * with Merge Sort 2 with different implementation
         */
        @BeforeEach
        void setUp() {
                scanPointSorter = new MergeSorter2<>();
                integerSorter = new MergeSorter2<>();
        }

        /**
         * Test method for sorting a List of @{@link Integer} with 700 000 values
         * and checking the execution time
         * using @{@link MergeSorter2}
         */
        @Test
        void testMergeSortIntegerList700000Values() {
                List<Integer> integerList = TestUtils.generateUnsortedList(1, 700000);
                List<Integer> sorted = TestUtils.generateSortedList(1, 700000);

                long startTime = System.nanoTime();
                integerSorter.sort(integerList);
                long endTime = System.nanoTime();

                long duration = endTime - startTime;
                System.out.println("Execution time: " + duration + " ns");

                assertEquals(sorted, integerList);
        }
}