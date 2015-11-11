package com.cei37.linkedList;

import com.cei37.adt.LinkList;

public class Q2_2 {

	/**
	 * Implement an algorithm to find the kth to last element of a singly linked list.
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
		System.out.println("The find");
		//System.out.println(list.find(2));
		//System.out.println(list.findTheKt(list.first, 3));
		list.findTheKt(list.first, 3);
	}
}