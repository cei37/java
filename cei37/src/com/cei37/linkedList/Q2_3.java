package com.cei37.linkedList;

import com.cei37.adt.LinkList;

public class Q2_3 {

	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked list,
	 * given only access to that node.
	 * EXAMPLE
	 * Input: the node c from the linked list a->b->c->d->e
	 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(3);
		list.insertFirst(9);
		list.insertFirst(6);
		list.insertFirst(7);
		list.insertLast(1);
		list.insertLast(2);
		list.insertFirst(63);
		list.insertFirst(8);
		list.insertFirst(10);
		list.insertFirst(9);
		list.insertLast(5);
		
		list.printAll();
		list.delete(6);
		list.printAll();
	}
}