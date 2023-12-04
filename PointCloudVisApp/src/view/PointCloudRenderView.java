package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;

import algorithms.Sorter;
import model.Scanning;
import model.Cuboid;
import model.Point3D;
import model.ScanPoint;
import model.ScanPointList;

public class PointCloudRenderView extends JPanel
  {
  private static final long            serialVersionUID     = 1L;
  private double                       deltaX;
  private double                       deltaY;
  private double                       minX, minY;
  private Scanning                     scanning;
  private JPanel                       controlPanel         = new JPanel();
  private JCheckBox                    sortOnCheckBox       = new JCheckBox("Sort on", false);
  private JButton                      sortButton           = new JButton("Sort now");
  private JButton                      shuffleButton        = new JButton("Unsort now");
  private JButton                      reduceButton         = new JButton("N := N/2");
  private JButton                      reverseButton        = new JButton("Reverse sort order");
  private JButton                      colorModeButton      = new JButton("FG Color");
  private JButton                      bgButton             = new JButton("BG Color");
  private JCheckBox                    projectionCheckBox   = new JCheckBox("Projection", true);
  private JCheckBox                    depthShadingCheckBox = new JCheckBox("Depth shading", true);
  private JSlider                      cutPointSlider       = new JSlider(0, 100, 0);
  private JSlider                      sliceWidthSlider     = new JSlider(0, 100, 100);
  private double                       cutPoint             = 0.0;
  private double                       sliceWidth           = 100.0;
  private int                          colorMode            = 1;
  private long                         sortTime             = 0L;
  private Color                        almostBlack          = new Color(20, 20, 20);
  private Color                        almostWhite          = new Color(235, 235, 235);
  private Cuboid                       cuboid;
  private JComboBox<Sorter<ScanPoint>> sorterCombo;
  private Sorter<ScanPoint>            selectedSorter;
  private boolean                      sortOn               = true;
  private boolean                      depthShadingOn       = true;
  private boolean                      projectionOn         = true;

  public PointCloudRenderView(List<Sorter<ScanPoint>> sorters)
    {
    super(true);
    this.scanning = new Scanning("Empty", new ScanPointList());
    update(scanning);
    this.setBackground(almostBlack);
    sorterCombo = new JComboBox<Sorter<ScanPoint>>(new Vector<Sorter<ScanPoint>>(sorters));
    sorterCombo.addActionListener(e -> changeSorter());
    selectedSorter = sorters.get(0);
    setLayout(null);
    controlPanel.setLayout(null);
    controlPanel.setOpaque(false);
    add(controlPanel, 0, 60, sortOnCheckBox);
    add(controlPanel, 0, 90, sorterCombo);
    add(controlPanel, 0, 120, sortButton);
    add(controlPanel, 0, 150, shuffleButton);
    add(controlPanel, 0, 180, reduceButton);
    add(controlPanel, 0, 210, reverseButton);
    add(controlPanel, 0, 240, bgButton);
    add(controlPanel, 0, 270, colorModeButton);
    add(controlPanel, 0, 300, projectionCheckBox);
    add(controlPanel, 0, 330, depthShadingCheckBox);
    add(controlPanel, 0, 360, cutPointSlider);
    add(controlPanel, 0, 390, sliceWidthSlider);
    controlPanel.setPreferredSize(new Dimension(250, 450));
    add(this, 0, 60, controlPanel);
    sortOnCheckBox.setOpaque(true);
    sortOnCheckBox.setBackground(new Color(150, 150, 150, 200));
    projectionCheckBox.setOpaque(true);
    projectionCheckBox.setBackground(new Color(150, 150, 150, 200));
    depthShadingCheckBox.setOpaque(true);
    depthShadingCheckBox.setBackground(new Color(150, 150, 150, 200));
    cutPointSlider.setOpaque(true);
    cutPointSlider.setBackground(new Color(150, 150, 150, 200));
    sliceWidthSlider.setOpaque(true);
    sliceWidthSlider.setBackground(new Color(150, 150, 150, 200));
    sortOnCheckBox.addActionListener(e -> sortOnOff());
    sortButton.addActionListener(e -> sort());
    shuffleButton.addActionListener(e -> shuffle());
    reduceButton.addActionListener(e -> reduce());
    reverseButton.addActionListener(e -> toggleSortOrder());
    bgButton.addActionListener(e -> changeBackground());
    colorModeButton.addActionListener(e -> changeColorMode());
    cutPointSlider.addChangeListener(e -> cutPointSliderChanged());
    sliceWidthSlider.addChangeListener(e -> sliceWidthSliderChanged());
    projectionCheckBox.addActionListener(e -> toggleProjection());
    depthShadingCheckBox.addActionListener(e -> toggleDepthShading());
    sortButton.setToolTipText("Sortera, mät tid, rita om display");
    shuffleButton.setToolTipText("Blanda om data (osortera)");
    reduceButton.setToolTipText("Halvera antal element");
    reverseButton.setToolTipText("Kasta om sorteringsordningen (bakifrån/framifrån)");
    bgButton.setToolTipText("Växla mellan mörk och ljus bakgrund");
    colorModeButton.setToolTipText("Växla mellan olika färgsättningar");
    projectionCheckBox.setToolTipText("Slå av/på projektion");
    depthShadingCheckBox.setToolTipText("Slå av/på linjärt avtagande ljusstyrka");
    cutPointSlider.setToolTipText("Klippets startdjup");
    sliceWidthSlider.setToolTipText("Klippets tjocklek");
    new MouseHandler(this);
    }

  private void sortOnOff()
    {
    sortOn = sortOnCheckBox.isSelected();
    sortButton.setEnabled(sortOn);
    reverseButton.setEnabled(sortOn);
    sorterCombo.setEnabled(sortOn);
    controlPanel.repaint();
    if (sortOn)
      sort();
    }

  private void toggleProjection()
    {
    projectionOn = projectionCheckBox.isSelected();
    repaint();
    }

  private void toggleDepthShading()
    {
    depthShadingOn = depthShadingCheckBox.isSelected();
    repaint();
    }

  private void add(Container container, int x, int y, JComponent jc)
    {
    Dimension d = jc.getPreferredSize();
    jc.setBounds(x, y, (int) d.getWidth(), (int) d.getHeight());
    container.add(jc);
    }

  private void changeSorter()
    {
    selectedSorter = sorterCombo.getItemAt(sorterCombo.getSelectedIndex());
    }

  public void update(double minX, double maxX, double minY, double maxY)
    {
    this.minY = minY;
    this.minX = minX;
    deltaY = maxY - minY;
    deltaX = maxX - minX;
    }

  public void update(Scanning scanning)
    {
    this.scanning = scanning;
    cuboid = scanning.getScanningAnalyst().getCuboid();
    update(cuboid.getMinX(), cuboid.getMaxX(), cuboid.getMinZ(), cuboid.getMaxZ());
    scanning.getScanPointList().shuffle();
    }

  private class Pixel
    {
    public int x;
    public int y;
    }

  private Pixel projectOn2D(ScanPoint tp)
    {
    Pixel p = new Pixel();
    int width = getWidth();
    int height = getHeight();
    if (projectionOn)
      {
      double proj = 3.0;
      double k = 0.75 / (1.0 + proj * (tp.getY() - cuboid.getMinY()));
      double offs = (1.0 - k) / 2.0;
      p.x = (int) (width * (offs + k * (tp.getX() - minX) / deltaX));
      p.y = height - (int) (height * (offs + k * (tp.getZ() - minY) / deltaY));
      }
    else
      {
      p.x = (int) (width * (tp.getX() - minX) / deltaX);
      p.y = height - (int) (height * (tp.getZ() - minY) / deltaY);
      }
    return p;
    }

  private void sort()
    {
    long startTime = System.nanoTime();
    if (sortOn)
      {
      scanning.getScanPointList().setSorter(selectedSorter);
      scanning.getScanPointList().sort();
      }
    sortTime = System.nanoTime() - startTime;
    repaint();
    }

  private void reduce()
    {
    scanning.getScanPointList().reduce();
    sortTime = 0;
    repaint();
    }

  private void shuffle()
    {
    scanning.getScanPointList().shuffle();
    sortTime = 0;
    repaint();
    }

  private void toggleSortOrder()
    {
    ScanPoint.toggleSortOrder();
    sort();
    repaint();
    }

  private void changeBackground()
    {
    setBackground((getBackground() == almostBlack) ? almostWhite : almostBlack);
    repaint();
    }

  private void changeColorMode()
    {
    colorMode = (colorMode + 1) % 3;
    repaint();
    }

  private void rotate(double dz, double dx)
    {
    Point3D center = cuboid.getCenterPoint();
    cuboid = new Cuboid(center);
    ScanPointList points = scanning.getScanPointList();
    for (ScanPoint tp : points)
      {
      tp.rotateAround(center, dz, dx);
      cuboid.expandWith(tp);
      }
    sort();
    }

  private void cutPointSliderChanged()
    {
    cutPoint = cutPointSlider.getValue();
    repaint();
    }

  private void sliceWidthSliderChanged()
    {
    sliceWidth = sliceWidthSlider.getValue();
    repaint();
    }

  public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    ScanPointList points = scanning.getScanPointList();
    double lowLimit = 0.01 * cutPoint * points.size();
    double highLimit = lowLimit + 0.01 * sliceWidth * points.size();
    int n = 0;
    for (ScanPoint tp : points)
      {
      if (n >= lowLimit && n <= highLimit)
        {
        Pixel p1 = projectOn2D(tp);
        Color color = Color.white;
        double closeness = (depthShadingOn) ? (cuboid.getMaxY() - tp.getY()) / cuboid.getDeltaY() : 1.0;
        try
          {
          switch (colorMode)
            {
            case 0:
              float intensity = tp.getI() / 255F;
              color = new Color(intensity * tp.getR() / 255F, intensity * tp.getG() / 255F, intensity * tp.getB() / 255F);
              break;
            case 1:
              color = new Color((int) (closeness * tp.getR()), (int) (closeness * tp.getG()), (int) (closeness * tp.getB()));
              break;
            case 2:
              int brightness = (int) (55 + 200 * closeness);
              color = new Color(brightness, brightness, brightness);
              break;
            }
          }
        catch (IllegalArgumentException iae)
          {
          System.err.println("ColorMode = " + colorMode + " : " + iae.getMessage() + " " + closeness);
          }
        g.setColor(color);
        g.fillOval(p1.x, p1.y, 3 + (int) (closeness * 3), 3 + (int) (closeness * 3));
        }
      n++;
      }
    g.setColor(Color.black);
    g.fillRect(0, 0, 150, 50);
    g.setColor(Color.white);
    g.drawRect(0, 0, 150, 50);
    g.drawString(String.format("N = %,6d", scanning.getScanPointList().size()), 5, 20);
    g.drawString(String.format("T = %,12d ns", sortTime), 5, 40);
    }

  private class MouseHandler
    {
    private int x, y;

    public MouseHandler(Container container)
      {
      container.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e)
        {
        double dx = e.getX() - x;
        x = e.getX();
        double dy = e.getY() - y;
        y = e.getY();
        rotate(0.01 * dx, -0.01 * dy);
        }
      });

      container.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e)
        {
        x = e.getX();
        y = e.getY();
        }
      });
      }
    }
  }
