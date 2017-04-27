package prj5;

/**
 * 
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class represents an individual
 *          person, who has filled out the survey
 *          on whether they have heard or like
 *          different songs listed. They contain
 *          data on their personal information
 *          as well as the responses to the survey
 *          questions.
 */
public class Person {
    private int identity;
    private String date;
    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private String[] answers;


    /**
     * The constructor, which creates a new
     * Person Object and initializes fields.
     * 
     * @param id
     *            The person's id
     * @param dateS
     *            The date the person took the survey
     * @param hobbyS
     *            The person's hobby (String)
     * @param majorS
     *            The person's major (String)
     * @param regionS
     *            The person's region (String)
     * @param answersS
     *            The person's list of answers
     */
    public Person(
        int id,
        String dateS,
        String hobbyS,
        String majorS,
        String regionS,
        String[] answersS) {
        identity = id;
        date = dateS;
        this.setHobby(hobbyS);
        this.setMajor(majorS);
        this.setRegion(regionS);
        answers = answersS;
    }


    /**
     * The default constructor, which is intentionally
     * left blank so that information for a person can
     * be added after the person is instantiated, which
     * is helpful when scanning files.
     */
    public Person() {
        // intentionally left blank
    }


    /**
     * Returns the person's id
     * 
     * @return The person's id
     */
    public int getId() {
        return identity;
    }


    /**
     * Returns the date that the
     * Person took the survey
     * 
     * @return The date that the Person
     *         took the survey
     */
    public String getDate() {
        return date;
    }


    /**
     * Returns the person's hobby
     * 
     * @return The person's hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * Returns the person's major
     * 
     * @return The person's major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * Returns the region the person is
     * from
     * 
     * @return The person's region
     */
    public RegionEnum getRegion() {
        return region;
    }


    /**
     * Sets the person's id
     * 
     * @param parseInt
     *            the integer to be
     *            set for the person's id
     */
    public void setId(int parseInt) {

        identity = parseInt;
    }


    /**
     * sets the array of the person's
     * answers to the survey questions
     * 
     * @param surveyAnswers
     *            the answers to be set for
     *            the person
     */
    public void setAnswers(String[] surveyAnswers) {
        answers = surveyAnswers;
    }


    /**
     * returns the person's answers to
     * the survey questions
     * 
     * @return the array of the person's answers
     */
    public String[] getAnswers() {
        return answers;
    }


    /**
     * sets the date that the person took the
     * survey
     * 
     * @param givenDate
     *            the date to set for when the
     *            person took the survey
     */
    public void setDate(String givenDate) {
        date = givenDate;
    }


    /**
     * Sets the hobby for the person
     * based on an input String
     * 
     * @param hobbyString
     *            The String representing
     *            the person's hobby
     */
    public void setHobby(String hobbyString) {
        hobbyString = hobbyString.toLowerCase();
        if (hobbyString.equals("reading")) {
            hobby = HobbyEnum.READ;
        }
        if (hobbyString.equals("sports")) {
            hobby = HobbyEnum.SPORTS;
        }
        if (hobbyString.equals("music")) {
            hobby = HobbyEnum.MUSIC;
        }
        if (hobbyString.equals("art")) {
            hobby = HobbyEnum.ART;
        }
    }


    /**
     * Sets the major for the person
     * based on an input String
     * 
     * @param majorString
     *            The String representing
     *            the person's major
     */
    public void setMajor(String majorString) {
        majorString = majorString.toLowerCase();
        if (majorString.equals("computer science")) {
            major = MajorEnum.COMPUTER_SCIENCE;
        }
        if (majorString.equals("math or cmda")) {
            major = MajorEnum.MATH_CMDA;
        }
        if (majorString.equals("other")) {
            major = MajorEnum.OTHER;
        }
        if (majorString.equals("other engineering")) {
            major = MajorEnum.OTHER_ENGINEERING;
        }
    }


    /**
     * Sets a person's region
     * based on an input String
     * 
     * @param regionString
     *            The String representing
     *            the person's region
     */
    public void setRegion(String regionString) {
        regionString = regionString.toLowerCase();
        if (regionString.equals("southeast")) {
            region = RegionEnum.SOUTH_EAST_US;
        }
        if (regionString.equals("northeast")) {
            region = RegionEnum.NORTH_EAST_US;
        }
        if (regionString.equals("united states "
            + "(other than southeast or northwest)")) {
            region = RegionEnum.OTHER_US;
        }
        if (regionString.equals("outside of united states")) {
            region = RegionEnum.OUTSIDE_US;
        }
    }

}
