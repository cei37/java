package com.cei37.sort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

	/**
	 * To measure all the sort methods implemented by me
	 */
	public static void main(String[] args) {
		int N = 300000;
		Random ran = new Random();
		int vector1[] = new int[N];
		int vector2[] = new int[N];
		int vector3[] = new int[N];
		int vector4[] = new int[N];
		int vector5[] = new int[N];
		int vector6[] = new int[N];
		int vector7[] = new int[N];
		System.out.println("Original vector");
		for(int i = 0; i<vector1.length; i++) {
			vector1[i] = ran.nextInt(1000000);
			vector2[i] = vector1[i];
			vector3[i] = vector1[i];
			vector4[i] = vector1[i];
			vector5[i] = vector1[i];
			vector6[i] = vector1[i];
			vector7[i] = vector1[i];
		}
		long startTime = 0;
		long stopTime = 0;
		double elapsedTime = 0;
		/*
		System.out.println("\n*** Starting bubble sort *** ");
		startTime = System.currentTimeMillis() ;
		Bubble.sort(vector4);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Bubble took: "+elapsedTime/1000 + " secs");
		*/
		System.out.println("\n*** Starting selection sort *** ");
		startTime = System.currentTimeMillis() ;
		Selection.sort(vector1);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Selection took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting insertion sort *** ");
		startTime = System.currentTimeMillis();
		Insertion.sort(vector2);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Insertion took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting shell sort *** ");
		startTime = System.currentTimeMillis();
		Shell.sort(vector3);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Shell took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting shell New sort *** ");
		startTime = System.currentTimeMillis();
		Shell.sortN(vector4);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Shell New took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting merge sort *** ");
		startTime = System.currentTimeMillis();
		Merge.sort(vector5);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Merge took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting Quick 3 Way sort *** ");
		startTime = System.currentTimeMillis();
		QuickSort3Way.sort(vector6);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Quick 3 Way took: "+elapsedTime/1000 + " secs");
		
		System.out.println("\n*** Starting Java Sort *** ");
		startTime = System.currentTimeMillis();
		Arrays.sort(vector7);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Java Sort took: "+elapsedTime/1000 + " secs");
	}
}
