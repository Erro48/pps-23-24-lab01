package iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorCircularListTest {

    private IteratorCircularList list;

    @BeforeEach
    void beforeEach() {
        this.list = new SimpleIteratorCircularList();
    }
    
    @Test
    void initializeList() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void addElement() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void addMultipleElements() {
        final int itemsToAdd = 10;
        for (int i = 0; i < itemsToAdd; i++) {
            this.list.add(i);
        }
        assertEquals(itemsToAdd, this.list.size());
    }

    @Test
    void getNextValue() {
        this.list.add(0);
        var iterator = this.list.forwardIterator();
        assertTrue(iterator.hasNext());
        var next = iterator.next();
        assertTrue(next.equals(0));
    }

    @Test
    void checkCircularityOfTheList() {
        final int numberOfItems = 10;
        final int numberOfCicles = 13;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }

        final var forwardIterator = this.list.forwardIterator();

        for (int i = 0; i < numberOfCicles; i++) {
            if (forwardIterator.hasNext()) {
                forwardIterator.next();
            }
        }

        final int next = forwardIterator.next();
        assertEquals(3, next);
    }

    @Test
    void getPreviousValue() {
        this.list.add(0);
        var iterator = this.list.backwardIterator();
        assertTrue(iterator.hasNext());
        var previous = iterator.next();
        assertTrue(previous.equals(0));
    }
}
