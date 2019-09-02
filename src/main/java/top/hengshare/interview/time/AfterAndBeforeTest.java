package top.hengshare.interview.time;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author StivenYang
 * @program interview
 * @description before函数和after测试类
 * @date 2019-06-12 19:13
 **/
public class AfterAndBeforeTest {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().minusDays(1);
        LocalDate yesterday = LocalDate.now().minusDays(-1);

        //今天在明天之后
        System.out.println(today.isAfter(tomorrow));
        //今天在明天之前
        System.out.println(today.isBefore(tomorrow));

        BigDecimal one = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        System.out.println(one.compareTo(two));
        System.out.println(two.compareTo(one));
        System.out.println(one.compareTo(one));
    }
}
