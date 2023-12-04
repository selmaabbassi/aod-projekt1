package ascparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import model.ScanPointList;

public class AscFileReader
  {
  private String fileName;
  private BufferedReader reader;
  
  public AscFileReader(String fileName)
    {
    this.fileName = fileName;
    }
  
  public void open()
    {
    try
      {
      FileInputStream is = new FileInputStream(fileName); // System.in;
      reader = new BufferedReader(new InputStreamReader(is));
      }
    catch (FileNotFoundException fnfe)
      {
      System.err.println(fnfe);
      }  
    }
  
  public void openStr(String source)
    {
    reader = new BufferedReader(new StringReader(source));
    }
  
  public void close()
    {
    try
      {
      reader.close();
      }
    catch(IOException ioe)
      {
      System.err.println(ioe);      
      }
    }
  
  public ScanPointList getScanPoints()
    {
    if(reader == null)
      return null;
    AscParser parser = new AscParser();
    parser.parse(reader);
    return parser.getScanPointList();
    }
  }
