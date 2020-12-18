package top.hengshare.interview.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocalDateTest {
    @Test
    public void testBeforeAndAfter() {
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
