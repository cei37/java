package com.cei37.linkedListImplementation;

public class CircularLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(10);
		list.addLast(9);
		list.addLast(8);
		list.addLast(7);
		list.addLast(6);
		list.addLast(5);
		list.addLast(4);
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);
		
		list.makeCircularLink(5);
		System.out.println(list.hasLoop());
		//list.printAll();
	}
}