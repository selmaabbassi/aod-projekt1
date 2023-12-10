package algorithms;

import org.junit.jupiter.api.BeforeEach;

class InsertionSorterTest extends SorterTest {

        /**
         * Initialize @{@link InsertionSorter} to execute tests in @{@link SorterTest}
         * with Insertion Sort
         */
        @BeforeEach
        void setUp() {
                scanPointSorter = new InsertionSorter<>();
                integerSorter = new InsertionSorter<>();
        }
}