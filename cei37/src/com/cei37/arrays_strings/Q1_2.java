package com.cei37.arrays_strings;

public class Q1_2 {

	/**
	 * Implement a function void reverse(char* str) in C or C++ which reverses a nullterminated string.
	 */
	public static void main(String[] args) {
		reverseString("this is the test.");
	}
	
	public static void reverseString(String str) {
		for (int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
	}
}