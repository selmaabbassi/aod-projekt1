package algorithms;

import model.ScanPoint;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class TestUtils {

        /**
         * Asserts that each @{@link ScanPoint} in a list is equal to the ScanPoint in the same position of another list
         *
         * @param expected the expected list of ScanPoints
         * @param actual   the actual list of ScanPoints after sorting
         */
        public static void assertEquals(List<ScanPoint> expected, List<ScanPoint> actual) {
                for (int i = 0; i < actual.size(); i++) {
                        Assertions.assertEquals(expected.get(i).getY(), (actual.get(i).getY()));
                }
        }
}
