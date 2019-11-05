package top.hengshare.interview.pattern.visitor.composite;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: Composite
 * @author: StivenYang
 * @create: 2019-11-05 16:12
 **/
public class Composite extends Component {

    private List<Component> childComponents = Lists.newArrayList();

    @Override
    public void accept(Visitor visitor) {
        //回调访问者的方法
        visitor.visitComposite(this);
        //循环子元素，让子元素也接受访问
//        for (Component childComponent : childComponents) {
//            //调用子元素的访问者回调方法，变相实现递归
//            childComponent.accept(visitor);
//        }
    }

    @Getter
    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child) {
        this.childComponents.add(child);
    }

    public List<Component> getChildComponents() {
        return childComponents;
    }
}
