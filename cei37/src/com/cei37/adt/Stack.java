package com.cei37.adt;

public class Stack {
	Link head;
	Link min;
	int size;
	
	public void push(int a) {
		Link newLink = new Link(a);
		newLink.next = head;
		head = newLink;
		size++;
		if (min == null) {
			min = new Link(a);
		} else {
			if (min.data>a) {
				min = head;
			}
		}
	}
	
	public Link pop() {
		if (!isEmpty()) {
			Link temLink = head;
			head = head.next;
			size--;
			return temLink; 
		} else {
			return null;
		}
	}
	
	public Link peek() {
		if (!isEmpty()) {
			return head; 
		} else {
			return null;
		}
	}
	
	public boolean isEmpty() {
		if (head==null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printAll() {
		Link current = head;
		while (current!=null) {
			System.out.println("| "+current.data+" |");
			current = current.next;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int getMin() {
		return min.data;
	}
}
