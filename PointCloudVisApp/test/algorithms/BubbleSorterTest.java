package algorithms;

import org.junit.jupiter.api.BeforeEach;

/**
 * Tests for @{@link BubbleSorter}
 */
class BubbleSorterTest extends SorterTest {

        /**
         * Initialize @{@link BubbleSorter} to execute tests in @{@link SorterTest}
         * with Bubble Sort
         */
        @BeforeEach
        void setUp() {
                scanPointSorter = new BubbleSorter<>();
                integerSorter = new BubbleSorter<>();
        }
}