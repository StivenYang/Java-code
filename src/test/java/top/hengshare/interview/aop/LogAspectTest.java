package top.hengshare.interview.aop;

import org.junit.Test;

public class LogAspectTest {

    @Test
    public void testTryCatch() throws Exception {
        String str = doTest();
        System.out.println(str);
    }

    private String doTest() throws Exception {
        try {
            System.out.println("try...");
            int i = 1 /0 ;
            return "try";
        }catch (Exception e){
            System.out.println("catch...");
            throw e;
        }
    }
}