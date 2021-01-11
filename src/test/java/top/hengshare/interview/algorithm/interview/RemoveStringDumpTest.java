package top.hengshare.interview.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveStringDumpTest {

    @Test
    public void removeStringDump() throws Exception {
        RemoveStringDump removeStringDump = new RemoveStringDump();
        String actualString = removeStringDump.removeStringDump("zabacdefabcz");
        assertEquals("zabcdef", actualString);
    }
}