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
        if (this.isEmpty()) {
            return Optional.empty();
        }
        
        if (this.listHead >= this.size()) {
            this.listHead = LIST_FIRST_INDEX;
        }
        
        final Optional<Integer> next = Optional.of(this.list.get(this.listHead));
        this.listHead = this.listHead + 1;
        return next;
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        this.listHead = this.listHead - 1;
        if (this.listHead < 0) {
            this.listHead = this.size() - 1;
        }
        return Optional.of(this.list.get(this.listHead));
    }

    @Override
    public void reset() {
        this.listHead = LIST_FIRST_INDEX;
    }

}
