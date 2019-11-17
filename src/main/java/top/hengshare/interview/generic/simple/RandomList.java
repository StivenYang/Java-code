package top.hengshare.interview.generic.simple;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: Java-Interview
 * @description: RandomList
 * @author: StivenYang
 * @create: 2019-11-17 12:35
 **/
public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("the quick brown fox jumped over the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(rs.select() + "");
        }
    }
}
