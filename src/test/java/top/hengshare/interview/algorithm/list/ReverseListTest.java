package top.hengshare.interview.algorithm.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseListTest {

    @Test
    public void reverseList() {
        ReverseList reverseList = new ReverseList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode revert = reverseList.reverseList(node1);
        int[] arr = new int[3];
        int i = 0;
        while (revert != null) {
            arr[i++] = revert.val;
            revert = revert.next;
        }
        assertArrayEquals(new int[]{3, 2, 1}, arr);
    }
}