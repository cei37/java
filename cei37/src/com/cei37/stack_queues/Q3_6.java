package com.cei37.stack_queues;

import com.cei37.adt.Stack;

public class Q3_6 {

	/**
	 * Write a program to sort a stack in ascending order (with biggest items on top).
	 * You may use at most one additional stack to hold items, but you may not copy
	 * the elements into any other data structure (such as an array). The stack supports
	 * the following operations: push, pop, peek, and isEmpty.
	 */
	public static void main(String[] args) {
		Stack stack1 = new Stack();
		stack1.push(3);
		stack1.push(4);
		stack1.push(1);
		stack1.push(7);
		stack1.push(2);
		stack1.push(6);
		stack1.push(9);
		stack1.push(5);
		
		stack1.printAll();
		
		Stack stack2 = new Stack();
		Integer tmp = null;
		while(!stack1.isEmpty()) {
			tmp = stack1.pop().data;
			while(!stack2.isEmpty() && stack2.peek().data>tmp) {
				stack1.push(stack2.pop().data);
			}
			stack2.push(tmp);
		}
		System.out.println("---------------");
		stack2.printAll();
	}
}