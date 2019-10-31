package top.hengshare.interview.pattern.decorator.aop;

/**
 * @program: Java-Interview
 * @description: Decorator
 * @author: StivenYang
 * @create: 2019-10-31 20:12
 **/
public abstract class Decorator implements GoodsSaleEbi {

    /**
     * 持有被装饰的对象
     */
    protected GoodsSaleEbi ebi;

    public Decorator(GoodsSaleEbi ebi) {
        this.ebi = ebi;
    }
}
