package algorithms;

import java.util.List;

public class MockUpSorter<T extends Comparable< ? super T>> implements Sorter<T>
  {
  @Override
  public void sort(List<T> list)
    {
    // here the sorting should take place
    }
  
  @Override
  public String toString()
    {
    return getClass().getName();
    }
  }
