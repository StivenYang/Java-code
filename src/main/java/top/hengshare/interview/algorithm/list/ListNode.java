package top.hengshare.interview.algorithm.list;

/**
 * 链表节点
 *
 * @author yjh
 * @date 2020/12/28 9:01 下午
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
