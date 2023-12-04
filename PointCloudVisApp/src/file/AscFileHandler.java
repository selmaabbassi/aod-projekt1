package file;

import java.io.IOException;
import java.io.PrintWriter;

import ascparser.AscFileReader;
import model.ScanPoint;
import model.ScanPointList;

public class AscFileHandler
  {
  public ScanPointList readCSV(String filename)
    {
    AscFileReader csvFileReader = new AscFileReader(filename);
    csvFileReader.open();
    ScanPointList scanpoints = csvFileReader.getScanPoints();
    return scanpoints;
    }

  public void writeAsc(ScanPointList scanPoints, String filename)
    {
    int suffixPos = filename.indexOf(".asc");
    if (suffixPos > 0)
      {
      filename = filename.substring(0, suffixPos) + ".asc";
      try
        {
        PrintWriter pw = new PrintWriter(filename);
        for (ScanPoint tp : scanPoints)
          {
          double x = tp.getX();
          double y = tp.getY();
          double z = tp.getZ();
          int    i = tp.getI();
          int    r = tp.getR();
          int    g = tp.getG();
          int    b = tp.getB();
          String line = String.format("%.4f;%.4f;%.4f;%d;%d;%d;%d;", x,y,z,i,r,g,b);
          line = line.replace(',', '.');
          pw.println(line);
          }
        pw.close();
        }
      catch (IOException ioe)
        {
        }
      }
    }
  }
