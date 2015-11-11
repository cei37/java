package com.cei37.stack_queues;

import java.util.Random;

import com.cei37.adt.SetOfStacks;

public class Q3_3 {

	/**
	 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
	 * Therefore, in real life, we would likely start a new stack when the previous stack
	 * exceeds some threshold. Implement a data structure SetOf Stacks that mimics
	 * this. SetOf Stacks should be composed of several stacks and should create a
	 * new stack once the previous one exceeds capacity. SetOf Stacks. push() and
	 * SetOf Stacks. pop() should behave identically to a single stack (that is, popO
	 * should return the same values as it would if there were just a single stack).
	 * FOLLOW UP
	 * Implement a function popAt(int index) which performs a pop operation on
	 * a specific sub-stack.
	 */
	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks(5);
		Random ran = new Random();
		for (int i=0; i<23; i++) {
			set.push(ran.nextInt(100));
		}
		set.printAll();
		System.out.println("-------------");
		System.out.println(set.popAt(2));
		set.printAll();
	}
}