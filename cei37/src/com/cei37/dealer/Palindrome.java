package com.cei37.dealer;

public class Palindrome {
	enum Operation {
		ADD,
		SUB
	}
	/**
	 * @author: Vicente Villegas Larios
	 * @mail: cei37@hotmail.com
	 * Palindrome
	 */
	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("Ah, Satan sees Natasha"));
		System.out.println(pal.isPalindrome("Anita lava la tina"));
	}
	
	public boolean isPalindrome(String str) {
		if (str!=null && str.trim().length()>0) {
			str = str.toLowerCase();
			for (int i=0, j=str.length()-1; i<=j; i++, j--) {
				i = verifyCurrentCharacter(str, i,Operation.ADD);
				j = verifyCurrentCharacter(str, j,Operation.SUB);
				
				if (str.charAt(i) != str.charAt(j)) {
					return false;
				}
				
				if (i+1>=j-1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private int verifyCurrentCharacter(String str, int pos, Operation ope) {
		while(!isValidCharacter(str.charAt(pos))) {
			if (ope == Operation.ADD) {
				pos++;
			} else {
				pos--;
			}
		}
		return pos;
	}
	
	private boolean isValidCharacter(char c) {
		return (int)c>=97 && (int)c<=122;  
	}
}
