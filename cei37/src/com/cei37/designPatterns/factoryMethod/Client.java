package com.cei37.designPatterns.factoryMethod;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory f = new CircleFactory();
		f.createShape().draw();
	}

}
