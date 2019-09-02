package top.hengshare.interview.test;

import java.math.BigDecimal;

public class Test
{
    public static int aMethod(int i)throws Exception
    {
        try{
            return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }

    public static void main(String[] args)
    {
        BigDecimal a = new BigDecimal(0);
        BigDecimal b = new BigDecimal("0.00");
        System.out.println(b.equals(BigDecimal.ZERO));
        System.out.println(a.equals(BigDecimal.ZERO));
//        try
//        {
//            aMethod(0);
//        }
//        catch (Exception ex)
//        {
//            System.out.printf("exception in main");
//        }
//        System.out.printf("finished");
    }
}
