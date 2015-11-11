package com.cei37.arrays_strings;
/*
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What
	if you cannot use additional data structures?
 */
public class Q1_1 {
	public static void main(String [] args) {
		String str = "ab cdefgopqwsa";
		complexn2(str);
		bestSolutionComplexN(str);
		bestOfbest(str);
	}
	
	public static void bestOfbest(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				System.out.println("characters are not unique");
				return;
			}
			checker |= (1 << val);
		}
		System.out.println("all characters are unique");
	}
	
	/*
	 * we are assuming that the string will be extended ascii
	 */
	public static void bestSolutionComplexN(String str) {
		boolean list[] = new boolean[256];
		for (int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if (list[val]) {
				System.out.println("characters are not unique");
				return;
			} else {
				list[val] = true;
			}
		}
		System.out.println("all characters are unique");
	}
	
	public static void complexn2(String str) {
		boolean unique = true;
		for (int i=0; i<str.length(); i++) {
			for (int j=i+1; j<str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					unique = false;
				}
			}
		}
		if (unique) {
			System.out.println("all characters are unique");
		} else {
			System.out.println("characters are not unique");
		}
	}
}
