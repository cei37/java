package com.cei37.sort;

import java.util.Random;

public class Insertion {

	/**
	 * Implement insertion sort
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
			if (arg[i]>arg[i+1]) {
				moveBack(arg,i+1);
			}
		}
	}
	
	private static void moveBack(int []arg, int pos) {
		for (int i = pos; i>0 && arg[i]<arg[i-1]; i--) {
			int tmp = arg[i];
			arg[i] = arg[i-1];
			arg[i-1] = tmp;
		}
	}
}