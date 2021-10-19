package top.hengshare.interview.algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 检查括号字符串是否正确
 *
 * @author StevenYang
 * @since 2020/7/18
 **/
public class EffectiveBrackets {
	private HashMap<Character, Character> mapping;

	public EffectiveBrackets() {
		this.mapping = new HashMap<>();
		this.mapping.put(')', '(');
		this.mapping.put('}', '{');
		this.mapping.put(']', '[');
	}

	public boolean isValid(String s) {

		if (s == null || s.length() % 2 != 0) {
			return false;
		}

		//创建一个栈
		Stack<Character> stack = new Stack<>();

		//依次对字符串每个字符进行处理
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			//如果当前字符是括号
			if (this.mapping.containsKey(c)) {
				//判断当前栈是否是空的，不是空的弹栈，是空的什么也不干
				char topElement = stack.empty() ? '#' : stack.pop();

				//判断弹出来的栈顶元素是不是映射的左括号，如果不是，说明括号不正确，直接返回false
				if (topElement != this.mapping.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}
}
