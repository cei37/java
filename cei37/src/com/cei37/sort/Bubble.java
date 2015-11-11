package com.cei37.sort;

import java.util.Random;

public class Bubble {

	/**
	 * Implement a Bubble sort
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
		for(int i=0; i < arg.length-1; i++ ) {
			for (int j=i; j<arg.length; j++) {
				if (arg[i]>arg[j]) {
					int tmp = arg[j];
					arg[j] = arg[i];
					arg[i] = tmp;
				}
			}
		}
	}
}