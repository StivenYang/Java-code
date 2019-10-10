package top.hengshare.interview.pattern.abstractFactory.struct;

public class Client {
    public static void main(String[] args) {
        AbstractFactory af = new ConcreteFactory1();
        af.createProductA();
        af.createProductB();
    }
}
