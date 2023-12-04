package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;

import algorithms.Sorter;
import model.ScanPoint;
import view.PointCloudRenderGUI;

public class TestApp
  {
  public TestApp()
    {
    }

  public void startApp()
    {
    List<Sorter<ScanPoint>> sorters = new LinkedList<Sorter<ScanPoint>>();
    sorters.add(new algorithms.MockUpSorter<ScanPoint>());
    sorters.add(new algorithms.InsertionSorter<ScanPoint>());

    SwingUtilities.invokeLater(() -> new PointCloudRenderGUI(sorters));
    }
  
  public static void main(String[] args)
    {
    TestApp app = new TestApp();
    app.startApp();
    }
  }
