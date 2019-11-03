package top.hengshare.interview.pattern.visitor.example1;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: ObjectStructure
 * @author: StivenYang
 * @create: 2019-11-03 19:39
 **/
public class ObjectStructure {

    /**
     * 要操作的客户集合
     */
    private Collection<Customer> col = Lists.newArrayList();

    /**
     * 请求处理器
     * @param visitor 访问者
     */
    public void handleRequest(Visitor visitor){
        for (Customer customer : col) {
            customer.accept(visitor);
        }
    }

    public void addElement(Customer element){
        this.col.add(element);
    }
}
