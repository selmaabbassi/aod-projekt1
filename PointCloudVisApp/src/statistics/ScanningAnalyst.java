package statistics;

import java.io.Serializable;

import model.Scanning;
import model.ScanningList;
import model.Cuboid;
import model.ScanPoint;
import model.ScanPointList;

// just a  sketch
public class ScanningAnalyst implements Serializable
  {
  private static final long serialVersionUID = 1L;
  private ScanPointList  scanPointList;
  private Cuboid            cuboid;
  private Scanning          scanning;

  public ScanningAnalyst(Scanning scanning)
    {
    this.scanning = scanning;
    this.scanPointList = scanning.getScanPointList();
    calculate();
    }

  public void calculate()
    {
    cuboid = getSpan(scanning);
    }

  public Cuboid getSpan(ScanningList activities)
    {
    cuboid = new Cuboid();
    for (Scanning activity : activities)
      {
      ScanPointList points = activity.getScanPointList();
      if (points.size() > 0)
        {
        cuboid = new Cuboid(points.getFirst());
        for (ScanPoint tp : points)
          getSpan(tp, cuboid);
        }
      }
    return cuboid;
    }

  public Cuboid getSpan(Scanning activity)
    {
    cuboid = new Cuboid();
    ScanPointList points = activity.getScanPointList();
    if (points.size() > 0)
      {
      cuboid = new Cuboid(points.getFirst());
      for (ScanPoint tp : points)
        getSpan(tp, cuboid);
      }
    return cuboid;
    }

  private void getSpan(ScanPoint tp, Cuboid r)
    {
    r.expandWith(tp);
    }
  
  public Cuboid getCuboid()
    {
    return cuboid;
    }
  public String toString()
    {
    return scanPointList.size() + " " + cuboid.toString();
    }
  }
