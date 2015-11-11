package com.cei37.stack_queues;

import com.cei37.adt.Stack;

public class Q3_5 {

	/**
	 * Implement a MyQueue class which implements a queue using two stacks
	 */
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.dequeue());
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(10);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}

class MyQueue {
	Stack stack1;
	Stack stack2;
	
	public MyQueue() {
		stack1 = new Stack();
		stack2 = new Stack();
	}
	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void enqueue(int data) {
		stack1.push(data);
	}
	
	public int dequeue() {
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop().data);
			}
			return stack2.pop().data;
		} else {
			return stack2.pop().data;
		}
	}
}