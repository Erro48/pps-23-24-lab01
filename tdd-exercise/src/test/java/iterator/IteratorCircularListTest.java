package iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorCircularListTest {

    private IteratorCircularList list;

    @BeforeEach
    void beforeEach() {
        list = new SimpleIteratorCircularList();
    }
    
    @Test
    void initializeList() {
        assertTrue(list.isEmpty());
    }
}
