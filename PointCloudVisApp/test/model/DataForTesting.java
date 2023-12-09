package model;

import java.util.ArrayList;
import java.util.List;

public class DataForTesting {

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

        public static List<ScanPoint> unsortedScanPointsWithDuplicates() {
                return new ArrayList<>(List.of(
                                new ScanPoint(3, 4, 3),
                                new ScanPoint(1, 1, 1),
                                new ScanPoint(5, 5, 5),
                                new ScanPoint(2, 2, 2),
                                new ScanPoint(4, 4, 4)));
        }

        public static List<ScanPoint> sortedScanPointsWithDuplicates() {
                return new ArrayList<>(List.of(
                                new ScanPoint(5, 5, 5),
                                new ScanPoint(4, 4, 4),
                                new ScanPoint(3, 4, 3),
                                new ScanPoint(2, 2, 2),
                                new ScanPoint(1, 1, 1)
                ));
        }

        public static List<Integer> unsortedIntegers() {
                return new ArrayList<>(List.of(4, 3, 2, 8, 1, 10, 9, 6, 5, 7));
        }

        public static List<Integer> sortedIntegers() {
                return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        }

        public static List<Integer> unsortedIntegersWithDuplicates() {
                return new ArrayList<>(List.of(4, 3, 2, 8, 4, 10, 9, 6, 5, 7));
        }

        public static List<Integer> sortedIntegersWithDuplicates() {
                return new ArrayList<>(List.of(2, 3, 4, 4, 5, 6, 7, 8, 9, 10));
        }
}
