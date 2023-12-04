package ascparser;

import java.io.BufferedReader;
import java.io.IOException;
import model.ScanPoint;
import model.ScanPointList;

public class AscParser
  {
  private ScanPointList scanpoints = new ScanPointList();

  public void parse(BufferedReader reader)
    {
    try
      {
      String line = reader.readLine();
      while (line != null)
        {
        if(line!=null && line.contains(","))
          line = line.replace(",", ".");
        String[] attributes = line.split(";");
        if (attributes.length == 7)
          {
          ScanPoint scanpoint = new ScanPoint();
          scanpoint.setX(Double.parseDouble(attributes[0]));
          scanpoint.setY(Double.parseDouble(attributes[1]));
          scanpoint.setZ(Double.parseDouble(attributes[2]));
          scanpoint.setI(Integer.parseInt(attributes[3]));
          scanpoint.setR(Integer.parseInt(attributes[4]));
          scanpoint.setG(Integer.parseInt(attributes[5]));
          scanpoint.setB(Integer.parseInt(attributes[6]));
          scanpoints.add(scanpoint);
          }
        line = reader.readLine();
        }
      }
    catch (IOException ioe)
      {
      }
    }

  public ScanPointList getScanPointList()
    {
    return scanpoints;
    }

  }
