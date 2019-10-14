package top.hengshare.interview.pattern.iterator.iterExample;

public class CollectionIteratorImpl implements Iterator {

    private PayManager payManager;

    private int index = -1;

    public CollectionIteratorImpl(PayManager payManager) {
        this.payManager = payManager;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < payManager.size()){
            index = index +1;
        }
    }

    @Override
    public boolean isDone() {
        if (index == payManager.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object currentItem() {
        return payManager.get(index);
    }
}
