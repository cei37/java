package com.cei37.moderate;

import java.util.Arrays;

public class Q17_12 {

	/**
	 */
	public static void main(String[] args) {
		int arr[] =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		printPairSums(arr,25);
	}
	
	public static void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				first++;
				last--;
			} else {
				if (s < sum)
					first++;
				else
					last--;
			}
		}
	}
}