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
 *          This class compares two songs by the artist's name.
 */
public class CompareSongArtist implements Comparator<Object> {

    /**
     * Compares two songs based on the Artist's name
     * 
     * @param o1
     *            the first object
     * @param o2
     *            the second object
     * @return the integer value that represents whether
     *         the first Artist comes before or after the second
     *         one in alphabetical order (0 if they are the same,
     *         some other integer if they are not)
     */
    @Override
    public int compare(Object o1, Object o2) {
        return ((Song)o1).getArtist().compareTo(((Song)o2).getArtist());
    }

}
