package com.cei37.TreesGraphs.adt;

public class Node<Value extends Comparable<Value>> {
	public Node<Value> left;
	public Node<Value> right;
	public Value value;
	
	public int compareTo(Value value) {
		return value.compareTo(this.value);
	}

	public boolean equals(Value value) {
		return this.value == value;
	}
	
	public Node<Value> getLeft() {
		return left;
	}

	public void setLeft(Node<Value> left) {
		this.left = left;
	}

	public Node<Value> getRight() {
		return right;
	}

	public void setRight(Node<Value> right) {
		this.right = right;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value.toString();
	}
}