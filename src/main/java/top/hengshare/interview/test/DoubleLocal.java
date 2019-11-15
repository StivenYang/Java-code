package top.hengshare.interview.test;

/**
 * @program: Java-Interview
 * @description: DoubleLocal
 * @author: StivenYang
 * @create: 2019-11-15 08:44
 **/
public class DoubleLocal {
    private static volatile Object instance = null;

    private DoubleLocal() {
    }

    public static Object getInstance(){
        if (instance == null) {
            synchronized (Object.class){
                if (instance == null) {
                    instance = new Object();
                }
            }
        }

        return instance;
    }
}

interface Stratege{
    void operation();
}

class context{
    private Stratege stratege;

    public context(Stratege stratege) {
        this.stratege = stratege;
    }

    public void operation(){
        stratege.operation();
    }
}

class ConcreteStratege1 implements Stratege{

    @Override
    public void operation() {
        //todo
    }
}