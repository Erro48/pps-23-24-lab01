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
    public Optional<Integer> filteredNext(Predicate<Integer> p) {
        int listPointer = 0;
        while (listPointer < this.list.size()) {
            final Optional<Integer> next = this.list.next();
            if (next.isPresent() && p.test(next.get())) {
                return next;
            }

            listPointer = listPointer + 1;
        }

        return Optional.empty();
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

}
