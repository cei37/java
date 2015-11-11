package com.cei37.linkedList;

import java.util.Random;

import com.cei37.adt.LinkList;

public class Q2_4 {

	/**
	 * Write code to partition a linked list around a value x, such that all nodes less than
	 * x come before all nodes greater than or equal to x.
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();
		LinkList leftList = new LinkList();
		LinkList rightList = new LinkList();
		for (int i=0; i<20; i++) {
			Random ran = new Random();
			list.insertLast(ran.nextInt(100));
		}
		list.printAll();
		list.splitList(50, leftList, rightList);
		System.out.println("Left");
		leftList.printAll();
		System.out.println("Right");
		rightList.printAll();
	}
}
