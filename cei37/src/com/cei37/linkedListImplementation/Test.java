package com.cei37.linkedListImplementation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(4);
		list.addLast(3);
		list.addLast(4);
		list.addLast(1);
		list.printAll();
		
		list.updateNode(4, 7);
		
		System.out.println("\nResult");
		list.printAll();
	}
}