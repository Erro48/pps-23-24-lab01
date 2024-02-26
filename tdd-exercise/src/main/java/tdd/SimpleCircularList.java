package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private static final int LIST_FIRST_INDEX = 0;
    private final List<Integer> list;
    private int listHead = LIST_FIRST_INDEX;

    public SimpleCircularList() {
        this.list = new ArrayList<Integer>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (listHead >= this.size()) {
            listHead = LIST_FIRST_INDEX;
        }
        final Optional<Integer> opt = Optional.of(this.list.get(listHead));
        listHead = listHead + 1;
        return opt;
    }

    @Override
    public Optional<Integer> previous() {
        listHead = listHead - 1;
        if (listHead < 0) {
            listHead = this.size() - 1;
        }
        return Optional.of(this.list.get(listHead));
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
