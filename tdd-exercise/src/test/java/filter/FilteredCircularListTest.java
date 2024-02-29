package filter;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
