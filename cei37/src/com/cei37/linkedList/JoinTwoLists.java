package com.cei37.linkedList;

import com.cei37.linkedListImplementation.LinkedList;

public class JoinTwoLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testJavaList();
		testMyLinkedList();
	}
	
	public static void testMyLinkedList() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		list1.addLast(2);
		list1.addLast(4);
		list1.addLast(6);
		list1.addLast(8);
		list1.addLast(10);
		list1.addLast(12);
		list1.addLast(14);
		
		System.out.println("\nThis is the list 1");
		list1.printAll();
		
		list2.addLast(1);
		list2.addLast(3);
		list2.addLast(5);
		list2.addLast(7);
		
		System.out.println("\nThis is the list 2");
		list2.printAll();
		
		try {
			result = list1.joinLists(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		
		System.out.println("\nThis is the list 1");
		list1.printAll();
		
		System.out.println("\nThis is the list 2");
		list2.printAll();
		
		System.out.println("\nThis is the result list");
		result.printAll();
		
		System.out.println("\n\n*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		
		System.out.println("\nThis is the list 1");
		list1.removeFirst();
		list1.removeLast();
		list1.removeLast();
		list1.printAll();
		
		System.out.println("\nThis is the list 2");
		list2.removeFirst();
		list2.removeLast();
		list2.removeLast();
		list2.printAll();
		
		System.out.println("\nThis is the result list");
		result.printAll();
		
		System.out.println("\nThis is the result list reverse");
		result.reverse();
		result.printAll();
	}
	
	
	public static void testJavaList() {
		java.util.LinkedList<Integer> list1 = new java.util.LinkedList<Integer>();
		java.util.LinkedList<Integer> list2 = new java.util.LinkedList<Integer>();
		java.util.LinkedList<Integer> result = new java.util.LinkedList<Integer>();
		
		list1.addLast(2);
		list1.addLast(4);
		list1.addLast(6);
		list1.addLast(8);
		list1.addLast(10);
		
		list2.addLast(1);
		list2.addLast(3);
		list2.addLast(5);
		list2.addLast(7);
		
		result = joinList(list1, list2);
		
		System.out.println("This is the list 1");
		for (Integer in: list1) {
			System.out.println(in);
		}
		
		System.out.println("This is the list 2");
		for (Integer in: list2) {
			System.out.println(in);
		}
		
		System.out.println("This is the list result");
		for (Integer in: result) {
			System.out.println(in);
		}
	}
	
	public static java.util.LinkedList<Integer> joinList(java.util.LinkedList<Integer> list1,java.util.LinkedList<Integer> list2) {
		if (list1.isEmpty() && !list2.isEmpty()) {
			return list2;
		} else if (list2.isEmpty() && !list1.isEmpty()) {
			return list1;
		}

		java.util.LinkedList<Integer> result = new java.util.LinkedList<Integer>();
		Integer current1 = list1.pollFirst();
		Integer current2 = list2.pollFirst();

		while (current1 != null && current2 != null) {
			if (current1 < current2) {
				result.addLast(current1);
				current1 = list1.pollFirst();
			} else {
				result.addLast(current2);
				current2 = list2.pollFirst();
			}
		}

		while (current1 == null && current2 != null) {
			result.addLast(current2);
			current2 = list2.pollFirst();
		}

		while (current2 == null && current1 != null) {
			result.addLast(current1);
			current1 = list1.pollFirst();
		}

		return result;
	}
}