package com.cei37.adt;


public class Link {
	public int data;
	public Link next;
	
	public Link(int data) {
		this.data = data;
	}
	
	public String toString() {
		return String.valueOf(data);
	}
}