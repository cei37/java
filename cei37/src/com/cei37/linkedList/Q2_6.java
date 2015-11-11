package com.cei37.linkedList;


import com.cei37.adt.LinkList;

public class Q2_6 {

	/**
	 * Given a circular linked list, implement an algorithm which returns the node at
	 * the beginning of the loop.
	 * DEFINITION
	 * Circular linked list: A (corrupt) linked list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list.
	 * EXAMPLE
	 * Input: A - > B - > C - > D - > E - > C [the same C as earlier]
	 * Output: C
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(11);
		list.insertFirst(9);
		list.insertFirst(6);
		list.insertFirst(7);
		list.insertLast(1);
		list.insertLast(2);
		list.insertFirst(6);
		list.insertFirst(8);
		list.insertFirst(10);
		list.insertFirst(9);
		list.insertLast(5);
		
		list.printAll();
		list.createLoop(8);
		System.out.println(list.hasLoop());
		System.out.println(list.removeLoop());
		list.printAll();
	}
}