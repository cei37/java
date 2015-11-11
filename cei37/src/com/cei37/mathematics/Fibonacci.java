package com.cei37.mathematics;

public class Fibonacci {

	/**
	 * Fibonacci Numbers
	 */
	public static void main(String[] args) {
		iterativeFibonacci(10000);
		
	}
	
	public static void iterativeFibonacci(int num) {
		double previous = 0;
		double current = 1;
		for (int i=0; i<=num; i++) {
			System.out.println(previous);
			double tmp = previous;
			previous = current;
			current = current + tmp;
		}
	}
	
	public static void recursiveFibonacci(int num) {
		for (int i=0; i<num; i++) {
			System.out.println(fibonacci(i));
		}
	}
	
	public static int fibonacci(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}