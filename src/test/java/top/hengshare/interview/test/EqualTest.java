package top.hengshare.interview.test;

import org.junit.Test;

public class EqualTest {

    @Test
    public void testEqual(){
        Integer a  = new Integer(100);
        Integer b = new Integer(100);
        Integer c = 100;

        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));
    }
}
