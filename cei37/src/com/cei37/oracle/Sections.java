package com.cei37.oracle;

import java.util.Random;

public class Sections {

	/**
	 * @autor Vicente Villegas Larios
	 * @mail cei37@hotmail.com
	 * @description Write a program that given a matrix NxM you can figure out the number of sections
	 * 
	 */
	public static void main(String[] args) {
		char matrix[][] = new char[15][15];
		
		/*
		 * here I'm going to populate the matrix with random values 
		 */
		populateMatrix(matrix);
		
		/*
		 * here I'm going to print the populated matrix
		 */
		printMatrix(matrix);
		
		/*
		 * here I'm going to find all sections in the matrix
		 */
		findSections(matrix);
	}
	
	public static void findSections(char [][] matrix) {
		int tmp[][] = new int[matrix.length][matrix[0].length];
		int counter = 0;
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				if (matrix[row][col] == 'B' && tmp[row][col] != 1) {
					counter++;
					findElement(matrix,row,col,tmp);
				}
			}
		}
		System.out.println("\nThere are "+counter + " sections.");
		printMatrix(tmp);
	}
	
	public static void findElement(char [][]matrix, int row, int col, int [][]tmp) {
		if (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length) {
			if (matrix[row][col] == 'B' && tmp[row][col] != 1) {
				tmp[row][col] = 1;
				//searching for top
				findElement(matrix,row-1,col,tmp);
				//searching for bottom
				findElement(matrix,row+1,col,tmp);
				//searching for left
				findElement(matrix,row,col-1,tmp);
				//searching for right
				findElement(matrix,row,col+1,tmp);
			}
		}
	}
	
	public static void printMatrix(int [][]matrix) {
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				if (matrix[row][col]==1) {
					System.out.print(matrix[row][col] + " ");
				} else {
					System.out.print(" " + " ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void printMatrix(char [][]matrix) {
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				System.out.print(matrix[row][col]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void populateMatrix(char [][]matrix) {
		Random ran = new Random();
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				if (ran.nextInt(2) == 1) {
					matrix[row][col] = 'B';
				} else {
					matrix[row][col] = 'W';
				} 
			}
		}
	}
}