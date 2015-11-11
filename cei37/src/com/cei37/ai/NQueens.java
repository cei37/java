package com.cei37.ai;

public class NQueens {

	static int NUM = 8;
	private static int[] b = new int[NUM];

	static boolean unsafe(int y) {
		int x = b[y];
		for (int i = 1; i <= y; i++) {
			int t = b[y - i];
			if (t == x || t == x - i || t == x + i) {
				return true;
			}
		}

		return false;
	}

	public static void putboard(int s) {
		System.out.println("\n\nSolution " + (s));
		for (int y = 0; y < NUM; y++) {
			for (int x = 0; x < NUM; x++) {
				System.out.print((b[y] == x) ? "|Q" : "|_");
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		int y = 0;
		int s = 0;
		b[0] = -1;
		while (y >= 0) {
			do {
				b[y]++;
			} while ((b[y] < NUM) && unsafe(y));
			if (b[y] < NUM) {
				if (y < NUM-1) {
					b[++y] = -1;
				} else {
					putboard(++s);
				}
			} else {
				y--;
			}
		}
	}
}