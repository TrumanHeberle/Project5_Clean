package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class tests the methods of the SongScanner
 *          class to ensure they work as expected.
 * 
 */
public class SongScannerTest extends TestCase {
    private SongScanner ss;
    private LinkedSongList<Song> list;


    /**
     * Sets up the test methods and is
     * executed before each test
     */
    public void setUp() {
        ss = new SongScanner();
        list = new LinkedSongList<Song>();
    }


    /**
     * Tests the scanPeople method
     */
    public void testScanPeople() {
        try {
            ss.scanSongs("SongListTest1.csv");
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }

        list = ss.getSongList();
        assertEquals(5, list.toArray().length);
    }


    /**
     * Tests the auto constructor
     */
    public void testConstructor() {
        try {
            ss = new SongScanner("SongListTest1.csv");
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }

        list = ss.getSongList();
        assertEquals(5, list.toArray().length);
    }


    /**
     * Tests the auto constructor again
     */
    public void testConstructor2() {
        try {
            ss = new SongScanner("SongListTest2.csv");
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }

        list = ss.getSongList();
        assertEquals(1, list.toArray().length);
    }


    /**
     * Tests the constructor when the file is invalid
     */
    public void testConstructorException() {

        try {
            ss = new SongScanner("input1.txt");
        }
        catch (Exception e) {
            e.getMessage();
        }
        assertEquals(0, ss.getSongList().size());
    }
}
