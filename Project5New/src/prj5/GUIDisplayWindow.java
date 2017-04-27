package prj5;

import java.awt.Color;
// import java.io.FileNotFoundException;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Ashlyn McDonald (mashlyn6)
 * @author Truman Heberle (trumanh)
 * @author Shivani Garg (shivanig)
 * @version 2017.04.26
 * 
 *          This class is the front end of this project. This
 *          class contains methods for displaying the data
 *          graphically and updating the window as various
 *          buttons are clicked by the user.
 */
public class GUIDisplayWindow {
    private Window window;
    private static final int ENTRY_STARTX = 120;
    private static final int ENTRY_STARTY = 45;
    private DoublyLinkedList<Person> people;
    private Button prev;
    private Button next;
    private Button artist;
    private Button title;
    private Button year;
    private Button genre;
    private Button hobby;
    private Button major;
    private Button region;
    private Button quit;
    private LinkedSongList<Song> songs;
    private Button representButton;
    private Button sortButton;
    private int numberOfEntries;
    private int startIndex;
    private int endIndex;


    /**
     * The constructor, which initializes the fields
     * and adds all of the buttons to the window
     */
    public GUIDisplayWindow(
        DoublyLinkedList<Person> personList,
        LinkedSongList<Song> songList) {
        window = new Window();
        window.setSize(800, 500);

        numberOfEntries = songList.size();
        startIndex = 0;

        prev = new Button("Prev");
        prev.setTitle("Prev");
        prev.onClick(this, "clickedPrev");
        next = new Button("Next");
        next.setTitle("Next");
        next.onClick(this, "clickedNext");
        artist = new Button("Sort by Artist Name");
        artist.setTitle("Sort by Artist Name");
        artist.onClick(this, "clickedArtist");
        title = new Button("Sort by Song Title");
        title.setTitle("Sort by Song Title");
        title.onClick(this, "clickedTitle");
        year = new Button("Sort by Release Year");
        year.setTitle("Sort by Release Year");
        year.onClick(this, "clickedYear");
        genre = new Button("Sort by Genre");
        genre.setTitle("Sort by Genre");
        genre.onClick(this, "clickedGenre");
        hobby = new Button("Represent Hobby");
        hobby.setTitle("Represent Hobby");
        hobby.onClick(this, "clickedHobby");
        major = new Button("Represent Major");
        major.setTitle("Represent Major");
        major.onClick(this, "clickedMajor");
        region = new Button("Represent Region");
        region.setTitle("Represent Region");
        region.onClick(this, "clickedRegion");
        quit = new Button("Quit");
        quit.setTitle("Quit");
        quit.onClick(this, "clickedQuit"); 

        representButton = hobby;
        sortButton = title;
        prev.disable();

        if (startIndex + 8 < numberOfEntries - 1) {
            endIndex = startIndex + 8;
        }
        else {
            endIndex = numberOfEntries - 1;
            next.disable();
        }

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(artist, WindowSide.NORTH);
        window.addButton(title, WindowSide.NORTH);
        window.addButton(year, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(region, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);

        songs = songList;
        people = personList;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Creates the nine glyphs on the screen
     * based on the buttons that have been clicked
     * 
     * @param begin
     *            the starting index for the songs
     * @param end
     *            the ending index for the songs
     * 
     */
    public void createGlyphs(int begin, int end) {
        LinkedSongList<Song> songList = null;

        if (sortButton == title) {
            songList = songs.sortByTitle();
        }
        else if (sortButton == artist) {
            songList = songs.sortByArtist();
        }
        else if (sortButton == genre) {
            songList = songs.sortByGenre();
        }
        else if (sortButton == year) {
            songList = songs.sortByYear();
        }

        Object[] songArray = songList.toArray();
        int xValue = ENTRY_STARTX;
        int yValue = ENTRY_STARTY;

        for (int i = startIndex; i <= endIndex; i++) {
            Song song = (Song)songArray[i];
            new Entry(xValue, yValue, song, representButton);
            xValue += 206;
            if ((i % 3) == 2) {
                xValue = ENTRY_STARTX;
            }
            if (i != startIndex && (i % 3) == 2) {
                yValue += 130;
            }
        }
    }


    /**
     * Creates the legend, based on which
     * representation the user selects
     */
    public void createLegend() {
        Shape box = new Shape(640, 180, 120, 180, Color.BLACK);
        box.setBackgroundColor(Color.WHITE);
        window.addShape(box);
        String title = "";
        String first = "";
        String second = "";
        String third = "";
        String fourth = "";

        if (representButton.equals(major)) {
            title = "Major Legend";
            first = "Comp Sci";
            second = "Other Eng";
            third = "Math/CMDA";
            fourth = "Other";
        }
        else if (representButton.equals(hobby)) {
            title = "Hobby Legend";
            first = "Read";
            second = "Art";
            third = "Sports";
            fourth = "Music";
        }
        else if (representButton.equals(region)) {
            title = "Region Legend";
            first = "Northeast US";
            second = "Southeast US";
            third = "Rest of US";
            fourth = "Outside US";
        }
        TextShape legendTitle = new TextShape(650, 190, title, Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendTitle);
        window.moveToFront(legendTitle);
        TextShape read = new TextShape(650, 210, first, Color.MAGENTA);
        read.setBackgroundColor(Color.WHITE);
        window.addShape(read);
        window.moveToFront(read);
        TextShape art = new TextShape(650, 230, second, Color.BLUE);
        art.setBackgroundColor(Color.WHITE);
        window.addShape(art);
        window.moveToFront(art);
        TextShape sports = new TextShape(650, 250, third, Color.ORANGE);
        sports.setBackgroundColor(Color.WHITE);
        window.addShape(sports);
        window.moveToFront(sports);
        TextShape music = new TextShape(650, 270, fourth, Color.GREEN);
        music.setBackgroundColor(Color.WHITE);
        window.addShape(music);
        window.moveToFront(music);
        TextShape songTitle = new TextShape(665, 290, "Song Title",
            Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);
        window.moveToFront(songTitle);
        Shape blackBox = new Shape(700, 310, 5, 44, Color.BLACK);
        window.addShape(blackBox);
        window.moveToFront(blackBox);
        TextShape heard = new TextShape(650, 325, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        window.moveToFront(heard);
        TextShape likes = new TextShape(710, 325, "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        window.moveToFront(likes);
    }


    /**
     * Updates the window to display
     * the previous nine songs when the "Prev"
     * button is clicked by the user
     * 
     * @param button
     *            the Prev button that was clicked
     */
    public void clickedPrev(Button button) {
        window.removeAllShapes();
        if (endIndex == numberOfEntries - 1) {
            endIndex = startIndex - 1;
        }
        else {
            endIndex -= 9;
        }
        if ((startIndex - 9) > 0) {
            startIndex -= 9;
        }
        else if ((startIndex - 9) == 0) {
            startIndex = 0;
            prev.disable();
        }
        next.enable();
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the next nine
     * songs when the "Next" button is clicked
     * by the user
     * 
     * @param button
     *            the Next button that was clicked
     */
    public void clickedNext(Button button) {
        window.removeAllShapes();
        startIndex += 9;
        if ((startIndex + 8) < numberOfEntries - 1) {
            endIndex = startIndex + 8;
        }
        else {
            endIndex = numberOfEntries - 1;
            next.disable();
        }
        prev.enable();
        createGlyphs(startIndex, endIndex);
        createLegend();

    }


    /**
     * Updates the window to display the songs,
     * sorted by Artist, when the "Sort by Artist
     * Name" button is clicked by the user
     * 
     * @param button
     *            the Sort by Artist Name button
     *            that was clicked
     */
    public void clickedArtist(Button button) {
        window.removeAllShapes();
        sortButton = artist;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the songs,
     * sorted by Title, when the "Sort by Song
     * Title" button is clicked by the user
     * 
     * @param button
     *            the Sort by Song Title button
     *            that was clicked
     */
    public void clickedTitle(Button button) {
        window.removeAllShapes();
        sortButton = title;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the songs,
     * sorted by Year, when the "Sort by Release
     * Year" button is clicked by the user
     * 
     * @param button
     *            the Sort by Release Year
     *            button that was clicked
     */
    public void clickedYear(Button button) {
        window.removeAllShapes();
        sortButton = year;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the songs,
     * sorted by Genre, when the "Sort by Genre"
     * button is clicked by the user
     * 
     * @param button
     *            the Sort by Genre button
     *            that was clicked
     */
    public void clickedGenre(Button button) {
        window.removeAllShapes();
        sortButton = genre;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the song
     * data based on the various hobbies when
     * the "Represent Hobby" button is clicked
     * by the user
     * 
     * @param button
     *            the Represent Hobby button
     *            that was clicked
     */
    public void clickedHobby(Button button) {
        window.removeAllShapes();
        representButton = hobby;
        createLegend();
        createGlyphs(startIndex, endIndex);
    }


    /**
     * Updates the window to display the song
     * data based on the various majors when
     * the "Represent Major" button is clicked
     * by the user
     * 
     * @param button
     *            the Represent Major button
     *            that was clicked
     */
    public void clickedMajor(Button button) {
        window.removeAllShapes();
        representButton = major;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Updates the window to display the song
     * data based on the various regions when
     * the "Represent Region" button is clicked
     * by the user
     * 
     * @param button
     *            the Represent Region button
     *            that was clicked
     */
    public void clickedRegion(Button button) {
        window.removeAllShapes();
        representButton = region;
        createGlyphs(startIndex, endIndex);
        createLegend();
    }


    /**
     * Exits the program when the "Quit" button
     * is clicked by the user
     * 
     * @param button
     *            the Quit button that
     *            was clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * 
     * @author Ashlyn McDonald (mashlyn6)
     * @author Truman Heberle (trumanh)
     * @author Shivani Garg (shivanig)
     * @version 2017.04.26
     * 
     *          This inner class represents an individual
     *          song, displayed visually in the window. The
     *          bar lengths are based on the survey data.
     * 
     */
    private class Entry {

        /**
         * The constructor, which creates
         * shapes to represent different data
         * that is associated with a particular
         * song and the survey results.
         * 
         * @param xValue
         *            the x value where the glyph
         *            should be displayed
         * @param yValue
         *            the y value where the glyph
         *            should be displayed
         * @param song
         *            the song to be represented
         *            visually
         * @param button
         *            the button that was clicked,
         *            which determines which data set to portray
         * 
         */
        public Entry(int xValue, int yValue, Song song, Button button) {
            Shape line = new Shape(xValue, yValue, 8, 48, Color.BLACK);
            window.addShape(line);
            TextShape title = new TextShape(xValue, yValue - 35, song.getTitle()
                .toString(), Color.BLACK);
            title.setX(xValue - title.getWidth() / 2);
            title.setBackgroundColor(Color.WHITE);
            window.addShape(title);
            TextShape artist = new TextShape(xValue, yValue - 20, song
                .getArtist().toString(), Color.BLACK);
            artist.setX(xValue - artist.getWidth() / 2);
            artist.setBackgroundColor(Color.WHITE);
            window.addShape(artist);

            Shape leftPink = null;
            Shape rightPink = null;
            Shape leftBlue = null;
            Shape rightBlue = null;
            Shape leftOrange = null;
            Shape rightOrange = null;
            Shape leftGreen = null;
            Shape rightGreen = null;
            if (button.equals(major)) {
                leftPink = new Shape(xValue - song.getMajorScore(
                    MajorEnum.COMPUTER_SCIENCE, people)[0], yValue, song
                        .getMajorScore(MajorEnum.COMPUTER_SCIENCE, people)[0],
                    12, Color.MAGENTA);
                rightPink = new Shape(xValue + 8, yValue, song.getMajorScore(
                    MajorEnum.COMPUTER_SCIENCE, people)[1], 12, Color.MAGENTA);
                leftBlue = new Shape(xValue - song.getMajorScore(
                    MajorEnum.OTHER_ENGINEERING, people)[0], yValue + 12, song
                        .getMajorScore(MajorEnum.OTHER_ENGINEERING, people)[0],
                    12, Color.BLUE);
                rightBlue = new Shape(xValue + 8, yValue + 12, song
                    .getMajorScore(MajorEnum.OTHER_ENGINEERING, people)[1], 12,
                    Color.BLUE);
                leftOrange = new Shape(xValue - song.getMajorScore(
                    MajorEnum.MATH_CMDA, people)[0], yValue + 24, song
                        .getMajorScore(MajorEnum.MATH_CMDA, people)[0], 12,
                    Color.ORANGE);
                rightOrange = new Shape(xValue + 8, yValue + 24, song
                    .getMajorScore(MajorEnum.MATH_CMDA, people)[1], 12,
                    Color.ORANGE);
                leftGreen = new Shape(xValue - song.getMajorScore(
                    MajorEnum.OTHER, people)[0], yValue + 36, song
                        .getMajorScore(MajorEnum.OTHER, people)[0], 12,
                    Color.GREEN);
                rightGreen = new Shape(xValue + 8, yValue + 36, song
                    .getMajorScore(MajorEnum.OTHER, people)[1], 12,
                    Color.GREEN);
            }
            else if (button.equals(hobby)) {
                leftPink = new Shape(xValue - song.getHobbyScore(HobbyEnum.READ,
                    people)[0], yValue, song.getHobbyScore(HobbyEnum.READ,
                        people)[0], 12, Color.MAGENTA);
                rightPink = new Shape(xValue + 8, yValue, song.getHobbyScore(
                    HobbyEnum.READ, people)[1], 12, Color.MAGENTA);
                leftBlue = new Shape(xValue - song.getHobbyScore(HobbyEnum.ART,
                    people)[0], yValue + 12, song.getHobbyScore(HobbyEnum.ART,
                        people)[0], 12, Color.BLUE);
                rightBlue = new Shape(xValue + 8, yValue + 12, song
                    .getHobbyScore(HobbyEnum.ART, people)[1], 12, Color.BLUE);
                leftOrange = new Shape(xValue - song.getHobbyScore(
                    HobbyEnum.SPORTS, people)[0], yValue + 24, song
                        .getHobbyScore(HobbyEnum.SPORTS, people)[0], 12,
                    Color.ORANGE);
                rightOrange = new Shape(xValue + 8, yValue + 24, song
                    .getHobbyScore(HobbyEnum.SPORTS, people)[1], 12,
                    Color.ORANGE);
                leftGreen = new Shape(xValue - song.getHobbyScore(
                    HobbyEnum.MUSIC, people)[0], yValue + 36, song
                        .getHobbyScore(HobbyEnum.MUSIC, people)[0], 12,
                    Color.GREEN);
                rightGreen = new Shape(xValue + 8, yValue + 36, song
                    .getHobbyScore(HobbyEnum.MUSIC, people)[1], 12,
                    Color.GREEN);
            }
            else if (button.equals(region)) {
                leftPink = new Shape(xValue - song.getRegionScore(
                    RegionEnum.NORTH_EAST_US, people)[0], yValue, song
                        .getRegionScore(RegionEnum.NORTH_EAST_US, people)[0],
                    12, Color.MAGENTA);
                rightPink = new Shape(xValue + 8, yValue, song.getRegionScore(
                    RegionEnum.NORTH_EAST_US, people)[1], 12, Color.MAGENTA);
                leftBlue = new Shape(xValue - song.getRegionScore(
                    RegionEnum.SOUTH_EAST_US, people)[0], yValue + 12, song
                        .getRegionScore(RegionEnum.SOUTH_EAST_US, people)[0],
                    12, Color.BLUE);
                rightBlue = new Shape(xValue + 8, yValue + 12, song
                    .getRegionScore(RegionEnum.SOUTH_EAST_US, people)[1], 12,
                    Color.BLUE);
                leftOrange = new Shape(xValue - song.getRegionScore(
                    RegionEnum.OTHER_US, people)[0], yValue + 24, song
                        .getRegionScore(RegionEnum.OTHER_US, people)[0], 12,
                    Color.ORANGE);
                rightOrange = new Shape(xValue + 8, yValue + 24, song
                    .getRegionScore(RegionEnum.OTHER_US, people)[1], 12,
                    Color.ORANGE);
                leftGreen = new Shape(xValue - song.getRegionScore(
                    RegionEnum.OUTSIDE_US, people)[0], yValue + 36, song
                        .getRegionScore(RegionEnum.OUTSIDE_US, people)[0], 12,
                    Color.GREEN);
                rightGreen = new Shape(xValue + 8, yValue + 36, song
                    .getRegionScore(RegionEnum.OUTSIDE_US, people)[1], 12,
                    Color.GREEN);
            }
            window.addShape(leftPink);
            window.addShape(rightPink);
            window.addShape(leftBlue);
            window.addShape(rightBlue);
            window.addShape(leftOrange);
            window.addShape(rightOrange);
            window.addShape(leftGreen);
            window.addShape(rightGreen);
        }
    }

}
