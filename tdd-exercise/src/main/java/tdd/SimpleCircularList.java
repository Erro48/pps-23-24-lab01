package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> list;

    public SimpleCircularList() {
        this.list = new ArrayList<Integer>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
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

    @Override
    public Optional<Integer> next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
