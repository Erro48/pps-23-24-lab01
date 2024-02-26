import static org.junit.jupiter.api.Assertions.assertAll;
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

}
