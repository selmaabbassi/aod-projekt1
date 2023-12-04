/**
 * This interface should be implemented in order to obtain
 * sorting functionality in this application.
 * The sort-method takes advantage of the fact that the
 * elements in the list implement Comparable, i.e. they
 * provide the method: int compareTo(T other)
 * compareTo returns 1, 0 or -1 to represent greater than,
 * equal and less than.
 * Naturally, this means that the implementer does something
 * like:
 * loop over elements
 *  if elementA.compareTo(elementB) < 1
 *    swap places
 * 
 * In addition, it is convenient to implement the method toString()
 * and let it return the name of your implementation. e.g.
 * return "BubbleSort".
 */

package algorithms;

import java.util.List;
/**
 * The implementing method receives a list containing elements that implements
 * the interface Comparable. (Note. ScanPoint does precisely that)
 * The method sorts the received list. Also see above. 
 */
public interface Sorter<T extends Comparable<? super T>>
  {
  public void sort(List<T> list);
  public String toString();
  }
