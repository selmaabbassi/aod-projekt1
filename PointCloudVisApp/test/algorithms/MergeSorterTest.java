package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MergeSorterTest extends SorterTest {

        /**
         * Initialize @{@link MergeSorter} to execute tests in @{@link SorterTest}
         * with Merge Sort
         */
        @BeforeEach
        void setUp() {
                scanPointSorter = new MergeSorter<>();
                integerSorter = new MergeSorter<>();
        }

        /**
         * Test method for sorting a List of @{@link Integer} with 1000 values
         * and checking the execution time
         * using @{@link MergeSorter}
         */
        @Test
        void testMergeSortIntegerList1000Values() {
                long startTime = System.nanoTime();

                List<Integer> integerList = TestUtils.generateUnsortedList(1, 1000);
                List<Integer> sorted = TestUtils.generateSortedList(1, 1000);

                integerSorter.sort(integerList);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time: " + duration + " ns");

                assertEquals(sorted, integerList);
        }

        /**
         * Test method for sorting a List of @{@link Integer} with 10 000 values
         * and checking the execution time
         * using @{@link MergeSorter}
         */
        @Test
        void testMergeSortIntegerList10000Values() {
                long startTime = System.nanoTime();

                List<Integer> integerList = TestUtils.generateUnsortedList(1, 10000);
                List<Integer> sorted = TestUtils.generateSortedList(1, 10000);

                integerSorter.sort(integerList);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time: " + duration + " ns");

                assertEquals(sorted, integerList);
        }

        /**
         * Test method for sorting a List of @{@link Integer} with 100 000 values
         * and checking the execution time
         * using @{@link MergeSorter}
         */
        @Test
        void testMergeSortIntegerList100000Values() {
                long startTime = System.nanoTime();

                List<Integer> integerList = TestUtils.generateUnsortedList(1, 100000);
                List<Integer> sorted = TestUtils.generateSortedList(1, 100000);

                integerSorter.sort(integerList);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time: " + duration + " ns");

                assertEquals(sorted, integerList);
        }

        /**
         * Test method for sorting a List of @{@link Integer} with 700 000 values
         * using @{@link MergeSorter}
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