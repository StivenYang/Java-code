package top.hengshare.interview.pattern.visitor.composite;

import lombok.Setter;

/**
 * @program: Java-Interview
 * @description: ObjectStructure
 * @author: StivenYang
 * @create: 2019-11-05 16:19
 **/
public class ObjectStructure {

    @Setter
    private Component root = null;

    public void handleRequest(Visitor visitor){
        if (root != null) {
            root.accept(visitor);
        }
    }


}
