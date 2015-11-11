package com.cei37.sort;

import java.util.Random;

public class QuickSort3Way {
	
	public static void main(String[] args) {
		Random ran = new Random();
		int vector[] = new int[30];
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
		sort(arg, 0, arg.length-1);
	}
	
	private static void sort(int []a, int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		
		int lt = lo, gt = hi;
		int v = a[lo];
		int i = lo;
		while (i<=gt) {
			if (a[i]<v) {
				int tmp = a[lt];
				a[lt] = a[i];
				a[i] = tmp;
				lt++;
				i++;
			} else if (a[i]>v ) {
				int tmp = a[i];
				a[i] = a[gt];
				a[gt] = tmp;
				gt--;
			} else {
				i++;
			}
		}
		sort(a,lo,lt-1);
		sort(a, gt+1, hi);
	}
}