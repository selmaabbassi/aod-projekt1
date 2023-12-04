package model;

import java.util.LinkedList;
import java.util.List;

import algorithms.MockUpSorter;
import algorithms.Sorter;

@SuppressWarnings("serial")
public class ScanPointList extends LinkedList<ScanPoint> implements List<ScanPoint>
  {
  private Sorter<ScanPoint> sorter;
  
  public ScanPointList()
    {
    setSorter(new MockUpSorter<ScanPoint>());
    }

  public ScanPointList(Sorter<ScanPoint> sorter)
    {
    setSorter(sorter);
    }
  
  public void setSorter(Sorter<ScanPoint> sorter)
    {
    this.sorter = sorter;  
    }
  
  public synchronized void sort()
    {
    if(sorter != null)
      sorter.sort(this);
    }

  public synchronized ScanPointList shuffle()
    {
    for (int i = 0; i < 8; i++)
      {
      ScanPointList tmp = new ScanPointList();
      while (!this.isEmpty())
        {
        ScanPoint sp = (this.size() % 2 == 0) ? this.removeFirst() : this.removeLast();
        tmp.add(sp);
        }
      for (ScanPoint sp : tmp)
        {
        this.add(sp);
        }
      }
    return this;
    }

  public synchronized ScanPointList reduce()
    {
    ScanPointList tmp = new ScanPointList();
    while (!this.isEmpty())
      {
      ScanPoint sp = this.removeFirst();
      if (this.size() % 2 == 0)
        tmp.add(sp);
      }
    for (ScanPoint sp : tmp)
      {
      this.add(sp);
      }
    return this;
    }
  }
