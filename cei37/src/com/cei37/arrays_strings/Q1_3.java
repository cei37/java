package com.cei37.arrays_strings;

import java.util.Arrays;

public class Q1_3 {

	/**
	 * Given two strings, write a method to decide if one is a permutation of the other.
	 */
	public static void main(String[] args) {
		usingSort("hola complicado","loha complicaod");
		bestSolution("hola complicado","loha complicaod");
	}
	
	/*
	 * I'm assuming that we are going to handle only extended ASCII which is 256 characters
	 */
	public static void bestSolution(String str1, String str2) {
		int []arr = new int[256];
		for (int i=0; i<str1.length(); i++) {
			arr[str1.charAt(i)]++;
		}
		for (int i=0; i<str2.length(); i++) {
			if (--arr[str2.charAt(i)]<0) {
				System.out.println("this is not a permutation");
				return;
			}
		}
		System.out.println("this is a permutation");
	}
	
	/*
	 * here I'm using sorting to the give a solution 
	 * but it is not the best
	 */
	public static void usingSort(String str1, String str2) {
		if (str1.length()==str2.length()) {
			char char1[] = str1.toCharArray();
			char char2[] = str2.toCharArray();
			Arrays.sort(char1);
			Arrays.sort(char2);
			String s1 = new String(char1);
			String s2 = new String(char2);
			if (s1.equals(s2)) {
				System.out.println("this is a permutation");
			} else {
				System.out.println("this is not a permutation");
			}
			
		} else {
			System.out.println("this is not a permutation");
		}
	}
}