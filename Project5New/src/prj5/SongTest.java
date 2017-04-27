/**
 * 
 */
package prj5;

import java.util.Arrays;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class tests the methods of the Song class
 *          to ensure they work as expected.
 */
public class SongTest extends student.TestCase {

    private Song song;
    private DoublyLinkedList<Person> list;
    private int[] scores;


    /**
     * sets up the test methods and is executed
     * before each test
     */
    public void setUp() {
        song = new Song("Hello", "Adele", 2016, "Pop", 0);
        String[] ans1 = new String[] { "yes", "no" };
        Person per1 = new Person(123, "03/03/2003 10:59", "art",
            "computer science", "Southeast", ans1);
        String[] ans2 = new String[] { "yes", "yes" };
        Person per2 = new Person(123, "03/03/2003 10:59", "art",
            "computer science", "Southeast", ans2);
        String[] ans3 = new String[] { "no", "no" };
        Person per3 = new Person(123, "03/03/2003 10:59", "art",
            "computer science", "Southeast", ans3);
        String[] ans4 = new String[] { "no", "yes" };
        Person per4 = new Person(123, "03/03/2003 10:59", "art",
            "computer science", "Southeast", ans4);
        String[] ans5 = new String[] { "a", "a" };
        Person per5 = new Person(123, "03/03/2003 10:59", "art",
            "computer science", "Southeast", ans5);
        list = new DoublyLinkedList<Person>();
        list.addToBack(per1);
        list.addToBack(per2);
        list.addToBack(per3);
        list.addToBack(per4);
        list.addToBack(per5);
        scores = new int[] { 50, 50 };
    }


    /**
     * tests the getter methods
     */
    public void testGetters() {
        assertEquals("Hello", song.getTitle());
        assertEquals("Adele", song.getArtist());
        assertEquals(2016, song.getYear());
        assertEquals("Pop", song.getGenre());
    }


    /**
     * tests the getMajorScore method
     */
    public void testGetMajorScore() {

        assertEquals(Arrays.toString(song.getMajorScore(
            MajorEnum.COMPUTER_SCIENCE, list)), Arrays.toString(scores));
    }


    /**
     * tests the getHobbyScore method
     */
    public void testGetHobbyScore() {
        assertEquals(Arrays.toString(song.getHobbyScore(HobbyEnum.ART, list)),
            Arrays.toString(scores));
    }


    /**
     * tests the getRegionScore method
     */
    public void testGetRegionScore() {
        assertEquals(Arrays.toString(song.getRegionScore(
            RegionEnum.SOUTH_EAST_US, list)), Arrays.toString(scores));
    }
}
