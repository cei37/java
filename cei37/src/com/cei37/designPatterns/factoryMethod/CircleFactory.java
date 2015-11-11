package com.cei37.designPatterns.factoryMethod;

public class CircleFactory extends Factory{

	@Override
	protected Shape createShape() {
		return new Circle();
	}
	
}
