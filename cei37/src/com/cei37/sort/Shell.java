package com.cei37.sort;

import java.util.Random;

public class Shell {

	/**
	 * Implement the shell sort
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
	
	public static void sort(int arr[]) {
		int h = arr.length/2;
		while(h>1) {
			for (int i=0, j = h; j<arr.length; i++,j++) {
				if (arr[i]>arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
			h = h / 2;
		}
		Insertion.sort(arr);
	}
	
	public static void sortN(int arr[]) {
		int N = arr.length;
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1;
		}
		
		while(h >= 1) {
			for (int i=h; i<N; i++) {
				for (int j=i; j>=h && arr[j]<arr[j-h]; j-=h) {
					int tmp = arr[j];
					arr[j] = arr[j-h];
					arr[j-h] = tmp;
				}
			}
			h = h/3;
		}
	}
}