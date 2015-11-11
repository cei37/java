package com.cei37.stack_queues;

import com.cei37.adt.Stack;

public class Q3_4 {

	/**
	 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
	 * different sizes which can slide onto any tower. The puzzle starts with disks sorted
	 * in ascending order of size from top to bottom (i.e., each disk sits on top of an
	 * even larger one). You have the following constraints:
	 * (1) Only one disk can be moved at a time.
	 * (2) A disk is slid off the top of one tower onto the next tower.
	 * (3) A disk can only be placed on top of a larger disk.
	 * Write a program to move the disks from the first tower to the last using stacks.
	 */
	public static void main(String[] args) {
		Stack peg1 = new Stack();
		Stack peg2 = new Stack();
		Stack peg3 = new Stack();
		peg1.push(5);
		peg1.push(4);
		peg1.printAll();
		while(!peg1.isEmpty() || !peg2.isEmpty()) {
			if (peg2.isEmpty()) {
				peg2.push(peg1.pop().data);
			} else if (peg3.isEmpty() || !peg2.isEmpty() && peg2.peek().data < peg3.peek().data) {
				peg3.push(peg2.pop().data);
			} else if (!peg2.isEmpty() && !peg1.isEmpty() && peg2.peek().data < peg1.peek().data) {
				peg1.push(peg2.pop().data);
			} else if (!peg1.isEmpty() && !peg3.isEmpty() && peg1.peek().data < peg3.peek().data) {
				peg3.push(peg1.pop().data);
			}
		}
		System.out.println("-----------");
		peg3.printAll();
		//peg2.printAll();
		//peg1.printAll();
	}
}