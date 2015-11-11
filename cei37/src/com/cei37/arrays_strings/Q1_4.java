package com.cei37.arrays_strings;

import java.util.Scanner;

public class Q1_4 {

	/**
	 * Write a method to replace all spaces in a string with'%20'. You may assume that
	 * the string has sufficient space at the end of the string to hold the additional
	 * characters, and that you are given the "true" length of the string. (Note: if implementing
	 * in Java, please use a character array so that you can perform this operation
	 * in place.)
	 * EXAMPLE
	 * Input: "Mr John Smith     "
	 * Output: "Mr%20Dohn%20Smith"
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---> write a string <---");
		String str = scan.nextLine();
		
		System.out.println("---> Solution one <---");
		solution1(str);
		
		System.out.println("---> Solution two <---");
		solution2(str);
	}
	
	/*
	 * this is the best solution
	 */
	public static void solution2(String str) {
		int counter = 0, length = str.length();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)==' ') {
				counter++;
			}
		}
		
		if (counter>0) {
			char []arr = new char[str.length()+counter*2];
			for (int i=0; i<str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			
			
			/*
			 * here is where we are starting the real solution
			 */
			int pos = arr.length-1;
			for (int i=length-1; i>=0; i--) {
				if (arr[i] == ' ') {
					arr[pos--] = '0';
					arr[pos--] = '2';
					arr[pos--] = '%';
				} else {
					arr[pos--] = arr[i];
				}
			}
			
			System.out.println(new String(arr));
		}
	}
	
	public static void solution1(String str) {
		char array[] = new char[str.length()*3];
		for (int i=0; i<str.length(); i++) {
			array[i] = str.charAt(i);
		}
		System.out.println(array);
		for (int i=0; i<array.length; i++) {
			if (array[i] == ' ') {
				//move from left to right
				for (int j=0; j<2; j++) {
					for (int k=array.length-1; k>0 && k>i; k--) {
						array[k] = array[k-1];
					}
				}
				array[i++] = '%';
				array[i++] = '2';
				array[i++] = '0';
			}
		}
		System.out.println(array);
	}
}