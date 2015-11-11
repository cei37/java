package com.cei37.linkedList;

import com.cei37.adt.Link;
import com.cei37.adt.LinkList;

public class Q2_5 {

	/**
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the 1's digit is at the
	 * head of the list. Write a function that adds the two numbers and returns the sum
	 * as a linked list.
	 * EXAMPLE
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 * Output: 2 -> 1 -> 9.That is, 912.
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * EXAMPLE
	 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	 * Output: 9 -> 1 -> 2.That is, 912.
	 */
	public static void main(String[] args) {
		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
		LinkList list3 = new LinkList();
		
		list1.insertFirst(6);
		list1.insertFirst(1);
		list1.insertFirst(7);
		
		list2.insertFirst(2);
		list2.insertFirst(9);
		list2.insertFirst(5);
		
		/*
		LinkList listTem1 = list1.invertList();
		LinkList listTem2 = list2.invertList();
		
		System.out.println(listTem1.concatenateValues() + " + " + listTem2.concatenateValues());
		
		String total = String.valueOf(Integer.parseInt(listTem1.concatenateValues()) + Integer.parseInt(listTem2.concatenateValues()));
		
		for (int i=0; i<total.length(); i++) {
			list3.insertFirst(total.charAt(i)-48);
		}
		
		//LinkList listTem3 = list3.invertList();
		list3.printAll();
		System.out.println(total); 
		*/
		
		list1.printAll();
		list2.printAll();
		
		Link link = addLists(list1.first,list2.first,0);
		list3.addNewHead(link);
		list3.invertList().printAll();
	}
	
	public static Link addLists(Link list1, Link list2, int carry) {
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}
		Link result = new Link(carry);
		
		int value = carry;
		
		if (list1!=null) {
			value += list1.data;
		}
		
		if (list2 !=null) {
			value += list2.data;
		}
		
		result.data = value % 10;
		
		if (list1!=null || list2!=null) {
			Link list = addLists(list1==null?null:list1.next, list2==null?null:list2.next, value>=10?1:0);
			result.next = list;
		}
		return result;
	}
}