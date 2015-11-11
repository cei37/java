package com.cei37.recursion;

import java.util.ArrayList;

public class Q9_9 {

	/**
	 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess
	 * board so that none of them share the same row, column or diagonal. In this case,
	 * "diagonal" means all diagonals, not just the two that bisect the board.
	 */
	static int GRID_SIZE = 8;
	
	public static void main(String[] args) {
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		/*for (int i=0; i<GRID_SIZE; i++) {
			placeQueens(i,columns,results);
		}*/
		String hola = "Hola";
		String hola2 = new String("Hola");
		System.out.println("Hola".hashCode());
		System.out.println(hola.hashCode());
		System.out.println(hola2.hashCode());
		placeQueens(0,columns,results);
		for (Integer[] v : results) {
			for (Integer i: v) {
				System.out.print(i);
			}
			System.out.println("");
			break;
		}
	}
	
	public static void placeQueens(int row, Integer[] columns,ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns);
		} else {
			for (int col = 0; col<GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
		
	public static boolean checkValid(Integer[] columns, int row, int col) {
		for (int row2 = 0; row2 < row; row2++) {
			int column = columns[row2];
			if (column == col) {
				return false;
			}
			int columDistance =  Math.abs(column - col);
			int rowDistance =  Math.abs(row2 - row);
			if (columDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
	
	public static void printMatrix(char [][]matrix) {
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++){
				if (matrix[row][col]==1) {
					System.out.print("|*");
				} else {
					System.out.print("|" + "_");
				}
			}
			System.out.print("|\n");
		}
	}
	
	public static boolean isFree(char [][] board, int row, int col) {
		return isRowFree(board,row) && isColFree(board,col) && isDiagFree(board,row,col);
	}
	
	public static boolean isRowFree(char [][] board, int row) {
		for (int col=0; col<board.length; col++) {
			if (board[row][col]!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isColFree(char [][] board, int col) {
		for (int row=0; row<board.length; row++) {
			if (board[row][col]!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDiagFree(char [][] board, int row, int col) {
		int i=row;
		int j=col;
		while(i<board.length && j<board.length) {
			if (board[i][j]!=0) {
				return false;
			}
			i++;
			j++;
		}
		
		i=row;
		j=col;
		while(i>=0 && j>=0) {
			if (board[i][j]!=0) {
				return false;
			}
			i--;
			j--;
		}
		return true;
	}
}