package com.cei37.arrays_strings;

import java.util.Random;

public class Q1_6 {

	/**
	 * Given an image represented by an NxN matrix, where each pixel in the image is
	 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	 * place?
	 */
	public static void main(String[] args) {
		int [][]matrix = new int[3][3];
		populateMatrix(matrix);
		System.out.println("===========================================================================");
		rotate90(matrix);
	}
	
	public static void rotate90(int [][]matrix) {
		for (int col=matrix.length-1; col>=0; col--) {
			for (int row=0; row<matrix.length; row++) {
				System.out.print(matrix[row][col]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void populateMatrix(int [][]matrix) {
		Random ran = new Random();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				matrix[i][j] = ran.nextInt(100);
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
}