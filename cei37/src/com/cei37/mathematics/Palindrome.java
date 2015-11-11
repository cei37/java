package com.cei37.mathematics;

public class Palindrome {
	public static void main(String[] arg) {
		int num = 1;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(isBitPalindrome(num));
	}

	static boolean isBitPalindrome(int x) {
		System.out.println("--------------------------");
		int reversed = 0, aux = x;
		while (aux > 0) {
			/*
			 * Taking LSB of aux and putting it as LSB of reversed variable.
			 * Before doing that shifting reversed to right, to build it from
			 * left to right.
			 */
			reversed = (reversed << 1) | (aux & 1);
			System.out.println(Integer.toBinaryString(reversed));
			/*
			 * Loop is depend of number of bits in aux. Taking next bit into LSB
			 * position by shifting aux toward right once.
			 */
			aux = aux >> 1;
		}
		return (reversed == x) ? true : false;
	}
}
