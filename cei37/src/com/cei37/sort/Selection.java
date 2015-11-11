package com.cei37.sort;

import java.util.Random;

public class Selection {

	/**
	 * Implement the selection sort
	 */
	public static void main(String[] args) {
		Random ran = new Random();
		int vector[] = new int[10];
		System.out.println("Original vector");
		for(int i = 0; i<vector.length; i++) {
			vector[i] = ran.nextInt(100);
			System.out.println(vector[i]);
		}
		sort(vector);
		System.out.println("\nSorted vector");
		for(int i = 0; i<vector.length; i++) {
			System.out.println(vector[i]);
		}
	}
	
	public static void sort(int []arg) {
		for(int i=0; i< arg.length; i++ ) {
			int min = getMin(arg, i);
			int tmp = arg[min];
			arg[min] = arg[i];
			arg[i] = tmp;
		}
	}
	
	private static int getMin(int []arg, int pos) {
		int target = pos;
		int minVal = arg[pos]; 
		for (int i=pos+1; i<arg.length; i++) {
			if (minVal > arg[i]) {
				target = i;
				minVal = arg[i];
			}
		}
		return target;
	}
}