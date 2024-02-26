import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.SimpleCircularList;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList list;

    @BeforeEach
    void beforeEach() {
        this.list = new SimpleCircularList();
    }

    @Test
    void initializeEmptyList() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void addElement() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void addMultipleElements() {
        int itemsToAdd = 10;
        for (int i = 0; i < itemsToAdd; i++) {
            this.list.add(i);
        }
        assertEquals(itemsToAdd, this.list.size());
    }

    @Test
    void getNextValue() {
        this.list.add(0);
        var next = this.list.next();
        assertTrue(next.isPresent());
        assertEquals(0, next.get());
    }

    @Test
    void getNextValues() {
        final int itemsToAdd = 10;
        for (int i = 0; i < itemsToAdd; i++) {
            this.list.add(i);
        }

        this.list.next();
        this.list.next();
        this.list.next();
        var next = this.list.next();

        assertTrue(next.isPresent());
        assertEquals(3, next.get());
    }

    @Test
    void getFirstElementAfterGettingLastOne() {
        this.list.add(0);
        this.list.add(1);
        this.list.next();
        this.list.next();
        var next = this.list.next();
        assertTrue(next.isPresent());
        assertEquals(0, next.get());
    }
}
