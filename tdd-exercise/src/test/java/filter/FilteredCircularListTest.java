package filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilteredCircularListTest {

    FilteredCircularList list;

    @BeforeEach
    void beforeEach() {
        list = new SimpleFilteredCircularList();
    }
    
    @Test
    void initialize() {
        assertTrue(list.isEmpty());
    }

    @Test
    void addElement() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void addMultipleElements() {
        final int numberOfItems = 10;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }
        assertEquals(numberOfItems, this.list.size());
    }

    @Test
    void getNextValue() {
        final int numberOfItems = 10;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }
        Optional<Integer> next = this.list.filteredNext(element -> element >= 5);
        assertTrue(next.isPresent());
        assertEquals(next.get(), 5);
    }

    @Test
    void getNextValueTwoTimes() {
        this.list.add(10);
        this.list.add(4);
        this.list.add(7);
        this.list.filteredNext(element -> element >= 5);
        Optional<Integer> next = this.list.filteredNext(element -> element >= 5);
        assertTrue(next.isPresent());
        assertEquals(next.get(), 7);
    }
}
