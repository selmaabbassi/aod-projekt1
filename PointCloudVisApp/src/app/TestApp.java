package app;

import algorithms.Sorter;
import model.ScanPoint;
import view.PointCloudRenderGUI;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class TestApp {
        public TestApp() {
        }

        public void startApp() {
                List<Sorter<ScanPoint>> sorters = new LinkedList<Sorter<ScanPoint>>();
                sorters.add(new algorithms.MockUpSorter<ScanPoint>());
                sorters.add(new algorithms.InsertionSorter<ScanPoint>());
                sorters.add(new algorithms.BubbleSorter<ScanPoint>());
                sorters.add(new algorithms.MergeSorter<ScanPoint>());

                SwingUtilities.invokeLater(() -> new PointCloudRenderGUI(sorters));
        }

        public static void main(String[] args) {
                TestApp app = new TestApp();
                app.startApp();
        }
}
