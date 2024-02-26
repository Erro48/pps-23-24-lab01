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
}
