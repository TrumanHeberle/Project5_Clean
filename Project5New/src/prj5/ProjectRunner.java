
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class begins the program
 *          by scanning the given files or
 *          using the default files that
 *          represent the list of songs and
 *          survey responses from our Spring 2017
 *          class and then creating a window
 *          to visually display this information.
 *
 */
public class ProjectRunner {

    /**
     * The main method, which evaluates whether or not
     * the given arguments are valid, and then scans the
     * files and creates a window to evaluate the data and
     * display it.
     * 
     * @param args
     *            the person file and song file in that order
     * @throws FileNotFoundException
     *             if the files are not valid
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 2) {
            PersonScanner personScanner = new PersonScanner(args[0]);
            DoublyLinkedList<Person> people = personScanner.getPeopleList();
            SongScanner songScanner = new SongScanner(args[1]);
            LinkedSongList<Song> songs = songScanner.getSongList();
            GUIDisplayWindow gui = new GUIDisplayWindow(people, songs);
        }
        else {
            PersonScanner personScanner = new PersonScanner(
                "MusicSurveyData2017S.csv");
            DoublyLinkedList<Person> people = personScanner.getPeopleList();
            SongScanner songScanner = new SongScanner("SongList2017S.csv ");
            LinkedSongList<Song> songs = songScanner.getSongList();
            GUIDisplayWindow gui = new GUIDisplayWindow(people, songs);
        }
    }
}
