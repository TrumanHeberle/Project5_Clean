/**
 * 
 */
package prj5;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 * This class tests the methods of the CompareSongArtist 
 * class to ensure they work as expected.
 */
public class CompareSongArtistTest extends student.TestCase {

    private CompareSongArtist comparer;
    
    /** 
     * sets up the test methods and is executed 
     * before each test
     */
    public void setUp()
    {
        comparer = new CompareSongArtist();
    }
    
    /**
     * tests the compare method when the two objects
     * have different artists
     */
    public void testCompareDiffArtists()
    {
        Song song1 = new Song("hey", "Taylor Swift", 1998, "pop", 1);
        Song song2 = new Song("hello", "Michael Jackson", 1997, "rock", 2);
        assertNotSame(0, comparer.compare(song1, song2));
    }
    
    /**
     * tests the compare method when the two objects
     * have the same artist
     */
    public void testCompareSameArtist()
    {
        Song song1 = new Song("hey", "Taylor Swift", 1998, "pop", 1);
        Song song2 = new Song("hello", "Taylor Swift", 1997, "rock", 2);
        assertEquals(0, comparer.compare(song1, song2));
    }
    
}
