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
    void testInitializeEmptyList() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testAddElement() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void testAddMultipleElements() {
        int itemsToAdd = 10;
        for (int i = 0; i < itemsToAdd; i++) {
            this.list.add(i);
        }
        assertEquals(itemsToAdd, this.list.size());
    }

}
