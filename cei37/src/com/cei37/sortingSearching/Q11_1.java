package com.cei37.sortingSearching;

public class Q11_1 {

	/**
	 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
	 * end to hold B. Write a method to merge B into A in sorted order.
	 * 
	 * A --> n
	 * B --> m
	 * O(m (log n))
	 */
	public static void main(String[] args) {
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 2;
		A[2] = 4;
		A[3] = 7;
		A[4] = 8;
		A[5] = 9;
		A[6] = 10;
		int[] B = {3,5,6};
		merge(A,B);
		for (int i=0; i<A.length; i++) {
			System.out.println(i + " --> "+A[i]);
		}
	}
	
	public static void merge(int A[], int[] B) {
		int pointerA = A.length - 1, cB = B.length -1, cA = A.length - B.length - 1;
		while(cB>=0 && cA>=0) {
			if (B[cB]>=A[cA]) {
				A[pointerA] = B[cB];
				pointerA--;
				cB--;
			} else {
				while(B[cB]<=A[cA]) {
					A[pointerA] = A[cA];
					pointerA--;
					cA--;
				}
			}
		}
	}
}