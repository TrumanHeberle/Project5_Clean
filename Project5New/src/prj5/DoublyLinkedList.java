package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
 *            chain of Nodes that store data and can
 *            traverse the chain and create sublists.
 *            This class has two sentinel nodes that mark the
 *            beginning and end of the chain.
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private int size;
    private Node head;
    private Node tail;


    /**
     * The constructor, which creates a new DoublyLinkedList
     * and initializes the fields
     */
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrevious(head);
    }


    /**
     * A constructor with a boolean parameter to
     * prevent StackOverflowErrors when creating a Node
     * 
     * @param bool
     *            any boolean value
     */
    private DoublyLinkedList(boolean bool) {
    }


    /**
     * Returns the size of the DoublyLinkedList
     * 
     * @return The size of the DoublyLinkedList
     */
    public int size() {
        return size;
    }


    /**
     * Returns a list that only contains people
     * that have the specified major
     * 
     * @return the list of people with the specified major
     * @param major
     *            the MajorEnum representing the desired major
     */
    public DoublyLinkedList<Person> getChosenMajorList(MajorEnum major) {
        DoublyLinkedList<Person> result = new DoublyLinkedList<Person>();
        for (T person : this) {
            if (((Person)person).getMajor().equals(major)) {
                result.addToBack((Person)person);
            }
        }
        return result;
    }


    /**
     * Returns a list that only contains people
     * that have the specified hobby
     * 
     * @return the list of people with the specified hobby
     * @param hobby
     *            the HobbyEnum representing the desired hobby
     */
    public DoublyLinkedList<Person> getChosenHobbyList(HobbyEnum hobby) {
        DoublyLinkedList<Person> result = new DoublyLinkedList<Person>();
        for (T person : this) {
            if (((Person)person).getHobby().equals(hobby)) {
                result.addToBack((Person)person);
            }
        }
        return result;
    }


    /**
     * Returns a list that only contains people
     * that are from the specified region
     * 
     * @return the list of people from the specified region
     * @param region
     *            the RegionEnum representing the desired region
     */
    public DoublyLinkedList<Person> getChosenRegionList(RegionEnum region) {
        DoublyLinkedList<Person> result = new DoublyLinkedList<Person>();
        for (T person : this) {
            if (((Person)person).getRegion().equals(region)) {
                result.addToBack((Person)person);
            }
        }

        return result;
    }


    /**
     * Creates a new Node with data and adds it to the back
     * of the DoublyLinkedList
     * 
     * @param data
     *            The data to be stored
     */
    public void addToBack(T data) {
        Node newNode = new Node(data);
        newNode.addAfter(tail.previous());
        size++;
    }


    /**
     * Creates a new Node with data and adds it at
     * a certain position in the DoublyLinkedList
     * 
     * @param index
     *            The position to add the Node to
     * @param data
     *            The data to be stored
     * @throws IndexOutOfBoundsException
     *             If the index is not valid
     */
    public void add(int index, T data) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        Node newNode = new Node(data);
        newNode.addAfter(curr);
        size++;
    }


    /**
     * Returns the data contained in the first Node
     * 
     * @return The data of the first Node
     */
    public T getFront() {
        return head.next().data();
    }


    /**
     * Returns the data of the last Node
     * 
     * @return The data of the last Node
     */
    public T getBack() {
        return tail.previous().data();
    }


    /**
     * Returns the data of a specified Node
     * 
     * @param index
     *            The Node's index
     * @return The Node's data
     * @throws IndexOutOfBoundsException
     *             If the index is invalid
     */
    public T getEntry(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
        Node curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr.data();
    }


    /**
     * Checks whether or not data is contained in the list
     * 
     * @param data
     *            The data to check for
     * @return Whether a Node in the list contains the data
     */
    public boolean contains(T data) {
        Node curr = head.next();
        while (curr != tail) {
            if (curr.data().equals(data)) {
                return true;
            }
            curr = curr.next();
        }
        return false;
    }


    /**
     * Returns the iterator being used for the
     * current list
     * 
     * @return the ListIterator
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    /**
     * Returns an object array of all the data in the list
     * 
     * @return The object array of all the data in the list
     */
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        if (size != 0) {
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.getEntry(i);
            }
        }
        return arr;
    }


    /**
     * This inner class represents the Node
     * that is used in the DoublyLinkedList
     * and the data that is stored within it.
     * 
     * @author Ashlyn McDonald (mashlyn6)
     * @author Truman Heberle (trumanh)
     * @author Shivani Garg (shivanig)
     * @version 2017.04.26
     * @param <T>
     *            The generic type, which provides
     *            the ability to use many different data types
     *            for this class
     */
    private class Node extends DoublyLinkedList<T> {

        private T data;
        private Node next;
        private Node prev;


        /**
         * Creates a new Node and initializes the
         * fields
         * 
         * @param nodeData
         *            The data to store in the Node
         */
        public Node(T nodeData) {
            super(false);
            this.setData(nodeData);
            next = null;
            prev = null;
        }


        /**
         * Sets the next Node that the
         * current Node should reference
         * 
         * @param nextNode
         *            The next Node
         */
        public void setNext(Node nextNode) {
            next = nextNode;
        }


        /**
         * Sets the previous Node that
         * the current Node should reference
         * 
         * @param prevNode
         *            The previous Node
         */
        public void setPrevious(Node prevNode) {
            prev = prevNode;
        }


        /**
         * Returns the next Node
         * that the current Node references
         * 
         * @return The next Node
         */
        public Node next() {
            return next;
        }


        /**
         * Returns the previous Node
         * that the current Node references
         * 
         * @return The previous Node
         */
        public Node previous() {
            return prev;
        }


        /**
         * Sets the data inside of the Node
         * 
         * @param nodeData
         *            The data inside the Node
         */
        public void setData(T nodeData) {
            data = nodeData;
        }


        /**
         * Returns the data stored inside the Node
         * 
         * @return The data inside the Node
         */
        public T data() {
            return data;
        }


        /**
         * Adds this Node to a chain after a specified Node
         * 
         * @param currentNode
         *            the specified Node of which this
         *            Node should then come after
         */
        public void addAfter(Node currentNode) {
            this.setNext(currentNode.next());
            currentNode.next().setPrevious(this);
            currentNode.setNext(this);
            this.setPrevious(currentNode);
        }
    }


    /**
     * This inner class allows iteration
     * through the DoublyLinkedList.
     * 
     * @author Ashlyn McDonald (mashlyn6)
     * @author Truman Heberle (trumanh)
     * @author Shivani Garg (shivanig)
     * @version 2017.04.26
     * @param <T>
     *            The generic type, which provides
     *            the ability to use many different data types
     *            for this class
     */
    private class ListIterator extends DoublyLinkedList<T>
        implements Iterator<T> {
        private Node curr;


        /**
         * Creates a new Iterator and
         * initializes the field
         */
        public ListIterator() {
            curr = head;
        }


        /**
         * checks to see if the list has
         * another Node
         * 
         * @return true if there is another node,
         *         false if not
         */
        @Override
        public boolean hasNext() {
            return curr.next() != tail;
        }


        /**
         * moves to the next Node
         * 
         * @return the next Node in the list
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException(
                    "No more elements to progress");
            }
            curr = curr.next();
            return curr.data();
        }

    }
}
