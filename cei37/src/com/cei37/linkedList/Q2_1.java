package com.cei37.linkedList;

import com.cei37.adt.LinkList;


public class Q2_1 {

	/**
	 * Write code to remove duplicates from an unsorted linked list.
	 * FOLLOW UP
	 * How would you solve this problem if a temporary buffer is not allowed?
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
		System.out.println("*********");
		//System.out.println(list.delete(1));
		//list.delete(9);
		//list.removeDuplicatesNoBufferAllowed();
		list.removeDuplicates();
		list.printAll();
	}
}