package com.cei37.arrays_strings;

public class Q1_8 {
	/**
	 * Assume you have a method isSubstring which checks if one word is a substring
	 * of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
	 * using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
	 */
	public static void main(String[] args) {
		String st1 = "waterbottLe";
		String st2 = "erbottLewat";
		String tmp = st1 + st1;
		
		if (st1.length()==st2.length()) {
			System.out.println(tmp);
			System.out.println(st2);
			System.out.println(tmp.indexOf(st2));
		}
	}
}