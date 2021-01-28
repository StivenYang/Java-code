package top.hengshare.interview.test;

import org.junit.Test;


public class MovTest {

    @Test
    public void testMoveBit(){
        int i = -256;
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
        i = i>>1;
        System.out.println(i);
//        0000 0001   反：0000 0001  补：
//        1000 0001   反：1111 1110  补：
    }
}
