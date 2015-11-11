package com.cei37.recursion;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

	/**
	 * Implement a routine that prints all possible orderings of the characters
	 * in a string. In other words, print all permutations that use all the characters from
	 * the original string. For example, given the string "hat", your function should print
	 * the strings "tha", "aht", "tah", "ath", "hta", and "hat". Treat each character in the
	 * input string as a distinct character, even if it is repeated. Given the string "aaa",
	 * your routine should print "aaa" six times. You may print the permutations in any
	 * order you choose.
	 */
	
	private boolean[] used;
	private String in;
	int i = 1;
	
	public static void main(String[] args) {
		Permutation per = new Permutation();
		per.in = "abc";
		per.used = new boolean[per.in.length()];
		StringBuilder out = new StringBuilder();
		per.permute(out);
	}

	public void permute(StringBuilder out) {
		if (out.length() == in.length()) {
			System.out.println("-->"+out);
			return;
		}
		for (int i = 0; i < in.length(); i++) {
			if (used[i]) {
				continue;
			}
			out.append(in.charAt(i));
			used[i] = true;
			permute(out);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}
}