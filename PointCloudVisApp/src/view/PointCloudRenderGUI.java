package view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import algorithms.Sorter;
import file.AscFileHandler;
import file.OpenFileSelector;
import model.ScanPoint;
import model.Scanning;
import model.ScanningList;

public class PointCloudRenderGUI extends JFrame
  {
  private static final long    serialVersionUID = 1L;
  private ScanningList         scanningList     = new ScanningList();
  private JTabbedPane          jTabbedPane      = new JTabbedPane();
  private PointCloudRenderView renderView;
  private PointCloudDataView   pointCloudDataView;

  public PointCloudRenderGUI(List<Sorter<ScanPoint>> sorters)
    {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e)
      {
      quit();
      }
    });
    createAndShowUserView(sorters);
    }

  private void createAndShowUserView(List<Sorter<ScanPoint>> sorters)
    {
    setSize(1000, 800);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    renderView = new PointCloudRenderView(sorters);
    pointCloudDataView = new PointCloudDataView(scanningList, renderView);
    JPanel scanningsP = new JPanel(new BorderLayout());
    scanningsP.add(pointCloudDataView, BorderLayout.NORTH);
    jTabbedPane.add("Point cloud data", scanningsP);
    JScrollPane scroll = new JScrollPane(renderView);
    jTabbedPane.add("Point cloud rendering", scroll);
    add(jTabbedPane);
    createMenue();
    setVisible(true);
    }

  private void quit()
    {
    System.exit(0);
    }

  private void createMenue()
    {
    JMenuItem mitemImport = new JMenuItem("Import ascii point cloud file");
    mitemImport.addActionListener(e -> importScanningData());
    JMenu menu = new JMenu("Actions");
    menu.add(mitemImport);
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    setJMenuBar(menuBar);
    }

  private void importScanningData()
    {
    AscFileHandler csvHandler = new AscFileHandler();
    OpenFileSelector ofs = new OpenFileSelector(this, "ASCII-files", "asc");
    for (File file : ofs.getFileList())
      {
      Scanning scanning = new Scanning(file.getName(), csvHandler.readCSV(file.getAbsolutePath()));
      scanningList.add(scanning);
      }
    pointCloudDataView.updateList(scanningList);
    }
  }
