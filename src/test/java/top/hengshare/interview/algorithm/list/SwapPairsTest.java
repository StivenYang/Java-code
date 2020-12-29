package top.hengshare.interview.algorithm.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapPairsTest {

    @Test
    public void swapPairs() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = swapPairs.swapPairs(list);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        assertEquals("2143", sb.toString());
    }
}