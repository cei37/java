package com.cei37.designPatterns.factoryMethod;

public abstract class Factory {
	public void anOperation() 
	{
		Shape product = createShape();
	}
	abstract protected Shape createShape();
}
