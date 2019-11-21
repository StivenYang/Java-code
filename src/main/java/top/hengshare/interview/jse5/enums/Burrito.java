package top.hengshare.interview.jse5.enums;

/**
 * @program: Java-Interview
 * @description: Burrito
 * @author: StivenYang
 * @create: 2019-11-21 16:05
 **/
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(Spiciness.NOT));
        System.out.println(new Burrito(Spiciness.MEDIUM));
        System.out.println(new Burrito(Spiciness.HOT));
    }
}
