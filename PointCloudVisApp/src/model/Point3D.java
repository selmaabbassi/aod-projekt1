package model;

public class Point3D
  {
  private double x, y, z;
  public Point3D(double x, double y, double z)
    {
    setX(x);
    setY(y);
    setZ(z);
    }

  public double getX()
    {
    return x;
    }

  public void setX(double x)
    {
    this.x = x;
    }

  public double getY()
    {
    return y;
    }

  public void setY(double y)
    {
    this.y = y;
    }

  public double getZ()
    {
    return z;
    }

  public void setZ(double z)
    {
    this.z = z;
    }  

  public double distanceTo(Point3D p)
    {
    return Math.pow(x*x*x + y*y*y + z*z*z, 1.0/3.0);
    }
  
  public Point3D add(Point3D p)
    {
    this.x+=p.getX();
    this.y+=p.getY();
    this.z+=p.getZ();
    return this;
    }

  public Point3D sub(Point3D p)
    {
    this.x-=p.getX();
    this.y-=p.getY();
    this.z-=p.getZ();
    return this;
    }

  public synchronized Point3D rotateAround(Point3D center, double angleZ, double angleX)
    {
    return sub(center).rotateZ(angleZ).rotateX(angleX).add(center);
    }

  private Point3D rotateZ(double angle)
    {
    final double x=this.x;
    final double y=this.y;
    final double s = Math.sin(angle);
    final double c = Math.cos(angle);
    this.x = x*c-y*s;
    this.y = x*s+y*c;
    return this;
    }
  
  private Point3D rotateX(double angle)
    {
    final double z=this.z;
    final double y=this.y;
    final double s = Math.sin(angle);
    final double c = Math.cos(angle);
    this.z = z*c-y*s;
    this.y = z*s+y*c;
    return this;
    }
  
  public String toString()
    {
    return String.format("%.3f %.3f %.3f", x,y,z);
    }
  }
