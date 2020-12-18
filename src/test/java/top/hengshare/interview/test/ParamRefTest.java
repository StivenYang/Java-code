package top.hengshare.interview.test;

import org.junit.Test;
import top.hengshare.interview.mysql.model.User;

/**
 * 测试java参数传递方式
 */
public class ParamRefTest {

    @Test
    public void testParamRef(){
        User user = new User();
        user.setId(10);
        user.setUsername("abd");
        user.setPassword("123");
        System.out.println(user);

        updateUserRef(user);
        System.out.println(user);

        updateUserValue(user);
        System.out.println(user);
    }

    private void updateUserValue(User user) {
        user.setEmail("abc@qq.com");
    }

    private void updateUserRef(User user) {
        User user1  = new User();
        user = user1;
    }


}
