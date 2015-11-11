package com.cei37.stackImplementation;

public class Stack<Type> {
	private Node<Type> top;
	
	public Stack() {
		top = new Node<Type>();
	}
	
	public void push(Type value) {
		Node<Type> newNode = new Node<Type>();
		newNode.setValue(value);
		newNode.setNext(top);
		top = newNode;
	}
	
	public Node<Type> pop() {
		Node<Type> node = top;
		if (top!=null) {
			top = top.getNext();
			return node;
		} else {
			return null;
		}
	}
	
	public Node<Type> peak() {
		return top;
	}
}

class Node<T> {
	private T value;
	private Node<T> next;
	
	protected T getValue() {
		return value;
	}
	
	protected void setValue(T value) {
		this.value = value;
	}
	
	protected Node<T> getNext() {
		return next;
	}
	
	protected void setNext(Node<T> next) {
		this.next = next;
	}
}