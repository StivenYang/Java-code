package top.hengshare.interview.pattern.memento.struct;

/**
 * 负责保存备忘录的对象
 * 可以保存备忘录的对象，但是却不能
 */
public class Caretaker {

    /**
     * 记录被保存的备忘录对象
     */
    private Memento memento;

    /**
     * 保存备忘录对象
     * @param memento 备忘录对象
     */
    public void saveMemento(Memento memento){
        this.memento = memento;
    }

    /**
     * 获取被保存的备忘录对象
     * @return 备忘录对象
     */
    public Memento retriveMemento(){
        return this.memento;
    }
}
