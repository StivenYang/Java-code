package top.hengshare.interview.generic.simple;

/**
 * @author StivenYang
 * @date 2020年12月18日
 **/
public class LinkedStack<T> {
	//节点
	private static class Node<U> {
		//当前项
		U item;
		//下一个节点
		Node<U> next;

		//初始化节点
		Node() {
			item = null;
			next = null;
		}

		//初始化节点
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		//判断是否是最后的节点
		boolean end() {
			return item == null && next == null;
		}
	}

	//栈顶节点
	private Node<T> top = new Node<>();

	//压栈
	public void push(T item) {
		top = new Node<>(item, top);
	}

	//弹栈
	public T pop() {
		//取得当前栈顶元素
		T result = top.item;
		if (!top.end()) {
			//如果不是栈顶节点
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<>();
		for (String s : "phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
}
