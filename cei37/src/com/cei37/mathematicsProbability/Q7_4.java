package com.cei37.mathematicsProbability;

public class Q7_4 {
	public static void main(String[] arg) throws Exception {
		System.out.println("multiply: "+multiply(3, 7));
		System.out.println("subtract: "+subtract(-4, -3));
		System.out.println("divide: "+divide(8, -4));
	}
	
	public static int divide(int dividend, int divisor) throws Exception {
		int result = 0;
		if (divisor == 0) {
			throw new Exception("Cannot divide by zero.");
		} else if (dividend == 0) {
			return 0;
		}
		boolean dd = dividend < 0 ? true : false;
		boolean dr = divisor < 0 ? true : false;
		
		if (dd) {
			dividend = negate(dividend);
		}
		if (dr) {
			divisor = negate(divisor);
		}
		
		for (int i = divisor; i <= dividend;  i += divisor) {
			result++;
		}
		
		if (dd && dr || !dd && !dr) {
			return result;
		} else {
			return negate(result);
		}
	}
	
	public static int multiply(int a, int b) {
		boolean negA = a < 0;
		boolean negB = b < 0;
		a = Math.abs(a);
		b = Math.abs(b);
		
		int result = 0;
		for (int i = 0; i<a; i++) {
			result += b;
		}
		
		if (negA && !negB || !negA && negB) {
			return negate(result);
		} else {
			return result;
		}
	}
	
	public static int subtract(int a, int b) {
		return a + negate(b);
	}
	
	private static int negate(int a) {
		int result = 0;
		int tmp = a < 0 ? 1 : -1;
		while(a!=0) {
			result += tmp;
			a += tmp;
		}
		return result;
	}
}