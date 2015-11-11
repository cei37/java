package com.cei37.adt.bitManipulation;

public class Q5_2 {

	/**
	 *Given a real number between 0 and 7 (e.g., 0.72) that is passed in as a double, print
	  the binary representation. If the number cannot be represented accurately in binary
	  with at most 32 characters, print "ERROR."

	 */
	public static void main(String[] args) {
		System.out.println(2 ^ 1);
		getBits(13948);
	}
	
	public static void getBits(int num) {
		StringBuffer sb = new StringBuffer();
		int bit = 1;
		for (int i=0; i<32; i++) {
			//sb.append((num & bit)==0?0:1);
			sb.insert(0, (num & bit)==0?0:1);
			bit = bit *2;
		}
		System.out.println(sb);
		System.out.println(Integer.toBinaryString(num));
	}
}