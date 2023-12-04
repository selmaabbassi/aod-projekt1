package model;

import java.io.Serializable;

public class Cuboid implements Serializable
  {
  private static final long serialVersionUID = 1L;
  private double            minX;
  private double            maxX;
  private double            minY;
  private double            maxY;
  private double            minZ;
  private double            maxZ;
  
  public Cuboid(double minX, double maxX, double minY, double maxY, double minZ, double maxZ)
    {
    this.minX = minX;
    this.maxX = maxX;
    this.minY = minY;
    this.maxY = maxY;
    this.minZ = minZ;
    this.maxZ = maxZ;
    }

  public Cuboid(Point3D p)
    {
    this.minX = this.maxX = p.getX();
    this.minY = this.maxY = p.getY();
    this.minZ = this.maxZ = p.getZ();
    }
  
  public Cuboid()
    {
    }

  public double getMinX()
    {
    return minX;
    }

  public double getMaxX()
    {
    return maxX;
    }

  public double getMinY()
    {
    return minY;
    }

  public double getMaxY()
    {
    return maxY;
    }

  public double getMinZ()
    {
    return minZ;
    }

  public double getMaxZ()
    {
    return maxZ;
    }

  public double getDeltaX()
    {
    return maxX - minX;
    }

  public double getDeltaY()
    {
    return maxY - minY;
    }

  public double getDeltaZ()
    {
    return maxZ - minZ;
    }

  public Point3D getCenterPoint()
    {
    return new Point3D((maxX + minX) / 2.0, (maxY + minY) / 2.0, (maxZ + minZ) / 2.0);
    }

  public void expandWith(Point3D p)
    {
    double x = p.getX();
    double y = p.getY();
    double z = p.getZ();
    if (x < minX)
      minX = x;
    if (y < minY)
      minY = y;
    if (z < minZ)
      minZ = z;
    if (x > maxX)
      maxX = x;
    if (y > maxY)
      maxY = y;
    if (z > maxZ)
      maxZ = z;
    }

  public String toString()
    {
    return String.format("X:[%.3f, %.3f] Y:[%.3f, %.3f] Z:[%.3f, %.3f] ", minX, maxX, minY, maxY, minZ, maxZ);
    }
  }
