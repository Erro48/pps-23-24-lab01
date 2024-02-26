package iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IteratorCircularListTest {
    
    @Test
    void initializeList() {
        IteratorCircularList list = new SimpleIteratorCircularList();
        assertTrue(list.isEmpty());
    }
}
