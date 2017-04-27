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
 *          This class scans a file of people
 *          and their survey responses and then
 *          creates a list of the people to be used
 *          in other aspects of this project.
 */
public class PersonScanner {
    private DoublyLinkedList<Person> peopleList;


    /**
     * the scanner constructor, which initializes
     * the DoublyLinkedList of people
     */
    public PersonScanner() {
        peopleList = new DoublyLinkedList<Person>();
    }


    /**
     * the constructor with a parameter, which
     * creates a new scanner out of the file and initializes
     * the field
     * 
     * @param fileName
     *            the name of the file
     * @throws FileNotFoundException
     *             if the file is invalid
     */
    public PersonScanner(String fileName) throws FileNotFoundException {
        peopleList = new DoublyLinkedList<Person>();
        scanPeople(fileName);
    }


    /**
     * scans the file of people and adds them
     * to the list that was created as a field
     * 
     * @param fileName
     *            the file name
     * @return the list of people created from the file
     * @throws FileNotFoundException
     *             if the file is invalid
     */
    public DoublyLinkedList<Person> scanPeople(String fileName)
        throws FileNotFoundException {
        try {
            Scanner scan = new Scanner(new File(fileName));
            scan.nextLine();
            scan.nextLine();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.endsWith(",")) {
                    line = line + "n/a";
                }
                String[] values = line.split(" *, *");
                Person person = new Person();
                person.setId(Integer.parseInt(values[0]));
                person.setDate(values[1]);
                if (values[2].contains("CMDA") || values[2].contains("Computer")
                    || values[2].contains("Engineering") || values[2].contains(
                        "Other")) {
                    person.setMajor(values[2]);
                }
                else {
                    person = null;
                }
                if (values[3].contains("Southeast") || values[3].contains(
                    "Northeast") || values[3].contains("Outside")) {
                    person.setRegion(values[3]);
                }
                else {
                    person = null;
                }
                if (values[4].contains("sports") || values[4].contains("music")
                    || values[4].contains("art") || values[4].contains(
                        "read")) {
                    person.setHobby(values[4]);
                }
                else {
                    person = null;
                }
                String[] answers = new String[values.length - 5];
                for (int i = 0; i <= values.length - 6; i++) {
                    answers[i] = values[i + 5];
                    if (answers[i].equals("")) {
                        answers[i] = "n/a";
                    }
                }
                if (person != null) {
                    person.setAnswers(answers);
                    peopleList.addToBack(person);
                }

            }

            scan.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        return peopleList;
    }


    /**
     * returns the list of people
     * 
     * @return the list of people
     */
    public DoublyLinkedList<Person> getPeopleList() {
        return peopleList;
    }
}
