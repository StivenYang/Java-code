package top.hengshare.interview.pattern.templateMethod.mapper;

import java.util.UUID;

/**
 * @program: Java-Interview
 * @description: 测试jdbc模板使用
 * @author: Steven Yang
 * @create: 2019-10-15 21:58
 **/
public class Client {
    public static void main(String[] args) {
        UserJDBC userJDBC = new UserJDBC();

        UserModel userModel = new UserModel();
        userModel.setAge((int)(Math.random()*100));
        userModel.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("user"+ (int)(Math.random()*100));
        userJDBC.create(userModel);

        userModel.setAge((int)(Math.random()*100));
        userModel.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("user"+ (int)(Math.random()*100));
        userJDBC.create(userModel);

        userModel.setAge((int)(Math.random()*100));
        userModel.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("user"+ (int)(Math.random()*100));
        userJDBC.create(userModel);

        userModel.setAge((int)(Math.random()*100));
        userModel.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("user"+ (int)(Math.random()*100));
        userJDBC.create(userModel);

        //初始化查询条件
        UserModel query = new UserModel();
        query.setName("%user%");
        //查询
        userJDBC.getByCondition(query).forEach(System.out::println);

//        userJDBC.getByCondition(null).forEach(System.out::println);

    }
}
