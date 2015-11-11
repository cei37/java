package com.cei37.stack_queues;

import com.cei37.adt.Stack;

public class Q3_2 {

	/**
	 * How would you design a stack which, in addition to push and pop, also has a
	 * function min which returns the minimum element? Push, pop and min should
	 * all operate in O(1) time.
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(5);
		stack.push(1);
		stack.push(7);
		stack.push(3);
		stack.push(2);
		stack.printAll();
		System.out.println("---------");
		System.out.println(stack.getMin());
	}
}