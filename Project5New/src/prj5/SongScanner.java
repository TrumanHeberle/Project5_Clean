package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class scans a file of songs and
 *          then creates a list of these songs to be
 *          used in other aspects of this project.
 */
public class SongScanner {
    private LinkedSongList<Song> songList;


    /**
     * the constructor, which initializes the field
     */
    public SongScanner() {
        songList = new LinkedSongList<Song>();
    }


    /**
     * the constructor, which scans the given
     * file and initializes the field
     * 
     * @param filename
     *            the file
     * @throws FileNotFoundException
     */
    public SongScanner(String filename) throws FileNotFoundException {
        this();
        this.scanSongs(filename);
    }


    /**
     * scans the file of songs and adds the
     * songs in the file to a list of songs
     * 
     * @param songFile
     *            the file to be scanned
     * 
     * @throws FileNotFoundException
     *             if the file is invalid
     */
    public LinkedSongList<Song> scanSongs(String songFile) throws FileNotFoundException {
        try {
            Scanner file = new Scanner(new File(songFile));
            int index = 0;
            file.nextLine();
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] songArray = line.split(" *, *");
                for (int i = 0; i < songArray.length; i += 4) {
                    songList.addToBack(new Song(songArray[i], songArray[i + 1],
                        Integer.valueOf(songArray[i + 2]), songArray[i + 3],
                        index));
                    index += 2;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        return songList;
    }


    /**
     * returns the list of songs
     * 
     * @return the list of songs
     */
    public LinkedSongList<Song> getSongList() {
        return songList;
    }
}
