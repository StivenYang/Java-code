package top.hengshare.interview.generic.simple.method;

import java.util.*;

/**
 * @program: Java-Interview
 * @description: 杠杆利用类型参数推断
 * @author: StivenYang
 * @create: 2019-11-17 15:59
 **/
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> list = New.list();
        LinkedList<String> linkedList = New.linkedList();
        Set<String> set = New.set();
        Queue<String> queue = New.queue();
    }
}
