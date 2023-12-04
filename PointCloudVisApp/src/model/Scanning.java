package model;

import java.io.Serializable;

import statistics.ScanningAnalyst;

public class Scanning implements Serializable
  {
  private static final long serialVersionUID = 1L;
  private ScanPointList     scanPoints;
  private ScanningAnalyst   scanningAnalyst;
  private String            caption          = "";
  private String            location         = "";
  private String            date             = "";
  private String            type             = "";
  private String            category         = "";
  private String            note             = "";
  private String            imageDefinitionFile;
  private double            minLon           = 180.0;
  private double            maxLon           = -180.0;
  private double            minLat           = 90.0;
  private double            maxLat           = -90.0;
  private String            imageFileName    = "";

  public Scanning(String caption, ScanPointList scanPoints)
    {
    this.caption = caption;
    this.scanPoints = scanPoints;
    this.scanningAnalyst = new ScanningAnalyst(this);
    }

  public double getMinLon()
    {
    return minLon;
    }

  public void setMinLon(double minLon)
    {
    this.minLon = minLon;
    }

  public double getMaxLon()
    {
    return maxLon;
    }

  public void setMaxLon(double maxLon)
    {
    this.maxLon = maxLon;
    }

  public double getMinLat()
    {
    return minLat;
    }

  public void setMinLat(double minLat)
    {
    this.minLat = minLat;
    }

  public double getMaxLat()
    {
    return maxLat;
    }

  public void setMaxLat(double maxLat)
    {
    this.maxLat = maxLat;
    }

  public String getImageFileName()
    {
    return imageFileName;
    }

  public void setImageFileName(String imageFileName)
    {
    this.imageFileName = imageFileName;
    }

  public void setImageDefinitionFile(String f)
    {
    this.imageDefinitionFile = f;
    }

  public String getImageDefinitionFile()
    {
    return imageDefinitionFile;
    }

  public ScanningAnalyst getScanningAnalyst()
    {
    return scanningAnalyst;
    }

  public String getCaption()
    {
    return caption;
    }

  public void setCaption(String caption)
    {
    this.caption = caption;
    }

  public String getLocation()
    {
    return location;
    }

  public void setLocation(String location)
    {
    this.location = location;
    }

  public String getDate()
    {
    return date;
    }

  public void setDate(String date)
    {
    this.date = date;
    }

  public String getType()
    {
    return type;
    }

  public void setType(String type)
    {
    this.type = type;
    }

  public String getCategory()
    {
    return category;
    }

  public void setCategory(String category)
    {
    this.category = category;
    }

  public String getNote()
    {
    return note;
    }

  public void setNote(String note)
    {
    this.note = note;
    }

  public ScanPointList getScanPointList()
    {
    return scanPoints;
    }

  public String toString()
    {
    return caption + " " + scanningAnalyst;
    }
  }
