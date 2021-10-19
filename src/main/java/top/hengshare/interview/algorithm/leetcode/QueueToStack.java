package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author StevenYang
 * @description 用队列实现栈
 * @date 2020/7/18
 **/
public class QueueToStack {

	private Queue<Integer> input;
	private Queue<Integer> output;
	int top;

	/** Initialize your data structure here. */
	public QueueToStack() {
		input = new ArrayDeque<>();
		output = new ArrayDeque<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		input.add(x);
		top = x;
		while (!output.isEmpty()) {
			input.add(output.remove());
		}
		Queue<Integer> temp = output;
		output = input;
		input = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		output.remove();
		int res = top;
		if (!output.isEmpty()) {
			top = output.peek();
		}
		return res;
	}

	/** Get the top element. */
	public int top() {
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return output.isEmpty();
	}
}
