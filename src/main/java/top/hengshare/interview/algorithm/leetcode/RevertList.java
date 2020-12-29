package top.hengshare.interview.algorithm.leetcode;

/**
 * 翻转单链表  leetCode：206
 *
 * @author StevenYang
 * @since 2020/7/16
 **/
public class RevertList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        print(node1);
        ListNode revert = revert(node1);
        print(revert);
    }

    public static void print(ListNode node){
        ListNode listNode;
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        listNode = node.next;
        print(listNode);
    }

    private static ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        System.out.println();
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val+"";
    }
}
