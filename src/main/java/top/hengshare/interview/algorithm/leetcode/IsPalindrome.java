package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * P234 回文链表
 *
 * @author v_yangjiaheng_dxm
 * @since  2020/10/23 10:39 上午
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode.next != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int end = list.size() - 1, start = 0;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private ListNode frontPointer;

    public boolean isPalindrome1(ListNode head) {
        frontPointer = head;
        return recursiveCheck(head);
    }

    private boolean recursiveCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursiveCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
