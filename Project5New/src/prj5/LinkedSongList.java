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
 * @param <T>
 *            The generic type, which provides
 *            the ability to use many different data types
 *            for this class
 * 
 *            This class represents a doubly-linked
 *            list of songs, and it has the ability
 *            to sort the list by title, artist, year,
 *            or genre.
 */
public class LinkedSongList<T> extends DoublyLinkedList<T> {

    /**
     * Sorts the current list by song title
     * by comparing two song titles as
     * the iterator traverses the list. This method
     * uses the insertion sorting method.
     * 
     * @return the list of songs, sorted by title
     */
    public LinkedSongList<Song> sortByTitle() {
        LinkedSongList<Song> titleList = new LinkedSongList<>();
        CompareSongTitle comparer = new CompareSongTitle();
        @SuppressWarnings("unchecked")
        Iterator<Song> iterator = (Iterator<Song>)this.iterator();
        while (iterator.hasNext()) {
            int size = titleList.size();
            Song currentSong = iterator.next();
            int position = 0;
            while (position < size && comparer.compare(currentSong, titleList
                .getEntry(position)) > 0) {
                position++;
            }
            titleList.add(Math.abs(position), currentSong);
        }
        return titleList;
    }


    /**
     * Sorts the current list by song artist
     * by comparing two song artists as
     * the iterator traverses the list. This method
     * uses the insertion sorting method.
     * 
     * @return the list of songs, sorted by artist name
     */
    public LinkedSongList<Song> sortByArtist() {
        LinkedSongList<Song> artistList = new LinkedSongList<>();
        CompareSongArtist comparer = new CompareSongArtist();
        @SuppressWarnings("unchecked")
        Iterator<Song> iterator = (Iterator<Song>)this.iterator();
        while (iterator.hasNext()) {
            int size = artistList.size();
            Song currentSong = iterator.next();
            int position = 0;
            while (position < size && comparer.compare(currentSong, artistList
                .getEntry(position)) > 0) {
                position++;
            }
            artistList.add(position, currentSong);
        }
        return artistList;
    }


    /**
     * Sorts the current list by song year
     * by comparing two song years as
     * the iterator traverses the list. This method
     * uses the insertion sorting method.
     * 
     * @return the list of songs, sorted by release year
     */
    public LinkedSongList<Song> sortByYear() {
        LinkedSongList<Song> yearList = new LinkedSongList<>();
        CompareSongYear comparer = new CompareSongYear();
        @SuppressWarnings("unchecked")
        Iterator<Song> iterator = (Iterator<Song>)this.iterator();
        while (iterator.hasNext()) {
            int size = yearList.size();
            Song currentSong = iterator.next();
            int position = 0;
            while (position < size && comparer.compare(currentSong, yearList
                .getEntry(position)) > 0) {
                position++;
            }
            yearList.add(position, currentSong);
        }
        return yearList;
    }


    /**
     * Sorts the current list by song genre
     * by comparing two song genres as
     * the iterator traverses the list. This method
     * uses the insertion sorting method.
     * 
     * @return the list of songs, sorted by genre
     */
    public LinkedSongList<Song> sortByGenre() {
        LinkedSongList<Song> genreList = new LinkedSongList<>();
        CompareSongGenre comparer = new CompareSongGenre();
        @SuppressWarnings("unchecked")
        Iterator<Song> iterator = (Iterator<Song>)this.iterator();
        while (iterator.hasNext()) {
            int size = genreList.size();
            Song currentSong = iterator.next();
            int position = 0;
            while (position < size && comparer.compare(currentSong, genreList
                .getEntry(position)) > 0) {
                position++;
            }
            genreList.add(position, currentSong);
        }
        return genreList;
    }
}
