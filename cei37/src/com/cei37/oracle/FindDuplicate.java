package com.cei37.oracle;

public class FindDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []arr = new int[10];
		arr[0] = 3;
		arr[1] = 1;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 7;
		arr[5] = 8;
		arr[6] = 3;
		arr[7] = 9;
		arr[8] = 2;
		arr[9] = 6;
		
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		int n = arr.length-1;
		int sum2 = (n*(n+1))/2;
		
		System.out.println(sum);
		System.out.println(sum2);
		
		System.out.println("The duplicate number is: "+(sum-sum2));
	}
}