package prj5;

import student.TestCase;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class tests the methods of the
 *          Person class to ensure they work
 *          as expected.
 */
public class PersonTest extends TestCase {
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private String[] answers;


    /**
     * Sets up the test methods and is executed
     * before each test
     */
    public void setUp() {
        answers = new String[] { "yes", "", "no", "yes" };
        person1 = new Person(1, "10/19/15 14:45", "reading", "computer science",
            "southeast", answers);
        person2 = new Person(2, "10/19/15 13:45", "sports", "math or cmda",
            "northeast", answers);
        person3 = new Person(3, "10/19/15 12:45", "music", "other engineering",
            "united states (other than southeast or northwest)", answers);
        person4 = new Person(4, "10/19/15 11:45", "art", "other",
            "outside of united states", answers);
        person5 = new Person(4, "10/19/15 11:45", "ArT", "oTheR",
            "OUTSIDE of United states", answers);
    }


    /**
     * Tests the getId() method
     */
    public void testGetId() {
        assertEquals(1, person1.getId());
        assertEquals(2, person2.getId());
        assertEquals(3, person3.getId());
        assertEquals(4, person4.getId());
        assertEquals(4, person5.getId());
    }


    /**
     * Tests the getDate() method
     */
    public void testGetDate() {
        assertEquals("10/19/15 14:45", person1.getDate());
        assertEquals("10/19/15 13:45", person2.getDate());
        assertEquals("10/19/15 12:45", person3.getDate());
        assertEquals("10/19/15 11:45", person4.getDate());
        assertEquals("10/19/15 11:45", person5.getDate());
    }


    /**
     * Tests the getHobby() method
     */
    public void testGetHobby() {
        assertEquals(HobbyEnum.READ, person1.getHobby());
        assertEquals(HobbyEnum.SPORTS, person2.getHobby());
        assertEquals(HobbyEnum.MUSIC, person3.getHobby());
        assertEquals(HobbyEnum.ART, person4.getHobby());
        assertEquals(HobbyEnum.ART, person5.getHobby());
    }


    /**
     * Tests the getMajor() method
     */
    public void testGetMajor() {
        assertEquals(MajorEnum.COMPUTER_SCIENCE, person1.getMajor());
        assertEquals(MajorEnum.MATH_CMDA, person2.getMajor());
        assertEquals(MajorEnum.OTHER_ENGINEERING, person3.getMajor());
        assertEquals(MajorEnum.OTHER, person4.getMajor());
        assertEquals(MajorEnum.OTHER, person5.getMajor());
    }


    /**
     * Tests the getRegion() method
     */
    public void testGetRegion() {
        assertEquals(RegionEnum.SOUTH_EAST_US, person1.getRegion());
        assertEquals(RegionEnum.NORTH_EAST_US, person2.getRegion());
        assertEquals(RegionEnum.OTHER_US, person3.getRegion());
        assertEquals(RegionEnum.OUTSIDE_US, person4.getRegion());
        assertEquals(RegionEnum.OUTSIDE_US, person5.getRegion());
    }


    /**
     * Tests that the setter methods fail if the strings don't match
     */
    public void testFailedPerson() {
        Person pers = new Person(3, "", "", "", "", answers);
        assertNull(pers.getHobby());
        assertNull(pers.getMajor());
        assertNull(pers.getRegion());
    }
}
