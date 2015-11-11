package com.cei37.amazon;

/*
 * You are given an array of integers foo. For each integer in the array N, find the digits number that exactly dived N
 * (division that leaves 0 as remainder) and print the count. For N=24, there are 2 digits (2 & 4). Both of these digits 
 * exactly divide 24. So our answer is 2.
 * 
 */
public class FindingDigits {

	public static void main(String[] args) {
		int arr[] = {2,12,1012};
		findingDigits(arr);
	}
	
	public static void findingDigits(int[] foo) {
		for (int N : foo) {
			int count = 0;
			String number = String.valueOf(N);
			if (number.length() == 1){
				continue;
			} else {
				for (int i=0; i<number.length(); i++) {
					int dig = Integer.valueOf(number.substring(i, i+1));
					if (dig != 0) {
						if (N % dig == 0){
							count++;
						}
					}
				}
			}
			
			if (count > 0) {
				System.out.println("--"+count);
			}
		}
	}
}