package iterator;

import java.util.Iterator;

import tdd.CircularList;
import tdd.SimpleCircularList;

public class SimpleIteratorCircularList implements IteratorCircularList {

    final private CircularList list;

    public SimpleIteratorCircularList() {
        this.list = new SimpleCircularList();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                return list.previous().get();
            }
            
        };
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                return list.next().get();
            }

        };
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.size();
    }

}
