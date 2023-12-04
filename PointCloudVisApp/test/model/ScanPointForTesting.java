package model;

import java.util.ArrayList;
import java.util.List;

public class ScanPointForTesting {

        public static List<ScanPoint> unsortedScanPoints() {
                return new ArrayList<>(List.of(
                                new ScanPoint(3, 3, 3),
                                new ScanPoint(1, 1, 1),
                                new ScanPoint(5, 5, 5),
                                new ScanPoint(2, 2, 2),
                                new ScanPoint(4, 4, 4)));
        }

        public static List<ScanPoint> sortedScanPoints() {
                return new ArrayList<>(List.of(
                                new ScanPoint(5, 5, 5),
                                new ScanPoint(4, 4, 4),
                                new ScanPoint(3, 3, 3),
                                new ScanPoint(2, 2, 2),
                                new ScanPoint(1, 1, 1)
                ));
        }
}
