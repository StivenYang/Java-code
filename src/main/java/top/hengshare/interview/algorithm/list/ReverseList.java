package top.hengshare.interview.algorithm.list;

/**
 * ReverseList
 *
 * @author yjh
 * @since 2021/1/18
 */
public class ReverseList {

	public ListNode reverseList(ListNode node) {
		if (node == null) {
			return null;
		}
		ListNode pre = null;
		ListNode head = node;
		while (head != null) {
			ListNode tempHead = head.next;
			head.next = pre;
			pre = head;
			head = tempHead;
		}
		return pre;
	}
}
