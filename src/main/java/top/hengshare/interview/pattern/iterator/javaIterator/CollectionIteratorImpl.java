package top.hengshare.interview.pattern.iterator.javaIterator;

import java.util.Iterator;

public class CollectionIteratorImpl implements Iterator {

    private PayManager payManager;

    private int index = 0;

    public CollectionIteratorImpl(PayManager payManager) {
        this.payManager = payManager;
    }

    @Override
    public boolean hasNext() {
        if (index < payManager.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (hasNext()) {
            obj = payManager.get(index);
            index++;
        }
        return obj;
    }
}
