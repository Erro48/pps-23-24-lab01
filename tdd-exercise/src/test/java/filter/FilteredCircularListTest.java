package filter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FilteredCircularListTest {
    
    @Test
    void initialize() {
        FilteredCircularList list = new SimpleFilteredCircularList();
        assertTrue(list.isEmpty());
    }
}
