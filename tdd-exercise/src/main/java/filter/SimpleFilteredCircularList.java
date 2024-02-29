package filter;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularList;
import tdd.SimpleCircularList;

public class SimpleFilteredCircularList implements FilteredCircularList {

    private final CircularList list;

    public SimpleFilteredCircularList() {
        this.list = new SimpleCircularList();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Boolean> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filteredNext'");
    }

    @Override
    public void add(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
