package algorithms;

import org.junit.jupiter.api.BeforeEach;

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
}