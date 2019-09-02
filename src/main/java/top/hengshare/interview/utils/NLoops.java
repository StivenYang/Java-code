package top.hengshare.interview.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/8
 * @description:
 */
public class NLoops {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String[] arg = str.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arg.length; i++) {
            try {
                Integer n = Integer.valueOf(arg[i]);
                list.add(n);
            } catch (Exception e) {
                System.out.println("参数转换失败，请输入正确的参数[0-9]");
            }
        }
        int size = list.size();
        System.out.println(list.size());
    }

    private void fun(int length, int n) {
        if (length == 0) {
            return;
        }
        System.out.println(n);
    }
}
