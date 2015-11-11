package com.cei37.arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class ReplaceString {

	/**
	 * 
	 */
	public static void main(String[] args) {
		String original = "This is a String to test some options that I saw before.";
		String remove = "aeiou";
		System.out.println(removeCharacters(original,remove));
	}
	
	public static String removeCharacters(String str, String remove) {
		StringBuffer sb = new StringBuffer();
		HashMap<Character,Boolean> hash = new HashMap<Character, Boolean>();
		for (int i=0; i<str.length(); i++) {
			hash.put(str.charAt(i), false);
		}
		for (int i=0; i<remove.length(); i++) {
			hash.put(remove.charAt(i), true);
		}
		for (int i=0; i<str.length(); i++) {
			if (!hash.get(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}