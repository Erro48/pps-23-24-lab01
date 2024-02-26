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
    public Iterator backwardIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator forwardIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
