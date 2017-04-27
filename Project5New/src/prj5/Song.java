/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class represents an individual
 *          song, and it has fields that store the
 *          data for the song and methods that
 *          track and can return different types
 *          of data for the song.
 */
public class Song {

    private String title;
    private String artist;
    private int year;
    private String genre;
    private int songNum;


    /**
     * the constructor, which initializes the
     * fields
     * 
     * @param title1
     *            the title of the song
     * @param artist1
     *            the song artist
     * @param year1
     *            the year the song was released
     * @param genre1
     *            the genre of the song
     * @param songNum1
     *            the song index
     */
    public Song(
        String title1,
        String artist1,
        int year1,
        String genre1,
        int songNum1) {
        title = title1;
        artist = artist1;
        year = year1;
        genre = genre1;
        songNum = songNum1;
    }


    /**
     * returns the title of the song
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * returns the name of the song artist
     * 
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * returns the year that the song
     * was released
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }


    /**
     * returns the genre of the song
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Calculates the percentage of people
     * for the given major who have heard and
     * who like the song
     * 
     * @param major
     *            the major of choice
     * @param list
     *            the list of people
     * @return the array representing the percentage
     *         of people who have heard and like the song
     */
    public int[] getMajorScore(MajorEnum major, DoublyLinkedList<Person> list) {
        double yesHeard = 0;
        double noHeard = 0;
        double yesLiked = 0;
        double noLiked = 0;
        int[] score = new int[2];
        DoublyLinkedList<Person> majorList = list.getChosenMajorList(major);
        Iterator<Person> iter = majorList.iterator();
        while (iter.hasNext()) {
            Person person = iter.next();
            if (person.getAnswers()[songNum].equalsIgnoreCase("yes")) {
                yesHeard++;
            }
            else if (person.getAnswers()[songNum].equalsIgnoreCase("no")) {
                noHeard++;
            }
            if (person.getAnswers()[songNum + 1].equalsIgnoreCase("yes")) {
                yesLiked++;
            }
            else if (person.getAnswers()[songNum + 1].equalsIgnoreCase("no")) {
                noLiked++;
            }
        }
        double totalHeard = yesHeard + noHeard;
        double scoreHeard = yesHeard / totalHeard;
        double totalLiked = yesLiked + noLiked;
        double scoreLiked = yesLiked / totalLiked;
        score[0] = (int)(scoreHeard * 100);
        score[1] = (int)(scoreLiked * 100);
        return score;
    }


    /**
     * Calculates the percentage of people
     * for the given hobby who have heard and
     * who like the song
     * 
     * @param hobby
     *            the hobby of choice
     * @param list
     *            the list of people
     * @return the array representing the percentage
     *         of people who have heard and like the song
     */

    public int[] getHobbyScore(HobbyEnum hobby, DoublyLinkedList<Person> list) {
        int yesHeard = 0;
        int noHeard = 0;
        int yesLiked = 0;
        int noLiked = 0;
        int[] score = new int[2];
        DoublyLinkedList<Person> hobbyList = list.getChosenHobbyList(hobby);
        Iterator<Person> iter = hobbyList.iterator();
        while (iter.hasNext()) {
            Person person = iter.next();
            if (person.getAnswers()[songNum].equalsIgnoreCase("yes")) {
                yesHeard++;
            }
            else if (person.getAnswers()[songNum].equalsIgnoreCase("no")) {
                noHeard++;
            }
            if (person.getAnswers()[songNum + 1].equalsIgnoreCase("yes")) {
                yesLiked++;
            }
            else if (person.getAnswers()[songNum + 1].equalsIgnoreCase("no")) {
                noLiked++;
            }
        }
        double totalHeard = yesHeard + noHeard;
        double scoreHeard = yesHeard / totalHeard;
        double totalLiked = yesLiked + noLiked;
        double scoreLiked = yesLiked / totalLiked;
        score[0] = (int)(scoreHeard * 100);
        score[1] = (int)(scoreLiked * 100);
        return score;
    }


    /**
     * Calculates the percentage of people
     * for the given region who have heard and
     * who like the song
     * 
     * @param region
     *            the region of choice
     * @param list
     *            the list of people
     * @return the array representing the percentage
     *         of people who have heard and like the song
     */

    public int[] getRegionScore(
        RegionEnum region,
        DoublyLinkedList<Person> list) {
        int yesHeard = 0;
        int noHeard = 0;
        int yesLiked = 0;
        int noLiked = 0;
        int[] score = new int[2];
        DoublyLinkedList<Person> regionList = list.getChosenRegionList(region);
        Iterator<Person> iter = regionList.iterator();
        while (iter.hasNext()) {
            Person person = iter.next();
            if (person.getAnswers()[songNum].equalsIgnoreCase("yes")) {
                yesHeard++;
            }
            else if (person.getAnswers()[songNum].equalsIgnoreCase("no")) {
                noHeard++;
            }
            if (person.getAnswers()[songNum + 1].equalsIgnoreCase("yes")) {
                yesLiked++;
            }
            else if (person.getAnswers()[songNum + 1].equalsIgnoreCase("no")) {
                noLiked++;
            }
        }
        double totalHeard = yesHeard + noHeard;
        double scoreHeard = yesHeard / totalHeard;
        double totalLiked = yesLiked + noLiked;
        double scoreLiked = yesLiked / totalLiked;
        score[0] = (int)(scoreHeard * 100);
        score[1] = (int)(scoreLiked * 100);
        return score;
    }
}
