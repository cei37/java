package com.cei37.adt;

public class SetOfStacks {
	Stack[] stacks;
	int current;
	public SetOfStacks(int numberOfStacks) {
		stacks = new Stack[numberOfStacks];
	}
	
	public void push(int data) {
		if (stacks[current]==null) {
			stacks[current] = new Stack();
		} else if (stacks[current].size>=5) {
			current++;
			stacks[current] = new Stack();
		}
		stacks[current].push(data);
	}
	
	public Link peek() {
		return stacks[current].peek();
	}
	
	public Link pop() {
		Link tmp = stacks[current].pop();
		if (stacks[current].isEmpty()) {
			current--;
		}
		return tmp;
	}
	
	public Link popAt(int pos) {
		if (pos >= 0 && pos <= current) {
			return stacks[pos].pop();
		} else {
			return null;
		}
	}
	
	public void printAll() {
		for (Stack stack: stacks) {
			if (stack!=null) {
				System.out.println("---");
				stack.printAll();
			}
		}
	}
}