package com.cei37.sort;

import java.util.Random;

public class Merge {

	/**
	 * 
	 */
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
		int aux[] = new int[arg.length];
		sort(arg, aux, 0, arg.length-1);
	}
	
	private static void sort(int arg[], int aux[], int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(arg,aux,lo,mid);
		sort(arg,aux,mid+1,hi);
		merge(arg,aux,lo,mid,hi);
	}
	
	private static void merge(int arg[], int aux[], int lo, int mid, int hi) {
		for (int k=lo; k<=hi; k++) {
			aux[k] = arg[k];
		} 
		int i = lo, j = mid+1;
		for (int k=lo; k<=hi; k++) {
			if (i > mid) {
				arg[k] = aux[j++];
			} else if (j > hi) {
				arg[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				arg[k] = aux[j++];
			} else {
				arg[k] = aux[i++];
			}
		}
	}
}