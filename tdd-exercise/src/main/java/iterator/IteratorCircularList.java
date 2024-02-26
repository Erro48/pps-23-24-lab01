package iterator;

import java.util.Iterator;

public interface IteratorCircularList {

    
    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Return an iterator which yields next elements, circularly
     * @return a new iterator
     */
    Iterator forwardIterator();

    /**
     * Return an iterator which yields previous elements, circularly
     * @return a new iterator
     */
    Iterator backwardIterator();
}
