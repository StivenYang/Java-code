package top.hengshare.interview.pattern.templateMethod.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Java-Interview
 * @description: 测试使用到模板方法的comparator
 * @author: Steven Yang
 * @create: 2019-10-15 19:08
 **/
public class Client {
    public static void main(String[] args) {
        //准备测试数据
        UserModel u1 = new UserModel("u1", "user1", 25);
        UserModel u2 = new UserModel("u2", "user2", 28);
        UserModel u3 = new UserModel("u3", "user3", 25);
        UserModel u4 = new UserModel("u4", "user4", 29);
        UserModel u5 = new UserModel("u5", "user5", 27);

        //添加到列表中
        List<UserModel> list = Lists.newArrayList();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);

        //对列表进行排序
        list.sort(new Comparator<UserModel>() {
            @Override
            public int compare(UserModel o1, UserModel o2) {
                //按照年龄升序排列
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() == o2.getAge()) {
                    return 0;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        });
        //list.stream().forEach(System.out::println);

//        list.stream().sorted((o1, o2) -> o1.getAge() > o2.getAge() ? 1: -1).forEach(System.out::println);

        list.stream()
                .sorted(Comparator.comparing(UserModel::getAge))
                .filter(userModel -> userModel.getAge() > 25)
                .forEach(System.out::println);


    }
}
