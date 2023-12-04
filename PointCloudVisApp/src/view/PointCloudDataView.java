package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

import model.ScanPointList;
import model.Scanning;
import model.ScanningList;

public class PointCloudDataView extends JPanel
  {
  private static final long    serialVersionUID = 1L;
  private JList<Scanning>      jlist            = new JList<Scanning>();
  private ScanningList         scanningList;
  private PointCloudRenderView pointCloudRenderView;
  private JButton              removeButton     = new JButton("Remove selected");

  public PointCloudDataView(ScanningList scanningList, PointCloudRenderView pointCloudRenderView)
    {
    this.pointCloudRenderView = pointCloudRenderView;
    updateList(scanningList);
    createView();
    jlist.addListSelectionListener(e -> selectActivity(e));
    removeButton.addActionListener(e -> removeActivity());
    }

  private void selectActivity(ListSelectionEvent e)
    {
    if (!e.getValueIsAdjusting())
      {
      List<Scanning> scannings = jlist.getSelectedValuesList();
      System.out.println(scannings.size());
      ScanPointList totalScanPointList = new ScanPointList();
      String caption = "";
      for (Scanning scanning : scannings)
        {
        totalScanPointList.addAll(scanning.getScanPointList());
        caption += scanning.getCaption();
        }
      Scanning scanning = new Scanning(caption, totalScanPointList);
      pointCloudRenderView.update(scanning);
      }
    }

  public List<Scanning> getSelectedScannings()
    {
    return jlist.getSelectedValuesList();
    }

  private void removeActivity()
    {
    List<Scanning> activities = jlist.getSelectedValuesList();
    scanningList.removeAll(activities);
    updateList();
    }

  public void updateList(ScanningList scanningsList)
    {
    this.scanningList = scanningsList;
    updateList();
    }

  private void updateList()
    {
    Collections.sort(scanningList, (a, b) -> a.getCaption().compareTo(b.getCaption()));
    jlist.setListData(new Vector<Scanning>(scanningList));
    }

  public void createView()
    {
    JLabel label = new JLabel("After import, select one or more point clouds for rendering:");
    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());
    JScrollPane jsp = new JScrollPane(jlist);
    jsp.setPreferredSize(new Dimension(500, 200));
    panel1.add(label, BorderLayout.NORTH);
    panel1.add(jsp, BorderLayout.SOUTH);
    JPanel panel2 = new JPanel();
    panel2.add(removeButton);
    JPanel panel3 = new JPanel(new BorderLayout());
    panel3.add(panel1, BorderLayout.NORTH);
    panel3.add(panel2, BorderLayout.SOUTH);
    add(panel3);
    }
  }
