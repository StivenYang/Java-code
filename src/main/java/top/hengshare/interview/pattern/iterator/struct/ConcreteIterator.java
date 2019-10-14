package top.hengshare.interview.pattern.iterator.struct;

/**
 * 具体的迭代器实现对象
 */
public class ConcreteIterator implements Iterator {

    private ConcreteAggregate concreteAggregate;

    private int index = -1;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < this.concreteAggregate.size()) {
            index = index + 1;
        }
    }

    @Override
    public boolean isDone() {
        if (index == this.concreteAggregate.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object currentItem() {
        return this.concreteAggregate.get(index);
    }
}
