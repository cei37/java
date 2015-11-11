package com.cei37.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
	Problem Statement

	In this problem you will test your knowledge of Java loops. Given three integers a, b, and n, output the following series:
	
	a+20b,a+20b+21b,......,a+20b+21b+...+2n−1b
	Input Format
	
	The first line will contain the number of testcases t. Each of the next t lines will have three integers, a, b, and n.
	
	Constraints:
	
	0≤a,b≤50
	1≤n≤15
	Output Format
	
	Print the answer to each test case in separate lines.
 */
public class JavaLoops {
	private int t;
	private int[][] values;
	
	public static void main(String[] args) {
		JavaLoops jl = new JavaLoops();
		jl.input();
		jl.run();
	}
	
	private void run() {
		for (int i=0; i<t; i++) { //the number of test cases
			for (int j=0; j<values[i][2]; j++) { // the number of terms 
				double term1 = values[i][0] + Math.pow(2, 0) * values[i][1];
				for (int k=1; k<j+1; k++) {
					term1 = term1 + Math.pow(2, k) * values[i][1];
				}
				System.out.print(String.valueOf((int)term1) + " ");
			}
			System.out.println();
		}
	}
	
	private void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        	t = Integer.parseInt(br.readLine());
        	values = new int[t][3];
        	for (int i=0; i<t; i++) {	        	
	        	String []v = br.readLine().split(" ");
	        	values[i][0] = Integer.parseInt(v[0]);
	        	values[i][1] = Integer.parseInt(v[1]);
	        	values[i][2] = Integer.parseInt(v[2]);
        	}
        } catch(NumberFormatException e){
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}