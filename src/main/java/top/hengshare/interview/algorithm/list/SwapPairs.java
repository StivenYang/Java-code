package top.hengshare.interview.algorithm.list;

/**
 * 交换链表中的相邻数据
 *
 * @author yjh
 * @date 2020/12/28 9:10 下午
 **/
public class SwapPairs {

	public ListNode swapPairs(ListNode head) {
		//当链表后面没有节点的时候，返回链表作为结果
		if (head == null || head.next == null) {
			return head;
		}

		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;

		return next;
	}
}
