package top.hengshare.interview.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortStringTest {

    @Test
    public void sortString() {
        SortString sortString = new SortString();
        String targetString = sortString.sortString("hfkfdlsahfgdiuanvzx");
        assertEquals("adfghiklnsuvxz", targetString);
    }

    @Test
    public void sortStringNoTree() {
        SortString sortString = new SortString();
        String targetString = sortString.sortStringNoTree("hfkfdlsahfgdiuanvzx");
        assertEquals("adfghiklnsuvxz", targetString);
    }
}