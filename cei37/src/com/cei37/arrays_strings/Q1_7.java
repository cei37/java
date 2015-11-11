package com.cei37.arrays_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q1_7 {

	/**
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
	 * and column are set to 0.
	 */
	public static void main(String[] args) {
		int matrix[][] = new int[10][15];
		populateMatrix(matrix);
		verifyMatrix(matrix);
		System.out.println("******************************************");
		printMatrix(matrix);
	}
	
	public static void verifyMatrix(int matrix[][]) {
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++) {
				if (matrix[row][col] == 0) {
					matrix[row][col] = -1;
				}
			}
		}
		
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++) {
				if (matrix[row][col] == -1) {
					changeTo0(matrix, row, col);
				}
			}
		}
	}
	
	public static void changeTo0(int [][]matrix, int row, int col) {
		//changing row
		for (int i=0; i<matrix[row].length; i++) {
			if (matrix[row][i] != -1) {
				matrix[row][i] = 0;
			} 
		}
		//changing col
		for (int i=0; i<matrix.length; i++) {
			if (matrix[i][col] != -1) {
				matrix[i][col] = 0;
			}
		}
		matrix[row][col] = 0;
	}
	
	public static void populateMatrix(int [][]matrix) {
		Random ran = new Random();
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				matrix[row][col] = ran.nextInt(20);
				System.out.print(matrix[row][col]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void printMatrix(int [][]matrix) {
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				System.out.print(matrix[row][col]+"\t");
			}
			System.out.print("\n");
		}
	}
}