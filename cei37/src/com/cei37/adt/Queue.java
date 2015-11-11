package com.cei37.adt;

public class Queue {
	Link first, last;
	
	public void enqueue(int data) {
		if (first == null) {
			first = new Link(data);
		} else {
			last.next = new Link(data);
			last = last.next;
		}
	}
	
	public Link dequeue() {
		if (first!=null) {
			Link current = first;
			first = first.next;
			return current;
		} else {
			return null;
		}
	}
}
