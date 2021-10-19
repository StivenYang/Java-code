package top.hengshare.interview.algorithm.leetcode;

import java.util.Stack;

/**
 * 用栈实现队列的功能
 *
 * @author StevenYang
 * @date 2020/7/18
 **/
public class StackToQueue {

	private Stack<Integer> input;
	private Stack<Integer> output;

	/** Initialize your data structure here. */
	public StackToQueue() {
		input = new Stack<>();
		output = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (output.empty()) {
			while (!input.empty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (output.empty()) {
			while (!input.empty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.empty() && output.empty();
	}
}
