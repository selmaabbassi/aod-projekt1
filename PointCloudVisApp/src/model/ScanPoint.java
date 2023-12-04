package model;

public class ScanPoint extends Point3D implements Comparable<ScanPoint>
  {
  private int i, r, g, b;
  private static boolean sortOrder = true;

  public ScanPoint()
    {
    super(0.0, 0.0, 0.0);
    }

  public ScanPoint(double x, double y, double z)
    {
    super(x, y, z);
    }
  
  public ScanPoint(double x, double y, double z, int r, int g, int b, int i)
    {
    this(x,y,z);
    setR(r);
    setG(g);
    setB(b);
    setI(i);
    }
  
  public int getR()
    {
    return r;
    }

  public void setR(int r)
    {
    this.r = r;
    }
  
  public int getG()
    {
    return g;
    }

  public void setG(int g)
    {
    this.g = g;
    }
  
  public int getB()
    {
    return b;
    }

  public void setB(int b)
    {
    this.b = b;
    }

  public int getI()
    {
    return i;
    }

  public void setI(int i)
    {
    this.i = i;
    }
  
  public String toString()
    {
    return String.format("%s %d %d %d %d", super.toString(), r, g, b, i);
    }
  
  public static void setSortOrder(boolean order)
    {
    sortOrder = order;
    }

  public static void toggleSortOrder()
    {
    sortOrder = !sortOrder;
    }

  @Override
  public int compareTo(ScanPoint other)
    {
    double diff = this.getY()-other.getY();
    if(diff == 0.0)
      return 0;
    if(sortOrder)
      return (diff < 0.0)? 1 : -1;
    else
      return (diff > 0.0)? 1 : -1;
    }
  }
