package com.cei37.linkedList;

import com.cei37.adt.LinkList;

public class Q2_7 {
	/**
	 * Implement a function to check if a linked list is a palindrome
	 */
	public static void main(String[] args) {
		LinkList list1 = new LinkList();
		list1.insertFirst(5);
		list1.insertFirst(2);
		list1.insertFirst(1);
		list1.insertFirst(3);
		list1.insertFirst(1);
		list1.insertFirst(8);
		list1.insertFirst(1);
		list1.insertFirst(3);
		list1.insertFirst(1);
		list1.insertFirst(2);
		list1.insertFirst(3);
		list1.printAll();
		//System.out.println(list1.isPalindrome());
		//System.out.println(list1.isPalindromeUsingStack());
		list1.isPalindromeUsingRecursion();
	}
}