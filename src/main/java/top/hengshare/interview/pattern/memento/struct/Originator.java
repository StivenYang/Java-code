package top.hengshare.interview.pattern.memento.struct;

/**
 * @program: Java-Interview
 * @description: 源发器对象
 * @author: Steven Yang
 * @create: 2019-10-18 18:48
 **/
public class Originator {

    private String state = "";

    public Memento createMemento() {
        return new MementoImpl(state);
    }

    public void setMemento(Memento memento){
        MementoImpl mementoImpl = (MementoImpl) memento;
        this.state = mementoImpl.getState();
    }

    private static class MementoImpl implements Memento{
        private String state = "";

        public MementoImpl(String state) {
            this.state = state;
        }

        public String getState(){
            return state;
        }
    }
}
