package com.cei37.designPatterns.factoryMethod;

public abstract class Shape {
	String name;
	String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	protected void fill() {
		
	}
	protected void clear() {
		
	}
	protected void rotate() {
		
	}
	protected void draw() {
		
	}
}
