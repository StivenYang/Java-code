package top.hengshare.interview.test;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    @Test
    public void testNot() {
        //测试正则表达式取非，取非万能公式：^((?!reg).)*  其中reg为需要的表达式
        String str = "^((?!^全部$).)*";
        Assert.assertTrue("a".matches(str));
        Assert.assertTrue("1全部".matches(str));
        Assert.assertFalse("全部".matches(str));
        Assert.assertTrue("1全部1".matches(str));
    }
}
