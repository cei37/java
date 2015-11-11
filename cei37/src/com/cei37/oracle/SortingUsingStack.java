package com.cei37.oracle;

import com.cei37.adt.Stack;


public class SortingUsingStack {

	/**
	 * @param args
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
			if (!stack2.isEmpty()) {
				if (tmp!=null && tmp >= stack2.peek().data) {
					stack2.push(tmp);
					tmp = null;
				}else if (stack1.peek().data >= stack2.peek().data) {
					stack2.push(stack1.pop().data);
				} else {
					tmp = stack1.pop().data;
					while(tmp != null) {
						if (tmp >= stack2.peek().data) {
							stack2.push(tmp);
							tmp = null;
						} else {
							stack1.push(stack2.pop().data);
							if (stack2.isEmpty()) {
								stack2.push(tmp);
								tmp = null;
							}
						}
					}
				}
			} else {
				if (tmp!=null && tmp > stack1.peek().data) {
					stack2.push(tmp);
					tmp = null;
				} else {
					stack2.push(stack1.pop().data);
				}
			}
		}
		System.out.println("---------------");
		stack2.printAll();
	}
}