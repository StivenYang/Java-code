package top.hengshare.interview.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalTest {
    public static void main(String[] args) {
//        try {
//            BigDecimal big1 = new BigDecimal(10);
//            BigDecimal big2 = new BigDecimal(3);
//            System.out.println(big1.divide(big2));
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            log.error("", e);
//        }
//        System.out.println(big1.divide(big2, 3, RoundingMode.HALF_UP));
        BigDecimal bigDecimal = new BigDecimal("3.33333333");
        System.out.println(bigDecimal.setScale(3, RoundingMode.HALF_UP));
    }
}
