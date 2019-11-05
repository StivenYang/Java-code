package top.hengshare.interview.pattern.visitor.composite;

import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: Leaf
 * @author: StivenYang
 * @create: 2019-11-05 16:16
 **/
public class Leaf extends Component {
    @Getter
    private String name = "";

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLeaf(this);
    }

    public Leaf(String name) {
        this.name = name;
    }
}
