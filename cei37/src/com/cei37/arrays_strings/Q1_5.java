package com.cei37.arrays_strings;

public class Q1_5 {

	/**
	 * Implement a method to perform basic string compression using the counts
	 * of repeated characters. For example, the string aabcccccaaa would become
	 * a2blc5a3. If the "compressed" string would not become smaller than the original
	 * string, your method should return the original string.
	 */
	public static void main(String[] args) {
		Q1_5 q = new Q1_5();
		System.out.println(q.compress("aaaaasssseeeedssswooksss"));
	}
	
	private String compress(String str) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int i=0; i<str.length(); i++) {
			if (i+1<str.length() && str.charAt(i)==str.charAt(i+1)) {
				counter++;
			} else {
				sb.append(str.charAt(i)).append(counter);
				counter = 1;
			}
		}
		return str.length()<sb.length()?str:sb.toString();
	}
}