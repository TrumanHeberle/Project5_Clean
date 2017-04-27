/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 * This class compares two songs by the song year.
 */
public class CompareSongYear implements Comparator<Object> {
     
    /**
     * Compares two songs based on the song's year
     * @param o1 the first object
     * @param o2 the second object
     * @return the integer value that represents whether
     * the first song's year comes before or after the second
     * one's year (0 if they are the same, the difference in 
     * years if they are not)
     */
    @Override
    public int compare(Object o1, Object o2)
    {
        int diff = ((Song)o1).getYear() - ((Song)o2).getYear();
        return diff;
    }

}
