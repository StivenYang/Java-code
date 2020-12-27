package top.hengshare.interview.algorithm.leetcode;

/**
 * 检查链表是否有环
 *
 * @author StevenYang
 * @since 2020/7/18
 **/
public class CheckRing {

    public static ListNode checkRing(ListNode head){
        //判断边界条件，如果节点只有一个或者为空，返回null
        if (head == null || head.next == null) {
            return null;
        }

        //快慢指针，判断是否有环，如果有环，跳出循环
        ListNode slow = head, fast = head;
        //判断快指针是否到达结尾了，如果没有到达结尾，且快慢指针相等了，那么说明有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //判断快指针是否到达结尾，如果到达结尾了，返回null，表示没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        //找环，快慢指针再次相遇点为入口点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
