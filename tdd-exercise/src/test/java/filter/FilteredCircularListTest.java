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
        assertEquals(5, next.get());
    }

    @Test
    void getNextValueTwoTimes() {
        this.list.add(10);
        this.list.add(4);
        this.list.add(7);
        this.list.filteredNext(element -> element >= 5);
        Optional<Integer> next = this.list.filteredNext(element -> element >= 5);
        assertTrue(next.isPresent());
        assertEquals(7, next.get());
    }

    @Test
    void filterConditionNotSatisfied() {
        final int numberOfItems = 10;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }
        Optional<Integer> next = this.list.filteredNext(element -> element < -1);
        assertFalse(next.isPresent());
    }

    @Test
    void getNextValueCircularly() {
        final int numberOfItems = 3;
        for (int i = 2; i < numberOfItems + 2; i++) {
            this.list.add(i);
        }
        this.list.filteredNext(element -> element % 2 == 0);
        this.list.filteredNext(element -> element % 2 == 0);
        Optional<Integer> next = this.list.filteredNext(element -> element % 2 == 0);
        assertTrue(next.isPresent());
        assertEquals(2, next.get());
    }

    @Test
    void getNextValueWithMixedFilters() {
        final int numberOfItems = 10;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }
        this.list.filteredNext(element -> element >= 5);
        this.list.filteredNext(element -> element >= 5);
        this.list.filteredNext(element -> element < 3);
        final Optional<Integer> next = this.list.filteredNext(element -> element < 3);
        assertTrue(next.isPresent());
        assertEquals(1, next.get());
    }

    @Test
    void getNextValueWithMixedFiltersWhichIntersect() {
        final int numberOfItems = 10;
        for (int i = 0; i < numberOfItems; i++) {
            this.list.add(i);
        }
        this.list.filteredNext(element -> element % 2 == 0);
        this.list.filteredNext(element -> element % 2 != 0);
        this.list.filteredNext(element -> element % 2 != 0);
        final Optional<Integer> next = this.list.filteredNext(element -> element % 2 == 0);
        assertTrue(next.isPresent());
        assertEquals(4, next.get());
    }
}
